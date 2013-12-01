/**
 * Patrick John Haskins
 * Zachary Evans
 * CS7020 - Term Project
 */
package android.otasyn.cardgames.manage.account.asynctask;

import android.os.AsyncTask;
import android.otasyn.cardgames.manage.account.dto.Game;
import android.otasyn.cardgames.manage.account.dto.parse.JsonResponseParserUtility;
import android.otasyn.cardgames.manage.account.http.WebManager;
import org.apache.http.message.BasicNameValuePair;

public class AcceptGameTask extends AsyncTask<Game,String,Game> {

    public AsyncTask<Game,String,Game> execute(final Game game) {
        return super.execute(game);
    }

    @Override
    protected Game doInBackground(final Game... params) {
        return accept(params[0]);
    }

    private Game accept(final Game game) {
        String responseString = WebManager.post("http://cg.otasyn.net/games/accept/json",
                                                new BasicNameValuePair("gameId", game.getId().toString()));
        return responseString != null ? JsonResponseParserUtility.parseGame(responseString) : null;
    }

}
