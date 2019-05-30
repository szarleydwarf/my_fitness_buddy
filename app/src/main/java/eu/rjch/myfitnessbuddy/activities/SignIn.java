package eu.rjch.myfitnessbuddy.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

        initiateBtns(u);

        passwordIconToggle(u);
    }

    private void passwordIconToggle(Utilities u) {
        ImageView iv = findViewById(R.id.inside_imageview);
        Log.d("WWW", "SignIn "+iv.getDrawable().toString()+" / "+R.drawable.showeye+" / "+R.drawable.hideeye);

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView imageView = (ImageView) view;
                assert(R.id.inside_imageview == imageView.getId());

                // See here
                Integer integer = (Integer) imageView.getTag();
                integer = integer == null ? 0 : integer;

                switch(integer) {
                    case R.drawable.showeye:
                        imageView.setImageResource(R.drawable.hideeye);
                        imageView.setTag(R.drawable.hideeye);
                        break;
                    case R.drawable.hideeye:
                    default:
                        imageView.setImageResource(R.drawable.showeye);
                        imageView.setTag(R.drawable.showeye);
                        break;
                }
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
