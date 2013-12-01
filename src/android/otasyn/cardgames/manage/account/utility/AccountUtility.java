package android.otasyn.cardgames.manage.account.utility;

import android.content.Context;
import android.otasyn.cardgames.database.DeleteLoginTask;
import android.otasyn.cardgames.database.LoginInfo;
import android.otasyn.cardgames.database.SetLoginTask;
import android.otasyn.cardgames.manage.account.asynctask.CurrentUserTask;
import android.otasyn.cardgames.manage.account.asynctask.FriendsListTask;
import android.otasyn.cardgames.manage.account.asynctask.GamesListTask;
import android.otasyn.cardgames.manage.account.asynctask.LoginTask;
import android.otasyn.cardgames.manage.account.asynctask.LogoutTask;
import android.otasyn.cardgames.manage.account.asynctask.RegisterTask;
import android.otasyn.cardgames.manage.account.dto.Friend;
import android.otasyn.cardgames.manage.account.dto.Game;
import android.otasyn.cardgames.manage.account.dto.SimpleUser;
import org.andengine.util.debug.Debug;

import java.util.ArrayList;
import java.util.List;

public class AccountUtility {

    public static SimpleUser register(final String firstname, final String lastname, final String email,
                                      final String password, final String passwordConfirm) {
        try {
            return new RegisterTask().execute(firstname, lastname, email, password, passwordConfirm).get();
        } catch (Exception e) {
            Debug.e("Failed to register.", e);
        }
        return null;
    }

    public static SimpleUser rememberAndLogin(final Context context, final boolean remember,
                                        final LoginInfo newLoginInfo, final LoginInfo oldLoginInfo) {
        remember(context, remember, newLoginInfo, oldLoginInfo);
        return login(newLoginInfo);
    }

    public static void remember(final Context context, final boolean remember,
                                final LoginInfo newLoginInfo, final LoginInfo oldLoginInfo) {
        if (remember) {
            if (!newLoginInfo.equals(oldLoginInfo)) {
                new SetLoginTask().execute(context, newLoginInfo);
            }
        } else {
            new DeleteLoginTask().execute(context);
        }
    }

    public static SimpleUser login(final LoginInfo loginInfo) {
        try {
            // For now, don't use spring RememberMe functionality.
            return new LoginTask().execute(loginInfo.getEmail(), loginInfo.getPassword(), false).get();
        } catch (Exception e) {
            Debug.e("Failed to log in.", e);
        }
        return null;
    }

    public static SimpleUser currentUser() {
        try {
            return new CurrentUserTask().execute().get();
        } catch (Exception e) {
            Debug.e("Failed to retrieve current user.", e);
        }
        return null;
    }

    public static boolean logout() {
        try {
            return new LogoutTask().execute().get();
        } catch (Exception e) {
            Debug.e("Failed to logout.", e);
        }
        return false;
    }

    public static List<Friend> retrieveFriendsList() {
        try {
            return new FriendsListTask().execute().get();
        } catch (Exception e) {
            Debug.e("Failed to retrieve friends list.", e);
        }
        return new ArrayList<Friend>(0);
    }

    public static List<Game> retrieveGamesList() {
        try {
            return new GamesListTask().execute().get();
        } catch (Exception e) {
            Debug.e("Failed to retrieve games list.", e);
        }
        return new ArrayList<Game>(0);
    }

}
