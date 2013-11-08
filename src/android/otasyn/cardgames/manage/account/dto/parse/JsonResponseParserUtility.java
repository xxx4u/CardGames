/**
 * Patrick John Haskins
 * Zachary Evans
 * CS7020 - Term Project
 */
package android.otasyn.cardgames.manage.account.dto.parse;

import android.otasyn.cardgames.manage.account.dto.Friend;
import android.otasyn.cardgames.manage.account.dto.Game;
import android.otasyn.cardgames.manage.account.dto.GamePlayer;
import android.otasyn.cardgames.manage.account.dto.GameType;
import android.otasyn.cardgames.manage.account.dto.SimpleUser;
import android.otasyn.cardgames.utility.DateUtility;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class JsonResponseParserUtility {

    public static boolean parseSuccess(final String responseString) {
        try {
            JSONObject jsonResponse = new JSONObject(responseString);
            if (jsonResponse.has("success")) {
                return jsonResponse.getBoolean("success");
            }
        } catch (JSONException e) { }
        return false;
    }

    public static SimpleUser parseUser(final String responseString) {
        try {
            JSONObject jsonResponse = new JSONObject(responseString);
            boolean success = jsonResponse.getBoolean("success");
            if (success && jsonResponse.has("user")) {
                return parseUser(jsonResponse.getJSONObject("user"));
            }
        } catch (JSONException e) { }
        return null;
    }

    public static List<Friend> parseFriendsList(final String responseString) {
        try {
            JSONObject jsonResponse = new JSONObject(responseString);
            boolean success = jsonResponse.getBoolean("success");
            if (success && jsonResponse.has("friends")) {
                JSONArray jsonFriends = jsonResponse.getJSONArray("friends");
                List<Friend> friends = new ArrayList<Friend>(jsonFriends.length());
                for (int n = 0; n < jsonFriends.length(); n++) {
                    friends.add(parseFriend(jsonFriends.getJSONObject(n)));
                }
                return friends;
            }
        } catch (JSONException e) { }
        return null;
    }

    public static List<Game> parseGamesList(final String responseString) {
        try {
            JSONObject jsonResponse = new JSONObject(responseString);
            boolean success = jsonResponse.getBoolean("success");
            if (success && jsonResponse.has("games")) {
                JSONArray jsonGames = jsonResponse.getJSONArray("games");
                List<Game> games = new ArrayList<Game>(jsonGames.length());
                for (int n = 0; n < jsonGames.length(); n++) {
                    games.add(parseGame(jsonGames.getJSONObject(n)));
                }
                return games;
            }
        } catch (JSONException e) { }
        return null;
    }

    private static SimpleUser parseUser(final JSONObject jsonUser) {
        try {
            SimpleUser user = new SimpleUser();
            if (jsonUser.has("id")) {
                user.setId(jsonUser.getInt("id"));
            }
            if (jsonUser.has("firstname")) {
                user.setFirstname(jsonUser.getString("firstname"));
            }
            if (jsonUser.has("lastname")) {
                user.setLastname(jsonUser.getString("lastname"));
            }
            if (jsonUser.has("email")) {
                user.setEmail(jsonUser.getString("email"));
            }
            if (jsonUser.has("enabled")) {
                user.setEnabled(jsonUser.getBoolean("enabled"));
            }
            return user;
        } catch (JSONException e) { }
        return null;
    }

    private static GamePlayer parseGamePlayer(final JSONObject jsonGamePlayer) {
        try {
            GamePlayer gamePlayer = new GamePlayer(parseUser(jsonGamePlayer));
            if (jsonGamePlayer.has("game")) {
                gamePlayer.setGame(parseGame(jsonGamePlayer.getJSONObject("game")));
            }
            if (jsonGamePlayer.has("accepted")) {
                gamePlayer.setAccepted(jsonGamePlayer.getBoolean("accepted"));
            }
            return gamePlayer;
        } catch (JSONException e) { }
        return null;
    }

    private static Friend parseFriend(final JSONObject jsonFriend) {
        try {
            Friend friend = new Friend(parseUser(jsonFriend));
            if (jsonFriend.has("confirmed")) {
                friend.setConfirmed(jsonFriend.getBoolean("confirmed"));
            }
            return friend;
        } catch (JSONException e) { }
        return null;
    }

    private static Game parseGame(final JSONObject jsonGame) {
        try {
            Game game = new Game();
            if (jsonGame.has("id")) {
                game.setId(jsonGame.getInt("id"));
            }
            if (jsonGame.has("currentUserIsOwner")) {
                game.setCurrentUserIsOwner(jsonGame.getBoolean("currentUserIsOwner"));
            }
            if (jsonGame.has("owner")) {
                game.setOwner(parseUser(jsonGame.getJSONObject("owner")));
            }
            if (jsonGame.has("gameType")) {
                game.setGameType(parseGameType(jsonGame.getJSONObject("gameType")));
            }
            if (jsonGame.has("uuid")) {
                game.setUuid(UUID.fromString(jsonGame.getString("uuid")));
            }
            if (jsonGame.has("started")) {
                game.setStarted(jsonGame.getBoolean("started"));
            }
            if (jsonGame.has("dateAdded")) {
                game.setDateAdded(DateUtility.dateFormat.parse(jsonGame.getString("dateAdded")));
            }
            if (jsonGame.has("players")) {
                JSONArray jsonPlayers = jsonGame.getJSONArray("players");
                Set<GamePlayer> players = new HashSet<GamePlayer>(jsonPlayers.length());
                for (int n = 0; n < jsonPlayers.length(); n++) {
                    players.add(parseGamePlayer(jsonPlayers.getJSONObject(n)));
                }
                game.setPlayers(players);
            }
            return game;
        } catch (Exception e) { }
        return null;
    }

    private static GameType parseGameType(final JSONObject jsonGameType) {
        try {
            GameType gameType = new GameType(jsonGameType.getInt("id"));
            if (jsonGameType.has("name")) {
                gameType.setName(jsonGameType.getString("name"));
            }
            return gameType;
        } catch (JSONException e) { }
        return null;
    }

}
