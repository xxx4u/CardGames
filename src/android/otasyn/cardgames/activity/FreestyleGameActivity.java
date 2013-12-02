package android.otasyn.cardgames.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.otasyn.cardgames.R;
import android.otasyn.cardgames.manage.account.asynctask.MoveTask;
import android.otasyn.cardgames.manage.account.dto.GamePlayer;
import android.otasyn.cardgames.manage.account.dto.gamestate.FreestyleState;
import android.otasyn.cardgames.manage.account.dto.gamestate.format.JsonStringFormatterUtility;
import android.otasyn.cardgames.scene.CardGameScene;
import android.otasyn.cardgames.sprite.CardSprite;
import android.otasyn.cardgames.utility.TextureUtility;
import android.otasyn.cardgames.utility.enumeration.Card;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import org.andengine.entity.sprite.ButtonSprite;

import java.util.List;
import java.util.Map;
import java.util.Queue;

public class FreestyleGameActivity extends CardGameActivity {

    private ButtonSprite deckButton;

    @Override
    protected void onCreateCardGameResources() {
        setCardTextureRegions(TextureUtility.loadCards92x128(this));
    }

    @Override
    protected void onCreateCardGameScene(final CardGameScene scene) {

        displayDeck();
        displayHands();

    }

    private class DeckClickListener implements ButtonSprite.OnClickListener {
        @Override
        public void onClick(final ButtonSprite deckButton,
                            final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
            FreestyleGameActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    AlertDialog.Builder alertBuilder = new AlertDialog.Builder(FreestyleGameActivity.this);
                    LayoutInflater inflater = FreestyleGameActivity.this.getLayoutInflater();
                    final AlertDialog dialog = alertBuilder
                            .setView(inflater.inflate(R.layout.popup_deck_options, null))
                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(final DialogInterface dialog, final int which) {
                                    dialog.dismiss();
                                }
                            })
                            .create();
                    dialog.show();
                    Button dealButton = (Button) dialog.findViewById(R.id.deckOptionsDealButton);
                    dealButton.setOnClickListener(new Button.OnClickListener() {
                        @Override
                        public void onClick(final View v) {
                            dealClick(dialog);
                        }
                    });
                    Button drawButton = (Button) dialog.findViewById(R.id.deckOptionsDrawButton);
                    drawButton.setOnClickListener(new Button.OnClickListener() {
                        @Override
                        public void onClick(final View v) {
                            drawClick(dialog);
                        }
                    });
                }
            });
        }
    }

    private void dealClick(final AlertDialog deckDialog) {
        deckDialog.dismiss();
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(FreestyleGameActivity.this);
        LayoutInflater inflater = FreestyleGameActivity.this.getLayoutInflater();
        final AlertDialog dialog = alertBuilder
                .setView(inflater.inflate(R.layout.popup_deal, null))
                .setCancelable(true)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(final DialogInterface dialog, final int which) {
                        AlertDialog alertDialog = (AlertDialog) dialog;
                        deal(((NumberPicker) alertDialog.findViewById(R.id.numCards)).getValue());
                        alertDialog.dismiss();
                    }
                })
                .create();
        dialog.show();
        NumberPicker numberPicker = (NumberPicker) dialog.findViewById(R.id.numCards);
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(52);
    }

    private void deal(final int numCards) {
        if (getLatestAction().getGameState() != null) {
            Queue<Card> deck = getLatestAction().getGameState().getDeck();
            for (int n = 0; n < numCards && !deck.isEmpty(); n++) {
                GamePlayer player = null;
                int t = -1;
                for (int p = 0; p < getGame().getPlayers().size() && !deck.isEmpty(); p++, t++) {
                    if (player == null) {
                        player = getLatestAction().getNextActionPlayer();
                        t = getGame().getTurnOrder().indexOf(player);
                    } else {
                        if (t >= getGame().getTurnOrder().size()) {
                            t = 0;
                        }
                        player = getGame().getTurnOrder().get(t);
                    }
                    Card nextCard = deck.poll();
                    if (nextCard != null) {
                        getLatestAction().getGameState().getHands().get(player).add(nextCard);
                    }
                }
            }
        }
        try {
            setLatestAction((new MoveTask()).execute(
                    getGame().getId().toString(),
                    JsonStringFormatterUtility.formatFreestyleState((FreestyleState)getLatestAction().getGameState()))
                    .get());
        } catch (Exception e) { }
        displayDeck();
        displayHands();
    }

    private void drawClick(final AlertDialog dialog) {
        dialog.dismiss();
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(FreestyleGameActivity.this);
        alertBuilder
                .setTitle("Draw")
                .setMessage("You have clicked the draw option.")
                .setCancelable(true)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(final DialogInterface dialog, final int which) {
                        dialog.dismiss();
                    }
                })
                .create()
                .show();
    }

    private void displayDeck() {
        if (deckButton == null) {
            float deckX = 20f;
            float deckY = (CAMERA_HEIGHT / 2f) - (getRedBack().getHeight() / 2f) ;

            deckButton = new ButtonSprite(
                    deckX, deckY,
                    getRedBack(),
                    this.getVertexBufferObjectManager());
            deckButton.setOnClickListener(new DeckClickListener());
            getCardGameScene().attachChild(deckButton);
            getCardGameScene().registerTouchArea(deckButton);
        }
        if (getLatestAction() != null
                && getLatestAction().getGameState() != null
                && getLatestAction().getGameState().getDeck() != null
                && getLatestAction().getGameState().getDeck().size() > 0) {
            deckButton.setVisible(true);
        } else {
            deckButton.setVisible(false);
        }
    }

    private void displayHands() {
        if (getLatestAction() != null
                && getLatestAction().getGameState() != null
                && getLatestAction().getGameState().getHands() != null) {
            Map<GamePlayer,List<Card>> hands = getLatestAction().getGameState().getHands();
            for (Map.Entry<GamePlayer,List<Card>> handEntry : hands.entrySet()) {
                GamePlayer handPlayer = handEntry.getKey();
                List<Card> hand = handEntry.getValue();

                float sectionWidth = CAMERA_WIDTH / (hand.size() + 1);

                if (getCurrentUser().equals(handPlayer)) {
                    for (int n = 0; n < hand.size(); n++) {
                        CardSprite cardSprite = getCardSprite(hand.get(n));
                        float x = (sectionWidth * (n + 1)) - (cardSprite.getWidth() / 2f);
                        float y = CAMERA_HEIGHT - cardSprite.getHeight();
                        cardSprite.setX(x);
                        cardSprite.setY(y);
                        cardSprite.showFace();
                        cardSprite.setVisible(true);
                    }
                } else {
                    for (int n = 0; n < hand.size(); n++) {
                        CardSprite cardSprite = getCardSprite(hand.get(n));
                        float x = (sectionWidth * (n + 1)) - (cardSprite.getWidth() / 2f);
                        float y = 0;
                        cardSprite.setX(x);
                        cardSprite.setY(y);
                        cardSprite.showBack();
                        cardSprite.setVisible(true);
                    }
                }
            }
        }
    }
}
