/**
 * Patrick John Haskins
 * Zachary Evans
 * CS7020 - Term Project
 */
package android.otasyn.cardgames.utility;

import android.otasyn.cardgames.utility.enumeration.Background;
import android.otasyn.cardgames.utility.enumeration.CardType;
import android.otasyn.cardgames.utility.enumeration.CardFile;
import android.otasyn.cardgames.utility.enumeration.CardLocation;
import org.andengine.extension.texturepacker.opengl.texture.util.texturepacker.TexturePack;
import org.andengine.extension.texturepacker.opengl.texture.util.texturepacker.TexturePackLoader;
import org.andengine.extension.texturepacker.opengl.texture.util.texturepacker.TexturePackTextureRegionLibrary;
import org.andengine.extension.texturepacker.opengl.texture.util.texturepacker.exception.TexturePackParseException;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.builder.BlackPawnTextureAtlasBuilder;
import org.andengine.opengl.texture.atlas.buildable.builder.ITextureAtlasBuilder;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TextureRegionFactory;
import org.andengine.ui.activity.BaseGameActivity;
import org.andengine.util.debug.Debug;

import java.util.HashMap;
import java.util.Map;

public class TextureUtility {

    public static final int BUTTON_STATE_UP = 0;
    public static final int BUTTON_STATE_DOWN = 1;
    public static final int BUTTON_STATE_DISABLED = 2;

    public static ITextureRegion loadBackground(final BaseGameActivity baseGameActivity,
                                                final int width, final int height) {
        return loadBackground(baseGameActivity, width, height, Background.BG_GREEN_1A9C48);
    }

    public static ITextureRegion loadBackground(final BaseGameActivity baseGameActivity,
                                                final int width, final int height,
                                                final Background bg) {
        BitmapTextureAtlas backgroundTexture = new BitmapTextureAtlas(baseGameActivity.getTextureManager(), 100, 100,
                TextureOptions.REPEATING_BILINEAR_PREMULTIPLYALPHA);
        BitmapTextureAtlasTextureRegionFactory.setAssetBasePath(Background.BG_BASE_PATH);
        BitmapTextureAtlasTextureRegionFactory.createFromAsset(
                backgroundTexture, baseGameActivity, bg.getLocation(), 0, 0);
        backgroundTexture.load();
        ITextureRegion backgroundTextureRegion = TextureRegionFactory.extractFromTexture(backgroundTexture);

        backgroundTextureRegion.setTextureWidth(width);
        backgroundTextureRegion.setTextureHeight(height);

        return backgroundTextureRegion;
    }

