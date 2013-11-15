package android.otasyn.cardgames.sprite;

import android.otasyn.cardgames.scene.CardGameScene;
import android.otasyn.cardgames.utility.enumeration.CardType;
import org.andengine.entity.IEntity;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

public class CardSprite extends Sprite {

    private CardType cardType;
    private float touchOffsetX;
    private float touchOffsetY;

    private CardGameScene scene;

    public CardSprite(CardType cardType, final float pX, final float pY,
                      final ITextureRegion pTextureRegion, final VertexBufferObjectManager pVertexBufferObjectManager) {
        super(pX, pY, pTextureRegion, pVertexBufferObjectManager);
        this.cardType = cardType;
    }

    public CardType getCardType() {
        return cardType;
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
