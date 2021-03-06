/**
 * Patrick John Haskins
 * Zachary Evans
 * CS7020 - Term Project
 */
package android.otasyn.cardgames;

import android.otasyn.cardgames.activity.CardGameActivity;
import android.otasyn.cardgames.scene.CardGameScene;
import android.otasyn.cardgames.utility.TextureUtility;

public class CardsFullSizeActivity extends CardGameActivity {

    @Override
    protected void onCreateCardGameResources() {
        setCardTextureRegions(TextureUtility.loadCardsFullSize(this));
    }

    @Override
    protected void onCreateCardGameScene(final CardGameScene scene) {
        loadCardSprites(scene, 40, 3, 80, 60);
    }
}
