/**
 * Patrick John Haskins
 * Zachary Evans
 * CS7020 - Term Project
 */
package android.otasyn.cardgames;

import android.os.Bundle;
import android.app.Activity;

public class GameActivity extends Activity {
    
    GameView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {        
        super.onCreate(savedInstanceState);
        gameView = new GameView(this);
        setContentView(gameView);
        
        if (savedInstanceState == null) {
            gameView.initializePoints();
        } else {
            gameView.initializePoints(savedInstanceState);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        gameView.savePoints(outState);
    }

}
