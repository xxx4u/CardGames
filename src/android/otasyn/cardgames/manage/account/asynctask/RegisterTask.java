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

public class RegisterTask extends AsyncTask<String,String,SimpleUser> {

    public AsyncTask<String, String, SimpleUser> execute(final String firstname, final String lastname,
                                                         final String email, final String password,
                                                         final String passwordConfirm) {
        return super.execute(firstname, lastname, email, password, passwordConfirm);
    }

    @Override
    protected SimpleUser doInBackground(final String... params) {
        return register(params[0], params[1], params[2], params[3], params[4]);
    }

    private SimpleUser register(final String firstname, final String lastname,
                             final String email, final String password,
                             final String passwordConfirm) {
        String responseString = WebManager.post("http://cg.otasyn.net/users/register/json",
                new BasicNameValuePair("firstname", firstname),
                new BasicNameValuePair("lastname", lastname),
                new BasicNameValuePair("email", email),
                new BasicNameValuePair("password", password),
                new BasicNameValuePair("passwordConfirm", passwordConfirm));
        return responseString != null ? JsonResponseParserUtility.parseUser(responseString) : null;
    }

}