/**
 * Patrick John Haskins
 * Zachary Evans
 * CS7020 - Term Project
 */
package android.otasyn.cardgames.manage.account.asynctask;

import android.os.AsyncTask;
import android.otasyn.cardgames.manage.account.dto.Friend;
import android.otasyn.cardgames.manage.account.dto.parse.JsonResponseParserUtility;
import android.otasyn.cardgames.manage.account.http.WebManager;

import java.util.List;

public class FriendsListTask extends AsyncTask<String,String,List<Friend>> {

    @Override
    protected List<Friend> doInBackground(final String... params) {
        return friendsList();
    }

    private List<Friend> friendsList() {
        String responseString = WebManager.get("http://cg.otasyn.net/friends/listall/json");
        return responseString != null ? JsonResponseParserUtility.parseFriendsList(responseString) : null;
    }

}
