package com.example.httpapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.httplibrary.HttpTool;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HttpTool.fetchData();
    }
}
