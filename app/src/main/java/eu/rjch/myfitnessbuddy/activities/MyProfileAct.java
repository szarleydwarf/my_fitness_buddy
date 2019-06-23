package eu.rjch.myfitnessbuddy.activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

import eu.rjch.myfitnessbuddy.R;
import eu.rjch.myfitnessbuddy.utility.Utilities;

public class MyProfileAct extends Activity implements View.OnClickListener {
    private String email, username, photo;
    private Uri url;
    private TextView userTV, emailTV;
    private ImageView iv;
    private Button signout_btn;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_profile_layout);
        intit();
    }

    private void intit() {
        Utilities u = new Utilities();

        mAuth = FirebaseAuth.getInstance();

        signout_btn = findViewById(R.id.signout_btn);
        signout_btn.setOnClickListener(this);

        email = getIntent().getStringExtra("email");
        username = getIntent().getStringExtra("username");
        photo = getIntent().getStringExtra("url");

        u.showToast(this,"Hello " + username);
        url = Uri.parse(photo);

        userTV = findViewById(R.id.user_nick);
        emailTV = findViewById(R.id.user_email);
        iv = findViewById(R.id.photo);

        userTV.setText(username);
        emailTV.setText(email);

        Picasso.get().load(url).into(iv);
    }
    public void onClick(View view) {
        goBack();
    }

    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser == null)
            goBack();
    }

    private void goBack() {
        FirebaseAuth.getInstance().signOut();
        Intent i = new Intent(this, SignIn.class);
        i.putExtra("signout", true);
        startActivity(i);
        finish();
    }

}
