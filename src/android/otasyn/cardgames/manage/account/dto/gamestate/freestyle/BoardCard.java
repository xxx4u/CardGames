package android.otasyn.cardgames.manage.account.dto.gamestate.freestyle;

import android.otasyn.cardgames.utility.enumeration.Card;

public class BoardCard {

    private Card card;
    private float x;
    private float y;
    private boolean faceUp;

    public Card getCard() {
        return card;
    }

    public void setCard(final Card card) {
        this.card = card;
    }

    public float getX() {
        return x;
    }

    public void setX(final float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(final float y) {
        this.y = y;
    }

    public boolean isFaceUp() {
        return faceUp;
    }

    public void setFaceUp(final boolean faceUp) {
        this.faceUp = faceUp;
    }
}