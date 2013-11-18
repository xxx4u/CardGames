package android.otasyn.cardgames.activity;

import android.otasyn.cardgames.scene.GameMenuScene;
import android.otasyn.cardgames.utility.TextureUtility;
import android.otasyn.cardgames.utility.enumeration.Background;
import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.FillResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.SpriteBackground;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.ui.activity.SimpleBaseGameActivity;

public abstract class GameMenuActivity extends SimpleBaseGameActivity {

    protected static int CAMERA_WIDTH = 720;
    protected static int CAMERA_HEIGHT = 1280;

    private ITextureRegion backgroundTextureRegion;

    @Override
    public EngineOptions onCreateEngineOptions() {
        final Camera camera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
        return new EngineOptions(true, ScreenOrientation.PORTRAIT_FIXED,
                new FillResolutionPolicy(), camera);
    }

    @Override
    protected void onCreateResources() {
        this.backgroundTextureRegion = TextureUtility.loadBackground(
                this, CAMERA_WIDTH, CAMERA_HEIGHT, Background.BG_BLUE_27647A);
        onCreateGameMenuResources();
    }

    protected abstract void onCreateGameMenuResources();

    @Override
    protected Scene onCreateScene() {
        final GameMenuScene scene = new GameMenuScene();

        final Sprite bgSprite = new Sprite(0, 0, this.backgroundTextureRegion, this.getVertexBufferObjectManager());
        scene.setBackground(new SpriteBackground(bgSprite));

        onCreateGameMenuScene(scene);

        scene.setTouchAreaBindingOnActionDownEnabled(true);
        return scene;
    }

    protected abstract void onCreateGameMenuScene(final GameMenuScene scene);
}
