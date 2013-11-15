package android.otasyn.cardgames.scene;

import android.otasyn.cardgames.sprite.CardSprite;
import org.andengine.entity.IEntity;
import org.andengine.entity.IEntityMatcher;
import org.andengine.entity.scene.ITouchArea;
import org.andengine.entity.scene.Scene;
import org.andengine.input.touch.TouchEvent;

import java.util.ArrayList;
import java.util.List;

public class CardGameScene extends Scene {

    private final List<CardSprite> cardSprites;
    private CardSprite touchedCardSprite = null;

    private static final int CARDS_ZINDEX_START = 1000;

    public CardGameScene() {
        super();
        this.cardSprites = new ArrayList<CardSprite>(54);
    }

    public CardGameScene(final int pChildCount) {
        super(pChildCount);
        this.cardSprites = new ArrayList<CardSprite>(54);
    }

    @Override
    public void attachChild(final IEntity pEntity) throws IllegalStateException {
        super.attachChild(pEntity);
        if (pEntity instanceof CardSprite) {
            attachCardSprite((CardSprite) pEntity);
        }
    }

    private void attachCardSprite(final CardSprite cardSprite) {
        cardSprites.add(cardSprite);
        reindexCardSprites();
    }

    @Override
    public void detachChildren() {
        super.detachChildren();
        detachCardSprites();
    }

    @Override
    public boolean detachChild(final IEntity pEntity) {
        boolean result = super.detachChild(pEntity);
        if (pEntity instanceof CardSprite) {
            detachCardSprite((CardSprite) pEntity, true);
        }
        return result;
    }

    @Override
    public IEntity detachChild(final int pTag) {
        IEntity result = super.detachChild(pTag);
        if (result instanceof CardSprite) {
            detachCardSprite((CardSprite) result, true);
        }
        return result;
    }

    @Override
    public IEntity detachChild(final IEntityMatcher pEntityMatcher) {
        IEntity result = super.detachChild(pEntityMatcher);
        if (result instanceof CardSprite) {
            detachCardSprite((CardSprite) result, true);
        }
        return result;
    }

    @Override
    public boolean detachChildren(final IEntityMatcher pEntityMatcher) {
        boolean result = super.detachChildren(pEntityMatcher);
        detachCardSprites();
        return result;
    }

    private void detachCardSprites() {
        for (CardSprite cardSprite : cardSprites) {
            if (!cardSprite.hasParent()) {
                detachCardSprite(cardSprite, false);
            }
        }
        reindexCardSprites();
    }

    private void detachCardSprite(final CardSprite cardSprite, final boolean doReindex) {
        while (cardSprites.remove(cardSprite)) {}
        if (doReindex) {
            reindexCardSprites();
        }
    }

    private void reindexCardSprites() {
        for (int n = 0; n < cardSprites.size(); n++) {
            cardSprites.get(n).setZIndex(CARDS_ZINDEX_START + n);
        }
        this.sortChildren();
    }

    public void moveCardSpriteToFront(final CardSprite cardSprite) {
        while (cardSprites.remove(cardSprite)) {}
        cardSprites.add(cardSprite);
        reindexCardSprites();
    }

    private boolean checkAndSetTouchedCardSprite(final CardSprite checkCardSprite) {
        if (this.touchedCardSprite == null ||
                checkCardSprite == null ||
                checkCardSprite.getZIndex() > this.touchedCardSprite.getZIndex()) {
            this.touchedCardSprite = checkCardSprite;
            return true;
        }
        return false;
    }

    public boolean isTouchedCardSprite(final CardSprite cardSprite) {
        return cardSprite != null && touchedCardSprite == cardSprite;
    }

    @Override
    public boolean onSceneTouchEvent(final TouchEvent pSceneTouchEvent) {
        boolean result = super.onSceneTouchEvent(pSceneTouchEvent);
        switch (pSceneTouchEvent.getAction()) {
            case TouchEvent.ACTION_DOWN:
                for (ITouchArea touchArea : this.getTouchAreas()) {
                    if (touchArea instanceof CardSprite) {
                        if (touchArea.contains(pSceneTouchEvent.getX(), pSceneTouchEvent.getY())) {
                            checkAndSetTouchedCardSprite((CardSprite) touchArea);
                        }
                    }
                }
                if (this.touchedCardSprite != null) {
                    moveCardSpriteToFront(this.touchedCardSprite);
                    this.touchedCardSprite.setTouchOffset(pSceneTouchEvent);
                }
                break;
            case TouchEvent.ACTION_MOVE:
                if (this.isTouchedCardSprite(this.touchedCardSprite)) {
                    this.touchedCardSprite.setPosition(pSceneTouchEvent);
                    return true;
                }
                break;
            case TouchEvent.ACTION_UP:
            case TouchEvent.ACTION_CANCEL:
                this.touchedCardSprite = null;
        }
        return result;
    }
}