    public static Map<CardType,ITextureRegion> loadCards46x64(final BaseGameActivity baseGameActivity) {
        Map<CardType,ITextureRegion> cards = new HashMap<CardType, ITextureRegion>(CardType.values().length);
        try {
            TexturePackLoader texturePackLoader = new TexturePackLoader(
                    baseGameActivity.getTextureManager(), CardLocation.LOCATION_46x64.getLocation());

            final TexturePack texturePack = texturePackLoader.loadFromAsset(
                    baseGameActivity.getAssets(), CardFile.FILE_46x64.getFile());
            texturePack.loadTexture();
            TexturePackTextureRegionLibrary texturePackLibrary = texturePack.getTexturePackTextureRegionLibrary();

            cards.put(CardType.CLUBS_ACE, texturePackLibrary.get(CardType.CLUBS_ACE.getId_46x64()));
            cards.put(CardType.CLUBS_TWO, texturePackLibrary.get(CardType.CLUBS_TWO.getId_46x64()));
            cards.put(CardType.CLUBS_THREE, texturePackLibrary.get(CardType.CLUBS_THREE.getId_46x64()));
            cards.put(CardType.CLUBS_FOUR, texturePackLibrary.get(CardType.CLUBS_FOUR.getId_46x64()));
            cards.put(CardType.CLUBS_FIVE, texturePackLibrary.get(CardType.CLUBS_FIVE.getId_46x64()));
            cards.put(CardType.CLUBS_SIX, texturePackLibrary.get(CardType.CLUBS_SIX.getId_46x64()));
            cards.put(CardType.CLUBS_SEVEN, texturePackLibrary.get(CardType.CLUBS_SEVEN.getId_46x64()));
            cards.put(CardType.CLUBS_EIGHT, texturePackLibrary.get(CardType.CLUBS_EIGHT.getId_46x64()));
            cards.put(CardType.CLUBS_NINE, texturePackLibrary.get(CardType.CLUBS_NINE.getId_46x64()));
            cards.put(CardType.CLUBS_TEN, texturePackLibrary.get(CardType.CLUBS_TEN.getId_46x64()));
            cards.put(CardType.CLUBS_JACK, texturePackLibrary.get(CardType.CLUBS_JACK.getId_46x64()));
            cards.put(CardType.CLUBS_QUEEN, texturePackLibrary.get(CardType.CLUBS_QUEEN.getId_46x64()));
            cards.put(CardType.CLUBS_KING, texturePackLibrary.get(CardType.CLUBS_KING.getId_46x64()));

            cards.put(CardType.DIAMONDS_ACE, texturePackLibrary.get(CardType.DIAMONDS_ACE.getId_46x64()));
            cards.put(CardType.DIAMONDS_TWO, texturePackLibrary.get(CardType.DIAMONDS_TWO.getId_46x64()));
            cards.put(CardType.DIAMONDS_THREE, texturePackLibrary.get(CardType.DIAMONDS_THREE.getId_46x64()));
            cards.put(CardType.DIAMONDS_FOUR, texturePackLibrary.get(CardType.DIAMONDS_FOUR.getId_46x64()));
            cards.put(CardType.DIAMONDS_FIVE, texturePackLibrary.get(CardType.DIAMONDS_FIVE.getId_46x64()));
            cards.put(CardType.DIAMONDS_SIX, texturePackLibrary.get(CardType.DIAMONDS_SIX.getId_46x64()));
            cards.put(CardType.DIAMONDS_SEVEN, texturePackLibrary.get(CardType.DIAMONDS_SEVEN.getId_46x64()));
            cards.put(CardType.DIAMONDS_EIGHT, texturePackLibrary.get(CardType.DIAMONDS_EIGHT.getId_46x64()));
            cards.put(CardType.DIAMONDS_NINE, texturePackLibrary.get(CardType.DIAMONDS_NINE.getId_46x64()));
            cards.put(CardType.DIAMONDS_TEN, texturePackLibrary.get(CardType.DIAMONDS_TEN.getId_46x64()));
            cards.put(CardType.DIAMONDS_JACK, texturePackLibrary.get(CardType.DIAMONDS_JACK.getId_46x64()));
            cards.put(CardType.DIAMONDS_QUEEN, texturePackLibrary.get(CardType.DIAMONDS_QUEEN.getId_46x64()));
            cards.put(CardType.DIAMONDS_KING, texturePackLibrary.get(CardType.DIAMONDS_KING.getId_46x64()));

            cards.put(CardType.HEARTS_ACE, texturePackLibrary.get(CardType.HEARTS_ACE.getId_46x64()));
            cards.put(CardType.HEARTS_TWO, texturePackLibrary.get(CardType.HEARTS_TWO.getId_46x64()));
            cards.put(CardType.HEARTS_THREE, texturePackLibrary.get(CardType.HEARTS_THREE.getId_46x64()));
            cards.put(CardType.HEARTS_FOUR, texturePackLibrary.get(CardType.HEARTS_FOUR.getId_46x64()));
            cards.put(CardType.HEARTS_FIVE, texturePackLibrary.get(CardType.HEARTS_FIVE.getId_46x64()));
            cards.put(CardType.HEARTS_SIX, texturePackLibrary.get(CardType.HEARTS_SIX.getId_46x64()));
            cards.put(CardType.HEARTS_SEVEN, texturePackLibrary.get(CardType.HEARTS_SEVEN.getId_46x64()));
            cards.put(CardType.HEARTS_EIGHT, texturePackLibrary.get(CardType.HEARTS_EIGHT.getId_46x64()));
            cards.put(CardType.HEARTS_NINE, texturePackLibrary.get(CardType.HEARTS_NINE.getId_46x64()));
            cards.put(CardType.HEARTS_TEN, texturePackLibrary.get(CardType.HEARTS_TEN.getId_46x64()));
            cards.put(CardType.HEARTS_JACK, texturePackLibrary.get(CardType.HEARTS_JACK.getId_46x64()));
            cards.put(CardType.HEARTS_QUEEN, texturePackLibrary.get(CardType.HEARTS_QUEEN.getId_46x64()));
            cards.put(CardType.HEARTS_KING, texturePackLibrary.get(CardType.HEARTS_KING.getId_46x64()));

            cards.put(CardType.SPADES_ACE, texturePackLibrary.get(CardType.SPADES_ACE.getId_46x64()));
            cards.put(CardType.SPADES_TWO, texturePackLibrary.get(CardType.SPADES_TWO.getId_46x64()));
            cards.put(CardType.SPADES_THREE, texturePackLibrary.get(CardType.SPADES_THREE.getId_46x64()));
            cards.put(CardType.SPADES_FOUR, texturePackLibrary.get(CardType.SPADES_FOUR.getId_46x64()));
            cards.put(CardType.SPADES_FIVE, texturePackLibrary.get(CardType.SPADES_FIVE.getId_46x64()));
            cards.put(CardType.SPADES_SIX, texturePackLibrary.get(CardType.SPADES_SIX.getId_46x64()));
            cards.put(CardType.SPADES_SEVEN, texturePackLibrary.get(CardType.SPADES_SEVEN.getId_46x64()));
            cards.put(CardType.SPADES_EIGHT, texturePackLibrary.get(CardType.SPADES_EIGHT.getId_46x64()));
            cards.put(CardType.SPADES_NINE, texturePackLibrary.get(CardType.SPADES_NINE.getId_46x64()));
            cards.put(CardType.SPADES_TEN, texturePackLibrary.get(CardType.SPADES_TEN.getId_46x64()));
            cards.put(CardType.SPADES_JACK, texturePackLibrary.get(CardType.SPADES_JACK.getId_46x64()));
            cards.put(CardType.SPADES_QUEEN, texturePackLibrary.get(CardType.SPADES_QUEEN.getId_46x64()));
            cards.put(CardType.SPADES_KING, texturePackLibrary.get(CardType.SPADES_KING.getId_46x64()));

            cards.put(CardType.BACK_BLUE, texturePackLibrary.get(CardType.BACK_BLUE.getId_46x64()));
            cards.put(CardType.BACK_RED, texturePackLibrary.get(CardType.BACK_RED.getId_46x64()));
        } catch (final TexturePackParseException e) {
            Debug.e(e);
        }

        return cards;
    }

