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
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import eu.rjch.myfitnessbuddy.R;
import eu.rjch.myfitnessbuddy.utility.Utilities;

public class SignIn extends Activity {
    private GoogleSignInClient mGoogleSignInClient;
    private SignInButton gSignInBtn;
    private Utilities u;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin_layout);
        init();
    }

    @Override
    public void onStart() {
        super.onStart();
        GoogleSignInAccount alreadyLoggedAccount = GoogleSignIn.getLastSignedInAccount(this);
        if(alreadyLoggedAccount != null) {
            u.showToast(this, "Already logged");
            onLoggedIn(alreadyLoggedAccount);
        } else {
            u.showToast(this, "Logging you in");
        }
    }

    private void init() {
        u = new Utilities();

        initiateBtns(u);
        passwordIconToggle(u);

        googleSigning();
    }

    private void googleSigning() {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        gSignInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = mGoogleSignInClient.getSignInIntent();
                Log.d("WWW", "On click");
                startActivityForResult(i, 101);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(resultCode == Activity.RESULT_OK){
            switch (requestCode){
                case 101:
                    try {
                        Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
                        GoogleSignInAccount account = task.getResult(ApiException.class);
                        Log.d("WWW", "Logging in TRY");
                        onLoggedIn(account);
                    } catch (ApiException e) {
                        Log.d("WWW", "SignInResult failed code = "+e.getStatusCode());
                    }
                    break;
            }
        }
    }

    private void onLoggedIn(GoogleSignInAccount account) {
        Log.d("WWW", "Logging in");
        Intent i = new Intent(this, SearchBuddy.class);
        i.putExtra(SearchBuddy.GOOGLE_ACCOUNT, account);
        startActivity(i);
        finish();
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

        gSignInBtn = findViewById(R.id.g_sign_btn);
    }
}
