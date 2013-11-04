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
import android.otasyn.cardgames.R;
import android.otasyn.cardgames.manage.account.asynctask.CurrentUserTask;
import android.otasyn.cardgames.manage.account.asynctask.FriendsListTask;
import android.otasyn.cardgames.manage.account.dto.Friend;
import android.otasyn.cardgames.manage.account.dto.SimpleUser;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
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

    final List<Friend> friends = new ArrayList<>();

    private LinearLayout friendsListLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_list);

        friendsListLayout = (LinearLayout) findViewById(R.id.friendsListLayout);

        friendsList();
    }

    private void friendsList() {
        friends.clear();
        try {
            friends.addAll(new FriendsListTask().execute().get());
        } catch (Exception e) { }

        if (!friends.isEmpty()) {
            friendsListLayout.removeAllViews();
            for (Friend friend : friends) {
                LinearLayout friendLayout = new LinearLayout(this);
                friendLayout.setOrientation(LinearLayout.VERTICAL);
                LinearLayout.LayoutParams friendLayoutParams = new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                friendLayoutParams.bottomMargin = getResources().getDimensionPixelSize(R.dimen.listEntryBottomMargin);
                friendLayout.setLayoutParams(friendLayoutParams);

                // Display name
                TextView friendName = new TextView(this);
                friendName.setText(friend.getFirstname() + " " + friend.getLastname());
                friendName.setTextColor(getResources().getColor(R.color.listEntryHeader));
                LinearLayout.LayoutParams friendNameLayoutParams = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                friendNameLayoutParams.leftMargin = getResources().getDimensionPixelSize(R.dimen.listEntryHeaderLeftMargin);
                friendName.setLayoutParams(friendNameLayoutParams);
                friendLayout.addView(friendName);

                // Display email
                TextView friendEmail = new TextView(this);
                friendEmail.setText(friend.getEmail());
                friendEmail.setTextColor(getResources().getColor(R.color.listEntryDetails));
                LinearLayout.LayoutParams friendEmailLayoutParams = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                friendEmailLayoutParams.leftMargin = getResources().getDimensionPixelSize(R.dimen.listEntryDetailsLeftMargin);
                friendEmail.setLayoutParams(friendEmailLayoutParams);
                friendLayout.addView(friendEmail);

                // If not confirmed, display "Awaiting Confirmation".
                if (!friend.isConfirmed()) {
                    TextView friendConfirmed = new TextView(this);
                    friendConfirmed.setText("Awaiting Confirmation");
                    friendConfirmed.setTextColor(getResources().getColor(R.color.listEntryDetails));
                    LinearLayout.LayoutParams friendConfirmedLayoutParams = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    friendConfirmedLayoutParams.leftMargin = getResources().getDimensionPixelSize(R.dimen.listEntryDetailsLeftMargin);
                    friendConfirmed.setLayoutParams(friendConfirmedLayoutParams);
                    friendConfirmed.setBackgroundDrawable(getResources().getDrawable(R.drawable.awaiting_response_background));
                    friendConfirmed.setPadding(
                            getResources().getDimensionPixelSize(R.dimen.awaitingConfirmationLeftRightPadding),
                            getResources().getDimensionPixelSize(R.dimen.awaitingConfirmationTopBottomPadding),
                            getResources().getDimensionPixelSize(R.dimen.awaitingConfirmationLeftRightPadding),
                            getResources().getDimensionPixelSize(R.dimen.awaitingConfirmationTopBottomPadding)
                    );
                    friendLayout.addView(friendConfirmed);
                }

                friendsListLayout.addView(friendLayout);
            }
        }
    }

}