package eu.rjch.myfitnessbuddy.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

import eu.rjch.myfitnessbuddy.R;
import eu.rjch.myfitnessbuddy.utility.Utilities;


public class SignIn extends Activity implements View.OnClickListener {

    private Utilities u;
    private static final int MY_REQUEST_CODE = 22;
    private List<AuthUI.IdpConfig> providers;
    private boolean signedout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin_layout);
        signedout = getIntent().getBooleanExtra("signout", false);
        init();
    }

    private void init(){
        if (signedout) {
            AuthUI.getInstance().signOut(SignIn.this)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            showSigningOptions();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(SignIn.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        providers = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build(),
                new AuthUI.IdpConfig.GoogleBuilder().build(),
                new AuthUI.IdpConfig.FacebookBuilder().build()

        );

        showSigningOptions();
    }

    private void showSigningOptions() {
        int requestCode;
        if(signedout) {
            requestCode = 0;
        } else {
            requestCode = MY_REQUEST_CODE;
        }
        startActivityForResult(
                AuthUI.getInstance().createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .setTheme(R.style.MyTheme)
                        .build(), requestCode
        );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == MY_REQUEST_CODE) {
            IdpResponse response = IdpResponse.fromResultIntent(data);
            if(resultCode == RESULT_OK){
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                //todo check if user exist in firebase database if not create user/else retrive data
                signIn(user);
                Toast.makeText(this, ""+user.getEmail(), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, ""+response.getError().getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void signIn(FirebaseUser user) {
        Intent i = new Intent(this, MyProfileAct.class);
        i.putExtra(getResources().getString(R.string.email), user.getEmail());
        i.putExtra(getResources().getString(R.string.username), user.getDisplayName());
        i.putExtra(getResources().getString(R.string.url), String.valueOf(user.getPhotoUrl()));

        startActivity(i);
        finish();
    }

    @Override
    public void onClick(View view) {

    }
}
