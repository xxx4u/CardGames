/**
 * Patrick John Haskins
 * Zachary Evans
 * CS7020 - Term Project
 */
package android.otasyn.cardgames.manage.account.dto.parse;

import android.otasyn.cardgames.manage.account.dto.Friend;
import android.otasyn.cardgames.manage.account.dto.Game;
import android.otasyn.cardgames.manage.account.dto.GameAction;
import android.otasyn.cardgames.manage.account.dto.GamePlayer;
import android.otasyn.cardgames.manage.account.dto.SimpleUser;
import android.otasyn.cardgames.manage.account.dto.gamestate.FivesState;
import android.otasyn.cardgames.manage.account.dto.gamestate.FreestyleState;
import android.otasyn.cardgames.manage.account.dto.gamestate.GameState;
import android.otasyn.cardgames.manage.account.enumeration.GameType;
import android.otasyn.cardgames.utility.DateUtility;
import android.otasyn.cardgames.utility.enumeration.Card;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.UUID;

public class JsonResponseParserUtility {

    private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm a");

    public static boolean parseSuccess(final String responseString) {
        try {
            JSONObject jsonResponse = new JSONObject(responseString);
            if (jsonResponse.has("success")) {
                return jsonResponse.optBoolean("success");
            }
        } catch (JSONException e) { }
        return false;
    }

    public static SimpleUser parseUser(final String responseString) {
        try {
            JSONObject jsonResponse = new JSONObject(responseString);
            boolean success = jsonResponse.optBoolean("success");
            if (success && jsonResponse.has("user") && !jsonResponse.isNull("user")) {
                return parseUser(jsonResponse.optJSONObject("user"));
            }
        } catch (JSONException e) { }
        return null;
    }

    public static List<Friend> parseFriendsList(final String responseString) {
        try {
            JSONObject jsonResponse = new JSONObject(responseString);
            boolean success = jsonResponse.optBoolean("success");
            if (success && jsonResponse.has("friends") && !jsonResponse.isNull("friends")) {
                JSONArray jsonFriends = jsonResponse.optJSONArray("friends");
                if (jsonFriends != null) {
                    List<Friend> friends = new ArrayList<Friend>(jsonFriends.length());
                    for (int n = 0; n < jsonFriends.length(); n++) {
                        friends.add(parseFriend(jsonFriends.optJSONObject(n)));
                    }
                    return friends;
                }
            }
        } catch (JSONException e) { }
        return null;
    }

    public static List<Game> parseGamesList(final String responseString) {
        try {
            JSONObject jsonResponse = new JSONObject(responseString);
            boolean success = jsonResponse.optBoolean("success");
            if (success && jsonResponse.has("games") && !jsonResponse.isNull("games")) {
                JSONArray jsonGames = jsonResponse.optJSONArray("games");
                if (jsonGames != null) {
                    List<Game> games = new ArrayList<Game>(jsonGames.length());
                    for (int n = 0; n < jsonGames.length(); n++) {
                        games.add(parseGame(jsonGames.optJSONObject(n)));
                    }
                    return games;
                }
            }
        } catch (JSONException e) { }
        return null;
    }

    public static Game parseGame(final String responseString) {
        try {
            JSONObject jsonResponse = new JSONObject(responseString);
            boolean success = jsonResponse.optBoolean("success");
            if (success && jsonResponse.has("game") && !jsonResponse.isNull("game")) {
                return parseGame(jsonResponse.optJSONObject("game"));
            }
        } catch (JSONException e) { }
        return null;
    }

    public static GameAction parseGameAction(final String responseString) {
        try {
            JSONObject jsonResponse = new JSONObject(responseString);
            boolean success = jsonResponse.optBoolean("success");
            if (success && jsonResponse.has("gameAction") && !jsonResponse.isNull("gameAction")) {
                return parseGameAction(jsonResponse.optJSONObject("gameAction"));
            }
        } catch (JSONException e) { }
        return null;
    }

    private static SimpleUser parseUser(final JSONObject jsonUser) {
        if (jsonUser == null) {
            return null;
        }
        SimpleUser user = new SimpleUser();
        if (jsonUser.has("id") && !jsonUser.isNull("id")) {
            user.setId(jsonUser.optInt("id", -1));
        }
        if (jsonUser.has("firstname") && !jsonUser.isNull("firstname")) {
            user.setFirstname(jsonUser.optString("firstname"));
        }
        if (jsonUser.has("lastname") && !jsonUser.isNull("lastname")) {
            user.setLastname(jsonUser.optString("lastname"));
        }
        if (jsonUser.has("email") && !jsonUser.isNull("email")) {
            user.setEmail(jsonUser.optString("email"));
        }
        if (jsonUser.has("enabled") && !jsonUser.isNull("enabled")) {
            user.setEnabled(jsonUser.optBoolean("enabled"));
        }
        return user;
    }

