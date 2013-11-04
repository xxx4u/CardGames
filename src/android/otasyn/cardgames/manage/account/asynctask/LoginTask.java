/**
 * Patrick John Haskins
 * Zachary Evans
 * CS7020 - Term Project
 */
package android.otasyn.cardgames.manage.account.asynctask;

import android.os.AsyncTask;
import android.otasyn.cardgames.manage.account.dto.SimpleUser;
import android.otasyn.cardgames.manage.account.dto.parse.JsonResponseParserUtility;
import android.otasyn.cardgames.manage.account.http.WebManager;
import org.apache.http.message.BasicNameValuePair;

public class LoginTask extends AsyncTask<String,String,SimpleUser> {

    public AsyncTask<String, String, SimpleUser> execute(String email, String password, boolean rememberMe) {
        return super.execute(email, password, String.valueOf(rememberMe));
    }

    @Override
    protected SimpleUser doInBackground(final String... params) {
        return login(params[0], params[1], params[2]);
    }

    private SimpleUser login(String email, String password, String rememberMe) {
        String responseString = WebManager.post("http://cg.otasyn.net/users/login/process",
                                                new BasicNameValuePair("email", email),
                                                new BasicNameValuePair("password", password),
                                                new BasicNameValuePair("rememberMe", rememberMe));
        return responseString != null ? JsonResponseParserUtility.parseUser(responseString) : null;
    }

}