    public static Map<CardType,ITextureRegion> loadCards92x128(final BaseGameActivity baseGameActivity) {
        Map<CardType,ITextureRegion> cards = new HashMap<CardType, ITextureRegion>(CardType.values().length);
        try {
            TexturePackLoader texturePackLoader = new TexturePackLoader(
                    baseGameActivity.getTextureManager(), CardLocation.LOCATION_92x128.getLocation());

            final TexturePack texturePack = texturePackLoader.loadFromAsset(
                    baseGameActivity.getAssets(), CardFile.FILE_92x128.getFile());
            texturePack.loadTexture();
            TexturePackTextureRegionLibrary texturePackLibrary = texturePack.getTexturePackTextureRegionLibrary();

            cards.put(CardType.CLUBS_ACE, texturePackLibrary.get(CardType.CLUBS_ACE.getId_92x128()));
            cards.put(CardType.CLUBS_TWO, texturePackLibrary.get(CardType.CLUBS_TWO.getId_92x128()));
            cards.put(CardType.CLUBS_THREE, texturePackLibrary.get(CardType.CLUBS_THREE.getId_92x128()));
            cards.put(CardType.CLUBS_FOUR, texturePackLibrary.get(CardType.CLUBS_FOUR.getId_92x128()));
            cards.put(CardType.CLUBS_FIVE, texturePackLibrary.get(CardType.CLUBS_FIVE.getId_92x128()));
            cards.put(CardType.CLUBS_SIX, texturePackLibrary.get(CardType.CLUBS_SIX.getId_92x128()));
            cards.put(CardType.CLUBS_SEVEN, texturePackLibrary.get(CardType.CLUBS_SEVEN.getId_92x128()));
            cards.put(CardType.CLUBS_EIGHT, texturePackLibrary.get(CardType.CLUBS_EIGHT.getId_92x128()));
            cards.put(CardType.CLUBS_NINE, texturePackLibrary.get(CardType.CLUBS_NINE.getId_92x128()));
            cards.put(CardType.CLUBS_TEN, texturePackLibrary.get(CardType.CLUBS_TEN.getId_92x128()));
            cards.put(CardType.CLUBS_JACK, texturePackLibrary.get(CardType.CLUBS_JACK.getId_92x128()));
            cards.put(CardType.CLUBS_QUEEN, texturePackLibrary.get(CardType.CLUBS_QUEEN.getId_92x128()));
            cards.put(CardType.CLUBS_KING, texturePackLibrary.get(CardType.CLUBS_KING.getId_92x128()));

            cards.put(CardType.DIAMONDS_ACE, texturePackLibrary.get(CardType.DIAMONDS_ACE.getId_92x128()));
            cards.put(CardType.DIAMONDS_TWO, texturePackLibrary.get(CardType.DIAMONDS_TWO.getId_92x128()));
            cards.put(CardType.DIAMONDS_THREE, texturePackLibrary.get(CardType.DIAMONDS_THREE.getId_92x128()));
            cards.put(CardType.DIAMONDS_FOUR, texturePackLibrary.get(CardType.DIAMONDS_FOUR.getId_92x128()));
            cards.put(CardType.DIAMONDS_FIVE, texturePackLibrary.get(CardType.DIAMONDS_FIVE.getId_92x128()));
            cards.put(CardType.DIAMONDS_SIX, texturePackLibrary.get(CardType.DIAMONDS_SIX.getId_92x128()));
            cards.put(CardType.DIAMONDS_SEVEN, texturePackLibrary.get(CardType.DIAMONDS_SEVEN.getId_92x128()));
            cards.put(CardType.DIAMONDS_EIGHT, texturePackLibrary.get(CardType.DIAMONDS_EIGHT.getId_92x128()));
            cards.put(CardType.DIAMONDS_NINE, texturePackLibrary.get(CardType.DIAMONDS_NINE.getId_92x128()));
            cards.put(CardType.DIAMONDS_TEN, texturePackLibrary.get(CardType.DIAMONDS_TEN.getId_92x128()));
            cards.put(CardType.DIAMONDS_JACK, texturePackLibrary.get(CardType.DIAMONDS_JACK.getId_92x128()));
            cards.put(CardType.DIAMONDS_QUEEN, texturePackLibrary.get(CardType.DIAMONDS_QUEEN.getId_92x128()));
            cards.put(CardType.DIAMONDS_KING, texturePackLibrary.get(CardType.DIAMONDS_KING.getId_92x128()));

            cards.put(CardType.HEARTS_ACE, texturePackLibrary.get(CardType.HEARTS_ACE.getId_92x128()));
            cards.put(CardType.HEARTS_TWO, texturePackLibrary.get(CardType.HEARTS_TWO.getId_92x128()));
            cards.put(CardType.HEARTS_THREE, texturePackLibrary.get(CardType.HEARTS_THREE.getId_92x128()));
            cards.put(CardType.HEARTS_FOUR, texturePackLibrary.get(CardType.HEARTS_FOUR.getId_92x128()));
            cards.put(CardType.HEARTS_FIVE, texturePackLibrary.get(CardType.HEARTS_FIVE.getId_92x128()));
            cards.put(CardType.HEARTS_SIX, texturePackLibrary.get(CardType.HEARTS_SIX.getId_92x128()));
            cards.put(CardType.HEARTS_SEVEN, texturePackLibrary.get(CardType.HEARTS_SEVEN.getId_92x128()));
            cards.put(CardType.HEARTS_EIGHT, texturePackLibrary.get(CardType.HEARTS_EIGHT.getId_92x128()));
            cards.put(CardType.HEARTS_NINE, texturePackLibrary.get(CardType.HEARTS_NINE.getId_92x128()));
            cards.put(CardType.HEARTS_TEN, texturePackLibrary.get(CardType.HEARTS_TEN.getId_92x128()));
            cards.put(CardType.HEARTS_JACK, texturePackLibrary.get(CardType.HEARTS_JACK.getId_92x128()));
            cards.put(CardType.HEARTS_QUEEN, texturePackLibrary.get(CardType.HEARTS_QUEEN.getId_92x128()));
            cards.put(CardType.HEARTS_KING, texturePackLibrary.get(CardType.HEARTS_KING.getId_92x128()));

            cards.put(CardType.SPADES_ACE, texturePackLibrary.get(CardType.SPADES_ACE.getId_92x128()));
            cards.put(CardType.SPADES_TWO, texturePackLibrary.get(CardType.SPADES_TWO.getId_92x128()));
            cards.put(CardType.SPADES_THREE, texturePackLibrary.get(CardType.SPADES_THREE.getId_92x128()));
            cards.put(CardType.SPADES_FOUR, texturePackLibrary.get(CardType.SPADES_FOUR.getId_92x128()));
            cards.put(CardType.SPADES_FIVE, texturePackLibrary.get(CardType.SPADES_FIVE.getId_92x128()));
            cards.put(CardType.SPADES_SIX, texturePackLibrary.get(CardType.SPADES_SIX.getId_92x128()));
            cards.put(CardType.SPADES_SEVEN, texturePackLibrary.get(CardType.SPADES_SEVEN.getId_92x128()));
            cards.put(CardType.SPADES_EIGHT, texturePackLibrary.get(CardType.SPADES_EIGHT.getId_92x128()));
            cards.put(CardType.SPADES_NINE, texturePackLibrary.get(CardType.SPADES_NINE.getId_92x128()));
            cards.put(CardType.SPADES_TEN, texturePackLibrary.get(CardType.SPADES_TEN.getId_92x128()));
            cards.put(CardType.SPADES_JACK, texturePackLibrary.get(CardType.SPADES_JACK.getId_92x128()));
            cards.put(CardType.SPADES_QUEEN, texturePackLibrary.get(CardType.SPADES_QUEEN.getId_92x128()));
            cards.put(CardType.SPADES_KING, texturePackLibrary.get(CardType.SPADES_KING.getId_92x128()));

            cards.put(CardType.BACK_BLUE, texturePackLibrary.get(CardType.BACK_BLUE.getId_92x128()));
            cards.put(CardType.BACK_RED, texturePackLibrary.get(CardType.BACK_RED.getId_92x128()));
        } catch (final TexturePackParseException e) {
            Debug.e(e);
        }

        return cards;
    }

