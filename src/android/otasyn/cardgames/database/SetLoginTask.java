package android.otasyn.cardgames.database;

import android.content.Context;
import android.os.AsyncTask;

public class SetLoginTask extends AsyncTask<Object, Object, Void> {

    private AccountConnector dbc;

    @Override
    protected Void doInBackground(final Object... params) {
        LoginInfo loginInfo;
        if (params.length == 2
                && (params[0] instanceof Context)
                && (params[1] instanceof LoginInfo)) {
            loginInfo = (LoginInfo) params[1];
        } else if (params.length == 3
                || !(params[0] instanceof Context)
                || !(params[1] instanceof String)
                || !(params[2] instanceof String)) {
            loginInfo = new LoginInfo((String) params[1], (String) params[2]);
        } else {
            return null;
        }
        dbc = new AccountConnector((Context) params[0]);
        dbc.setLogin(loginInfo.getEmail(), loginInfo.getPassword());
        return null;
    }
}
