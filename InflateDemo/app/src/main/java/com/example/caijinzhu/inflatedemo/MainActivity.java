package com.example.caijinzhu.inflatedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    private View inflateView;
    private ViewGroup rootView;
    private boolean isShowing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rootView = (ViewGroup)findViewById(R.id.ll_main);

        /*方式1*/
//        inflateView = View.inflate(this, R.layout.inflate_view, null);

        /*方式2*/
//       inflateView = LayoutInflater.from(this).inflate(R.layout.inflate_view,null);

        /* 方式3 */
        LayoutInflater inflate = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

        inflateView = inflate.inflate(R.layout.inflate_view,null);
    }

    public void show(View v){
        if (isShowing){return;}
        rootView.addView(inflateView);
        isShowing = true;

    }
    public void remove(View v){
        if (!isShowing){return;}
        isShowing = false;
        rootView.removeView(inflateView);



    }

}
