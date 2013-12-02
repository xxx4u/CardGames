package android.otasyn.cardgames.activity;

import android.otasyn.cardgames.R;
import android.otasyn.cardgames.manage.account.asynctask.LatestActionTask;
import android.otasyn.cardgames.manage.account.dto.Game;
import android.otasyn.cardgames.manage.account.dto.GameAction;
import android.otasyn.cardgames.manage.account.dto.SimpleUser;
import android.otasyn.cardgames.scene.CardGameScene;
import android.otasyn.cardgames.sprite.CardSprite;
import android.otasyn.cardgames.utility.TextureUtility;
import android.otasyn.cardgames.utility.enumeration.Card;
import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.SpriteBackground;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.ui.activity.SimpleBaseGameActivity;

import java.util.HashMap;
import java.util.Map;

public abstract class CardGameActivity extends SimpleBaseGameActivity {

    public static final String GAME_INFO = "game_info";
    public static final String CURRENT_USER = "current_user";

    protected static int CAMERA_WIDTH = 720;
    protected static int CAMERA_HEIGHT = 1280;

    private Game game;
    private SimpleUser currentUser;
    private GameAction latestAction;

    private ITextureRegion backgroundTextureRegion;
    private ITextureRegion[] gameMenuButtonRegion;
    private Map<Card,ITextureRegion> cardTextureRegions;
    private Map<Card,CardSprite> cardSpritesMap = new HashMap<Card, CardSprite>();
    private ITextureRegion redBack;

    private ButtonSprite gameMenuButton;

    private CardGameScene cardGameScene;

    public Game getGame() {
        return game;
    }

    public void setGame(final Game game) {
        this.game = game;
    }

    public SimpleUser getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(final SimpleUser currentUser) {
        this.currentUser = currentUser;
    }

    public GameAction getLatestAction() {
        return latestAction;
    }

    public void setLatestAction(final GameAction latestAction) {
        this.latestAction = latestAction;
    }

