/**
 * Patrick John Haskins
 * Zachary Evans
 * CS7020 - Term Project
 */
package android.otasyn.cardgames;

import android.content.Context;
import android.content.Intent;
import android.otasyn.cardgames.activity.GameMenuActivity;
import android.otasyn.cardgames.manage.account.activity.FriendsListActivity;
import android.otasyn.cardgames.manage.account.activity.GamesListActivity;
import android.otasyn.cardgames.manage.account.activity.LoginActivity;
import android.otasyn.cardgames.manage.account.activity.RegisterActivity;
import android.otasyn.cardgames.manage.account.dto.SimpleUser;
import android.otasyn.cardgames.manage.account.utility.AccountUtility;
import android.otasyn.cardgames.scene.GameMenuScene;
import android.otasyn.cardgames.utility.TextureUtility;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.opengl.texture.region.ITextureRegion;

public class MainActivity extends GameMenuActivity {

    public static void launch(final Context context) {
        Intent mainIntent = new Intent(context, MainActivity.class);
        mainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(mainIntent);
    }

    private ITextureRegion[] signInButtonRegion;
    private ITextureRegion[] signOutButtonRegion;
    private ITextureRegion[] registerButtonRegion;
    private ITextureRegion[] demosButtonRegion;
    private ITextureRegion[] friendsButtonRegion;
    private ITextureRegion[] gamesButtonRegion;

    private GameMenuScene scene;
    private ButtonSprite signInButton;
    private ButtonSprite signOutButton;
    private ButtonSprite registerButton;
    private ButtonSprite demosButton;
    private ButtonSprite friendsButton;
    private ButtonSprite gamesButton;

    private float demosLoggedOutY = 395;
    private float demosLoggedInY = 310;

    private SimpleUser currentUser;

    @Override
    protected void onCreateGameMenuResources() {
        signInButtonRegion = TextureUtility.loadSignInButton(this);
        signOutButtonRegion = TextureUtility.loadSignOutButton(this);
        registerButtonRegion = TextureUtility.loadRegisterButton(this);
        demosButtonRegion = TextureUtility.loadDemosButton(this);
        friendsButtonRegion = TextureUtility.loadFriendsButton(this);
        gamesButtonRegion = TextureUtility.loadGamesButton(this);
    }

