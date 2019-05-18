package com.example.dialogapplication;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dialog1Activity extends AppCompatActivity {

    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog1);
        // 初始化UI控件
        setupView();
        // 设置事件监听
        setListener();
    }

    private void setupView() {
        mButton = findViewById(R.id.btn_n1);
    }

    private void setListener() {
        mButton.setOnClickListener(new MyClickListener());
    }

    class MyClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_n1:

                    break;
                case R.id.btn_dialog1:
                    // dialog
                    break;

            }
        }
    }
}
