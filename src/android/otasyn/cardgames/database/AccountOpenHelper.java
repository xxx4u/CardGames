/**
 * Patrick John Haskins
 * Zachary Evans
 * CS7020 - Term Project
 */
package android.otasyn.cardgames.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AccountOpenHelper extends SQLiteOpenHelper {

    private final String tableLogin;

    private String createLoginTable;
    private String dropLoginTable;

    public AccountOpenHelper(final Context context, final String dbName,
                             final SQLiteDatabase.CursorFactory factory, final int version,
                             final String tableLogin) {
        super(context, dbName, factory, version);
        this.tableLogin = tableLogin;
        setupSql();
    }

    private void setupSql() {
        createLoginTable = new SqlQuery().appendlastln(
                "CREATE TABLE ", tableLogin, " (").appendln(
                "    email TEXT,",
                "    password TEXT",
                ")").toString();

        dropLoginTable = new SqlQuery().appendlastln(
                "DROP TABLE IF EXISTS ", tableLogin).toString();
    }

    @Override
    public void onCreate(final SQLiteDatabase db) {
        db.execSQL(createLoginTable);
    }

    @Override
    public void onUpgrade(final SQLiteDatabase db, final int oldVersion, final int newVersion) {
        db.execSQL(dropLoginTable);
        db.execSQL(createLoginTable);
    }
}
