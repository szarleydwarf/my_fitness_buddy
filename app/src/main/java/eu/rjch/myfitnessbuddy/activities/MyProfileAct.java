package eu.rjch.myfitnessbuddy.activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
    private Button signout_btn, settings_btn, edit_btn, password_change_btn;
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

        setButtnos();

        email = getIntent().getStringExtra(getResources().getString(R.string.email));
        username = getIntent().getStringExtra(getResources().getString(R.string.username));
        photo = getIntent().getStringExtra(getResources().getString(R.string.url));

        u.showToast(this,"Hello " + username);
        url = Uri.parse(photo);

        userTV = findViewById(R.id.user_nick);
        emailTV = findViewById(R.id.user_email);
        iv = findViewById(R.id.photo);

        userTV.setText(username);
        emailTV.setText(email);

        Picasso.get().load(url).into(iv);
    }

    private void setButtnos() {
        signout_btn = findViewById(R.id.signout_btn);
        signout_btn.setOnClickListener(this);

        settings_btn = findViewById(R.id.settings_btn);
        settings_btn.setOnClickListener(this);

        edit_btn = findViewById(R.id.edit_btn);
        edit_btn.setOnClickListener(this);

        password_change_btn = findViewById(R.id.password_edit_btn);
        password_change_btn.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.signout_btn:
                goBack();
            break;
            case R.id.settings_btn:
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                break;
            case R.id.edit_btn:
                Toast.makeText(this, "EDIT", Toast.LENGTH_SHORT).show();
                break;
            case R.id.password_edit_btn:
                Toast.makeText(this, "PASSWORD change", Toast.LENGTH_SHORT).show();
                break;
        }
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
