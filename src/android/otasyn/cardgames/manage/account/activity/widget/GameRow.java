package android.otasyn.cardgames.manage.account.activity.widget;

import android.content.Context;
import android.otasyn.cardgames.R;
import android.otasyn.cardgames.manage.account.dto.Game;
import android.otasyn.cardgames.manage.account.dto.GamePlayer;
import android.otasyn.cardgames.manage.account.dto.SimpleUser;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class GameRow extends LinearLayout {

    private Game game;
    private SimpleUser currentUser;

    private final TextView gameTypeView;
    private final Map<GamePlayer,TextView> gamePlayerViews;

    public GameRow(final Context context, final Game game, final SimpleUser currentUser) {
        super(context);

        this.game = game;
        this.currentUser = currentUser;

        setOrientation(LinearLayout.VERTICAL);
        LayoutParams gameLayoutParams = new LayoutParams(
                ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        gameLayoutParams.bottomMargin = context.getResources().getDimensionPixelSize(R.dimen.listEntryBottomMargin);
        setLayoutParams(gameLayoutParams);

        // Display type
        gameTypeView = new TextView(context);
        gameTypeView.setTextColor(getResources().getColor(R.color.listEntryHeader));
        LinearLayout.LayoutParams gameTypeLayoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        gameTypeLayoutParams.leftMargin = getResources().getDimensionPixelSize(R.dimen.listEntryHeaderLeftMargin);
        gameTypeView.setLayoutParams(gameTypeLayoutParams);
        addView(gameTypeView);

        // Display players
        gamePlayerViews = new HashMap<GamePlayer, TextView>(game.getPlayers().size());
        for (GamePlayer gamePlayer : game.getPlayers()) {
            TextView gamePlayerView = new TextView(context);
            gamePlayerView.setTextColor(getResources().getColor(R.color.listEntryDetails));
            LinearLayout.LayoutParams gamePlayerLayoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            gamePlayerLayoutParams.leftMargin = getResources().getDimensionPixelSize(R.dimen.listEntryDetailsLeftMargin);
            gamePlayerView.setLayoutParams(gamePlayerLayoutParams);
            addView(gamePlayerView);
            gamePlayerViews.put(gamePlayer, gamePlayerView);
        }

        updateGameInfo(game);
    }

    private void updateGameInfo(final Game game) {
        gameTypeView.setText(game.getGameType().getName());
        for (GamePlayer gamePlayer : game.getPlayers()) {
            String playerText = gamePlayer.getFirstname() + " " + gamePlayer.getLastname();
            if (!Boolean.TRUE.equals(gamePlayer.getAccepted())) {
                playerText += " [Pending]";
            }
            gamePlayerViews.get(gamePlayer).setText(playerText);
        }
    }

    public Game getGame() {
        return game;
    }

    public void setGame(final Game game) {
        this.game = game;
        updateGameInfo(game);
    }

    public SimpleUser getCurrentUser() {
        return currentUser;
    }

    public static abstract class OnClickListener implements LinearLayout.OnClickListener {
        @Override
        public final void onClick(final View v) {
            GameRow gameRow = (GameRow) v;
            Game game = gameRow.getGame();
            SimpleUser currentUser = gameRow.getCurrentUser();
            onClick(gameRow, game, currentUser);
        }

        public abstract void onClick(GameRow gameRow, Game game, SimpleUser currentUser);
    }
}
