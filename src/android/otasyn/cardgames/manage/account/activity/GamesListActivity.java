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
import android.otasyn.cardgames.manage.account.asynctask.CurrentUserTask;
import android.otasyn.cardgames.manage.account.asynctask.GamesListTask;
import android.otasyn.cardgames.manage.account.dto.Game;
import android.otasyn.cardgames.manage.account.dto.SimpleUser;
import android.otasyn.cardgames.utility.DateUtility;

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
            context.startActivity(new Intent(context, LoginActivity.class));
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games_list);

        gamesList();
    }

    private void gamesList() {
        List<Game> games = null;
        try {
            games = new GamesListTask().execute().get();
        } catch (Exception e) { }

        String gamesString = null;
        if (games != null) {
            gamesString = "Games[" + games.size() + "]:";
            for (Game game : games) {
                gamesString += "\n  " + (game.getGameType() != null ? game.getGameType().getName() + ": " : "") + DateUtility.dateFormat.format(game.getDateAdded());
            }
        }

        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(GamesListActivity.this);
        alertBuilder
                .setMessage(gamesString != null ? gamesString : "No games.")
                .setCancelable(true)
                .create()
                .show();
    }

}