package eu.rjch.myfitnessbuddy.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

import eu.rjch.myfitnessbuddy.R;

public class SearchBuddy extends Activity {
    public static final String GOOGLE_ACCOUNT = "google_account";
    private TextView profileName, profileEmail;
    private ImageView profileImage;
    private Button signOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_buddy_layout);
        Log.d("WWW", "Search buddy class");

        intit();
    }

    private void intit() {
        findObjects();
        setDataOnView();
    }

    private void findObjects() {
        profileName = findViewById(R.id.user_nick);
        profileEmail = findViewById(R.id.email);
        profileImage = findViewById(R.id.profile_image);
//        signOut = findViewById()
    }

    private void setDataOnView(){
        GoogleSignInAccount gsoa = getIntent().getParcelableExtra(GOOGLE_ACCOUNT);
        profileImage.setImageURI(gsoa.getPhotoUrl());
        profileName.setText(gsoa.getDisplayName());
        profileEmail.setText(gsoa.getEmail());
    }

}