    private static GamePlayer parseGamePlayer(final JSONObject jsonGamePlayer) {
        if (jsonGamePlayer == null) {
            return null;
        }
        GamePlayer gamePlayer = new GamePlayer(parseUser(jsonGamePlayer));
        if (jsonGamePlayer.has("game") && !jsonGamePlayer.isNull("game")) {
            gamePlayer.setGame(parseGame(jsonGamePlayer.optJSONObject("game")));
        }
        if (jsonGamePlayer.has("accepted") && !jsonGamePlayer.isNull("accepted")) {
            gamePlayer.setAccepted(jsonGamePlayer.optBoolean("accepted"));
        }
        return gamePlayer;
    }

    private static Friend parseFriend(final JSONObject jsonFriend) {
        Friend friend = new Friend(parseUser(jsonFriend));
        if (jsonFriend.has("confirmed") && !jsonFriend.isNull("confirmed")) {
            friend.setConfirmed(jsonFriend.optBoolean("confirmed"));
        }
        return friend;
    }

    private static Game parseGame(final JSONObject jsonGame) {
        if (jsonGame == null) {
            return null;
        }
        Game game = new Game();
        if (jsonGame.has("id") && !jsonGame.isNull("id")) {
            game.setId(jsonGame.optInt("id", -1));
        }
        if (jsonGame.has("currentUserIsOwner") && !jsonGame.isNull("currentUserIsOwner")) {
            game.setCurrentUserIsOwner(jsonGame.optBoolean("currentUserIsOwner"));
        }
        if (jsonGame.has("owner") && !jsonGame.isNull("owner")) {
            game.setOwner(parseUser(jsonGame.optJSONObject("owner")));
        }
        if (jsonGame.has("gameType") && !jsonGame.isNull("gameType")) {
            game.setGameType(parseGameType(jsonGame.optJSONObject("gameType")));
        }
        if (jsonGame.has("uuid") && !jsonGame.isNull("uuid")) {
            game.setUuid(UUID.fromString(jsonGame.optString("uuid")));
        }
        if (jsonGame.has("started") && !jsonGame.isNull("started")) {
            game.setStarted(jsonGame.optBoolean("started"));
        }
        if (jsonGame.has("dateAdded") && !jsonGame.isNull("dateAdded")) {
            try {
                game.setDateAdded(DateUtility.dateFormat.parse(jsonGame.optString("dateAdded")));
            } catch (ParseException e) {
                game.setDateAdded(null);
            }
        }
        if (jsonGame.has("players") && !jsonGame.isNull("players")) {
            JSONArray jsonPlayers = jsonGame.optJSONArray("players");
            if (jsonPlayers != null) {
                Set<GamePlayer> players = new HashSet<GamePlayer>(jsonPlayers.length());
                Map<Integer,GamePlayer> playerMap = new HashMap<Integer, GamePlayer>(jsonPlayers.length());
                for (int n = 0; n < jsonPlayers.length(); n++) {
                    GamePlayer gamePlayer = parseGamePlayer(jsonPlayers.optJSONObject(n));
                    players.add(gamePlayer);
                    playerMap.put(gamePlayer.getId(), gamePlayer);
                }
                game.setPlayers(players);
                game.setPlayerMap(playerMap);
            }
        }
        if (jsonGame.has("turnOrder") && !jsonGame.isNull("turnOrder")) {
            JSONArray jsonTurnOrder = jsonGame.optJSONArray("turnOrder");
            if (jsonTurnOrder != null && jsonTurnOrder.length() == game.getPlayerMap().size()) {
                List<GamePlayer> turnOrder = new ArrayList<GamePlayer>(jsonTurnOrder.length());
                for (int n = 0; n < jsonTurnOrder.length(); n++) {
                    turnOrder.add(game.getPlayerMap().get(jsonTurnOrder.optInt(n, -1)));
                }
                game.setTurnOrder(turnOrder);
            }
        }
        if (jsonGame.has("currentUserAccepted") && !jsonGame.isNull("currentUserAccepted")) {
            game.setCurrentUserAccepted(jsonGame.optBoolean("currentUserAccepted"));
        }
        return game;
    }

