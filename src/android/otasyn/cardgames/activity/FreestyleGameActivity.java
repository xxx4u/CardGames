package android.otasyn.cardgames.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.otasyn.cardgames.R;
import android.otasyn.cardgames.scene.CardGameScene;
import android.otasyn.cardgames.utility.TextureUtility;
import android.otasyn.cardgames.utility.enumeration.Card;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.opengl.texture.region.ITextureRegion;

public class FreestyleGameActivity extends CardGameActivity {

    private ButtonSprite deckButton;

    @Override
    protected void onCreateCardGameResources() {
        setCardTextureRegions(TextureUtility.loadCards92x128(this));
    }

    @Override
    protected void onCreateCardGameScene(final CardGameScene scene) {

        ITextureRegion redBack = getCardTextureRegions().get(Card.BACK_RED);
        float deckX = 20f;
        float deckY = (CAMERA_HEIGHT / 2f) - (redBack.getHeight() / 2f) ;

        deckButton = new ButtonSprite(
                deckX, deckY,
                redBack,
                this.getVertexBufferObjectManager());
        deckButton.setOnClickListener(new DeckClickListener());
        scene.attachChild(deckButton);
        scene.registerTouchArea(deckButton);

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
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(FreestyleGameActivity.this);
        alertBuilder
                .setTitle("Deal")
                .setMessage("You deal " + numCards + " cards.")
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
}
