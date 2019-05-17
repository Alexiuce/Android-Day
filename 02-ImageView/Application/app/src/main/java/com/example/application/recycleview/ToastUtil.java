package com.example.application.recycleview;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil extends Object {
    public static String text;
    private static Toast mToast;
    public static void showMessage(Context c, String msg){
        if (mToast == null){
            mToast = Toast.makeText(c,msg,Toast.LENGTH_SHORT);
            mToast.setText(msg);
        }else {
            mToast.setText(msg);
        }

        mToast.show();
    }
}
