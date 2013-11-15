package android.otasyn.cardgames.sprite;

import android.otasyn.cardgames.scene.CardGameScene;
import org.andengine.entity.IEntity;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

public class CardSprite extends Sprite {

    private float touchOffsetX;
    private float touchOffsetY;

    private CardGameScene scene;

    public CardSprite(final float pX, final float pY, final ITextureRegion pTextureRegion, final VertexBufferObjectManager pVertexBufferObjectManager) {
        super(pX, pY, pTextureRegion, pVertexBufferObjectManager);
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