    @Override
    public EngineOptions onCreateEngineOptions() {
        setTheme(R.style.GameBoardTheme);

        game = getIntent().getParcelableExtra(GAME_INFO);
        currentUser = getIntent().getParcelableExtra(CURRENT_USER);
        try {
            latestAction = (new LatestActionTask()).execute(game).get();
        } catch (Exception e) { }

        if (latestAction == null) {
            latestAction = new GameAction();
            latestAction.setGame(game);
            latestAction.setActionNumber(-1);
        }

        final Camera camera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
        return new EngineOptions(true, ScreenOrientation.PORTRAIT_FIXED,
                new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), camera);
    }

    @Override
    final protected void onCreateResources() {
        this.backgroundTextureRegion = TextureUtility.loadBackground(this, CAMERA_WIDTH, CAMERA_HEIGHT);
        gameMenuButtonRegion = TextureUtility.loadGameMenuButton(this);
        onCreateCardGameResources();
    }

    protected abstract void onCreateCardGameResources();

    public Map<Card, ITextureRegion> getCardTextureRegions() {
        return cardTextureRegions;
    }

    public void setCardTextureRegions(final Map<Card, ITextureRegion> cardTextureRegions) {
        this.cardTextureRegions = cardTextureRegions;
    }

    public ITextureRegion getRedBack() {
        return redBack;
    }

    public CardGameScene getCardGameScene() {
        return cardGameScene;
    }

    @Override
    final protected Scene onCreateScene() {
        cardGameScene = new CardGameScene();

        final Sprite bgSprite = new Sprite(0, 0, this.backgroundTextureRegion, this.getVertexBufferObjectManager());
        cardGameScene.setBackground(new SpriteBackground(bgSprite));

        float x = 10;
        float y = CAMERA_HEIGHT - (gameMenuButtonRegion[TextureUtility.BUTTON_STATE_DOWN].getHeight() + 10);
        gameMenuButton = new ButtonSprite(
                x, y,
                gameMenuButtonRegion[TextureUtility.BUTTON_STATE_UP],
                gameMenuButtonRegion[TextureUtility.BUTTON_STATE_DOWN],
                this.getVertexBufferObjectManager());
        gameMenuButton.setOnClickListener(new GameMenuClickListener());
        cardGameScene.attachChild(gameMenuButton);
        cardGameScene.registerTouchArea(gameMenuButton);

        redBack = getCardTextureRegions().get(Card.BACK_RED);

        onCreateCardGameScene(cardGameScene);

        cardGameScene.setTouchAreaBindingOnActionDownEnabled(true);
        return cardGameScene;
    }

    protected abstract void onCreateCardGameScene(final CardGameScene scene);

    public CardSprite getCardSprite(final Card card) {
        CardSprite cardSprite = cardSpritesMap.get(card);
        if (cardSprite == null) {
            cardSprite = new CardSprite(card, 0, 0, getCardTextureRegions().get(card), redBack, getVertexBufferObjectManager());
            cardSpritesMap.put(card, cardSprite);

            getCardGameScene().attachCardSprite(cardSprite);
            cardSprite.setVisible(false);

            cardSprite.showBack();
        }
        return cardSprite;
    }

    private class GameMenuClickListener implements ButtonSprite.OnClickListener {
        @Override
        public void onClick(final ButtonSprite pButtonSprite,
                            final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
            onGameMenuClick(pButtonSprite, pTouchAreaLocalX, pTouchAreaLocalY);
        }
    }

    protected void onGameMenuClick(ButtonSprite pButtonSprite,float pTouchAreaLocalX, float pTouchAreaLocalY) { }

    protected void loadCardSprites(final CardGameScene scene,
                                   final int xMod, final int xSlightMod,
                                   final int yMod, final int yGroupMod) {
        int x = 360;
        int y = 0;
        CardSprite cardSprite = new CardSprite(Card.BACK_BLUE, x, y, this.cardTextureRegions.get(Card.BACK_BLUE), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);

        x = x + (2 * xMod);
        y = y + (2 * yGroupMod);
        cardSprite = new CardSprite(Card.BACK_RED, x, y, this.cardTextureRegions.get(Card.BACK_RED), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);

        x = 0;
        int startY = 0;
        y = startY;
        cardSprite = new CardSprite(Card.CLUBS_ACE, x, y, this.cardTextureRegions.get(Card.CLUBS_ACE), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(Card.DIAMONDS_ACE, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.DIAMONDS_ACE), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(Card.HEARTS_ACE, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.HEARTS_ACE), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(Card.SPADES_ACE, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.SPADES_ACE), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);

        x+=xMod;
        y = (startY+=yGroupMod);
        cardSprite = new CardSprite(Card.CLUBS_TWO, x, y, this.cardTextureRegions.get(Card.CLUBS_TWO), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(Card.DIAMONDS_TWO, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.DIAMONDS_TWO), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(Card.HEARTS_TWO, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.HEARTS_TWO), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(Card.SPADES_TWO, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.SPADES_TWO), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);

        x+=xMod;
        y = (startY+=yGroupMod);
        cardSprite = new CardSprite(Card.CLUBS_THREE, x, y, this.cardTextureRegions.get(Card.CLUBS_THREE), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(Card.DIAMONDS_THREE, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.DIAMONDS_THREE), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(Card.HEARTS_THREE, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.HEARTS_THREE), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(Card.SPADES_THREE, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.SPADES_THREE), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);

        x+=xMod;
        y = (startY+=yGroupMod);
        cardSprite = new CardSprite(Card.CLUBS_FOUR, x, y, this.cardTextureRegions.get(Card.CLUBS_FOUR), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(Card.DIAMONDS_FOUR, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.DIAMONDS_FOUR), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(Card.HEARTS_FOUR, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.HEARTS_FOUR), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(Card.SPADES_FOUR, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.SPADES_FOUR), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);

        x+=xMod;
        y = (startY+=yGroupMod);
        cardSprite = new CardSprite(Card.CLUBS_FIVE, x, y, this.cardTextureRegions.get(Card.CLUBS_FIVE), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(Card.DIAMONDS_FIVE, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.DIAMONDS_FIVE), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(Card.HEARTS_FIVE, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.HEARTS_FIVE), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(Card.SPADES_FIVE, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.SPADES_FIVE), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);

        x+=xMod;
        y = (startY+=yGroupMod);
        cardSprite = new CardSprite(Card.CLUBS_SIX, x, y, this.cardTextureRegions.get(Card.CLUBS_SIX), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(Card.DIAMONDS_SIX, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.DIAMONDS_SIX), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(Card.HEARTS_SIX, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.HEARTS_SIX), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(Card.SPADES_SIX, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.SPADES_SIX), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);

        x+=xMod;
        y = (startY+=yGroupMod);
        cardSprite = new CardSprite(Card.CLUBS_SEVEN, x, y, this.cardTextureRegions.get(Card.CLUBS_SEVEN), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(Card.DIAMONDS_SEVEN, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.DIAMONDS_SEVEN), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(Card.HEARTS_SEVEN, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.HEARTS_SEVEN), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(Card.SPADES_SEVEN, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.SPADES_SEVEN), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);

        x+=xMod;
        y = (startY+=yGroupMod);
        cardSprite = new CardSprite(Card.CLUBS_EIGHT, x, y, this.cardTextureRegions.get(Card.CLUBS_EIGHT), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(Card.DIAMONDS_EIGHT, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.DIAMONDS_EIGHT), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(Card.HEARTS_EIGHT, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.HEARTS_EIGHT), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(Card.SPADES_EIGHT, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.SPADES_EIGHT), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);

        x+=xMod;
        y = (startY+=yGroupMod);
        cardSprite = new CardSprite(Card.CLUBS_NINE, x, y, this.cardTextureRegions.get(Card.CLUBS_NINE), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(Card.DIAMONDS_NINE, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.DIAMONDS_NINE), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(Card.HEARTS_NINE, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.HEARTS_NINE), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(Card.SPADES_NINE, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.SPADES_NINE), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);

        x+=xMod;
        y = (startY+=yGroupMod);
        cardSprite = new CardSprite(Card.CLUBS_TEN, x, y, this.cardTextureRegions.get(Card.CLUBS_TEN), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(Card.DIAMONDS_TEN, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.DIAMONDS_TEN), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(Card.HEARTS_TEN, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.HEARTS_TEN), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(Card.SPADES_TEN, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.SPADES_TEN), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);

        x+=xMod;
        y = (startY+=yGroupMod);
        cardSprite = new CardSprite(Card.CLUBS_JACK, x, y, this.cardTextureRegions.get(Card.CLUBS_JACK), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(Card.DIAMONDS_JACK, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.DIAMONDS_JACK), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(Card.HEARTS_JACK, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.HEARTS_JACK), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(Card.SPADES_JACK, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.SPADES_JACK), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);

        x+=xMod;
        y = (startY+=yGroupMod);
        cardSprite = new CardSprite(Card.CLUBS_QUEEN, x, y, this.cardTextureRegions.get(Card.CLUBS_QUEEN), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(Card.DIAMONDS_QUEEN, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.DIAMONDS_QUEEN), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(Card.HEARTS_QUEEN, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.HEARTS_QUEEN), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(Card.SPADES_QUEEN, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.SPADES_QUEEN), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);

        x+=xMod;
        y = (startY+=yGroupMod);
        cardSprite = new CardSprite(Card.CLUBS_KING, x, y, this.cardTextureRegions.get(Card.CLUBS_KING), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(Card.DIAMONDS_KING, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.DIAMONDS_KING), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(Card.HEARTS_KING, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.HEARTS_KING), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
        cardSprite = new CardSprite(Card.SPADES_KING, x+=xSlightMod, y+=yMod, this.cardTextureRegions.get(Card.SPADES_KING), this.getVertexBufferObjectManager());
        scene.attachCardSprite(cardSprite);
    }
}
