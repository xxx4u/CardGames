/**
 * Patrick John Haskins
 * CS7020 - Term Project
 */
package android.otasyn.cardgames;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button gameActivityButton = (Button) findViewById(R.id.buttonLaunchGameActivity);
        gameActivityButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, GameActivity.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
