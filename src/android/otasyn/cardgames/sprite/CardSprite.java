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

    @Override
    public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX,
                                 final float pTouchAreaLocalY) {
        switch (pSceneTouchEvent.getAction()) {
            case TouchEvent.ACTION_DOWN:
                touchOffsetX = pSceneTouchEvent.getX() - this.getX();
                touchOffsetY = pSceneTouchEvent.getY() - this.getY();
                break;
            case TouchEvent.ACTION_MOVE:
                if (scene.isTouchedCardSprite(this)) {
                    this.setPosition(pSceneTouchEvent.getX() - touchOffsetX, pSceneTouchEvent.getY() - touchOffsetY);
                    return true;
                }
                break;
            case TouchEvent.ACTION_UP:
            case TouchEvent.ACTION_CANCEL:
                return true;
        }
        return false;
    }
}
