package android.otasyn.cardgames;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class DemosActivity extends Activity {

    public static void launch(final Context context) {
        Intent registerIntent = new Intent(context, DemosActivity.class);
        context.startActivity(registerIntent);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        Button gameActivityButton = (Button) findViewById(R.id.buttonLaunchFirebaseActivity);
        gameActivityButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                DemosActivity.this.startActivity(new Intent(DemosActivity.this, FirebaseActivity.class));
            }
        });

        Button andEngineActivityButton = (Button) findViewById(R.id.buttonLaunchAndEngineActivity);
        andEngineActivityButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                DemosActivity.this.startActivity(new Intent(DemosActivity.this, AndEngineActivity.class));
            }
        });

        Button cards46x64ActivityButton = (Button) findViewById(R.id.buttonLaunchCards46x64Activity);
        cards46x64ActivityButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                DemosActivity.this.startActivity(new Intent(DemosActivity.this, Cards46x64Activity.class));
            }
        });

        Button cards92x128ActivityButton = (Button) findViewById(R.id.buttonLaunchCards92x128Activity);
        cards92x128ActivityButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                DemosActivity.this.startActivity(new Intent(DemosActivity.this, Cards92x128Activity.class));
            }
        });

        Button cards184x256ActivityButton = (Button) findViewById(R.id.buttonLaunchCards184x256Activity);
        cards184x256ActivityButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                DemosActivity.this.startActivity(new Intent(DemosActivity.this, Cards184x256Activity.class));
            }
        });

        Button cardsFullSizeActivityButton = (Button) findViewById(R.id.buttonLaunchCardsFullSizeActivity);
        cardsFullSizeActivityButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                DemosActivity.this.startActivity(new Intent(DemosActivity.this, CardsFullSizeActivity.class));
            }
        });
    }
}