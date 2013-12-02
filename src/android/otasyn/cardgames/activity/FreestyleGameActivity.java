package android.otasyn.cardgames.activity;

import android.otasyn.cardgames.manage.account.dto.Game;
import android.otasyn.cardgames.scene.CardGameScene;

public class FreestyleGameActivity extends CardGameActivity {

    private Game game;

    @Override
    protected void onCreateCardGameResources() {
        game = getIntent().getParcelableExtra(GAME_INFO);
    }

    @Override
    protected void onCreateCardGameScene(final CardGameScene scene) {

    }
}
