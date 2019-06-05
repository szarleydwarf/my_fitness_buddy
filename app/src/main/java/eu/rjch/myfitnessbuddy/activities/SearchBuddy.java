package eu.rjch.myfitnessbuddy.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import eu.rjch.myfitnessbuddy.R;

public class SearchBuddy extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_buddy_layout);
        Log.d("WWW", "Search buddy class");

        intit();
    }

    private void intit() {

    }

}