    public static Map<CardType,ITextureRegion> loadCards184x256(final BaseGameActivity baseGameActivity) {
        Map<CardType,ITextureRegion> cards = new HashMap<CardType, ITextureRegion>(CardType.values().length);
        try {
            TexturePackLoader texturePackLoader = new TexturePackLoader(baseGameActivity.getTextureManager(),
                    CardLocation.LOCATION_184x256.getLocation());
            final TexturePack clubsTexturePack = texturePackLoader.loadFromAsset(
                    baseGameActivity.getAssets(), CardFile.FILE_184x256_CLUBS.getFile());
            clubsTexturePack.loadTexture();
            TexturePackTextureRegionLibrary clubsTexturePackLibrary =
                    clubsTexturePack.getTexturePackTextureRegionLibrary();

            cards.put(CardType.CLUBS_ACE, clubsTexturePackLibrary.get(CardType.CLUBS_ACE.getId_184x256()));
            cards.put(CardType.CLUBS_TWO, clubsTexturePackLibrary.get(CardType.CLUBS_TWO.getId_184x256()));
            cards.put(CardType.CLUBS_THREE, clubsTexturePackLibrary.get(CardType.CLUBS_THREE.getId_184x256()));
            cards.put(CardType.CLUBS_FOUR, clubsTexturePackLibrary.get(CardType.CLUBS_FOUR.getId_184x256()));
            cards.put(CardType.CLUBS_FIVE, clubsTexturePackLibrary.get(CardType.CLUBS_FIVE.getId_184x256()));
            cards.put(CardType.CLUBS_SIX, clubsTexturePackLibrary.get(CardType.CLUBS_SIX.getId_184x256()));
            cards.put(CardType.CLUBS_SEVEN, clubsTexturePackLibrary.get(CardType.CLUBS_SEVEN.getId_184x256()));
            cards.put(CardType.CLUBS_EIGHT, clubsTexturePackLibrary.get(CardType.CLUBS_EIGHT.getId_184x256()));
            cards.put(CardType.CLUBS_NINE, clubsTexturePackLibrary.get(CardType.CLUBS_NINE.getId_184x256()));
            cards.put(CardType.CLUBS_TEN, clubsTexturePackLibrary.get(CardType.CLUBS_TEN.getId_184x256()));
            cards.put(CardType.CLUBS_JACK, clubsTexturePackLibrary.get(CardType.CLUBS_JACK.getId_184x256()));
            cards.put(CardType.CLUBS_QUEEN, clubsTexturePackLibrary.get(CardType.CLUBS_QUEEN.getId_184x256()));
            cards.put(CardType.CLUBS_KING, clubsTexturePackLibrary.get(CardType.CLUBS_KING.getId_184x256()));

            final TexturePack diamondsTexturePack = texturePackLoader.loadFromAsset(
                    baseGameActivity.getAssets(),  CardFile.FILE_184x256_DIAMONDS.getFile());
            diamondsTexturePack.loadTexture();
            TexturePackTextureRegionLibrary diamondsTexturePackLibrary =
                    diamondsTexturePack.getTexturePackTextureRegionLibrary();

            cards.put(CardType.DIAMONDS_ACE, diamondsTexturePackLibrary.get(CardType.DIAMONDS_ACE.getId_184x256()));
            cards.put(CardType.DIAMONDS_TWO, diamondsTexturePackLibrary.get(CardType.DIAMONDS_TWO.getId_184x256()));
            cards.put(CardType.DIAMONDS_THREE, diamondsTexturePackLibrary.get(CardType.DIAMONDS_THREE.getId_184x256()));
            cards.put(CardType.DIAMONDS_FOUR, diamondsTexturePackLibrary.get(CardType.DIAMONDS_FOUR.getId_184x256()));
            cards.put(CardType.DIAMONDS_FIVE, diamondsTexturePackLibrary.get(CardType.DIAMONDS_FIVE.getId_184x256()));
            cards.put(CardType.DIAMONDS_SIX, diamondsTexturePackLibrary.get(CardType.DIAMONDS_SIX.getId_184x256()));
            cards.put(CardType.DIAMONDS_SEVEN, diamondsTexturePackLibrary.get(CardType.DIAMONDS_SEVEN.getId_184x256()));
            cards.put(CardType.DIAMONDS_EIGHT, diamondsTexturePackLibrary.get(CardType.DIAMONDS_EIGHT.getId_184x256()));
            cards.put(CardType.DIAMONDS_NINE, diamondsTexturePackLibrary.get(CardType.DIAMONDS_NINE.getId_184x256()));
            cards.put(CardType.DIAMONDS_TEN, diamondsTexturePackLibrary.get(CardType.DIAMONDS_TEN.getId_184x256()));
            cards.put(CardType.DIAMONDS_JACK, diamondsTexturePackLibrary.get(CardType.DIAMONDS_JACK.getId_184x256()));
            cards.put(CardType.DIAMONDS_QUEEN, diamondsTexturePackLibrary.get(CardType.DIAMONDS_QUEEN.getId_184x256()));
            cards.put(CardType.DIAMONDS_KING, diamondsTexturePackLibrary.get(CardType.DIAMONDS_KING.getId_184x256()));

            final TexturePack heartsTexturePack = texturePackLoader.loadFromAsset(
                    baseGameActivity.getAssets(),  CardFile.FILE_184x256_HEARTS.getFile());
            heartsTexturePack.loadTexture();
            TexturePackTextureRegionLibrary heartsTexturePackLibrary =
                    heartsTexturePack.getTexturePackTextureRegionLibrary();

            cards.put(CardType.HEARTS_ACE, heartsTexturePackLibrary.get(CardType.HEARTS_ACE.getId_184x256()));
            cards.put(CardType.HEARTS_TWO, heartsTexturePackLibrary.get(CardType.HEARTS_TWO.getId_184x256()));
            cards.put(CardType.HEARTS_THREE, heartsTexturePackLibrary.get(CardType.HEARTS_THREE.getId_184x256()));
            cards.put(CardType.HEARTS_FOUR, heartsTexturePackLibrary.get(CardType.HEARTS_FOUR.getId_184x256()));
            cards.put(CardType.HEARTS_FIVE, heartsTexturePackLibrary.get(CardType.HEARTS_FIVE.getId_184x256()));
            cards.put(CardType.HEARTS_SIX, heartsTexturePackLibrary.get(CardType.HEARTS_SIX.getId_184x256()));
            cards.put(CardType.HEARTS_SEVEN, heartsTexturePackLibrary.get(CardType.HEARTS_SEVEN.getId_184x256()));
            cards.put(CardType.HEARTS_EIGHT, heartsTexturePackLibrary.get(CardType.HEARTS_EIGHT.getId_184x256()));
            cards.put(CardType.HEARTS_NINE, heartsTexturePackLibrary.get(CardType.HEARTS_NINE.getId_184x256()));
            cards.put(CardType.HEARTS_TEN, heartsTexturePackLibrary.get(CardType.HEARTS_TEN.getId_184x256()));
            cards.put(CardType.HEARTS_JACK, heartsTexturePackLibrary.get(CardType.HEARTS_JACK.getId_184x256()));
            cards.put(CardType.HEARTS_QUEEN, heartsTexturePackLibrary.get(CardType.HEARTS_QUEEN.getId_184x256()));
            cards.put(CardType.HEARTS_KING, heartsTexturePackLibrary.get(CardType.HEARTS_KING.getId_184x256()));

            final TexturePack spadesTexturePack = texturePackLoader.loadFromAsset(
                    baseGameActivity.getAssets(),  CardFile.FILE_184x256_SPADES.getFile());
            spadesTexturePack.loadTexture();
            TexturePackTextureRegionLibrary spadesTexturePackLibrary =
                    spadesTexturePack.getTexturePackTextureRegionLibrary();

            cards.put(CardType.SPADES_ACE, spadesTexturePackLibrary.get(CardType.SPADES_ACE.getId_184x256()));
            cards.put(CardType.SPADES_TWO, spadesTexturePackLibrary.get(CardType.SPADES_TWO.getId_184x256()));
            cards.put(CardType.SPADES_THREE, spadesTexturePackLibrary.get(CardType.SPADES_THREE.getId_184x256()));
            cards.put(CardType.SPADES_FOUR, spadesTexturePackLibrary.get(CardType.SPADES_FOUR.getId_184x256()));
            cards.put(CardType.SPADES_FIVE, spadesTexturePackLibrary.get(CardType.SPADES_FIVE.getId_184x256()));
            cards.put(CardType.SPADES_SIX, spadesTexturePackLibrary.get(CardType.SPADES_SIX.getId_184x256()));
            cards.put(CardType.SPADES_SEVEN, spadesTexturePackLibrary.get(CardType.SPADES_SEVEN.getId_184x256()));
            cards.put(CardType.SPADES_EIGHT, spadesTexturePackLibrary.get(CardType.SPADES_EIGHT.getId_184x256()));
            cards.put(CardType.SPADES_NINE, spadesTexturePackLibrary.get(CardType.SPADES_NINE.getId_184x256()));
            cards.put(CardType.SPADES_TEN, spadesTexturePackLibrary.get(CardType.SPADES_TEN.getId_184x256()));
            cards.put(CardType.SPADES_JACK, spadesTexturePackLibrary.get(CardType.SPADES_JACK.getId_184x256()));
            cards.put(CardType.SPADES_QUEEN, spadesTexturePackLibrary.get(CardType.SPADES_QUEEN.getId_184x256()));
            cards.put(CardType.SPADES_KING, spadesTexturePackLibrary.get(CardType.SPADES_KING.getId_184x256()));

            final TexturePack backsTexturePack = texturePackLoader.loadFromAsset(
                    baseGameActivity.getAssets(),  CardFile.FILE_184x256_BACKS.getFile());
            backsTexturePack.loadTexture();
            TexturePackTextureRegionLibrary backsTexturePackLibrary =
                    backsTexturePack.getTexturePackTextureRegionLibrary();

            cards.put(CardType.BACK_BLUE, backsTexturePackLibrary.get(CardType.BACK_BLUE.getId_184x256()));
            cards.put(CardType.BACK_RED, backsTexturePackLibrary.get(CardType.BACK_RED.getId_184x256()));
        } catch (final TexturePackParseException e) {
            Debug.e(e);
        }

        return cards;
    }

