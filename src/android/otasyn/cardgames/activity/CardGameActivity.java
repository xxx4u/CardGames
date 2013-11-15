package android.otasyn.cardgames.activity;

import android.otasyn.cardgames.R;
import android.otasyn.cardgames.scene.CardGameScene;
import android.otasyn.cardgames.sprite.CardSprite;
import android.otasyn.cardgames.utility.TextureUtility;
import android.otasyn.cardgames.utility.enumeration.CardType;
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

public abstract class CardGameActivity extends SimpleBaseGameActivity {

    private static int CAMERA_WIDTH = 720;
    private static int CAMERA_HEIGHT = 1280;

    private ITextureRegion backgroundTextureRegion;
    private Map<CardType,ITextureRegion> cardTextureRegions;

    @Override
    public EngineOptions onCreateEngineOptions() {
        setTheme(R.style.GameBoardTheme);
        final Camera camera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
        return new EngineOptions(true, ScreenOrientation.PORTRAIT_FIXED,
                new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), camera);
    }

    @Override
    final protected void onCreateResources() {
        this.backgroundTextureRegion = TextureUtility.loadBackground(this, CAMERA_WIDTH, CAMERA_HEIGHT);
        onCreateCardGameResources();
    }

    protected abstract void onCreateCardGameResources();

    public Map<CardType, ITextureRegion> getCardTextureRegions() {
        return cardTextureRegions;
    }

    public void setCardTextureRegions(final Map<CardType, ITextureRegion> cardTextureRegions) {
        this.cardTextureRegions = cardTextureRegions;
    }

    @Override
    final protected Scene onCreateScene() {
        final CardGameScene scene = new CardGameScene();

        final Sprite bgSprite = new Sprite(0, 0, this.backgroundTextureRegion, this.getVertexBufferObjectManager());
        scene.setBackground(new SpriteBackground(bgSprite));

        onCreateCardGameScene(scene);

        scene.setTouchAreaBindingOnActionDownEnabled(true);
        return scene;
    }

    protected abstract void onCreateCardGameScene(final CardGameScene scene);

    protected void loadCardSprites(final CardGameScene scene,
                                   final int xMod, final int xSlightMod,
                                   final int yMod, final int yGroupMod) {
        int x = 360;
        int y = 0;
        CardSprite cardSprite = new CardSprite(CardType.BACK_BLUE, x, y, this.cardTextureRegions.get(CardType.BACK_BLUE), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);

        x = x + (2 * xMod);
        y = y + (2 * yGroupMod);
        cardSprite = new CardSprite(CardType.BACK_RED, x, y, this.cardTextureRegions.get(CardType.BACK_RED), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);

        x = 0;
        int startY = 0;
        y = startY;
        cardSprite = new CardSprite(CardType.CLUBS_ACE, x, y, this.cardTextureRegions.get(CardType.CLUBS_ACE), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(CardType.DIAMONDS_ACE, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardType.DIAMONDS_ACE), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(CardType.HEARTS_ACE, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardType.HEARTS_ACE), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(CardType.SPADES_ACE, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardType.SPADES_ACE), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);

        x+=xMod;
        y = (startY+=yGroupMod);
        cardSprite = new CardSprite(CardType.CLUBS_TWO, x, y, this.cardTextureRegions.get(CardType.CLUBS_TWO), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(CardType.DIAMONDS_TWO, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardType.DIAMONDS_TWO), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(CardType.HEARTS_TWO, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardType.HEARTS_TWO), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(CardType.SPADES_TWO, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardType.SPADES_TWO), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);

        x+=xMod;
        y = (startY+=yGroupMod);
        cardSprite = new CardSprite(CardType.CLUBS_THREE, x, y, this.cardTextureRegions.get(CardType.CLUBS_THREE), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(CardType.DIAMONDS_THREE, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardType.DIAMONDS_THREE), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(CardType.HEARTS_THREE, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardType.HEARTS_THREE), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(CardType.SPADES_THREE, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardType.SPADES_THREE), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);

        x+=xMod;
        y = (startY+=yGroupMod);
        cardSprite = new CardSprite(CardType.CLUBS_FOUR, x, y, this.cardTextureRegions.get(CardType.CLUBS_FOUR), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(CardType.DIAMONDS_FOUR, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardType.DIAMONDS_FOUR), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(CardType.HEARTS_FOUR, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardType.HEARTS_FOUR), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(CardType.SPADES_FOUR, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardType.SPADES_FOUR), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);

        x+=xMod;
        y = (startY+=yGroupMod);
        cardSprite = new CardSprite(CardType.CLUBS_FIVE, x, y, this.cardTextureRegions.get(CardType.CLUBS_FIVE), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(CardType.DIAMONDS_FIVE, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardType.DIAMONDS_FIVE), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(CardType.HEARTS_FIVE, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardType.HEARTS_FIVE), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(CardType.SPADES_FIVE, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardType.SPADES_FIVE), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);

        x+=xMod;
        y = (startY+=yGroupMod);
        cardSprite = new CardSprite(CardType.CLUBS_SIX, x, y, this.cardTextureRegions.get(CardType.CLUBS_SIX), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(CardType.DIAMONDS_SIX, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardType.DIAMONDS_SIX), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(CardType.HEARTS_SIX, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardType.HEARTS_SIX), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(CardType.SPADES_SIX, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardType.SPADES_SIX), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);

        x+=xMod;
        y = (startY+=yGroupMod);
        cardSprite = new CardSprite(CardType.CLUBS_SEVEN, x, y, this.cardTextureRegions.get(CardType.CLUBS_SEVEN), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(CardType.DIAMONDS_SEVEN, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardType.DIAMONDS_SEVEN), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(CardType.HEARTS_SEVEN, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardType.HEARTS_SEVEN), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(CardType.SPADES_SEVEN, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardType.SPADES_SEVEN), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);

        x+=xMod;
        y = (startY+=yGroupMod);
        cardSprite = new CardSprite(CardType.CLUBS_EIGHT, x, y, this.cardTextureRegions.get(CardType.CLUBS_EIGHT), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(CardType.DIAMONDS_EIGHT, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardType.DIAMONDS_EIGHT), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(CardType.HEARTS_EIGHT, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardType.HEARTS_EIGHT), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(CardType.SPADES_EIGHT, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardType.SPADES_EIGHT), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);

        x+=xMod;
        y = (startY+=yGroupMod);
        cardSprite = new CardSprite(CardType.CLUBS_NINE, x, y, this.cardTextureRegions.get(CardType.CLUBS_NINE), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(CardType.DIAMONDS_NINE, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardType.DIAMONDS_NINE), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(CardType.HEARTS_NINE, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardType.HEARTS_NINE), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(CardType.SPADES_NINE, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardType.SPADES_NINE), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);

        x+=xMod;
        y = (startY+=yGroupMod);
        cardSprite = new CardSprite(CardType.CLUBS_TEN, x, y, this.cardTextureRegions.get(CardType.CLUBS_TEN), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(CardType.DIAMONDS_TEN, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardType.DIAMONDS_TEN), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(CardType.HEARTS_TEN, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardType.HEARTS_TEN), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(CardType.SPADES_TEN, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardType.SPADES_TEN), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);

        x+=xMod;
        y = (startY+=yGroupMod);
        cardSprite = new CardSprite(CardType.CLUBS_JACK, x, y, this.cardTextureRegions.get(CardType.CLUBS_JACK), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(CardType.DIAMONDS_JACK, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardType.DIAMONDS_JACK), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(CardType.HEARTS_JACK, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardType.HEARTS_JACK), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(CardType.SPADES_JACK, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardType.SPADES_JACK), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);

        x+=xMod;
        y = (startY+=yGroupMod);
        cardSprite = new CardSprite(CardType.CLUBS_QUEEN, x, y, this.cardTextureRegions.get(CardType.CLUBS_QUEEN), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(CardType.DIAMONDS_QUEEN, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardType.DIAMONDS_QUEEN), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(CardType.HEARTS_QUEEN, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardType.HEARTS_QUEEN), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(CardType.SPADES_QUEEN, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardType.SPADES_QUEEN), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);

        x+=xMod;
        y = (startY+=yGroupMod);
        cardSprite = new CardSprite(CardType.CLUBS_KING, x, y, this.cardTextureRegions.get(CardType.CLUBS_KING), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(CardType.DIAMONDS_KING, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardType.DIAMONDS_KING), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(CardType.HEARTS_KING, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardType.HEARTS_KING), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(CardType.SPADES_KING, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(CardType.SPADES_KING), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
    }
}
