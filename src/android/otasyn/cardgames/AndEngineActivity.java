package android.otasyn.cardgames;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TextureRegionFactory;
import org.andengine.ui.activity.SimpleBaseGameActivity;

public class AndEngineActivity extends SimpleBaseGameActivity {

    private static int CAMERA_WIDTH = 720;
    private static int CAMERA_HEIGHT = 1280;

    private static String BG_BLUE_0B4E66 = "gfx/blue-0b4e66.png";
    private static String BG_BLUE_0B2566 = "gfx/blue-0b2566.png";
    private static String BG_BLUE_27647A = "gfx/blue-27647a.png";
    private static String BG_BROWN_7A4827 = "gfx/brown-7a4827.png";
    private static String BG_GREEN_1A9C48 = "gfx/green-1a9c48.png";
    private static String BG_MAGENTA_660b29 = "gfx/magenta-660b29.png";
    private static String BG_ORANGE_C47219 = "gfx/orange-c47219.png";

    private ITextureRegion mBackgroundTextureRegion;

    @Override
    public EngineOptions onCreateEngineOptions() {
        final Camera camera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
        return new EngineOptions(true, ScreenOrientation.PORTRAIT_FIXED,
                new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), camera);
    }

    @Override
    protected void onCreateResources() {
        BitmapTextureAtlas backgroundTexture = new BitmapTextureAtlas(this.getTextureManager(), 100, 100,
                TextureOptions.REPEATING_BILINEAR_PREMULTIPLYALPHA);
        this.mBackgroundTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
                backgroundTexture, this, BG_BLUE_0B4E66, 0, 0);
        backgroundTexture.load();
        this.mBackgroundTextureRegion = TextureRegionFactory.extractFromTexture(backgroundTexture);

        this.mBackgroundTextureRegion.setTextureWidth(CAMERA_WIDTH);
        this.mBackgroundTextureRegion.setTextureHeight(CAMERA_HEIGHT);
    }

    @Override
    protected Scene onCreateScene() {

        final Scene scene = new Scene();

        final Sprite mySprite = new Sprite(0, 0, this.mBackgroundTextureRegion, this.getVertexBufferObjectManager());
        scene.attachChild(mySprite);

        return scene;
    }
}
