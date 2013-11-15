/**
 * Patrick John Haskins
 * Zachary Evans
 * CS7020 - Term Project
 */
package android.otasyn.cardgames.utility;

import android.otasyn.cardgames.utility.enumeration.Background;
import android.otasyn.cardgames.utility.enumeration.CardId;
import android.otasyn.cardgames.utility.enumeration.CardFile;
import android.otasyn.cardgames.utility.enumeration.CardLocation;
import org.andengine.extension.texturepacker.opengl.texture.util.texturepacker.TexturePack;
import org.andengine.extension.texturepacker.opengl.texture.util.texturepacker.TexturePackLoader;
import org.andengine.extension.texturepacker.opengl.texture.util.texturepacker.TexturePackTextureRegionLibrary;
import org.andengine.extension.texturepacker.opengl.texture.util.texturepacker.exception.TexturePackParseException;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TextureRegionFactory;
import org.andengine.ui.activity.BaseGameActivity;
import org.andengine.util.debug.Debug;

import java.util.HashMap;
import java.util.Map;

public class TextureUtility {

    public static ITextureRegion loadBackground(final BaseGameActivity baseGameActivity,
                                                final int width, final int height) {
        return loadBackground(baseGameActivity, width, height, Background.BG_BLUE_0B4E66);
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

    public static Map<CardId,ITextureRegion> loadCards46x64(final BaseGameActivity baseGameActivity) {
        Map<CardId,ITextureRegion> cards = new HashMap<CardId, ITextureRegion>(CardId.values().length);
        try {
            TexturePackLoader texturePackLoader = new TexturePackLoader(
                    baseGameActivity.getTextureManager(), CardLocation.LOCATION_46x64.getLocation());

            final TexturePack texturePack = texturePackLoader.loadFromAsset(
                    baseGameActivity.getAssets(), CardFile.FILE_46x64.getFile());
            texturePack.loadTexture();
            TexturePackTextureRegionLibrary texturePackLibrary = texturePack.getTexturePackTextureRegionLibrary();

            cards.put(CardId.CLUBS_ACE, texturePackLibrary.get(CardId.CLUBS_ACE.getId_46x64()));
            cards.put(CardId.CLUBS_TWO, texturePackLibrary.get(CardId.CLUBS_TWO.getId_46x64()));
            cards.put(CardId.CLUBS_THREE, texturePackLibrary.get(CardId.CLUBS_THREE.getId_46x64()));
            cards.put(CardId.CLUBS_FOUR, texturePackLibrary.get(CardId.CLUBS_FOUR.getId_46x64()));
            cards.put(CardId.CLUBS_FIVE, texturePackLibrary.get(CardId.CLUBS_FIVE.getId_46x64()));
            cards.put(CardId.CLUBS_SIX, texturePackLibrary.get(CardId.CLUBS_SIX.getId_46x64()));
            cards.put(CardId.CLUBS_SEVEN, texturePackLibrary.get(CardId.CLUBS_SEVEN.getId_46x64()));
            cards.put(CardId.CLUBS_EIGHT, texturePackLibrary.get(CardId.CLUBS_EIGHT.getId_46x64()));
            cards.put(CardId.CLUBS_NINE, texturePackLibrary.get(CardId.CLUBS_NINE.getId_46x64()));
            cards.put(CardId.CLUBS_TEN, texturePackLibrary.get(CardId.CLUBS_TEN.getId_46x64()));
            cards.put(CardId.CLUBS_JACK, texturePackLibrary.get(CardId.CLUBS_JACK.getId_46x64()));
            cards.put(CardId.CLUBS_QUEEN, texturePackLibrary.get(CardId.CLUBS_QUEEN.getId_46x64()));
            cards.put(CardId.CLUBS_KING, texturePackLibrary.get(CardId.CLUBS_KING.getId_46x64()));

            cards.put(CardId.DIAMONDS_ACE, texturePackLibrary.get(CardId.DIAMONDS_ACE.getId_46x64()));
            cards.put(CardId.DIAMONDS_TWO, texturePackLibrary.get(CardId.DIAMONDS_TWO.getId_46x64()));
            cards.put(CardId.DIAMONDS_THREE, texturePackLibrary.get(CardId.DIAMONDS_THREE.getId_46x64()));
            cards.put(CardId.DIAMONDS_FOUR, texturePackLibrary.get(CardId.DIAMONDS_FOUR.getId_46x64()));
            cards.put(CardId.DIAMONDS_FIVE, texturePackLibrary.get(CardId.DIAMONDS_FIVE.getId_46x64()));
            cards.put(CardId.DIAMONDS_SIX, texturePackLibrary.get(CardId.DIAMONDS_SIX.getId_46x64()));
            cards.put(CardId.DIAMONDS_SEVEN, texturePackLibrary.get(CardId.DIAMONDS_SEVEN.getId_46x64()));
            cards.put(CardId.DIAMONDS_EIGHT, texturePackLibrary.get(CardId.DIAMONDS_EIGHT.getId_46x64()));
            cards.put(CardId.DIAMONDS_NINE, texturePackLibrary.get(CardId.DIAMONDS_NINE.getId_46x64()));
            cards.put(CardId.DIAMONDS_TEN, texturePackLibrary.get(CardId.DIAMONDS_TEN.getId_46x64()));
            cards.put(CardId.DIAMONDS_JACK, texturePackLibrary.get(CardId.DIAMONDS_JACK.getId_46x64()));
            cards.put(CardId.DIAMONDS_QUEEN, texturePackLibrary.get(CardId.DIAMONDS_QUEEN.getId_46x64()));
            cards.put(CardId.DIAMONDS_KING, texturePackLibrary.get(CardId.DIAMONDS_KING.getId_46x64()));

            cards.put(CardId.HEARTS_ACE, texturePackLibrary.get(CardId.HEARTS_ACE.getId_46x64()));
            cards.put(CardId.HEARTS_TWO, texturePackLibrary.get(CardId.HEARTS_TWO.getId_46x64()));
            cards.put(CardId.HEARTS_THREE, texturePackLibrary.get(CardId.HEARTS_THREE.getId_46x64()));
            cards.put(CardId.HEARTS_FOUR, texturePackLibrary.get(CardId.HEARTS_FOUR.getId_46x64()));
            cards.put(CardId.HEARTS_FIVE, texturePackLibrary.get(CardId.HEARTS_FIVE.getId_46x64()));
            cards.put(CardId.HEARTS_SIX, texturePackLibrary.get(CardId.HEARTS_SIX.getId_46x64()));
            cards.put(CardId.HEARTS_SEVEN, texturePackLibrary.get(CardId.HEARTS_SEVEN.getId_46x64()));
            cards.put(CardId.HEARTS_EIGHT, texturePackLibrary.get(CardId.HEARTS_EIGHT.getId_46x64()));
            cards.put(CardId.HEARTS_NINE, texturePackLibrary.get(CardId.HEARTS_NINE.getId_46x64()));
            cards.put(CardId.HEARTS_TEN, texturePackLibrary.get(CardId.HEARTS_TEN.getId_46x64()));
            cards.put(CardId.HEARTS_JACK, texturePackLibrary.get(CardId.HEARTS_JACK.getId_46x64()));
            cards.put(CardId.HEARTS_QUEEN, texturePackLibrary.get(CardId.HEARTS_QUEEN.getId_46x64()));
            cards.put(CardId.HEARTS_KING, texturePackLibrary.get(CardId.HEARTS_KING.getId_46x64()));

            cards.put(CardId.SPADES_ACE, texturePackLibrary.get(CardId.SPADES_ACE.getId_46x64()));
            cards.put(CardId.SPADES_TWO, texturePackLibrary.get(CardId.SPADES_TWO.getId_46x64()));
            cards.put(CardId.SPADES_THREE, texturePackLibrary.get(CardId.SPADES_THREE.getId_46x64()));
            cards.put(CardId.SPADES_FOUR, texturePackLibrary.get(CardId.SPADES_FOUR.getId_46x64()));
            cards.put(CardId.SPADES_FIVE, texturePackLibrary.get(CardId.SPADES_FIVE.getId_46x64()));
            cards.put(CardId.SPADES_SIX, texturePackLibrary.get(CardId.SPADES_SIX.getId_46x64()));
            cards.put(CardId.SPADES_SEVEN, texturePackLibrary.get(CardId.SPADES_SEVEN.getId_46x64()));
            cards.put(CardId.SPADES_EIGHT, texturePackLibrary.get(CardId.SPADES_EIGHT.getId_46x64()));
            cards.put(CardId.SPADES_NINE, texturePackLibrary.get(CardId.SPADES_NINE.getId_46x64()));
            cards.put(CardId.SPADES_TEN, texturePackLibrary.get(CardId.SPADES_TEN.getId_46x64()));
            cards.put(CardId.SPADES_JACK, texturePackLibrary.get(CardId.SPADES_JACK.getId_46x64()));
            cards.put(CardId.SPADES_QUEEN, texturePackLibrary.get(CardId.SPADES_QUEEN.getId_46x64()));
            cards.put(CardId.SPADES_KING, texturePackLibrary.get(CardId.SPADES_KING.getId_46x64()));

            cards.put(CardId.BACK_BLUE, texturePackLibrary.get(CardId.BACK_BLUE.getId_46x64()));
            cards.put(CardId.BACK_RED, texturePackLibrary.get(CardId.BACK_RED.getId_46x64()));
        } catch (final TexturePackParseException e) {
            Debug.e(e);
        }

        return cards;
    }

    public static Map<CardId,ITextureRegion> loadCards92x128(final BaseGameActivity baseGameActivity) {
        Map<CardId,ITextureRegion> cards = new HashMap<CardId, ITextureRegion>(CardId.values().length);
        try {
            TexturePackLoader texturePackLoader = new TexturePackLoader(
                    baseGameActivity.getTextureManager(), CardLocation.LOCATION_92x128.getLocation());

            final TexturePack texturePack = texturePackLoader.loadFromAsset(
                    baseGameActivity.getAssets(), CardFile.FILE_92x128.getFile());
            texturePack.loadTexture();
            TexturePackTextureRegionLibrary texturePackLibrary = texturePack.getTexturePackTextureRegionLibrary();

            cards.put(CardId.CLUBS_ACE, texturePackLibrary.get(CardId.CLUBS_ACE.getId_92x128()));
            cards.put(CardId.CLUBS_TWO, texturePackLibrary.get(CardId.CLUBS_TWO.getId_92x128()));
            cards.put(CardId.CLUBS_THREE, texturePackLibrary.get(CardId.CLUBS_THREE.getId_92x128()));
            cards.put(CardId.CLUBS_FOUR, texturePackLibrary.get(CardId.CLUBS_FOUR.getId_92x128()));
            cards.put(CardId.CLUBS_FIVE, texturePackLibrary.get(CardId.CLUBS_FIVE.getId_92x128()));
            cards.put(CardId.CLUBS_SIX, texturePackLibrary.get(CardId.CLUBS_SIX.getId_92x128()));
            cards.put(CardId.CLUBS_SEVEN, texturePackLibrary.get(CardId.CLUBS_SEVEN.getId_92x128()));
            cards.put(CardId.CLUBS_EIGHT, texturePackLibrary.get(CardId.CLUBS_EIGHT.getId_92x128()));
            cards.put(CardId.CLUBS_NINE, texturePackLibrary.get(CardId.CLUBS_NINE.getId_92x128()));
            cards.put(CardId.CLUBS_TEN, texturePackLibrary.get(CardId.CLUBS_TEN.getId_92x128()));
            cards.put(CardId.CLUBS_JACK, texturePackLibrary.get(CardId.CLUBS_JACK.getId_92x128()));
            cards.put(CardId.CLUBS_QUEEN, texturePackLibrary.get(CardId.CLUBS_QUEEN.getId_92x128()));
            cards.put(CardId.CLUBS_KING, texturePackLibrary.get(CardId.CLUBS_KING.getId_92x128()));

            cards.put(CardId.DIAMONDS_ACE, texturePackLibrary.get(CardId.DIAMONDS_ACE.getId_92x128()));
            cards.put(CardId.DIAMONDS_TWO, texturePackLibrary.get(CardId.DIAMONDS_TWO.getId_92x128()));
            cards.put(CardId.DIAMONDS_THREE, texturePackLibrary.get(CardId.DIAMONDS_THREE.getId_92x128()));
            cards.put(CardId.DIAMONDS_FOUR, texturePackLibrary.get(CardId.DIAMONDS_FOUR.getId_92x128()));
            cards.put(CardId.DIAMONDS_FIVE, texturePackLibrary.get(CardId.DIAMONDS_FIVE.getId_92x128()));
            cards.put(CardId.DIAMONDS_SIX, texturePackLibrary.get(CardId.DIAMONDS_SIX.getId_92x128()));
            cards.put(CardId.DIAMONDS_SEVEN, texturePackLibrary.get(CardId.DIAMONDS_SEVEN.getId_92x128()));
            cards.put(CardId.DIAMONDS_EIGHT, texturePackLibrary.get(CardId.DIAMONDS_EIGHT.getId_92x128()));
            cards.put(CardId.DIAMONDS_NINE, texturePackLibrary.get(CardId.DIAMONDS_NINE.getId_92x128()));
            cards.put(CardId.DIAMONDS_TEN, texturePackLibrary.get(CardId.DIAMONDS_TEN.getId_92x128()));
            cards.put(CardId.DIAMONDS_JACK, texturePackLibrary.get(CardId.DIAMONDS_JACK.getId_92x128()));
            cards.put(CardId.DIAMONDS_QUEEN, texturePackLibrary.get(CardId.DIAMONDS_QUEEN.getId_92x128()));
            cards.put(CardId.DIAMONDS_KING, texturePackLibrary.get(CardId.DIAMONDS_KING.getId_92x128()));

            cards.put(CardId.HEARTS_ACE, texturePackLibrary.get(CardId.HEARTS_ACE.getId_92x128()));
            cards.put(CardId.HEARTS_TWO, texturePackLibrary.get(CardId.HEARTS_TWO.getId_92x128()));
            cards.put(CardId.HEARTS_THREE, texturePackLibrary.get(CardId.HEARTS_THREE.getId_92x128()));
            cards.put(CardId.HEARTS_FOUR, texturePackLibrary.get(CardId.HEARTS_FOUR.getId_92x128()));
            cards.put(CardId.HEARTS_FIVE, texturePackLibrary.get(CardId.HEARTS_FIVE.getId_92x128()));
            cards.put(CardId.HEARTS_SIX, texturePackLibrary.get(CardId.HEARTS_SIX.getId_92x128()));
            cards.put(CardId.HEARTS_SEVEN, texturePackLibrary.get(CardId.HEARTS_SEVEN.getId_92x128()));
            cards.put(CardId.HEARTS_EIGHT, texturePackLibrary.get(CardId.HEARTS_EIGHT.getId_92x128()));
            cards.put(CardId.HEARTS_NINE, texturePackLibrary.get(CardId.HEARTS_NINE.getId_92x128()));
            cards.put(CardId.HEARTS_TEN, texturePackLibrary.get(CardId.HEARTS_TEN.getId_92x128()));
            cards.put(CardId.HEARTS_JACK, texturePackLibrary.get(CardId.HEARTS_JACK.getId_92x128()));
            cards.put(CardId.HEARTS_QUEEN, texturePackLibrary.get(CardId.HEARTS_QUEEN.getId_92x128()));
            cards.put(CardId.HEARTS_KING, texturePackLibrary.get(CardId.HEARTS_KING.getId_92x128()));

            cards.put(CardId.SPADES_ACE, texturePackLibrary.get(CardId.SPADES_ACE.getId_92x128()));
            cards.put(CardId.SPADES_TWO, texturePackLibrary.get(CardId.SPADES_TWO.getId_92x128()));
            cards.put(CardId.SPADES_THREE, texturePackLibrary.get(CardId.SPADES_THREE.getId_92x128()));
            cards.put(CardId.SPADES_FOUR, texturePackLibrary.get(CardId.SPADES_FOUR.getId_92x128()));
            cards.put(CardId.SPADES_FIVE, texturePackLibrary.get(CardId.SPADES_FIVE.getId_92x128()));
            cards.put(CardId.SPADES_SIX, texturePackLibrary.get(CardId.SPADES_SIX.getId_92x128()));
            cards.put(CardId.SPADES_SEVEN, texturePackLibrary.get(CardId.SPADES_SEVEN.getId_92x128()));
            cards.put(CardId.SPADES_EIGHT, texturePackLibrary.get(CardId.SPADES_EIGHT.getId_92x128()));
            cards.put(CardId.SPADES_NINE, texturePackLibrary.get(CardId.SPADES_NINE.getId_92x128()));
            cards.put(CardId.SPADES_TEN, texturePackLibrary.get(CardId.SPADES_TEN.getId_92x128()));
            cards.put(CardId.SPADES_JACK, texturePackLibrary.get(CardId.SPADES_JACK.getId_92x128()));
            cards.put(CardId.SPADES_QUEEN, texturePackLibrary.get(CardId.SPADES_QUEEN.getId_92x128()));
            cards.put(CardId.SPADES_KING, texturePackLibrary.get(CardId.SPADES_KING.getId_92x128()));

            cards.put(CardId.BACK_BLUE, texturePackLibrary.get(CardId.BACK_BLUE.getId_92x128()));
            cards.put(CardId.BACK_RED, texturePackLibrary.get(CardId.BACK_RED.getId_92x128()));
        } catch (final TexturePackParseException e) {
            Debug.e(e);
        }

        return cards;
    }

    public static Map<CardId,ITextureRegion> loadCards184x256(final BaseGameActivity baseGameActivity) {
        Map<CardId,ITextureRegion> cards = new HashMap<CardId, ITextureRegion>(CardId.values().length);
        try {
            TexturePackLoader texturePackLoader = new TexturePackLoader(baseGameActivity.getTextureManager(),
                    CardLocation.LOCATION_184x256.getLocation());
            final TexturePack clubsTexturePack = texturePackLoader.loadFromAsset(
                    baseGameActivity.getAssets(), CardFile.FILE_184x256_CLUBS.getFile());
            clubsTexturePack.loadTexture();
            TexturePackTextureRegionLibrary clubsTexturePackLibrary =
                    clubsTexturePack.getTexturePackTextureRegionLibrary();

            cards.put(CardId.CLUBS_ACE, clubsTexturePackLibrary.get(CardId.CLUBS_ACE.getId_184x256()));
            cards.put(CardId.CLUBS_TWO, clubsTexturePackLibrary.get(CardId.CLUBS_TWO.getId_184x256()));
            cards.put(CardId.CLUBS_THREE, clubsTexturePackLibrary.get(CardId.CLUBS_THREE.getId_184x256()));
            cards.put(CardId.CLUBS_FOUR, clubsTexturePackLibrary.get(CardId.CLUBS_FOUR.getId_184x256()));
            cards.put(CardId.CLUBS_FIVE, clubsTexturePackLibrary.get(CardId.CLUBS_FIVE.getId_184x256()));
            cards.put(CardId.CLUBS_SIX, clubsTexturePackLibrary.get(CardId.CLUBS_SIX.getId_184x256()));
            cards.put(CardId.CLUBS_SEVEN, clubsTexturePackLibrary.get(CardId.CLUBS_SEVEN.getId_184x256()));
            cards.put(CardId.CLUBS_EIGHT, clubsTexturePackLibrary.get(CardId.CLUBS_EIGHT.getId_184x256()));
            cards.put(CardId.CLUBS_NINE, clubsTexturePackLibrary.get(CardId.CLUBS_NINE.getId_184x256()));
            cards.put(CardId.CLUBS_TEN, clubsTexturePackLibrary.get(CardId.CLUBS_TEN.getId_184x256()));
            cards.put(CardId.CLUBS_JACK, clubsTexturePackLibrary.get(CardId.CLUBS_JACK.getId_184x256()));
            cards.put(CardId.CLUBS_QUEEN, clubsTexturePackLibrary.get(CardId.CLUBS_QUEEN.getId_184x256()));
            cards.put(CardId.CLUBS_KING, clubsTexturePackLibrary.get(CardId.CLUBS_KING.getId_184x256()));

            final TexturePack diamondsTexturePack = texturePackLoader.loadFromAsset(
                    baseGameActivity.getAssets(),  CardFile.FILE_184x256_DIAMONDS.getFile());
            diamondsTexturePack.loadTexture();
            TexturePackTextureRegionLibrary diamondsTexturePackLibrary =
                    diamondsTexturePack.getTexturePackTextureRegionLibrary();

            cards.put(CardId.DIAMONDS_ACE, diamondsTexturePackLibrary.get(CardId.DIAMONDS_ACE.getId_184x256()));
            cards.put(CardId.DIAMONDS_TWO, diamondsTexturePackLibrary.get(CardId.DIAMONDS_TWO.getId_184x256()));
            cards.put(CardId.DIAMONDS_THREE, diamondsTexturePackLibrary.get(CardId.DIAMONDS_THREE.getId_184x256()));
            cards.put(CardId.DIAMONDS_FOUR, diamondsTexturePackLibrary.get(CardId.DIAMONDS_FOUR.getId_184x256()));
            cards.put(CardId.DIAMONDS_FIVE, diamondsTexturePackLibrary.get(CardId.DIAMONDS_FIVE.getId_184x256()));
            cards.put(CardId.DIAMONDS_SIX, diamondsTexturePackLibrary.get(CardId.DIAMONDS_SIX.getId_184x256()));
            cards.put(CardId.DIAMONDS_SEVEN, diamondsTexturePackLibrary.get(CardId.DIAMONDS_SEVEN.getId_184x256()));
            cards.put(CardId.DIAMONDS_EIGHT, diamondsTexturePackLibrary.get(CardId.DIAMONDS_EIGHT.getId_184x256()));
            cards.put(CardId.DIAMONDS_NINE, diamondsTexturePackLibrary.get(CardId.DIAMONDS_NINE.getId_184x256()));
            cards.put(CardId.DIAMONDS_TEN, diamondsTexturePackLibrary.get(CardId.DIAMONDS_TEN.getId_184x256()));
            cards.put(CardId.DIAMONDS_JACK, diamondsTexturePackLibrary.get(CardId.DIAMONDS_JACK.getId_184x256()));
            cards.put(CardId.DIAMONDS_QUEEN, diamondsTexturePackLibrary.get(CardId.DIAMONDS_QUEEN.getId_184x256()));
            cards.put(CardId.DIAMONDS_KING, diamondsTexturePackLibrary.get(CardId.DIAMONDS_KING.getId_184x256()));

            final TexturePack heartsTexturePack = texturePackLoader.loadFromAsset(
                    baseGameActivity.getAssets(),  CardFile.FILE_184x256_HEARTS.getFile());
            heartsTexturePack.loadTexture();
            TexturePackTextureRegionLibrary heartsTexturePackLibrary =
                    heartsTexturePack.getTexturePackTextureRegionLibrary();

            cards.put(CardId.HEARTS_ACE, heartsTexturePackLibrary.get(CardId.HEARTS_ACE.getId_184x256()));
            cards.put(CardId.HEARTS_TWO, heartsTexturePackLibrary.get(CardId.HEARTS_TWO.getId_184x256()));
            cards.put(CardId.HEARTS_THREE, heartsTexturePackLibrary.get(CardId.HEARTS_THREE.getId_184x256()));
            cards.put(CardId.HEARTS_FOUR, heartsTexturePackLibrary.get(CardId.HEARTS_FOUR.getId_184x256()));
            cards.put(CardId.HEARTS_FIVE, heartsTexturePackLibrary.get(CardId.HEARTS_FIVE.getId_184x256()));
            cards.put(CardId.HEARTS_SIX, heartsTexturePackLibrary.get(CardId.HEARTS_SIX.getId_184x256()));
            cards.put(CardId.HEARTS_SEVEN, heartsTexturePackLibrary.get(CardId.HEARTS_SEVEN.getId_184x256()));
            cards.put(CardId.HEARTS_EIGHT, heartsTexturePackLibrary.get(CardId.HEARTS_EIGHT.getId_184x256()));
            cards.put(CardId.HEARTS_NINE, heartsTexturePackLibrary.get(CardId.HEARTS_NINE.getId_184x256()));
            cards.put(CardId.HEARTS_TEN, heartsTexturePackLibrary.get(CardId.HEARTS_TEN.getId_184x256()));
            cards.put(CardId.HEARTS_JACK, heartsTexturePackLibrary.get(CardId.HEARTS_JACK.getId_184x256()));
            cards.put(CardId.HEARTS_QUEEN, heartsTexturePackLibrary.get(CardId.HEARTS_QUEEN.getId_184x256()));
            cards.put(CardId.HEARTS_KING, heartsTexturePackLibrary.get(CardId.HEARTS_KING.getId_184x256()));

            final TexturePack spadesTexturePack = texturePackLoader.loadFromAsset(
                    baseGameActivity.getAssets(),  CardFile.FILE_184x256_SPADES.getFile());
            spadesTexturePack.loadTexture();
            TexturePackTextureRegionLibrary spadesTexturePackLibrary =
                    spadesTexturePack.getTexturePackTextureRegionLibrary();

            cards.put(CardId.SPADES_ACE, spadesTexturePackLibrary.get(CardId.SPADES_ACE.getId_184x256()));
            cards.put(CardId.SPADES_TWO, spadesTexturePackLibrary.get(CardId.SPADES_TWO.getId_184x256()));
            cards.put(CardId.SPADES_THREE, spadesTexturePackLibrary.get(CardId.SPADES_THREE.getId_184x256()));
            cards.put(CardId.SPADES_FOUR, spadesTexturePackLibrary.get(CardId.SPADES_FOUR.getId_184x256()));
            cards.put(CardId.SPADES_FIVE, spadesTexturePackLibrary.get(CardId.SPADES_FIVE.getId_184x256()));
            cards.put(CardId.SPADES_SIX, spadesTexturePackLibrary.get(CardId.SPADES_SIX.getId_184x256()));
            cards.put(CardId.SPADES_SEVEN, spadesTexturePackLibrary.get(CardId.SPADES_SEVEN.getId_184x256()));
            cards.put(CardId.SPADES_EIGHT, spadesTexturePackLibrary.get(CardId.SPADES_EIGHT.getId_184x256()));
            cards.put(CardId.SPADES_NINE, spadesTexturePackLibrary.get(CardId.SPADES_NINE.getId_184x256()));
            cards.put(CardId.SPADES_TEN, spadesTexturePackLibrary.get(CardId.SPADES_TEN.getId_184x256()));
            cards.put(CardId.SPADES_JACK, spadesTexturePackLibrary.get(CardId.SPADES_JACK.getId_184x256()));
            cards.put(CardId.SPADES_QUEEN, spadesTexturePackLibrary.get(CardId.SPADES_QUEEN.getId_184x256()));
            cards.put(CardId.SPADES_KING, spadesTexturePackLibrary.get(CardId.SPADES_KING.getId_184x256()));

            final TexturePack backsTexturePack = texturePackLoader.loadFromAsset(
                    baseGameActivity.getAssets(),  CardFile.FILE_184x256_BACKS.getFile());
            backsTexturePack.loadTexture();
            TexturePackTextureRegionLibrary backsTexturePackLibrary =
                    backsTexturePack.getTexturePackTextureRegionLibrary();

            cards.put(CardId.BACK_BLUE, backsTexturePackLibrary.get(CardId.BACK_BLUE.getId_184x256()));
            cards.put(CardId.BACK_RED, backsTexturePackLibrary.get(CardId.BACK_RED.getId_184x256()));
        } catch (final TexturePackParseException e) {
            Debug.e(e);
        }

        return cards;
    }

    public static Map<CardId,ITextureRegion> loadCardsFullSize(final BaseGameActivity baseGameActivity) {
        Map<CardId,ITextureRegion> cards = new HashMap<CardId, ITextureRegion>(CardId.values().length);
        try {
            TexturePackLoader texturePackLoader = new TexturePackLoader(baseGameActivity.getTextureManager(),
                    CardLocation.LOCATION_FULL.getLocation());
            final TexturePack clubsNumberedTexturePack = texturePackLoader.loadFromAsset(
                    baseGameActivity.getAssets(), CardFile.FILE_FULL_CLUBS_NUMBERED.getFile());
            clubsNumberedTexturePack.loadTexture();
            TexturePackTextureRegionLibrary clubsNumberedTexturePackLibrary =
                    clubsNumberedTexturePack.getTexturePackTextureRegionLibrary();

            cards.put(CardId.CLUBS_TWO, clubsNumberedTexturePackLibrary.get(CardId.CLUBS_TWO.getId_fullSize()));
            cards.put(CardId.CLUBS_THREE, clubsNumberedTexturePackLibrary.get(CardId.CLUBS_THREE.getId_fullSize()));
            cards.put(CardId.CLUBS_FOUR, clubsNumberedTexturePackLibrary.get(CardId.CLUBS_FOUR.getId_fullSize()));
            cards.put(CardId.CLUBS_FIVE, clubsNumberedTexturePackLibrary.get(CardId.CLUBS_FIVE.getId_fullSize()));
            cards.put(CardId.CLUBS_SIX, clubsNumberedTexturePackLibrary.get(CardId.CLUBS_SIX.getId_fullSize()));
            cards.put(CardId.CLUBS_SEVEN, clubsNumberedTexturePackLibrary.get(CardId.CLUBS_SEVEN.getId_fullSize()));
            cards.put(CardId.CLUBS_EIGHT, clubsNumberedTexturePackLibrary.get(CardId.CLUBS_EIGHT.getId_fullSize()));
            cards.put(CardId.CLUBS_NINE, clubsNumberedTexturePackLibrary.get(CardId.CLUBS_NINE.getId_fullSize()));
            cards.put(CardId.CLUBS_TEN, clubsNumberedTexturePackLibrary.get(CardId.CLUBS_TEN.getId_fullSize()));

            final TexturePack clubsLetteredTexturePack = texturePackLoader.loadFromAsset(
                    baseGameActivity.getAssets(), CardFile.FILE_FULL_CLUBS_LETTERED.getFile());
            clubsLetteredTexturePack.loadTexture();
            TexturePackTextureRegionLibrary clubsLetteredTexturePackLibrary =
                    clubsLetteredTexturePack.getTexturePackTextureRegionLibrary();

            cards.put(CardId.CLUBS_ACE, clubsLetteredTexturePackLibrary.get(CardId.CLUBS_ACE.getId_fullSize()));
            cards.put(CardId.CLUBS_JACK, clubsLetteredTexturePackLibrary.get(CardId.CLUBS_JACK.getId_fullSize()));
            cards.put(CardId.CLUBS_QUEEN, clubsLetteredTexturePackLibrary.get(CardId.CLUBS_QUEEN.getId_fullSize()));
            cards.put(CardId.CLUBS_KING, clubsLetteredTexturePackLibrary.get(CardId.CLUBS_KING.getId_fullSize()));

            final TexturePack diamondsNumberedTexturePack = texturePackLoader.loadFromAsset(
                    baseGameActivity.getAssets(), CardFile.FILE_FULL_DIAMONDS_NUMBERED.getFile());
            diamondsNumberedTexturePack.loadTexture();
            TexturePackTextureRegionLibrary diamondsNumberedTexturePackLibrary =
                    diamondsNumberedTexturePack.getTexturePackTextureRegionLibrary();

            cards.put(CardId.DIAMONDS_TWO, diamondsNumberedTexturePackLibrary.get(CardId.DIAMONDS_TWO.getId_fullSize()));
            cards.put(CardId.DIAMONDS_THREE, diamondsNumberedTexturePackLibrary.get(CardId.DIAMONDS_THREE.getId_fullSize()));
            cards.put(CardId.DIAMONDS_FOUR, diamondsNumberedTexturePackLibrary.get(CardId.DIAMONDS_FOUR.getId_fullSize()));
            cards.put(CardId.DIAMONDS_FIVE, diamondsNumberedTexturePackLibrary.get(CardId.DIAMONDS_FIVE.getId_fullSize()));
            cards.put(CardId.DIAMONDS_SIX, diamondsNumberedTexturePackLibrary.get(CardId.DIAMONDS_SIX.getId_fullSize()));
            cards.put(CardId.DIAMONDS_SEVEN, diamondsNumberedTexturePackLibrary.get(CardId.DIAMONDS_SEVEN.getId_fullSize()));
            cards.put(CardId.DIAMONDS_EIGHT, diamondsNumberedTexturePackLibrary.get(CardId.DIAMONDS_EIGHT.getId_fullSize()));
            cards.put(CardId.DIAMONDS_NINE, diamondsNumberedTexturePackLibrary.get(CardId.DIAMONDS_NINE.getId_fullSize()));
            cards.put(CardId.DIAMONDS_TEN, diamondsNumberedTexturePackLibrary.get(CardId.DIAMONDS_TEN.getId_fullSize()));

            final TexturePack diamondsLetteredTexturePack = texturePackLoader.loadFromAsset(
                    baseGameActivity.getAssets(), CardFile.FILE_FULL_DIAMONDS_LETTERED.getFile());
            diamondsLetteredTexturePack.loadTexture();
            TexturePackTextureRegionLibrary diamondsLetteredTexturePackLibrary =
                    diamondsLetteredTexturePack.getTexturePackTextureRegionLibrary();

            cards.put(CardId.DIAMONDS_ACE, diamondsLetteredTexturePackLibrary.get(CardId.DIAMONDS_ACE.getId_fullSize()));
            cards.put(CardId.DIAMONDS_JACK, diamondsLetteredTexturePackLibrary.get(CardId.DIAMONDS_JACK.getId_fullSize()));
            cards.put(CardId.DIAMONDS_QUEEN, diamondsLetteredTexturePackLibrary.get(CardId.DIAMONDS_QUEEN.getId_fullSize()));
            cards.put(CardId.DIAMONDS_KING, diamondsLetteredTexturePackLibrary.get(CardId.DIAMONDS_KING.getId_fullSize()));

            final TexturePack heartsNumberedTexturePack = texturePackLoader.loadFromAsset(
                    baseGameActivity.getAssets(), CardFile.FILE_FULL_HEARTS_NUMBERED.getFile());
            heartsNumberedTexturePack.loadTexture();
            TexturePackTextureRegionLibrary heartsNumberedTexturePackLibrary =
                    heartsNumberedTexturePack.getTexturePackTextureRegionLibrary();

            cards.put(CardId.HEARTS_TWO, heartsNumberedTexturePackLibrary.get(CardId.HEARTS_TWO.getId_fullSize()));
            cards.put(CardId.HEARTS_THREE, heartsNumberedTexturePackLibrary.get(CardId.HEARTS_THREE.getId_fullSize()));
            cards.put(CardId.HEARTS_FOUR, heartsNumberedTexturePackLibrary.get(CardId.HEARTS_FOUR.getId_fullSize()));
            cards.put(CardId.HEARTS_FIVE, heartsNumberedTexturePackLibrary.get(CardId.HEARTS_FIVE.getId_fullSize()));
            cards.put(CardId.HEARTS_SIX, heartsNumberedTexturePackLibrary.get(CardId.HEARTS_SIX.getId_fullSize()));
            cards.put(CardId.HEARTS_SEVEN, heartsNumberedTexturePackLibrary.get(CardId.HEARTS_SEVEN.getId_fullSize()));
            cards.put(CardId.HEARTS_EIGHT, heartsNumberedTexturePackLibrary.get(CardId.HEARTS_EIGHT.getId_fullSize()));
            cards.put(CardId.HEARTS_NINE, heartsNumberedTexturePackLibrary.get(CardId.HEARTS_NINE.getId_fullSize()));
            cards.put(CardId.HEARTS_TEN, heartsNumberedTexturePackLibrary.get(CardId.HEARTS_TEN.getId_fullSize()));

            final TexturePack heartsLetteredTexturePack = texturePackLoader.loadFromAsset(
                    baseGameActivity.getAssets(), CardFile.FILE_FULL_HEARTS_LETTERED.getFile());
            heartsLetteredTexturePack.loadTexture();
            TexturePackTextureRegionLibrary heartsLetteredTexturePackLibrary =
                    heartsLetteredTexturePack.getTexturePackTextureRegionLibrary();

            cards.put(CardId.HEARTS_ACE, heartsLetteredTexturePackLibrary.get(CardId.HEARTS_ACE.getId_fullSize()));
            cards.put(CardId.HEARTS_JACK, heartsLetteredTexturePackLibrary.get(CardId.HEARTS_JACK.getId_fullSize()));
            cards.put(CardId.HEARTS_QUEEN, heartsLetteredTexturePackLibrary.get(CardId.HEARTS_QUEEN.getId_fullSize()));
            cards.put(CardId.HEARTS_KING, heartsLetteredTexturePackLibrary.get(CardId.HEARTS_KING.getId_fullSize()));

            final TexturePack spadesNumberedTexturePack = texturePackLoader.loadFromAsset(
                    baseGameActivity.getAssets(), CardFile.FILE_FULL_SPADES_NUMBERED.getFile());
            spadesNumberedTexturePack.loadTexture();
            TexturePackTextureRegionLibrary spadesNumberedTexturePackLibrary =
                    spadesNumberedTexturePack.getTexturePackTextureRegionLibrary();

            cards.put(CardId.SPADES_TWO, spadesNumberedTexturePackLibrary.get(CardId.SPADES_TWO.getId_fullSize()));
            cards.put(CardId.SPADES_THREE, spadesNumberedTexturePackLibrary.get(CardId.SPADES_THREE.getId_fullSize()));
            cards.put(CardId.SPADES_FOUR, spadesNumberedTexturePackLibrary.get(CardId.SPADES_FOUR.getId_fullSize()));
            cards.put(CardId.SPADES_FIVE, spadesNumberedTexturePackLibrary.get(CardId.SPADES_FIVE.getId_fullSize()));
            cards.put(CardId.SPADES_SIX, spadesNumberedTexturePackLibrary.get(CardId.SPADES_SIX.getId_fullSize()));
            cards.put(CardId.SPADES_SEVEN, spadesNumberedTexturePackLibrary.get(CardId.SPADES_SEVEN.getId_fullSize()));
            cards.put(CardId.SPADES_EIGHT, spadesNumberedTexturePackLibrary.get(CardId.SPADES_EIGHT.getId_fullSize()));
            cards.put(CardId.SPADES_NINE, spadesNumberedTexturePackLibrary.get(CardId.SPADES_NINE.getId_fullSize()));
            cards.put(CardId.SPADES_TEN, spadesNumberedTexturePackLibrary.get(CardId.SPADES_TEN.getId_fullSize()));

            final TexturePack spadesLetteredTexturePack = texturePackLoader.loadFromAsset(
                    baseGameActivity.getAssets(), CardFile.FILE_FULL_SPADES_LETTERED.getFile());
            spadesLetteredTexturePack.loadTexture();
            TexturePackTextureRegionLibrary spadesLetteredTexturePackLibrary =
                    spadesLetteredTexturePack.getTexturePackTextureRegionLibrary();

            cards.put(CardId.SPADES_ACE, spadesLetteredTexturePackLibrary.get(CardId.SPADES_ACE.getId_fullSize()));
            cards.put(CardId.SPADES_JACK, spadesLetteredTexturePackLibrary.get(CardId.SPADES_JACK.getId_fullSize()));
            cards.put(CardId.SPADES_QUEEN, spadesLetteredTexturePackLibrary.get(CardId.SPADES_QUEEN.getId_fullSize()));
            cards.put(CardId.SPADES_KING, spadesLetteredTexturePackLibrary.get(CardId.SPADES_KING.getId_fullSize()));

            final TexturePack backsTexturePack = texturePackLoader.loadFromAsset(
                    baseGameActivity.getAssets(), CardFile.FILE_FULL_BACKS.getFile());
            backsTexturePack.loadTexture();
            TexturePackTextureRegionLibrary backsTexturePackLibrary =
                    backsTexturePack.getTexturePackTextureRegionLibrary();

            cards.put(CardId.BACK_BLUE, backsTexturePackLibrary.get(CardId.BACK_BLUE.getId_fullSize()));
            cards.put(CardId.BACK_RED, backsTexturePackLibrary.get(CardId.BACK_RED.getId_fullSize()));
        } catch (final TexturePackParseException e) {
            Debug.e(e);
        }

        return cards;
    }
}
