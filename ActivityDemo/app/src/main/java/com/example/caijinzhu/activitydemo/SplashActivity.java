package com.example.caijinzhu.activitydemo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // 获取上个页码传过来的数据
        String sms = getIntent().getStringExtra("sms");
        TextView t = (TextView) findViewById(R.id.tv_title);
        t.setText(sms);
    }



    // 返回方法,传递数据
    public void goback(View v){
        Intent intent = getIntent();
        intent.putExtra("back","good");
        setResult(RESULT_OK,intent);

        finish();

    }


    // 重写返回物理按钮,传递数据
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK){
            Intent intent = getIntent();
            intent.putExtra("back","good");
            setResult(RESULT_OK,intent);

            finish();
        }
        return true;
    }
}
