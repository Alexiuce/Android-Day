package com.example.alexcai.javacdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public  void click(View v){
        JNIHelper jniHelper = new JNIHelper();
        Log.i("hello:", "click: " + jniHelper.stringFromC());

        Toast.makeText(this,jniHelper.stringFromC(),Toast.LENGTH_SHORT).show();
    }
}
