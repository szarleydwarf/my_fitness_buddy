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

import eu.rjch.myfitnessbuddy.R;
import eu.rjch.myfitnessbuddy.utility.Utilities;

public class SignIn extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin_layout);
        intit();
    }

    private void intit() {
        Utilities u = new Utilities();

        initiateBtns(u);

        passwordIconToggle(u);
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
