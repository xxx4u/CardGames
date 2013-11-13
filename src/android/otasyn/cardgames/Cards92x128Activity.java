/**
 * Patrick John Haskins
 * Zachary Evans
 * CS7020 - Term Project
 */
package android.otasyn.cardgames;

import android.otasyn.cardgames.utility.TextureUtility;
import android.otasyn.cardgames.utility.enumeration.Card;
import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.ui.activity.SimpleBaseGameActivity;

import java.util.Map;

public class Cards92x128Activity extends SimpleBaseGameActivity {

    private static int CAMERA_WIDTH = 720;
    private static int CAMERA_HEIGHT = 1280;

    private ITextureRegion backgroundTextureRegion;
    private Map<Card,ITextureRegion> cardTextureRegions;

    @Override
    public EngineOptions onCreateEngineOptions() {
        final Camera camera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
        return new EngineOptions(true, ScreenOrientation.PORTRAIT_FIXED,
                new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), camera);
    }

    @Override
    protected void onCreateResources() {
        this.backgroundTextureRegion = TextureUtility.loadBackground(this, CAMERA_WIDTH, CAMERA_HEIGHT);
        this.cardTextureRegions = TextureUtility.loadCards92x128(this);
    }

    @Override
    protected Scene onCreateScene() {

        final Scene scene = new Scene();

        final Sprite bgSprite = new Sprite(0, 0, this.backgroundTextureRegion, this.getVertexBufferObjectManager());
        scene.attachChild(bgSprite);

        int xMod = 20;
        int xSlightMod = 3;
        int yMod = 40;
        int yGroupMod = 30;

        int x = 360;
        int y = 0;
        Sprite cardSprite = new Sprite(x, y, this.cardTextureRegions.get(Card.BACK_BLUE), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);

        x = x + (2 * xMod);
        y = y + (2 * yGroupMod);
        cardSprite = new Sprite(x, y, this.cardTextureRegions.get(Card.BACK_RED), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);

        x = 0;
        int startY = 0;
        y = startY;
        cardSprite = new Sprite(x, y, this.cardTextureRegions.get(Card.CLUBS_ACE), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new Sprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.DIAMONDS_ACE), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new Sprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.HEARTS_ACE), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new Sprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.SPADES_ACE), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);

        x+=xMod;
        y = (startY+=yGroupMod);
        cardSprite = new Sprite(x, y, this.cardTextureRegions.get(Card.CLUBS_TWO), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new Sprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.DIAMONDS_TWO), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new Sprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.HEARTS_TWO), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new Sprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.SPADES_TWO), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);

        x+=xMod;
        y = (startY+=yGroupMod);
        cardSprite = new Sprite(x, y, this.cardTextureRegions.get(Card.CLUBS_THREE), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new Sprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.DIAMONDS_THREE), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new Sprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.HEARTS_THREE), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new Sprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.SPADES_THREE), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);

        x+=xMod;
        y = (startY+=yGroupMod);
        cardSprite = new Sprite(x, y, this.cardTextureRegions.get(Card.CLUBS_FOUR), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new Sprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.DIAMONDS_FOUR), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new Sprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.HEARTS_FOUR), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new Sprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.SPADES_FOUR), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);

        x+=xMod;
        y = (startY+=yGroupMod);
        cardSprite = new Sprite(x, y, this.cardTextureRegions.get(Card.CLUBS_FIVE), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new Sprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.DIAMONDS_FIVE), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new Sprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.HEARTS_FIVE), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new Sprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.SPADES_FIVE), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);

        x+=xMod;
        y = (startY+=yGroupMod);
        cardSprite = new Sprite(x, y, this.cardTextureRegions.get(Card.CLUBS_SIX), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new Sprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.DIAMONDS_SIX), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new Sprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.HEARTS_SIX), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new Sprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.SPADES_SIX), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);

        x+=xMod;
        y = (startY+=yGroupMod);
        cardSprite = new Sprite(x, y, this.cardTextureRegions.get(Card.CLUBS_SEVEN), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new Sprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.DIAMONDS_SEVEN), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new Sprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.HEARTS_SEVEN), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new Sprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.SPADES_SEVEN), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);

        x+=xMod;
        y = (startY+=yGroupMod);
        cardSprite = new Sprite(x, y, this.cardTextureRegions.get(Card.CLUBS_EIGHT), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new Sprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.DIAMONDS_EIGHT), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new Sprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.HEARTS_EIGHT), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new Sprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.SPADES_EIGHT), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);

        x+=xMod;
        y = (startY+=yGroupMod);
        cardSprite = new Sprite(x, y, this.cardTextureRegions.get(Card.CLUBS_NINE), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new Sprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.DIAMONDS_NINE), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new Sprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.HEARTS_NINE), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new Sprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.SPADES_NINE), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);

        x+=xMod;
        y = (startY+=yGroupMod);
        cardSprite = new Sprite(x, y, this.cardTextureRegions.get(Card.CLUBS_TEN), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new Sprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.DIAMONDS_TEN), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new Sprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.HEARTS_TEN), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new Sprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.SPADES_TEN), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);

        x+=xMod;
        y = (startY+=yGroupMod);
        cardSprite = new Sprite(x, y, this.cardTextureRegions.get(Card.CLUBS_JACK), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new Sprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.DIAMONDS_JACK), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new Sprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.HEARTS_JACK), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new Sprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.SPADES_JACK), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);

        x+=xMod;
        y = (startY+=yGroupMod);
        cardSprite = new Sprite(x, y, this.cardTextureRegions.get(Card.CLUBS_QUEEN), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new Sprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.DIAMONDS_QUEEN), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new Sprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.HEARTS_QUEEN), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new Sprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.SPADES_QUEEN), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);

        x+=xMod;
        y = (startY+=yGroupMod);
        cardSprite = new Sprite(x, y, this.cardTextureRegions.get(Card.CLUBS_KING), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new Sprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.DIAMONDS_KING), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new Sprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.HEARTS_KING), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new Sprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.SPADES_KING), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);

        return scene;
    }
}