    public static Map<CardType,ITextureRegion> loadCardsFullSize(final BaseGameActivity baseGameActivity) {
        Map<CardType,ITextureRegion> cards = new HashMap<CardType, ITextureRegion>(CardType.values().length);
        try {
            TexturePackLoader texturePackLoader = new TexturePackLoader(baseGameActivity.getTextureManager(),
                    CardLocation.LOCATION_FULL.getLocation());
            final TexturePack clubsNumberedTexturePack = texturePackLoader.loadFromAsset(
                    baseGameActivity.getAssets(), CardFile.FILE_FULL_CLUBS_NUMBERED.getFile());
            clubsNumberedTexturePack.loadTexture();
            TexturePackTextureRegionLibrary clubsNumberedTexturePackLibrary =
                    clubsNumberedTexturePack.getTexturePackTextureRegionLibrary();

            cards.put(CardType.CLUBS_TWO, clubsNumberedTexturePackLibrary.get(CardType.CLUBS_TWO.getId_fullSize()));
            cards.put(CardType.CLUBS_THREE, clubsNumberedTexturePackLibrary.get(CardType.CLUBS_THREE.getId_fullSize()));
            cards.put(CardType.CLUBS_FOUR, clubsNumberedTexturePackLibrary.get(CardType.CLUBS_FOUR.getId_fullSize()));
            cards.put(CardType.CLUBS_FIVE, clubsNumberedTexturePackLibrary.get(CardType.CLUBS_FIVE.getId_fullSize()));
            cards.put(CardType.CLUBS_SIX, clubsNumberedTexturePackLibrary.get(CardType.CLUBS_SIX.getId_fullSize()));
            cards.put(CardType.CLUBS_SEVEN, clubsNumberedTexturePackLibrary.get(CardType.CLUBS_SEVEN.getId_fullSize()));
            cards.put(CardType.CLUBS_EIGHT, clubsNumberedTexturePackLibrary.get(CardType.CLUBS_EIGHT.getId_fullSize()));
            cards.put(CardType.CLUBS_NINE, clubsNumberedTexturePackLibrary.get(CardType.CLUBS_NINE.getId_fullSize()));
            cards.put(CardType.CLUBS_TEN, clubsNumberedTexturePackLibrary.get(CardType.CLUBS_TEN.getId_fullSize()));

            final TexturePack clubsLetteredTexturePack = texturePackLoader.loadFromAsset(
                    baseGameActivity.getAssets(), CardFile.FILE_FULL_CLUBS_LETTERED.getFile());
            clubsLetteredTexturePack.loadTexture();
            TexturePackTextureRegionLibrary clubsLetteredTexturePackLibrary =
                    clubsLetteredTexturePack.getTexturePackTextureRegionLibrary();

            cards.put(CardType.CLUBS_ACE, clubsLetteredTexturePackLibrary.get(CardType.CLUBS_ACE.getId_fullSize()));
            cards.put(CardType.CLUBS_JACK, clubsLetteredTexturePackLibrary.get(CardType.CLUBS_JACK.getId_fullSize()));
            cards.put(CardType.CLUBS_QUEEN, clubsLetteredTexturePackLibrary.get(CardType.CLUBS_QUEEN.getId_fullSize()));
            cards.put(CardType.CLUBS_KING, clubsLetteredTexturePackLibrary.get(CardType.CLUBS_KING.getId_fullSize()));

            final TexturePack diamondsNumberedTexturePack = texturePackLoader.loadFromAsset(
                    baseGameActivity.getAssets(), CardFile.FILE_FULL_DIAMONDS_NUMBERED.getFile());
            diamondsNumberedTexturePack.loadTexture();
            TexturePackTextureRegionLibrary diamondsNumberedTexturePackLibrary =
                    diamondsNumberedTexturePack.getTexturePackTextureRegionLibrary();

            cards.put(CardType.DIAMONDS_TWO, diamondsNumberedTexturePackLibrary.get(CardType.DIAMONDS_TWO.getId_fullSize()));
            cards.put(CardType.DIAMONDS_THREE, diamondsNumberedTexturePackLibrary.get(CardType.DIAMONDS_THREE.getId_fullSize()));
            cards.put(CardType.DIAMONDS_FOUR, diamondsNumberedTexturePackLibrary.get(CardType.DIAMONDS_FOUR.getId_fullSize()));
            cards.put(CardType.DIAMONDS_FIVE, diamondsNumberedTexturePackLibrary.get(CardType.DIAMONDS_FIVE.getId_fullSize()));
            cards.put(CardType.DIAMONDS_SIX, diamondsNumberedTexturePackLibrary.get(CardType.DIAMONDS_SIX.getId_fullSize()));
            cards.put(CardType.DIAMONDS_SEVEN, diamondsNumberedTexturePackLibrary.get(CardType.DIAMONDS_SEVEN.getId_fullSize()));
            cards.put(CardType.DIAMONDS_EIGHT, diamondsNumberedTexturePackLibrary.get(CardType.DIAMONDS_EIGHT.getId_fullSize()));
            cards.put(CardType.DIAMONDS_NINE, diamondsNumberedTexturePackLibrary.get(CardType.DIAMONDS_NINE.getId_fullSize()));
            cards.put(CardType.DIAMONDS_TEN, diamondsNumberedTexturePackLibrary.get(CardType.DIAMONDS_TEN.getId_fullSize()));

            final TexturePack diamondsLetteredTexturePack = texturePackLoader.loadFromAsset(
                    baseGameActivity.getAssets(), CardFile.FILE_FULL_DIAMONDS_LETTERED.getFile());
            diamondsLetteredTexturePack.loadTexture();
            TexturePackTextureRegionLibrary diamondsLetteredTexturePackLibrary =
                    diamondsLetteredTexturePack.getTexturePackTextureRegionLibrary();

            cards.put(CardType.DIAMONDS_ACE, diamondsLetteredTexturePackLibrary.get(CardType.DIAMONDS_ACE.getId_fullSize()));
            cards.put(CardType.DIAMONDS_JACK, diamondsLetteredTexturePackLibrary.get(CardType.DIAMONDS_JACK.getId_fullSize()));
            cards.put(CardType.DIAMONDS_QUEEN, diamondsLetteredTexturePackLibrary.get(CardType.DIAMONDS_QUEEN.getId_fullSize()));
            cards.put(CardType.DIAMONDS_KING, diamondsLetteredTexturePackLibrary.get(CardType.DIAMONDS_KING.getId_fullSize()));

            final TexturePack heartsNumberedTexturePack = texturePackLoader.loadFromAsset(
                    baseGameActivity.getAssets(), CardFile.FILE_FULL_HEARTS_NUMBERED.getFile());
            heartsNumberedTexturePack.loadTexture();
            TexturePackTextureRegionLibrary heartsNumberedTexturePackLibrary =
                    heartsNumberedTexturePack.getTexturePackTextureRegionLibrary();

            cards.put(CardType.HEARTS_TWO, heartsNumberedTexturePackLibrary.get(CardType.HEARTS_TWO.getId_fullSize()));
            cards.put(CardType.HEARTS_THREE, heartsNumberedTexturePackLibrary.get(CardType.HEARTS_THREE.getId_fullSize()));
            cards.put(CardType.HEARTS_FOUR, heartsNumberedTexturePackLibrary.get(CardType.HEARTS_FOUR.getId_fullSize()));
            cards.put(CardType.HEARTS_FIVE, heartsNumberedTexturePackLibrary.get(CardType.HEARTS_FIVE.getId_fullSize()));
            cards.put(CardType.HEARTS_SIX, heartsNumberedTexturePackLibrary.get(CardType.HEARTS_SIX.getId_fullSize()));
            cards.put(CardType.HEARTS_SEVEN, heartsNumberedTexturePackLibrary.get(CardType.HEARTS_SEVEN.getId_fullSize()));
            cards.put(CardType.HEARTS_EIGHT, heartsNumberedTexturePackLibrary.get(CardType.HEARTS_EIGHT.getId_fullSize()));
            cards.put(CardType.HEARTS_NINE, heartsNumberedTexturePackLibrary.get(CardType.HEARTS_NINE.getId_fullSize()));
            cards.put(CardType.HEARTS_TEN, heartsNumberedTexturePackLibrary.get(CardType.HEARTS_TEN.getId_fullSize()));

            final TexturePack heartsLetteredTexturePack = texturePackLoader.loadFromAsset(
                    baseGameActivity.getAssets(), CardFile.FILE_FULL_HEARTS_LETTERED.getFile());
            heartsLetteredTexturePack.loadTexture();
            TexturePackTextureRegionLibrary heartsLetteredTexturePackLibrary =
                    heartsLetteredTexturePack.getTexturePackTextureRegionLibrary();

            cards.put(CardType.HEARTS_ACE, heartsLetteredTexturePackLibrary.get(CardType.HEARTS_ACE.getId_fullSize()));
            cards.put(CardType.HEARTS_JACK, heartsLetteredTexturePackLibrary.get(CardType.HEARTS_JACK.getId_fullSize()));
            cards.put(CardType.HEARTS_QUEEN, heartsLetteredTexturePackLibrary.get(CardType.HEARTS_QUEEN.getId_fullSize()));
            cards.put(CardType.HEARTS_KING, heartsLetteredTexturePackLibrary.get(CardType.HEARTS_KING.getId_fullSize()));

            final TexturePack spadesNumberedTexturePack = texturePackLoader.loadFromAsset(
                    baseGameActivity.getAssets(), CardFile.FILE_FULL_SPADES_NUMBERED.getFile());
            spadesNumberedTexturePack.loadTexture();
            TexturePackTextureRegionLibrary spadesNumberedTexturePackLibrary =
                    spadesNumberedTexturePack.getTexturePackTextureRegionLibrary();

            cards.put(CardType.SPADES_TWO, spadesNumberedTexturePackLibrary.get(CardType.SPADES_TWO.getId_fullSize()));
            cards.put(CardType.SPADES_THREE, spadesNumberedTexturePackLibrary.get(CardType.SPADES_THREE.getId_fullSize()));
            cards.put(CardType.SPADES_FOUR, spadesNumberedTexturePackLibrary.get(CardType.SPADES_FOUR.getId_fullSize()));
            cards.put(CardType.SPADES_FIVE, spadesNumberedTexturePackLibrary.get(CardType.SPADES_FIVE.getId_fullSize()));
            cards.put(CardType.SPADES_SIX, spadesNumberedTexturePackLibrary.get(CardType.SPADES_SIX.getId_fullSize()));
            cards.put(CardType.SPADES_SEVEN, spadesNumberedTexturePackLibrary.get(CardType.SPADES_SEVEN.getId_fullSize()));
            cards.put(CardType.SPADES_EIGHT, spadesNumberedTexturePackLibrary.get(CardType.SPADES_EIGHT.getId_fullSize()));
            cards.put(CardType.SPADES_NINE, spadesNumberedTexturePackLibrary.get(CardType.SPADES_NINE.getId_fullSize()));
            cards.put(CardType.SPADES_TEN, spadesNumberedTexturePackLibrary.get(CardType.SPADES_TEN.getId_fullSize()));

            final TexturePack spadesLetteredTexturePack = texturePackLoader.loadFromAsset(
                    baseGameActivity.getAssets(), CardFile.FILE_FULL_SPADES_LETTERED.getFile());
            spadesLetteredTexturePack.loadTexture();
            TexturePackTextureRegionLibrary spadesLetteredTexturePackLibrary =
                    spadesLetteredTexturePack.getTexturePackTextureRegionLibrary();

            cards.put(CardType.SPADES_ACE, spadesLetteredTexturePackLibrary.get(CardType.SPADES_ACE.getId_fullSize()));
            cards.put(CardType.SPADES_JACK, spadesLetteredTexturePackLibrary.get(CardType.SPADES_JACK.getId_fullSize()));
            cards.put(CardType.SPADES_QUEEN, spadesLetteredTexturePackLibrary.get(CardType.SPADES_QUEEN.getId_fullSize()));
            cards.put(CardType.SPADES_KING, spadesLetteredTexturePackLibrary.get(CardType.SPADES_KING.getId_fullSize()));

            final TexturePack backsTexturePack = texturePackLoader.loadFromAsset(
                    baseGameActivity.getAssets(), CardFile.FILE_FULL_BACKS.getFile());
            backsTexturePack.loadTexture();
            TexturePackTextureRegionLibrary backsTexturePackLibrary =
                    backsTexturePack.getTexturePackTextureRegionLibrary();

            cards.put(CardType.BACK_BLUE, backsTexturePackLibrary.get(CardType.BACK_BLUE.getId_fullSize()));
            cards.put(CardType.BACK_RED, backsTexturePackLibrary.get(CardType.BACK_RED.getId_fullSize()));
        } catch (final TexturePackParseException e) {
            Debug.e(e);
        }

        return cards;
    }

