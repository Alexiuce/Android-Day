package com.example.caijinzhu.activitydemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renpin);
    }


    // MARK: - 按钮点击事件处理
    public void openNewActivity(View v){
        Intent it = new Intent(this,SplashActivity.class);

        startActivity(it);
    }
}
