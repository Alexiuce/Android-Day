package com.example.caijinzhu.activitydemo;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // 获取上个页码传过来的数据
        String name = getIntent().getStringExtra("name");
        System.out.println(name);
    }



    public void goback(View v){

        finish();

    }
}
