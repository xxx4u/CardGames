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

import java.util.Map;

public class AndEngineActivity extends SimpleBaseGameActivity {

    private static int CAMERA_WIDTH = 720;
    private static int CAMERA_HEIGHT = 1280;

    private ITextureRegion backgroundTextureRegion;
    private Map<CardId,ITextureRegion> cardTextureRegions;

    @Override
    public EngineOptions onCreateEngineOptions() {
        final Camera camera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
        return new EngineOptions(true, ScreenOrientation.PORTRAIT_FIXED,
                new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), camera);
    }

    @Override
    protected void onCreateResources() {
        this.backgroundTextureRegion = TextureUtility.loadBackground(this, CAMERA_WIDTH, CAMERA_HEIGHT);
        this.cardTextureRegions = TextureUtility.loadCardsFullSize(this);
    }

    @Override
    protected Scene onCreateScene() {

        final Scene scene = new CardGameScene();

        final Sprite bgSprite = new Sprite(0, 0, this.backgroundTextureRegion, this.getVertexBufferObjectManager());
        scene.setBackground(new SpriteBackground(bgSprite));

        int x = 0;
        int startY = 0;
        int y = startY;
        Sprite cardSprite = new CardSprite(x, y, this.cardTextureRegions.get(CardId.CLUBS_ACE), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new CardSprite(x+=3, y+=70, this.cardTextureRegions.get(CardId.DIAMONDS_ACE), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new CardSprite(x+=3, y+=70, this.cardTextureRegions.get(CardId.HEARTS_ACE), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new CardSprite(x+=3, y+=70, this.cardTextureRegions.get(CardId.SPADES_ACE), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);

        x+=35;
        y = (startY+=70);
        cardSprite = new CardSprite(x, y, this.cardTextureRegions.get(CardId.CLUBS_TWO), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new CardSprite(x+=3, y+=70, this.cardTextureRegions.get(CardId.DIAMONDS_TWO), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new CardSprite(x+=3, y+=70, this.cardTextureRegions.get(CardId.HEARTS_TWO), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new CardSprite(x+=3, y+=70, this.cardTextureRegions.get(CardId.SPADES_TWO), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);

        x+=30;
        y = (startY+=70);
        cardSprite = new CardSprite(x, y, this.cardTextureRegions.get(CardId.CLUBS_THREE), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new CardSprite(x+=3, y+=70, this.cardTextureRegions.get(CardId.DIAMONDS_THREE), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new CardSprite(x+=3, y+=70, this.cardTextureRegions.get(CardId.HEARTS_THREE), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new CardSprite(x+=3, y+=70, this.cardTextureRegions.get(CardId.SPADES_THREE), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);

        x+=30;
        y = (startY+=70);
        cardSprite = new CardSprite(x, y, this.cardTextureRegions.get(CardId.CLUBS_FOUR), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new CardSprite(x+=3, y+=70, this.cardTextureRegions.get(CardId.DIAMONDS_FOUR), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new CardSprite(x+=3, y+=70, this.cardTextureRegions.get(CardId.HEARTS_FOUR), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new CardSprite(x+=3, y+=70, this.cardTextureRegions.get(CardId.SPADES_FOUR), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);

        x+=30;
        y = (startY+=70);
        cardSprite = new CardSprite(x, y, this.cardTextureRegions.get(CardId.CLUBS_FIVE), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new CardSprite(x+=3, y+=70, this.cardTextureRegions.get(CardId.DIAMONDS_FIVE), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new CardSprite(x+=3, y+=70, this.cardTextureRegions.get(CardId.HEARTS_FIVE), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new CardSprite(x+=3, y+=70, this.cardTextureRegions.get(CardId.SPADES_FIVE), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);

        x+=30;
        y = (startY+=70);
        cardSprite = new CardSprite(x, y, this.cardTextureRegions.get(CardId.CLUBS_SIX), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new CardSprite(x+=3, y+=70, this.cardTextureRegions.get(CardId.DIAMONDS_SIX), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new CardSprite(x+=3, y+=70, this.cardTextureRegions.get(CardId.HEARTS_SIX), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new CardSprite(x+=3, y+=70, this.cardTextureRegions.get(CardId.SPADES_SIX), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);

        x+=30;
        y = (startY+=70);
        cardSprite = new CardSprite(x, y, this.cardTextureRegions.get(CardId.CLUBS_SEVEN), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new CardSprite(x+=3, y+=70, this.cardTextureRegions.get(CardId.DIAMONDS_SEVEN), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new CardSprite(x+=3, y+=70, this.cardTextureRegions.get(CardId.HEARTS_SEVEN), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new CardSprite(x+=3, y+=70, this.cardTextureRegions.get(CardId.SPADES_SEVEN), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);

        x+=30;
        y = (startY+=70);
        cardSprite = new CardSprite(x, y, this.cardTextureRegions.get(CardId.CLUBS_EIGHT), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new CardSprite(x+=3, y+=70, this.cardTextureRegions.get(CardId.DIAMONDS_EIGHT), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new CardSprite(x+=3, y+=70, this.cardTextureRegions.get(CardId.HEARTS_EIGHT), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new CardSprite(x+=3, y+=70, this.cardTextureRegions.get(CardId.SPADES_EIGHT), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);

        x+=30;
        y = (startY+=70);
        cardSprite = new CardSprite(x, y, this.cardTextureRegions.get(CardId.CLUBS_NINE), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new CardSprite(x+=3, y+=70, this.cardTextureRegions.get(CardId.DIAMONDS_NINE), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new CardSprite(x+=3, y+=70, this.cardTextureRegions.get(CardId.HEARTS_NINE), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new CardSprite(x+=3, y+=70, this.cardTextureRegions.get(CardId.SPADES_NINE), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);

        x+=30;
        y = (startY+=70);
        cardSprite = new CardSprite(x, y, this.cardTextureRegions.get(CardId.CLUBS_TEN), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new CardSprite(x+=3, y+=70, this.cardTextureRegions.get(CardId.DIAMONDS_TEN), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new CardSprite(x+=3, y+=70, this.cardTextureRegions.get(CardId.HEARTS_TEN), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new CardSprite(x+=3, y+=70, this.cardTextureRegions.get(CardId.SPADES_TEN), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);

        x+=30;
        y = (startY+=70);
        cardSprite = new CardSprite(x, y, this.cardTextureRegions.get(CardId.CLUBS_JACK), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new CardSprite(x+=3, y+=70, this.cardTextureRegions.get(CardId.DIAMONDS_JACK), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new CardSprite(x+=3, y+=70, this.cardTextureRegions.get(CardId.HEARTS_JACK), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new CardSprite(x+=3, y+=70, this.cardTextureRegions.get(CardId.SPADES_JACK), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);

        x+=30;
        y = (startY+=70);
        cardSprite = new CardSprite(x, y, this.cardTextureRegions.get(CardId.CLUBS_QUEEN), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new CardSprite(x+=3, y+=70, this.cardTextureRegions.get(CardId.DIAMONDS_QUEEN), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new CardSprite(x+=3, y+=70, this.cardTextureRegions.get(CardId.HEARTS_QUEEN), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new CardSprite(x+=3, y+=70, this.cardTextureRegions.get(CardId.SPADES_QUEEN), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);

        x+=30;
        y = (startY+=70);
        cardSprite = new CardSprite(x, y, this.cardTextureRegions.get(CardId.CLUBS_KING), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new CardSprite(x+=3, y+=70, this.cardTextureRegions.get(CardId.DIAMONDS_KING), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new CardSprite(x+=3, y+=70, this.cardTextureRegions.get(CardId.HEARTS_KING), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);
        cardSprite = new CardSprite(x+=3, y+=70, this.cardTextureRegions.get(CardId.SPADES_KING), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);

        x = 360;
        y = 0;
        cardSprite = new CardSprite(x, y, this.cardTextureRegions.get(CardId.BACK_BLUE), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);

        x = 430;
        y = 140;
        cardSprite = new CardSprite(x, y, this.cardTextureRegions.get(CardId.BACK_RED), this.getVertexBufferObjectManager());
        scene.attachChild(cardSprite);

        return scene;
    }
}