    private static GameType parseGameType(final JSONObject jsonGameType) {
        if (jsonGameType == null) {
            return null;
        }
        if (jsonGameType.has("id") && !jsonGameType.isNull("id")) {
            return GameType.findGameType(jsonGameType.optInt("id", -1));
        }
        return GameType.UNKNOWN;
    }

    private static GameAction parseGameAction(final JSONObject jsonGameAction) {
        if (jsonGameAction == null) {
            return null;
        }
        GameAction gameAction = new GameAction();
        if (jsonGameAction.has("game") && !jsonGameAction.isNull("game")) {
            gameAction.setGame(parseGame(jsonGameAction.optJSONObject("game")));
        }
        if (jsonGameAction.has("actionNumber") && !jsonGameAction.isNull("actionNumber")) {
            gameAction.setActionNumber(jsonGameAction.optInt("actionNumber", -1));
        }
        if (jsonGameAction.has("nextActionPlayer") && !jsonGameAction.isNull("nextActionPlayer")) {
            gameAction.setNextActionPlayer(parseGamePlayer(jsonGameAction.optJSONObject("nextActionPlayer")));
        }
        if (jsonGameAction.has("gameState") && !jsonGameAction.isNull("gameState") && gameAction.getGame() != null) {
            gameAction.setGameState(parseGameState(jsonGameAction.optJSONObject("gameState"), gameAction.getGame()));
        }
        if (jsonGameAction.has("actionDate") && !jsonGameAction.isNull("actionDate")) {
            try {
                gameAction.setActionDate(formatter.parse(jsonGameAction.optString("actionDate")));
            } catch (ParseException e) {
                gameAction.setActionDate(null);
            }
        }
        return gameAction;
    }

    private static GameState parseGameState(final JSONObject jsonGameState, final Game game) {
        if (jsonGameState == null || game == null) {
            return null;
        }
        switch (game.getGameType()) {
            case FREESTYLE:
                return parseFreestyleState(jsonGameState, game);
            case FIVES:
                return parseFivesState(jsonGameState, game);
            default:
                return null;
        }
    }

    private static FreestyleState parseFreestyleState(final JSONObject jsonFreestyleState, final Game game) {
        if (jsonFreestyleState == null) {
            return null;
        }
        FreestyleState freestyleState = new FreestyleState();
        populateGameState(freestyleState, jsonFreestyleState, game);
        return freestyleState;
    }

    private static FivesState parseFivesState(final JSONObject jsonFivesState, final Game game) {
        if (jsonFivesState == null) {
            return null;
        }
        FivesState fivesState = new FivesState();
        populateGameState(fivesState, jsonFivesState, game);
        return fivesState;
    }

    private static void populateGameState(final GameState gameState, final JSONObject jsonGameState,
                                          final Game game) {
        if (jsonGameState.has("deck") && !jsonGameState.isNull("deck")) {
            populateDeck(gameState, jsonGameState.optJSONArray("deck"));
        }
        if (jsonGameState.has("hands") && !jsonGameState.isNull("hands")) {
            populateHands(gameState, jsonGameState.optJSONObject("hands"), game);
        }
    }

    private static void populateDeck(final GameState gameState, final JSONArray jsonDeck) {
        if (jsonDeck != null) {
            Queue<Card> deck = new LinkedList<Card>();
            for (int n = 0; n < jsonDeck.length(); n++) {
                deck.add(Card.findCard(jsonDeck.optInt(n, -1)));
            }
            gameState.setDeck(deck);
        }
    }

    private static void populateHands(final GameState gameState, final JSONObject jsonHands, final Game game) {
        if (jsonHands != null) {
            Map<GamePlayer,List<Card>> hands = new HashMap<GamePlayer, List<Card>>(jsonHands.length());
            Iterator<String> iterator;
            for (iterator = jsonHands.keys(); iterator.hasNext();) {
                String key = iterator.next();
                JSONArray jsonHand = jsonHands.optJSONArray(key);
                if (jsonHand == null) {
                    hands.put(new GamePlayer(Integer.valueOf(key), game), new ArrayList<Card>(0));
                } else {
                    List<Card> hand = new ArrayList<Card>(jsonHand.length());
                    for (int n = 0; n < jsonHand.length(); n++) {
                        hand.add(Card.findCard(jsonHand.optInt(n, -1)));
                    }
                    hands.put(new GamePlayer(Integer.valueOf(key), game), hand);
                }
            }
            gameState.setHands(hands);
        }
    }

}
