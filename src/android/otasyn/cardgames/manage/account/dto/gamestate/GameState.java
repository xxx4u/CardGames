package android.otasyn.cardgames.manage.account.dto.gamestate;

import android.otasyn.cardgames.manage.account.dto.GamePlayer;
import android.otasyn.cardgames.utility.enumeration.Card;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public abstract class GameState {

    private Queue<Card> deck;
    private Map<GamePlayer,List<Card>> hands;

    public Queue<Card> getDeck() {
        if (deck == null) {
            deck = new LinkedList<Card>();
        }
        return deck;
    }

    public void setDeck(final Queue<Card> deck) {
        this.deck = deck;
    }

    public Map<GamePlayer, List<Card>> getHands() {
        if (hands == null) {
            hands = new HashMap<GamePlayer, List<Card>>();
        }
        return hands;
    }

    public void setHands(final Map<GamePlayer, List<Card>> hands) {
        this.hands = hands;
    }

    @Override
    public String toString() {
        return "GameState{" +
                "deck=" + deck +
                ", hands=" + hands +
                '}';
    }
}
