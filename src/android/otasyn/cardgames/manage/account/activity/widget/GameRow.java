package android.otasyn.cardgames.manage.account.activity.widget;

import android.content.Context;
import android.otasyn.cardgames.R;
import android.otasyn.cardgames.manage.account.dto.Game;
import android.otasyn.cardgames.manage.account.dto.GamePlayer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class GameRow extends LinearLayout {

    private Game game;

    public GameRow(final Context context, final Game game) {
        super(context);
        this.game = game;
        setOrientation(LinearLayout.VERTICAL);
        LayoutParams gameLayoutParams = new LayoutParams(
                ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        gameLayoutParams.bottomMargin = context.getResources().getDimensionPixelSize(R.dimen.listEntryBottomMargin);
        setLayoutParams(gameLayoutParams);

        // Display type
        TextView gameType = new TextView(context);
        gameType.setText(game.getGameType().getName());
        gameType.setTextColor(getResources().getColor(R.color.listEntryHeader));
        LinearLayout.LayoutParams gameTypeLayoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        gameTypeLayoutParams.leftMargin = getResources().getDimensionPixelSize(R.dimen.listEntryHeaderLeftMargin);
        gameType.setLayoutParams(gameTypeLayoutParams);
        addView(gameType);

        // Display players
        for (GamePlayer gamePlayer : game.getPlayers()) {
            TextView gamePlayerName = new TextView(context);
            String playerText = gamePlayer.getFirstname() + " " + gamePlayer.getLastname();
            if (!Boolean.TRUE.equals(gamePlayer.getAccepted())) {
                playerText += " [Pending]";
            }
            gamePlayerName.setText(playerText);
            gamePlayerName.setTextColor(getResources().getColor(R.color.listEntryDetails));
            LinearLayout.LayoutParams gamePlayerLayoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            gamePlayerLayoutParams.leftMargin = getResources().getDimensionPixelSize(R.dimen.listEntryDetailsLeftMargin);
            gamePlayerName.setLayoutParams(gamePlayerLayoutParams);
            addView(gamePlayerName);
        }
    }

    public Game getGame() {
        return game;
    }

    public static abstract class OnClickListener implements LinearLayout.OnClickListener {
        @Override
        public final void onClick(final View v) {
            onClick((GameRow) v);
        }

        public abstract void onClick(GameRow gameRow);
    }
}
