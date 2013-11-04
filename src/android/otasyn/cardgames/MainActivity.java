/**
 * Patrick John Haskins
 * Zachary Evans
 * CS7020 - Term Project
 */
package android.otasyn.cardgames;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.otasyn.cardgames.manage.account.activity.FriendsListActivity;
import android.otasyn.cardgames.manage.account.activity.GamesListActivity;
import android.otasyn.cardgames.manage.account.activity.LoginActivity;
import android.otasyn.cardgames.manage.account.activity.RegisterActivity;
import android.otasyn.cardgames.manage.account.asynctask.CurrentUserTask;
import android.otasyn.cardgames.manage.account.asynctask.LogoutTask;
import android.otasyn.cardgames.manage.account.dto.SimpleUser;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginActivityButton = (Button) findViewById(R.id.buttonLaunchLoginActivity);
        loginActivityButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });

        Button currentUser = (Button) findViewById(R.id.buttonCurrentUser);
        currentUser.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                currentUser();
            }
        });

        Button logout = (Button) findViewById(R.id.buttonLogout);
        logout.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                logout();
            }
        });

        Button registerActivityButton = (Button) findViewById(R.id.buttonLaunchRegisterActivity);
        registerActivityButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });

        Button friendsListActivityButton = (Button) findViewById(R.id.buttonLaunchFriendsListActivity);
        friendsListActivityButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                FriendsListActivity.launch(MainActivity.this);
            }
        });

        Button gamesListActivityButton = (Button) findViewById(R.id.buttonLaunchGamesListActivity);
        gamesListActivityButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                GamesListActivity.launch(MainActivity.this);
            }
        });
        
        Button gameActivityButton = (Button) findViewById(R.id.buttonLaunchGameActivity);
        gameActivityButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, GameActivity.class));
            }
        });
    }

    private void currentUser() {
        SimpleUser user = null;
        try {
            user = new CurrentUserTask().execute().get();
        } catch (Exception e) { }

        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);
        alertBuilder
                .setMessage(user != null ? user.toString() : "No user.")
                .setCancelable(true)
                .create()
                .show();
    }

    private void logout() {
        boolean logoutSuccess = false;
        try {
            logoutSuccess = new LogoutTask().execute().get();
        } catch (Exception e) { }

        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);
        alertBuilder
                .setMessage(logoutSuccess ? "Logout Successful." : "Logout Failed.")
                .setCancelable(true)
                .create()
                .show();
    }

}
