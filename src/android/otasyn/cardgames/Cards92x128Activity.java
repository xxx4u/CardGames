/**
 * Patrick John Haskins
 * Zachary Evans
 * CS7020 - Term Project
 */
package android.otasyn.cardgames;

import android.otasyn.cardgames.scene.CardGameScene;
import android.otasyn.cardgames.sprite.CardSprite;
import android.otasyn.cardgames.utility.TextureUtility;
import android.otasyn.cardgames.utility.enumeration.CardId;
import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.SpriteBackground;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.ui.activity.SimpleBaseGameActivity;

import java.util.HashMap;
import java.util.Map;

public class Cards92x128Activity extends SimpleBaseGameActivity {

    private static int CAMERA_WIDTH = 720;
    private static int CAMERA_HEIGHT = 1280;

    private ITextureRegion backgroundTextureRegion;
    private Map<CardId,ITextureRegion> cardTextureRegions;
    private Map<CardId,CardSprite> cardSprites;

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

        final Scene scene = new CardGameScene();

        final Sprite bgSprite = new Sprite(0, 0, this.backgroundTextureRegion, this.getVertexBufferObjectManager());
        scene.setBackground(new SpriteBackground(bgSprite));

        this.cardSprites = new HashMap<CardId,CardSprite>(this.cardTextureRegions.size());

        int xMod = 20;
        int xSlightMod = 3;
        int yMod = 40;
        int yGroupMod = 30;

        int x = 360;
        int y = 0;
        CardSprite cardSprite = new CardSprite(x, y, this.cardTextureRegions.get(CardId.BACK_BLUE), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        this.cardSprites.put(CardId.BACK_BLUE, cardSprite);

        x = x + (2 * xMod);
        y = y + (2 * yGroupMod);
        cardSprite = new CardSprite(x, y, this.cardTextureRegions.get(CardId.BACK_RED), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        this.cardSprites.put(CardId.BACK_RED, cardSprite);

        x = 0;
        int startY = 0;
        y = startY;
        cardSprite = new CardSprite(x, y, this.cardTextureRegions.get(CardId.CLUBS_ACE), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        this.cardSprites.put(CardId.CLUBS_ACE, cardSprite);
        cardSprite = new CardSprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardId.DIAMONDS_ACE), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        this.cardSprites.put(CardId.DIAMONDS_ACE, cardSprite);
        cardSprite = new CardSprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardId.HEARTS_ACE), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        this.cardSprites.put(CardId.HEARTS_ACE, cardSprite);
        cardSprite = new CardSprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardId.SPADES_ACE), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        this.cardSprites.put(CardId.SPADES_ACE, cardSprite);

