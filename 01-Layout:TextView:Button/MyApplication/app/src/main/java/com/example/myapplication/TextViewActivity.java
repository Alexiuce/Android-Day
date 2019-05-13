package com.example.myapplication;

import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class TextViewActivity extends AppCompatActivity {


    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);
        mTextView = findViewById(R.id.tv_ac1);
        // 设置下划线;
        mTextView.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        // 设置中划线;
//        mTextView.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
//        去除锯齿;
//        mTextView.getPaint().setAntiAlias(true);

//        mTextView.setText(Html.fromHtml("<p>THIS IS HTML P TAG</p>"));

    }
}
