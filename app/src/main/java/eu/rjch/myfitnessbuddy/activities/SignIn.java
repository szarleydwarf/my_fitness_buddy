package eu.rjch.myfitnessbuddy.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
        u.showToast(this, "Sign in please");

//        initiateBtns(u);

        passwordIconToggle(u);
    }

    private void passwordIconToggle(Utilities u) {
//        ImageView cros_eye = findViewById(R.id.inside_imageview);
//        ImageView reg_eye = findViewById(R.id.outside_imageview);

//        u.iconToggle(reg_eye, cros_eye);
//        u.iconToggle(cros_eye);
    }

    private void initiateBtns(Utilities u) {
//        Button eulabtn = findViewById(R.id.eula_btn);
//        eulabtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(view.getContext(), Eula.class);
//                startActivity(i);
//                finish();
//            }
//        });
    }
}
