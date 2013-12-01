/**
 * Patrick John Haskins
 * Zachary Evans
 * CS7020 - Term Project
 */
package android.otasyn.cardgames.manage.account.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.otasyn.cardgames.R;
import android.otasyn.cardgames.manage.account.activity.widget.GameRow;
import android.otasyn.cardgames.manage.account.asynctask.CurrentUserTask;
import android.otasyn.cardgames.manage.account.dto.Game;
import android.otasyn.cardgames.manage.account.dto.SimpleUser;
import android.otasyn.cardgames.manage.account.utility.AccountUtility;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class GamesListActivity extends Activity {

    public static void launch(final Context context) {
        SimpleUser user = null;
        try {
            user = new CurrentUserTask().execute().get();
        } catch (Exception e) { }

        if (user != null) {
            context.startActivity(new Intent(context, GamesListActivity.class));
        } else {
            LoginActivity.setNextDestination(GamesListActivity.class);
            Intent loginIntent = new Intent(context, LoginActivity.class);
            loginIntent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            context.startActivity(loginIntent);
        }
    }

    final List<Game> games = new ArrayList<Game>();

    private LinearLayout gamesListLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games_list);

        gamesListLayout = (LinearLayout) findViewById(R.id.gamesListLayout);

        gamesList();
    }

    private void gamesList() {
        games.clear();
        games.addAll(AccountUtility.retrieveGamesList());

        if (!games.isEmpty()) {
            gamesListLayout.removeAllViews();
            for (Game game : games) {
                GameRow gameLayout = new GameRow(this, game);
                gameLayout.setOnClickListener(new GameClickListener());
                gamesListLayout.addView(gameLayout);
            }
        }
    }

    private class GameClickListener extends GameRow.OnClickListener {
        @Override
        public void onClick(final GameRow gameRow) {
            String gameString = null;
            Game game = gameRow.getGame();
            if (game != null && game.getGameType() != null) {
                gameString = game.getGameType().getName() + " [" + (Boolean.TRUE.equals(game.getStarted()) ? "started" : "pending") + "]";
            }

            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(GamesListActivity.this);
            alertBuilder
                    .setMessage(gameString != null ? gameString : "No game.")
                    .setCancelable(true)
                    .create()
                    .show();
        }
    }

}