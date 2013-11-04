/**
 * Patrick John Haskins
 * Zachary Evans
 * CS7020 - Term Project
 */
package android.otasyn.cardgames.manage.account.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.otasyn.cardgames.MainActivity;
import android.otasyn.cardgames.R;
import android.otasyn.cardgames.manage.account.asynctask.LoginTask;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity {

    private static Class<? extends Activity> nextDestination = null;

    public static void setNextDestination(Class<? extends Activity> nextDestination) {
        LoginActivity.nextDestination = nextDestination;
    }

    private EditText loginEmail;
    private EditText loginPassword;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginEmail = (EditText) findViewById(R.id.loginEmail);
        loginPassword = (EditText) findViewById(R.id.loginPassword);

        Button loginSubmitButton = (Button) findViewById(R.id.loginSubmitButton);
        loginSubmitButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                login();
            }
        });
    }

    public void login() {
        try {
            new LoginTask()
                    .execute(loginEmail.getText().toString(), loginPassword.getText().toString(), false)
                    .get();
        } catch (Exception e) { }

        launchNextDestination();
    }

    private void launchNextDestination() {
        try {
            if (nextDestination != null) {
                if (FriendsListActivity.class.equals(nextDestination)) {
                    FriendsListActivity.launch(LoginActivity.this);
                } else if (GamesListActivity.class.equals(nextDestination)) {
                    GamesListActivity.launch(LoginActivity.this);
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