package eu.rjch.myfitnessbuddy;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;

import com.crashlytics.android.Crashlytics;

import eu.rjch.myfitnessbuddy.activities.SignIn;
import eu.rjch.myfitnessbuddy.utility.Utilities;
import io.fabric.sdk.android.Fabric;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);
        Crashlytics.log(1, "MainApp", "Something went wrong on start MainApp");

        final VideoView vv = findViewById(R.id.VideoView);
    runApp();
//        try{
//            String pkgName = getPackageName();
//            int id = getResources().getIdentifier("intro", "raw", pkgName);
//            vv.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+id));
//
//            vv.start();
//            vv.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//                @Override
//                public void onCompletion(MediaPlayer mediaPlayer) {
//                    runApp(vv);
//                }
//            });
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    private void runApp() {
        Intent i = new Intent(this, SignIn.class);
        startActivity(i);
        finish();
    }
}
