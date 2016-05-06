package mehdi.sakout.custom_facebook_login_button;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import java.util.Arrays;
import mehdi.sakout.fancybuttons.FancyButton;

public class MainActivity extends AppCompatActivity {

    String TAG = "FacebookLogin";
    CallbackManager mFacebookCallbackManager;
    LoginManager mLoginManager;
    FancyButton FacebookLogin;
    TextView mUserNameTextView;
    AccessTokenTracker mAccessTokenTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUserNameTextView = (TextView)findViewById(R.id.user_name);
        FacebookLogin = (FancyButton)findViewById(R.id.facebook_login);

        setupFacebookStuff();
        updateFacebookButtonUI();

        FacebookLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleFacebookLogin();
            }
        });


    }

    private void setupFacebookStuff() {

        // This should normally be on your application class
        FacebookSdk.sdkInitialize(getApplicationContext());

        mAccessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken,AccessToken currentAccessToken) {
                updateFacebookButtonUI();
            }
        };

        mLoginManager = LoginManager.getInstance();
        mFacebookCallbackManager = CallbackManager.Factory.create();

        LoginManager.getInstance().registerCallback(mFacebookCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                updateFacebookButtonUI();
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });
    }

    private void updateFacebookButtonUI(){
        if (AccessToken.getCurrentAccessToken() != null){
            FacebookLogin.setText("Logout");
            mUserNameTextView.setText("Hello ...");
        }else{
            FacebookLogin.setText("Facebook Connect");
            mUserNameTextView.setText("Hello ...");
        }
    }
    private void handleFacebookLogin() {
        if (AccessToken.getCurrentAccessToken() != null){
            mLoginManager.logOut();
        }else{
            mAccessTokenTracker.startTracking();
            mLoginManager.logInWithReadPermissions(MainActivity.this, Arrays.asList("public_profile"));
        }

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mFacebookCallbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
