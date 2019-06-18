package eu.rjch.myfitnessbuddy.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import eu.rjch.myfitnessbuddy.R;
import eu.rjch.myfitnessbuddy.utility.Utilities;


public class SignIn extends Activity {

    private Utilities u;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin_layout);
        init();
    }

    private void init(){
        initiateBtns();
    }


    private void initiateBtns() {
        Button eulabtn = findViewById(R.id.eula_btn);
        eulabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runActivity(Eula.class);

            }
        });

        ImageButton googleBtn = findViewById(R.id.g_sign_btn);
        googleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runActivity(GSignIn.class);
            }
        });

        ImageButton fbBtn = findViewById(R.id.fb_sign_btn);
        fbBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runActivity(FSigniIn.class);
            }
        });

        Button emailSignBtn = findViewById(R.id.email_signin_btn);
        emailSignBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //todo test if pasword and email views not empty
                runActivity(EmailSignIn.class);
            }
        });
    }

    private void runActivity(Class<?> classy) {
        Intent i = new Intent(this, classy);
        startActivity(i);
        finish();
    }
}