    public static ITextureRegion[] loadSignInButton(final BaseGameActivity baseGameActivity) {
        BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/buttons/");
        // Width and height have to be powers of 2 or this won't work.
        BuildableBitmapTextureAtlas buttonTextureAtlas = new BuildableBitmapTextureAtlas(
                baseGameActivity.getTextureManager(), 1024, 1024, TextureOptions.NEAREST);

        ITextureRegion signInUpButtonRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
                buttonTextureAtlas, baseGameActivity, "sign-in-up.png");
        ITextureRegion signInDownButtonRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
                buttonTextureAtlas, baseGameActivity, "sign-in-down.png");
        ITextureRegion signInDisabledButtonRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
                buttonTextureAtlas, baseGameActivity, "sign-in-disabled.png");

        try {
            buttonTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 0, 1));
            buttonTextureAtlas.load();

            ITextureRegion[] textureRegions = new ITextureRegion[3];
            textureRegions[BUTTON_STATE_UP] = signInUpButtonRegion;
            textureRegions[BUTTON_STATE_DOWN] = signInDownButtonRegion;
            textureRegions[BUTTON_STATE_DISABLED] = signInDisabledButtonRegion;
            return textureRegions;
        } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Debug.e(e);
        }
        return null;
    }

    public static ITextureRegion[] loadSignOutButton(final BaseGameActivity baseGameActivity) {
        BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/buttons/");
        // Width and height have to be powers of 2 or this won't work.
        BuildableBitmapTextureAtlas buttonTextureAtlas = new BuildableBitmapTextureAtlas(
                baseGameActivity.getTextureManager(), 1024, 1024, TextureOptions.NEAREST);

        ITextureRegion signOutUpButtonRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
                buttonTextureAtlas, baseGameActivity, "sign-out-up.png");
        ITextureRegion signOutDownButtonRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
                buttonTextureAtlas, baseGameActivity, "sign-out-down.png");
        ITextureRegion signOutDisabledButtonRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
                buttonTextureAtlas, baseGameActivity, "sign-out-disabled.png");

        try {
            buttonTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 0, 1));
            buttonTextureAtlas.load();

            ITextureRegion[] textureRegions = new ITextureRegion[3];
            textureRegions[BUTTON_STATE_UP] = signOutUpButtonRegion;
            textureRegions[BUTTON_STATE_DOWN] = signOutDownButtonRegion;
            textureRegions[BUTTON_STATE_DISABLED] = signOutDisabledButtonRegion;
            return textureRegions;
        } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Debug.e(e);
        }
        return null;
    }

    public static ITextureRegion[] loadRegisterButton(final BaseGameActivity baseGameActivity) {
        BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/buttons/");
        // Width and height have to be powers of 2 or this won't work.
        BuildableBitmapTextureAtlas buttonTextureAtlas = new BuildableBitmapTextureAtlas(
                baseGameActivity.getTextureManager(), 1024, 1024, TextureOptions.NEAREST);

        ITextureRegion registerUpButtonRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
                buttonTextureAtlas, baseGameActivity, "register-up.png");
        ITextureRegion registerDownButtonRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
                buttonTextureAtlas, baseGameActivity, "register-down.png");
        ITextureRegion registerDisabledButtonRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
                buttonTextureAtlas, baseGameActivity, "register-disabled.png");

        try {
            buttonTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 0, 1));
            buttonTextureAtlas.load();

            ITextureRegion[] textureRegions = new ITextureRegion[3];
            textureRegions[BUTTON_STATE_UP] = registerUpButtonRegion;
            textureRegions[BUTTON_STATE_DOWN] = registerDownButtonRegion;
            textureRegions[BUTTON_STATE_DISABLED] = registerDisabledButtonRegion;
            return textureRegions;
        } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Debug.e(e);
        }
        return null;
    }

    public static ITextureRegion[] loadDemosButton(final BaseGameActivity baseGameActivity) {
        BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/buttons/");
        // Width and height have to be powers of 2 or this won't work.
        BuildableBitmapTextureAtlas buttonTextureAtlas = new BuildableBitmapTextureAtlas(
                baseGameActivity.getTextureManager(), 1024, 1024, TextureOptions.NEAREST);

        ITextureRegion demosUpButtonRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
                buttonTextureAtlas, baseGameActivity, "demos-up.png");
        ITextureRegion demosDownButtonRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
                buttonTextureAtlas, baseGameActivity, "demos-down.png");
        ITextureRegion demosDisabledButtonRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
                buttonTextureAtlas, baseGameActivity, "demos-disabled.png");

        try {
            buttonTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 0, 1));
            buttonTextureAtlas.load();

            ITextureRegion[] textureRegions = new ITextureRegion[3];
            textureRegions[BUTTON_STATE_UP] = demosUpButtonRegion;
            textureRegions[BUTTON_STATE_DOWN] = demosDownButtonRegion;
            textureRegions[BUTTON_STATE_DISABLED] = demosDisabledButtonRegion;
            return textureRegions;
        } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Debug.e(e);
        }
        return null;
    }

    public static ITextureRegion[] loadFriendsButton(final BaseGameActivity baseGameActivity) {
        BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/buttons/");
        // Width and height have to be powers of 2 or this won't work.
        BuildableBitmapTextureAtlas buttonTextureAtlas = new BuildableBitmapTextureAtlas(
                baseGameActivity.getTextureManager(), 1024, 1024, TextureOptions.NEAREST);

        ITextureRegion friendsUpButtonRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
                buttonTextureAtlas, baseGameActivity, "friends-up.png");
        ITextureRegion friendsDownButtonRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
                buttonTextureAtlas, baseGameActivity, "friends-down.png");
        ITextureRegion friendsDisabledButtonRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
                buttonTextureAtlas, baseGameActivity, "friends-disabled.png");

        try {
            buttonTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 0, 1));
            buttonTextureAtlas.load();

            ITextureRegion[] textureRegions = new ITextureRegion[3];
            textureRegions[BUTTON_STATE_UP] = friendsUpButtonRegion;
            textureRegions[BUTTON_STATE_DOWN] = friendsDownButtonRegion;
            textureRegions[BUTTON_STATE_DISABLED] = friendsDisabledButtonRegion;
            return textureRegions;
        } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Debug.e(e);
        }
        return null;
    }

    public static ITextureRegion[] loadGamesButton(final BaseGameActivity baseGameActivity) {
        BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/buttons/");
        // Width and height have to be powers of 2 or this won't work.
        BuildableBitmapTextureAtlas buttonTextureAtlas = new BuildableBitmapTextureAtlas(
                baseGameActivity.getTextureManager(), 1024, 1024, TextureOptions.NEAREST);

        ITextureRegion gamesUpButtonRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
                buttonTextureAtlas, baseGameActivity, "games-up.png");
        ITextureRegion gamesDownButtonRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
                buttonTextureAtlas, baseGameActivity, "games-down.png");
        ITextureRegion gamesDisabledButtonRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
                buttonTextureAtlas, baseGameActivity, "games-disabled.png");

        try {
            buttonTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 0, 1));
            buttonTextureAtlas.load();

            ITextureRegion[] textureRegions = new ITextureRegion[3];
            textureRegions[BUTTON_STATE_UP] = gamesUpButtonRegion;
            textureRegions[BUTTON_STATE_DOWN] = gamesDownButtonRegion;
            textureRegions[BUTTON_STATE_DISABLED] = gamesDisabledButtonRegion;
            return textureRegions;
        } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Debug.e(e);
        }
        return null;
    }
}
