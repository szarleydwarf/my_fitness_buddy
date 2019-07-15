package eu.rjch.myfitnessbuddy.utility;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IOHelper {
    private static final String TAG = "IOHELPER";

    public static String readFromAssets(Context ctx, String assetsFileName){
        AssetManager am = ctx.getAssets();
        try{
            InputStream is = am.open(assetsFileName);
            String res = IOHelper.stringFromStream(is);
            is.close();
            return res;
        } catch (Exception e) {
            Log.d(TAG, "readFromAssets: "+e.getMessage());
        }
        return null;
    }

    private static String stringFromStream(InputStream is) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            String line = null;

            while ((line = br.readLine()) != null){
                sb.append(line).append("\n");
            }
            br.close();
            return sb.toString();
        } catch (IOException e){
            Log.d(TAG, "stringFromStream: "+e.getMessage());
        }

        return null;
    }
}
