package android.otasyn.cardgames.manage.account.asynctask;

import android.os.AsyncTask;
import android.otasyn.cardgames.manage.account.dto.GameAction;
import android.otasyn.cardgames.manage.account.dto.parse.JsonResponseParserUtility;
import android.otasyn.cardgames.manage.account.http.WebManager;
import org.apache.http.message.BasicNameValuePair;

public class TurnTask extends AsyncTask<String,String,GameAction> {

    public AsyncTask<String, String, GameAction> execute(final String gameId, final String jsonGameState) {
        return super.execute(gameId, jsonGameState);
    }

    @Override
    protected GameAction doInBackground(final String... params) {
        return turn(params[0], params[1]);
    }

    private GameAction turn(final String gameId, final String jsonGameState) {
        String responseString = WebManager.post("http://cg.otasyn.net/game/action/turn/json",
                                                new BasicNameValuePair("gameId", gameId),
                                                new BasicNameValuePair("gameState", jsonGameState));
        return responseString != null ? JsonResponseParserUtility.parseGameAction(responseString) : null;
    }

}