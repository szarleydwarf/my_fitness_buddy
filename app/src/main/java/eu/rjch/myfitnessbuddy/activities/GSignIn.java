package eu.rjch.myfitnessbuddy.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import eu.rjch.myfitnessbuddy.R;

public class GSignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gsign_in);

        Button cancelBtn = findViewById(R.id.cnacel_btn);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(GSignIn.this, SignIn.class);
                startActivity(i);
                finish();
            }
        });
    }
}
