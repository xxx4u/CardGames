/**
 * Patrick John Haskins
 * Zachary Evans
 * CS7020 - Term Project
 */
package android.otasyn.cardgames.manage.account.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.otasyn.cardgames.R;
import android.otasyn.cardgames.manage.account.asynctask.CurrentUserTask;
import android.otasyn.cardgames.manage.account.asynctask.FriendsListTask;
import android.otasyn.cardgames.manage.account.dto.Friend;
import android.otasyn.cardgames.manage.account.dto.SimpleUser;

import java.util.List;

public class FriendsListActivity extends Activity {

    public static void launch(final Context context) {
        SimpleUser user = null;
        try {
            user = new CurrentUserTask().execute().get();
        } catch (Exception e) { }

        if (user != null) {
            context.startActivity(new Intent(context, FriendsListActivity.class));
        } else {
            LoginActivity.setNextDestination(FriendsListActivity.class);
            context.startActivity(new Intent(context, LoginActivity.class));
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_list);

        friendsList();
    }

    private void friendsList() {
        List<Friend> friends = null;
        try {
            friends = new FriendsListTask().execute().get();
        } catch (Exception e) { }

        String friendsString = null;
        if (friends != null) {
            friendsString = "Friends[" + friends.size() + "]:";
            for (Friend friend : friends) {
                friendsString += "\n  " + friend.getFirstname() + " " + friend.getLastname();
            }
        }

        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(FriendsListActivity.this);
        alertBuilder
                .setMessage(friendsString != null ? friendsString : "No friends.")
                .setCancelable(true)
                .create()
                .show();
    }

}