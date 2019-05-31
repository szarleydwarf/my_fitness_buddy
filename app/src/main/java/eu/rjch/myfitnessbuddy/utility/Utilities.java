package eu.rjch.myfitnessbuddy.utility;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.method.PasswordTransformationMethod;
import android.text.method.SingleLineTransformationMethod;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import eu.rjch.myfitnessbuddy.R;

public class Utilities {
    public Utilities() {
    }

    public void showDialog(Context ctx, final String s) {
        AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
        builder.setMessage(s);

        builder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
//						boolean isOk = true;
//						if(isOk)
							return;
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void showToast(Context v, String msg) {

        LayoutInflater lf = (LayoutInflater)v.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        View ctv = lf.inflate(R.layout.toaster, null);
        ((TextView) ctv.findViewById(R.id.msg)).setText(msg);
        Toast t = Toast.makeText(ctv.getContext(), "", Toast.LENGTH_LONG);
        t.setGravity(Gravity.CENTER_VERTICAL,0 ,0);
        t.setView(ctv);
        t.show();
    }

    public void passwordToggle(EditText et) {
        Log.d("WWW","Toggle password");

        if (et.getTransformationMethod().getClass().getSimpleName().equals("PasswordTransformationMethod")) {
            et.setTransformationMethod(new SingleLineTransformationMethod());
        }
        else {
            et.setTransformationMethod(new PasswordTransformationMethod());
        }

        et.setSelection(et.getText().length());
    }


    public void iconToggle(ImageView iv, int id2assert, int drawable1, int drawable2) {
        ImageView imageView = iv;
        assert(id2assert == imageView.getId());

        // This method works only if there is no other action in hand
        Integer integer = (Integer) imageView.getTag();
        integer = integer == null ? 0 : integer;
        Log.d("WWW","onclick "+integer+" / "+drawable1+" / "+drawable2);

        if(integer == drawable1) {
            Log.d("WWW","draw1");
            imageView.setImageResource(drawable2);
            imageView.setTag(drawable2);
        } else if(integer == drawable2){
            Log.d("WWW","draw2");
            imageView.setImageResource(drawable1);
            imageView.setTag(drawable1);
        }

    }
}
