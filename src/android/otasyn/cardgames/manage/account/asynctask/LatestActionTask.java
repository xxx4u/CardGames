package android.otasyn.cardgames.manage.account.asynctask;

import android.os.AsyncTask;
import android.otasyn.cardgames.manage.account.dto.Game;
import android.otasyn.cardgames.manage.account.dto.GameAction;
import android.otasyn.cardgames.manage.account.dto.parse.JsonResponseParserUtility;
import android.otasyn.cardgames.manage.account.http.WebManager;

public class LatestActionTask extends AsyncTask<Integer,String,GameAction> {

    public AsyncTask<Integer, String, GameAction> execute(final Game game) {
        return super.execute(game.getId());
    }

    @Override
    protected GameAction doInBackground(final Integer... params) {
        return latestAction(params[0]);
    }

    private GameAction latestAction(final Integer gameId) {
        // Apparently, using NameValuePairs for parameters doesn't work with .get().
        String responseString = WebManager.get("http://cg.otasyn.net/game/action/latest/json?gameId=" + gameId.toString());
        return responseString != null ? JsonResponseParserUtility.parseGameAction(responseString) : null;
    }

}
