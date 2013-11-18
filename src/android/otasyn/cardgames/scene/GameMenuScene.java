package android.otasyn.cardgames.scene;

import org.andengine.entity.scene.Scene;
import org.andengine.input.touch.TouchEvent;

public class GameMenuScene extends Scene {

    private static final int SHADOW_ZINDEX_START = 1000;
    private static final int WIDGET_ZINDEX_START = 2000;

    @Override
    public boolean onSceneTouchEvent(final TouchEvent pSceneTouchEvent) {
        boolean result = super.onSceneTouchEvent(pSceneTouchEvent);
        switch (pSceneTouchEvent.getAction()) {
            case TouchEvent.ACTION_DOWN:
                break;
            case TouchEvent.ACTION_MOVE:
                break;
            case TouchEvent.ACTION_UP:
            case TouchEvent.ACTION_CANCEL:
        }
        return result;
    }
}