        x+=xMod;
        y = (startY+=yGroupMod);
        cardSprite = new CardSprite(x, y, this.cardTextureRegions.get(CardId.CLUBS_TWO), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        this.cardSprites.put(CardId.CLUBS_TWO, cardSprite);
        cardSprite = new CardSprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardId.DIAMONDS_TWO), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        this.cardSprites.put(CardId.DIAMONDS_TWO, cardSprite);
        cardSprite = new CardSprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardId.HEARTS_TWO), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        this.cardSprites.put(CardId.HEARTS_TWO, cardSprite);
        cardSprite = new CardSprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardId.SPADES_TWO), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        this.cardSprites.put(CardId.SPADES_TWO, cardSprite);

        x+=xMod;
        y = (startY+=yGroupMod);
        cardSprite = new CardSprite(x, y, this.cardTextureRegions.get(CardId.CLUBS_THREE), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        this.cardSprites.put(CardId.CLUBS_THREE, cardSprite);
        cardSprite = new CardSprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardId.DIAMONDS_THREE), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        this.cardSprites.put(CardId.DIAMONDS_THREE, cardSprite);
        cardSprite = new CardSprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardId.HEARTS_THREE), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        this.cardSprites.put(CardId.HEARTS_THREE, cardSprite);
        cardSprite = new CardSprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardId.SPADES_THREE), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        this.cardSprites.put(CardId.SPADES_THREE, cardSprite);

        x+=xMod;
        y = (startY+=yGroupMod);
        cardSprite = new CardSprite(x, y, this.cardTextureRegions.get(CardId.CLUBS_FOUR), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        this.cardSprites.put(CardId.CLUBS_FOUR, cardSprite);
        cardSprite = new CardSprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardId.DIAMONDS_FOUR), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        this.cardSprites.put(CardId.DIAMONDS_FOUR, cardSprite);
        cardSprite = new CardSprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardId.HEARTS_FOUR), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        this.cardSprites.put(CardId.HEARTS_FOUR, cardSprite);
        cardSprite = new CardSprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardId.SPADES_FOUR), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        this.cardSprites.put(CardId.SPADES_FOUR, cardSprite);

        x+=xMod;
        y = (startY+=yGroupMod);
        cardSprite = new CardSprite(x, y, this.cardTextureRegions.get(CardId.CLUBS_FIVE), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        this.cardSprites.put(CardId.CLUBS_FIVE, cardSprite);
        cardSprite = new CardSprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardId.DIAMONDS_FIVE), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        this.cardSprites.put(CardId.DIAMONDS_FIVE, cardSprite);
        cardSprite = new CardSprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardId.HEARTS_FIVE), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        this.cardSprites.put(CardId.HEARTS_FIVE, cardSprite);
        cardSprite = new CardSprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardId.SPADES_FIVE), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        this.cardSprites.put(CardId.SPADES_FIVE, cardSprite);

        x+=xMod;
        y = (startY+=yGroupMod);
        cardSprite = new CardSprite(x, y, this.cardTextureRegions.get(CardId.CLUBS_SIX), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        this.cardSprites.put(CardId.CLUBS_SIX, cardSprite);
        cardSprite = new CardSprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardId.DIAMONDS_SIX), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        this.cardSprites.put(CardId.DIAMONDS_SIX, cardSprite);
        cardSprite = new CardSprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardId.HEARTS_SIX), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        this.cardSprites.put(CardId.HEARTS_SIX, cardSprite);
        cardSprite = new CardSprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardId.SPADES_SIX), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        this.cardSprites.put(CardId.SPADES_SIX, cardSprite);

        x+=xMod;
        y = (startY+=yGroupMod);
        cardSprite = new CardSprite(x, y, this.cardTextureRegions.get(CardId.CLUBS_SEVEN), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        this.cardSprites.put(CardId.CLUBS_SEVEN, cardSprite);
        cardSprite = new CardSprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardId.DIAMONDS_SEVEN), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        this.cardSprites.put(CardId.DIAMONDS_SEVEN, cardSprite);
        cardSprite = new CardSprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardId.HEARTS_SEVEN), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        this.cardSprites.put(CardId.HEARTS_SEVEN, cardSprite);
        cardSprite = new CardSprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardId.SPADES_SEVEN), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        this.cardSprites.put(CardId.SPADES_SEVEN, cardSprite);

        x+=xMod;
        y = (startY+=yGroupMod);
        cardSprite = new CardSprite(x, y, this.cardTextureRegions.get(CardId.CLUBS_EIGHT), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        this.cardSprites.put(CardId.CLUBS_EIGHT, cardSprite);
        cardSprite = new CardSprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardId.DIAMONDS_EIGHT), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        this.cardSprites.put(CardId.DIAMONDS_EIGHT, cardSprite);
        cardSprite = new CardSprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardId.HEARTS_EIGHT), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        this.cardSprites.put(CardId.HEARTS_EIGHT, cardSprite);
        cardSprite = new CardSprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardId.SPADES_EIGHT), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        this.cardSprites.put(CardId.SPADES_EIGHT, cardSprite);

        x+=xMod;
        y = (startY+=yGroupMod);
        cardSprite = new CardSprite(x, y, this.cardTextureRegions.get(CardId.CLUBS_NINE), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        this.cardSprites.put(CardId.CLUBS_NINE, cardSprite);
        cardSprite = new CardSprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardId.DIAMONDS_NINE), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        this.cardSprites.put(CardId.DIAMONDS_NINE, cardSprite);
        cardSprite = new CardSprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardId.HEARTS_NINE), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        this.cardSprites.put(CardId.HEARTS_NINE, cardSprite);
        cardSprite = new CardSprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardId.SPADES_NINE), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        this.cardSprites.put(CardId.SPADES_NINE, cardSprite);

        x+=xMod;
        y = (startY+=yGroupMod);
        cardSprite = new CardSprite(x, y, this.cardTextureRegions.get(CardId.CLUBS_TEN), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        this.cardSprites.put(CardId.CLUBS_TEN, cardSprite);
        cardSprite = new CardSprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardId.DIAMONDS_TEN), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        this.cardSprites.put(CardId.DIAMONDS_TEN, cardSprite);
        cardSprite = new CardSprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardId.HEARTS_TEN), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        this.cardSprites.put(CardId.HEARTS_TEN, cardSprite);
        cardSprite = new CardSprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardId.SPADES_TEN), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        this.cardSprites.put(CardId.SPADES_TEN, cardSprite);

        x+=xMod;
        y = (startY+=yGroupMod);
        cardSprite = new CardSprite(x, y, this.cardTextureRegions.get(CardId.CLUBS_JACK), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        this.cardSprites.put(CardId.CLUBS_JACK, cardSprite);
        cardSprite = new CardSprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardId.DIAMONDS_JACK), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        this.cardSprites.put(CardId.DIAMONDS_JACK, cardSprite);
        cardSprite = new CardSprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardId.HEARTS_JACK), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        this.cardSprites.put(CardId.HEARTS_JACK, cardSprite);
        cardSprite = new CardSprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardId.SPADES_JACK), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        this.cardSprites.put(CardId.SPADES_JACK, cardSprite);

        x+=xMod;
        y = (startY+=yGroupMod);
        cardSprite = new CardSprite(x, y, this.cardTextureRegions.get(CardId.CLUBS_QUEEN), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        this.cardSprites.put(CardId.CLUBS_QUEEN, cardSprite);
        cardSprite = new CardSprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardId.DIAMONDS_QUEEN), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        this.cardSprites.put(CardId.DIAMONDS_QUEEN, cardSprite);
        cardSprite = new CardSprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardId.HEARTS_QUEEN), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        this.cardSprites.put(CardId.HEARTS_QUEEN, cardSprite);
        cardSprite = new CardSprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardId.SPADES_QUEEN), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        this.cardSprites.put(CardId.SPADES_QUEEN, cardSprite);

        x+=xMod;
        y = (startY+=yGroupMod);
        cardSprite = new CardSprite(x, y, this.cardTextureRegions.get(CardId.CLUBS_KING), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        this.cardSprites.put(CardId.CLUBS_KING, cardSprite);
        cardSprite = new CardSprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardId.DIAMONDS_KING), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        this.cardSprites.put(CardId.DIAMONDS_KING, cardSprite);
        cardSprite = new CardSprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardId.HEARTS_KING), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        this.cardSprites.put(CardId.HEARTS_KING, cardSprite);
        cardSprite = new CardSprite(x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardId.SPADES_KING), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        this.cardSprites.put(CardId.SPADES_KING, cardSprite);

        for (Map.Entry<CardId,CardSprite> cardSpriteEntry : cardSprites.entrySet()) {
            CardSprite cs = cardSpriteEntry.getValue();
            scene.registerTouchArea(cs);
        }
        scene.setTouchAreaBindingOnActionDownEnabled(true);
        scene.setOnAreaTouchTraversalFrontToBack();

        return scene;
    }
}
