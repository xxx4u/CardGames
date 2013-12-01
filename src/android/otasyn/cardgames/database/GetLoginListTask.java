/**
 * Patrick John Haskins
 * Zachary Evans
 * CS7020 - Term Project
 */
package android.otasyn.cardgames.database;

import android.content.Context;
import android.os.AsyncTask;

public class GetLoginListTask extends AsyncTask<Object, String, LoginInfo> {

    private AccountConnector dbc;

    @Override
    protected LoginInfo doInBackground(Object... params) {
        if (params.length != 1 || !(params[0] instanceof Context)) {
            return null;
        }
        dbc = new AccountConnector((Context) params[0]);
        return dbc.getLogin();
    }
}
