/**
 * Patrick John Haskins
 * Zachary Evans
 * CS7020 - Term Project
 */
package android.otasyn.cardgames.manage.account.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.otasyn.cardgames.MainActivity;
import android.otasyn.cardgames.R;
import android.otasyn.cardgames.database.GetLoginListTask;
import android.otasyn.cardgames.database.LoginInfo;
import android.otasyn.cardgames.manage.account.utility.AccountUtility;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class LoginActivity extends Activity {

    public static void launch(final Context context) {
        LoginActivity.setNextDestination(MainActivity.class);
        Intent loginIntent = new Intent(context, LoginActivity.class);
        loginIntent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        context.startActivity(loginIntent);
    }

    private static Class<? extends Activity> nextDestination = null;

    public static void setNextDestination(Class<? extends Activity> nextDestination) {
        LoginActivity.nextDestination = nextDestination;
    }

    private EditText loginEmail;
    private EditText loginPassword;
    private CheckBox loginRemember;

    private LoginInfo loginInfo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginEmail = (EditText) findViewById(R.id.loginEmail);
        loginPassword = (EditText) findViewById(R.id.loginPassword);
        loginRemember = (CheckBox) findViewById(R.id.loginRemember);

        try {
            loginInfo = new GetLoginListTask().execute(this).get();
        } catch (Exception e) {
            loginInfo = null;
        }

        if (loginInfo == null) {
            loginEmail.setText("");
            loginPassword.setText("");
            loginRemember.setChecked(false);
        } else {
            loginEmail.setText(loginInfo.getEmail());
            loginPassword.setText(loginInfo.getPassword());
            loginRemember.setChecked(true);
        }

        Button loginSubmitButton = (Button) findViewById(R.id.loginSubmitButton);
        loginSubmitButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                login();
            }
        });
    }

    public void login() {
        LoginInfo newLoginInfo = new LoginInfo(loginEmail.getText().toString(), loginPassword.getText().toString());
        AccountUtility.rememberAndLogin(LoginActivity.this, loginRemember.isChecked(), newLoginInfo, loginInfo);
        launchNextDestination();
    }

    private void launchNextDestination() {
        try {
            if (nextDestination != null) {
                if (FriendsListActivity.class.equals(nextDestination)) {
                    FriendsListActivity.launch(LoginActivity.this);
                } else if (GamesListActivity.class.equals(nextDestination)) {
                    GamesListActivity.launch(LoginActivity.this);
                } else if (MainActivity.class.equals(nextDestination)) {
                    MainActivity.launch(LoginActivity.this);
                } else {
                    LoginActivity.this.startActivity(new Intent(LoginActivity.this, nextDestination));
                }
            } else {
                LoginActivity.this.startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        } finally {
            nextDestination = null;
        }
    }

}