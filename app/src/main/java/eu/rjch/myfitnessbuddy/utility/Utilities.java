package eu.rjch.myfitnessbuddy.utility;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
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
}
