/**
 * Patrick John Haskins
 * Zachary Evans
 * CS7020 - Term Project
 */
package android.otasyn.cardgames.manage.account.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.otasyn.cardgames.R;
import android.otasyn.cardgames.activity.CardGameActivity;
import android.otasyn.cardgames.activity.FivesGameActivity;
import android.otasyn.cardgames.activity.FreestyleGameActivity;
import android.otasyn.cardgames.manage.account.activity.widget.GameRow;
import android.otasyn.cardgames.manage.account.asynctask.AcceptGameTask;
import android.otasyn.cardgames.manage.account.asynctask.CurrentUserTask;
import android.otasyn.cardgames.manage.account.dto.Game;
import android.otasyn.cardgames.manage.account.dto.GamePlayer;
import android.otasyn.cardgames.manage.account.dto.SimpleUser;
import android.otasyn.cardgames.manage.account.utility.AccountUtility;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Iterator;
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

    private final List<Game> games = new ArrayList<Game>();
    private SimpleUser currentUser;

    private LinearLayout gamesListLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games_list);

        gamesListLayout = (LinearLayout) findViewById(R.id.gamesListLayout);

        currentUser = AccountUtility.currentUser();
        gamesList();
    }

    private void gamesList() {
        games.clear();
        games.addAll(AccountUtility.retrieveGamesList());

        if (!games.isEmpty()) {
            gamesListLayout.removeAllViews();
            for (Game game : games) {
                GameRow gameLayout = new GameRow(this, game, currentUser);
                gameLayout.setOnClickListener(new GameClickListener());
                gamesListLayout.addView(gameLayout);
            }
        }
    }

    private void playGame(final Game game) {
        Intent gameIntent = null;
        switch (game.getGameType()) {
            case FREESTYLE:
                gameIntent = new Intent(GamesListActivity.this, FreestyleGameActivity.class);
                gameIntent.putExtra(CardGameActivity.GAME_INFO, game);
                break;
            case FIVES:
                gameIntent = new Intent(GamesListActivity.this, FivesGameActivity.class);
                gameIntent.putExtra(CardGameActivity.GAME_INFO, game);
                break;
            default:
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(GamesListActivity.this);
                alertBuilder
                        .setTitle("Game Type Not Supported")
                        .setMessage("This game type is not supported on this device.")
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
        if (gameIntent != null) {
            GamesListActivity.this.startActivity(gameIntent);
        }
    }

    private void askToAccept(final Game game, final GameRow gameRow) {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(GamesListActivity.this);
        alertBuilder
                .setTitle("Pending")
                .setMessage("Would you like to accept this game?")
                .setCancelable(true)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(final DialogInterface dialog, final int which) {
                        accept(game, gameRow);
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(final DialogInterface dialog, final int which) {
                        dialog.dismiss();
                    }
                })
                .create()
                .show();
    }

    private void accept(final Game game, final GameRow gameRow) {
        Game newGame;
        try {
            newGame = new AcceptGameTask().execute(game).get();
        } catch (Exception e) {
            newGame = null;
        }
        if (newGame != null) {
            gameRow.setGame(newGame);
        }
    }

    private void alertPending() {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(GamesListActivity.this);
        alertBuilder
                .setTitle("Pending")
                .setMessage("Not all players have accepted the game.")
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

    private class GameClickListener extends GameRow.OnClickListener {
        @Override
        public void onClick(final GameRow gameRow, final Game game, final SimpleUser currentUser) {
            if (game != null) {
                if (Boolean.TRUE.equals(game.getStarted())) {
                    playGame(game);
                } else {
                    Iterator<GamePlayer> iter;
                    GamePlayer currentPlayer = null;
                    for (iter = game.getPlayers().iterator(); iter.hasNext() && currentPlayer == null;) {
                        GamePlayer gamePlayer = iter.next();
                        if (currentUser.equals(gamePlayer)) {
                            currentPlayer = gamePlayer;
                        }
                    }
                    if (currentPlayer != null) {
                        if (!Boolean.TRUE.equals(currentPlayer.getAccepted())) {
                            askToAccept(game, gameRow);
                        } else {
                            alertPending();
                        }
                    }
                }
            }
        }
    }

}