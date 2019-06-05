package eu.rjch.myfitnessbuddy.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.text.method.SingleLineTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

import eu.rjch.myfitnessbuddy.R;
import eu.rjch.myfitnessbuddy.utility.Utilities;

public class SignIn extends Activity {
    private GoogleSignInClient mGoogleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin_layout);
        init();
    }

    private void init() {
        Utilities u = new Utilities();

        // Check for existing Google Sign In account,
        // if the user is already signed in
        // the GoogleSignInAccount will be non-null.
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);

        if(account == null) {
            Log.d("WWW", "Acc null");
            setGoogleSignin();
        } else {
            Log.d("WWW", "Acc fund");
            Intent i = new Intent(this, SearchBuddy.class);
            runApp(i);
        }
        initiateBtns(u);

        passwordIconToggle(u);
    }

    private void runApp(Intent i) {
//        Intent i = new Intent(this, SearchBuddy.class);
        Log.d("WWW", "Run app");
        startActivity(i);
        finish();
    }

    private void setGoogleSignin() {
        Log.d("WWW", "Signing to google");

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        findViewById(R.id.g_sign_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = mGoogleSignInClient.getSignInIntent();
                Log.d("WWW", "On click");

                runApp(i);
            }
        });
    }

    private void passwordIconToggle(final Utilities u) {
        final ImageView iv = findViewById(R.id.inside_imageview);
        final EditText et = findViewById(R.id.password_edittext);
//        Log.d("WWW", "SignIn "+iv.getDrawable().toString()+" / "+R.drawable.showeye+" / "+R.drawable.hideeye);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                u.passwordToggle(et);

            }
        });
    }


    private void initiateBtns(Utilities u) {
        Button eulabtn = findViewById(R.id.eula_btn);
        eulabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), Eula.class);
                startActivity(i);
                finish();
            }
        });
    }
}
