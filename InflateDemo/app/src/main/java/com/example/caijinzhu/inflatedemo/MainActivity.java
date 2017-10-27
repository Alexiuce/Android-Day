package com.example.caijinzhu.inflatedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        inflateView = View.inflate(this, R.layout.inflate_view, null);


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
