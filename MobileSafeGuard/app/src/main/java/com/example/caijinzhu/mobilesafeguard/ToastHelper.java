package com.example.caijinzhu.mobilesafeguard;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by caijinzhu on 2017/11/16.
 */

public class ToastHelper {
    public static void showMessage(Context context,String msg){

        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();

    }
}
