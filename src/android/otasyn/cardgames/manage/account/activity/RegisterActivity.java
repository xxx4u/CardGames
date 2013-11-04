/**
 * Patrick John Haskins
 * Zachary Evans
 * CS7020 - Term Project
 */
package android.otasyn.cardgames.manage.account.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.otasyn.cardgames.MainActivity;
import android.otasyn.cardgames.R;
import android.otasyn.cardgames.manage.account.asynctask.RegisterTask;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.concurrent.ExecutionException;

public class RegisterActivity extends Activity {

    private EditText registerFirstname;
    private EditText registerLastname;
    private EditText registerEmail;
    private EditText registerPassword;
    private EditText registerPasswordConfirm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerFirstname = (EditText) findViewById(R.id.registerFirstname);
        registerLastname = (EditText) findViewById(R.id.registerLastname);
        registerEmail = (EditText) findViewById(R.id.registerEmail);
        registerPassword = (EditText) findViewById(R.id.registerPassword);
        registerPasswordConfirm = (EditText) findViewById(R.id.registerPasswordConfirm);

        Button registerSubmitButton = (Button) findViewById(R.id.registerSubmitButton);
        registerSubmitButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                register();
            }
        });
    }

    public void register() {
        try {
            new RegisterTask()
                    .execute(registerFirstname.getText().toString(), registerLastname.getText().toString(),
                             registerEmail.getText().toString(),
                             registerPassword.getText().toString(), registerPasswordConfirm.getText().toString())
                    .get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        RegisterActivity.this.startActivity(new Intent(RegisterActivity.this, MainActivity.class));
    }

}