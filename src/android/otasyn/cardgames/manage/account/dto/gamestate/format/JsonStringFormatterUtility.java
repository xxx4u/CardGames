package android.otasyn.cardgames.manage.account.dto.gamestate.format;

import android.otasyn.cardgames.manage.account.dto.GamePlayer;
import android.otasyn.cardgames.manage.account.dto.gamestate.FivesState;
import android.otasyn.cardgames.manage.account.dto.gamestate.FreestyleState;
import android.otasyn.cardgames.manage.account.dto.gamestate.GameState;
import android.otasyn.cardgames.manage.account.dto.gamestate.freestyle.BoardCard;
import android.otasyn.cardgames.utility.enumeration.Card;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class JsonStringFormatterUtility {

    private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm a");

    public static String formatFreestyleState(final FreestyleState freestyleState) {
        try {
            JSONObject jsonFreestyleState = new JSONObject();

            formatGameState(freestyleState, jsonFreestyleState);

            Map<Card,BoardCard> board = freestyleState.getBoard();
            JSONObject jsonBoard = new JSONObject();
            for (Map.Entry<Card,BoardCard> boardEntry : board.entrySet()) {
                BoardCard boardCard = boardEntry.getValue();
                JSONObject jsonBoardCard = new JSONObject();
                jsonBoardCard.put("card", boardCard.getCard().getId());
                jsonBoardCard.put("x", boardCard.getX());
                jsonBoardCard.put("y", boardCard.getY());
                jsonBoardCard.put("faceUp", boardCard.isFaceUp());

                jsonBoard.put(String.valueOf(boardEntry.getKey().getId()), jsonBoardCard);
            }
            jsonFreestyleState.put("board", jsonBoard);

            return jsonFreestyleState.toString();
        } catch (JSONException e) {
            return null;
        }
    }

    public static String formatFivesState(final FivesState fivesState) {
        try {
            JSONObject jsonFivesState = new JSONObject();

            formatGameState(fivesState, jsonFivesState);

            return jsonFivesState.toString();
        } catch (JSONException e) {
            return null;
        }
    }

    private static void formatGameState(final GameState gameState, final JSONObject jsonGameState)
            throws JSONException {
        Queue<Card> deck = gameState.getDeck();
        JSONArray jsonDeck = new JSONArray();
        for (Card card : deck) {
            jsonDeck.put(card.getId());
        }
        jsonGameState.put("deck", jsonDeck);

        Map<GamePlayer,List<Card>> hands = gameState.getHands();
        JSONObject jsonHands = new JSONObject();
        for (Map.Entry<GamePlayer,List<Card>> handEntry : hands.entrySet()) {
            JSONArray jsonHand = new JSONArray();
            for (Card card : handEntry.getValue()) {
                jsonHand.put(card.getId());
            }
            jsonHands.put(handEntry.getKey().getId().toString(), jsonHand);
        }
        jsonGameState.put("hands", jsonHands);
    }

}
