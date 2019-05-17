package com.example.application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.application.recycleview.AlertDialogActivity;
import com.example.application.recycleview.RecycleViewActivity;
import com.example.application.recycleview.ToastActivity;
import com.example.application.recycleview.WebViewActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListener();
    }

    private void setListener() {
        findViewById(R.id.btn_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, WebViewActivity.class);
                startActivity(it);
            }
        });

        findViewById(R.id.btn_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, ToastActivity.class);
                startActivity(it);
            }
        });
        findViewById(R.id.btn_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, AlertDialogActivity.class);
                startActivity(it);
            }
        });
    }

    public void showRecycleView(View v){
        Intent it = new Intent(MainActivity.this, RecycleViewActivity.class);
        startActivity(it);
    }
}
