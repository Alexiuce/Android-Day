package com.example.caijinzhu.activitydemo;

import android.content.Intent;
import android.net.Uri;
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


        // 传递数据到下个页面
//        Uri hello = Uri.parse("hello://world");
//        it.setData(hello);
//        startActivity(it);

        it.putExtra("name","alexiuce");
        startActivityForResult(it,100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){

            System.out.println(data.getStringExtra("back"));
        }
    }
}
