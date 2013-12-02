package android.otasyn.cardgames.sprite;

import android.otasyn.cardgames.scene.CardGameScene;
import android.otasyn.cardgames.utility.enumeration.Card;
import org.andengine.entity.IEntity;
import org.andengine.entity.sprite.TiledSprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

public class CardSprite extends TiledSprite {

    private Card card;
    private float touchOffsetX;
    private float touchOffsetY;

    private CardGameScene scene;

    public CardSprite(Card card, final float pX, final float pY,
                      final ITextureRegion pTextureRegion, final VertexBufferObjectManager pVertexBufferObjectManager) {
        super(pX, pY, new TiledTextureRegion(pTextureRegion.getTexture(), pTextureRegion), pVertexBufferObjectManager);
        this.card = card;
    }

    public CardSprite(Card card, final float pX, final float pY,
                      final ITextureRegion cardFace, final ITextureRegion cardBack,
                      final VertexBufferObjectManager pVertexBufferObjectManager) {
        super(pX, pY, new TiledTextureRegion(cardFace.getTexture(), cardFace, cardBack), pVertexBufferObjectManager);
        this.card = card;
    }

    public CardSprite(Card card, final float pX, final float pY,
                      final TiledTextureRegion pTiledTextRegion, final VertexBufferObjectManager pVertexBufferObjectManager) {
        super(pX, pY, pTiledTextRegion, pVertexBufferObjectManager);
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    public void showFace() {
        setCurrentTileIndex(0);
    }

    public void showBack() {
        if (getTileCount() > 1) {
            setCurrentTileIndex(1);
        }
    }

    @Override
    public void onAttached() {
        IEntity parent = this.getParent();
        while (parent != null && this.scene == null) {
            if (this.getParent() instanceof CardGameScene) {
                this.scene = (CardGameScene) this.getParent();
            }
            parent = parent.getParent();
        }
    }

    @Override
    public void onDetached() {
        this.scene = null;
    }

    public void setTouchOffset(final TouchEvent pSceneTouchEvent) {
        touchOffsetX = pSceneTouchEvent.getX() - this.getX();
        touchOffsetY = pSceneTouchEvent.getY() - this.getY();
    }

    public void setPosition(final TouchEvent pSceneTouchEvent) {
        this.setPosition(pSceneTouchEvent.getX() - touchOffsetX, pSceneTouchEvent.getY() - touchOffsetY);
    }
}
