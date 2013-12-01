/**
 * Patrick John Haskins
 * Zachary Evans
 * CS7020 - Term Project
 */
package android.otasyn.cardgames.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class AccountConnector {

    private static final String DATABASE_NAME = "account.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_LOGIN = "login";
    private AccountOpenHelper dbHelper;
    private SQLiteDatabase db;

    public AccountConnector(Context context) {
        dbHelper = new AccountOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION, TABLE_LOGIN);
    }

    public void open() {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        if (db != null) {
            db.close();
            db = null;
        }
    }

    public void setLogin(final String email, final String password) {
        ContentValues cv = new ContentValues();
        cv.put("email", email);
        cv.put("password", password);

        open();
        db.delete(TABLE_LOGIN, null, null);
        db.insert(TABLE_LOGIN, null, cv);
        close();
    }

    public void deleteLogin() {
        open();
        db.delete(TABLE_LOGIN, null, null);
        close();
    }

    public LoginInfo getLogin() {
        open();
        Cursor cursor = db.query(TABLE_LOGIN, new String[] {"email", "password"}, null, null, null, null, null);
        LoginInfo loginInfo = null;
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            loginInfo = new LoginInfo(
                    cursor.getString(cursor.getColumnIndex("email")),
                    cursor.getString(cursor.getColumnIndex("password")));
        }
        close();
        return loginInfo;
    }
}
