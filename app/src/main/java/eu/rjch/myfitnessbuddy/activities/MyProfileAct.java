package eu.rjch.myfitnessbuddy.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import eu.rjch.myfitnessbuddy.R;
import eu.rjch.myfitnessbuddy.utility.Utilities;

public class MyProfileAct extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_profile_layout);
        intit();
    }

    private void intit() {
        Utilities u = new Utilities();
        u.showToast(this,"Hello User");
    }

}
