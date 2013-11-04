/**
 * Patrick John Haskins
 * Zachary Evans
 * CS7020 - Term Project
 */
package android.otasyn.cardgames.manage.account.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.otasyn.cardgames.R;
import android.otasyn.cardgames.manage.account.asynctask.CurrentUserTask;
import android.otasyn.cardgames.manage.account.asynctask.GamesListTask;
import android.otasyn.cardgames.manage.account.dto.Game;
import android.otasyn.cardgames.manage.account.dto.GamePlayer;
import android.otasyn.cardgames.manage.account.dto.SimpleUser;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

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
            context.startActivity(new Intent(context, LoginActivity.class));
        }
    }

    final List<Game> games = new ArrayList<>();

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
        try {
            games.addAll(new GamesListTask().execute().get());
        } catch (Exception e) { }

        if (!games.isEmpty()) {
            gamesListLayout.removeAllViews();
            for (Game game : games) {
                LinearLayout gameLayout = new LinearLayout(this);
                gameLayout.setOrientation(LinearLayout.VERTICAL);
                LinearLayout.LayoutParams gameLayoutParams = new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                gameLayoutParams.bottomMargin = getResources().getDimensionPixelSize(R.dimen.listEntryBottomMargin);
                gameLayout.setLayoutParams(gameLayoutParams);

                // Display type
                TextView gameType = new TextView(this);
                gameType.setText(game.getGameType().getName());
                gameType.setTextColor(getResources().getColor(R.color.listEntryHeader));
                LinearLayout.LayoutParams gameTypeLayoutParams = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                gameTypeLayoutParams.leftMargin = getResources().getDimensionPixelSize(R.dimen.listEntryHeaderLeftMargin);
                gameType.setLayoutParams(gameTypeLayoutParams);
                gameLayout.addView(gameType);

                // Display players
                for (GamePlayer gamePlayer : game.getPlayers()) {
                    TextView gamePlayerName = new TextView(this);
                    gamePlayerName.setText(gamePlayer.getFirstname() + " " + gamePlayer.getLastname());
                    gamePlayerName.setTextColor(getResources().getColor(R.color.listEntryDetails));
                    LinearLayout.LayoutParams gamePlayerLayoutParams = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    gamePlayerLayoutParams.leftMargin = getResources().getDimensionPixelSize(R.dimen.listEntryDetailsLeftMargin);
                    gamePlayerName.setLayoutParams(gamePlayerLayoutParams);
                    gameLayout.addView(gamePlayerName);
                }

                gamesListLayout.addView(gameLayout);
            }
        }

/*        String gamesString = null;
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
                .show();*/
    }

}