    @Override
    protected void onCreateGameMenuScene(final GameMenuScene scene) {
        this.scene = scene;
        float buttonPadding = 20;

        //
        // Both Logged In and Not Logged In
        //

        float start = demosLoggedOutY;
        demosButton = new ButtonSprite(
                buttonPadding, start,
                demosButtonRegion[TextureUtility.BUTTON_STATE_UP],
                demosButtonRegion[TextureUtility.BUTTON_STATE_DOWN],
                demosButtonRegion[TextureUtility.BUTTON_STATE_DISABLED],
                this.getVertexBufferObjectManager());
        demosButton.setOnClickListener(new DemosClickListener());
        scene.attachChild(demosButton);
        scene.registerTouchArea(demosButton);

        //
        // Not Logged In
        //

        start += (demosButtonRegion[TextureUtility.BUTTON_STATE_UP].getHeight() + buttonPadding);
        signInButton = new ButtonSprite(
                buttonPadding, start,
                signInButtonRegion[TextureUtility.BUTTON_STATE_UP],
                signInButtonRegion[TextureUtility.BUTTON_STATE_DOWN],
                signInButtonRegion[TextureUtility.BUTTON_STATE_DISABLED],
                this.getVertexBufferObjectManager());
        signInButton.setOnClickListener(new SignInClickListener());
        scene.attachChild(signInButton);
        scene.registerTouchArea(signInButton);

        start += (signInButtonRegion[TextureUtility.BUTTON_STATE_UP].getHeight() + buttonPadding);
        registerButton = new ButtonSprite(
                buttonPadding, start,
                registerButtonRegion[TextureUtility.BUTTON_STATE_UP],
                registerButtonRegion[TextureUtility.BUTTON_STATE_DOWN],
                registerButtonRegion[TextureUtility.BUTTON_STATE_DISABLED],
                this.getVertexBufferObjectManager());
        registerButton.setOnClickListener(new RegisterClickListener());
        scene.attachChild(registerButton);
        scene.registerTouchArea(registerButton);

        //
        // Logged In
        //

        start = (demosLoggedInY + demosButtonRegion[TextureUtility.BUTTON_STATE_UP].getHeight() + buttonPadding);
        gamesButton = new ButtonSprite(
                buttonPadding, start,
                gamesButtonRegion[TextureUtility.BUTTON_STATE_UP],
                gamesButtonRegion[TextureUtility.BUTTON_STATE_DOWN],
                gamesButtonRegion[TextureUtility.BUTTON_STATE_DISABLED],
                this.getVertexBufferObjectManager());
        gamesButton.setOnClickListener(new GamesClickListener());
        scene.attachChild(gamesButton);
        scene.registerTouchArea(gamesButton);

        start += (gamesButtonRegion[TextureUtility.BUTTON_STATE_UP].getHeight() + buttonPadding);
        friendsButton = new ButtonSprite(
                buttonPadding, start,
                friendsButtonRegion[TextureUtility.BUTTON_STATE_UP],
                friendsButtonRegion[TextureUtility.BUTTON_STATE_DOWN],
                friendsButtonRegion[TextureUtility.BUTTON_STATE_DISABLED],
                this.getVertexBufferObjectManager());
        friendsButton.setOnClickListener(new FriendsClickListener());
        scene.attachChild(friendsButton);
        scene.registerTouchArea(friendsButton);

        start += (friendsButtonRegion[TextureUtility.BUTTON_STATE_UP].getHeight() + buttonPadding);
        signOutButton = new ButtonSprite(
                buttonPadding, start,
                signOutButtonRegion[TextureUtility.BUTTON_STATE_UP],
                signOutButtonRegion[TextureUtility.BUTTON_STATE_DOWN],
                signOutButtonRegion[TextureUtility.BUTTON_STATE_DISABLED],
                this.getVertexBufferObjectManager());
        signOutButton.setOnClickListener(new SignOutClickListener());
        scene.attachChild(signOutButton);
        scene.registerTouchArea(signOutButton);

        currentUser = AccountUtility.currentUser();
        if (currentUser == null) {
            showLoggedOutButton();
        } else {
            showLoggedInButtons();
        }
    }

    private void showLoggedInButtons() {
        demosButton.setVisible(true);
        demosButton.setPosition(demosButton.getX(), demosLoggedInY);

        gamesButton.setVisible(true);
        friendsButton.setVisible(true);
        signOutButton.setVisible(true);

        signInButton.setVisible(false);
        registerButton.setVisible(false);
    }

    private void showLoggedOutButton() {
        demosButton.setVisible(true);
        demosButton.setPosition(demosButton.getX(), demosLoggedOutY);

        gamesButton.setVisible(false);
        friendsButton.setVisible(false);
        signOutButton.setVisible(false);

        signInButton.setVisible(true);
        registerButton.setVisible(true);
    }

    private class SignInClickListener implements ButtonSprite.OnClickListener {
        @Override
        public void onClick(final ButtonSprite pButtonSprite,
                            final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
            LoginActivity.launch(MainActivity.this);
        }
    }

    private class SignOutClickListener implements ButtonSprite.OnClickListener {
        @Override
        public void onClick(final ButtonSprite pButtonSprite,
                            final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
            AccountUtility.logout();
            showLoggedOutButton();
        }
    }

    private class RegisterClickListener implements ButtonSprite.OnClickListener {
        @Override
        public void onClick(final ButtonSprite pButtonSprite,
                            final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
            RegisterActivity.launch(MainActivity.this);
        }
    }

    private class GamesClickListener implements ButtonSprite.OnClickListener {
        @Override
        public void onClick(final ButtonSprite pButtonSprite,
                            final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
            GamesListActivity.launch(MainActivity.this);
        }
    }

    private class FriendsClickListener implements ButtonSprite.OnClickListener {
        @Override
        public void onClick(final ButtonSprite pButtonSprite,
                            final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
            FriendsListActivity.launch(MainActivity.this);
        }
    }

    private class DemosClickListener implements ButtonSprite.OnClickListener {
        @Override
        public void onClick(final ButtonSprite pButtonSprite,
                            final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
            DemosActivity.launch(MainActivity.this);
        }
    }
}
