package android.otasyn.cardgames.manage.account.dto.gamestate;

import android.otasyn.cardgames.manage.account.dto.gamestate.freestyle.BoardCard;
import android.otasyn.cardgames.utility.enumeration.Card;

import java.util.HashMap;
import java.util.Map;

public class FreestyleState extends GameState {

    private Map<Card,BoardCard> board;

    public Map<Card,BoardCard> getBoard() {
        if (board == null) {
            board = new HashMap<Card, BoardCard>();
        }
        return board;
    }

    public void setBoard(final Map<Card,BoardCard> board) {
        this.board = board;
    }
}
