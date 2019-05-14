package com.example.textapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void showTextView(View v){
        Log.d(TAG, "showTextView: ====");
    }

    public void showButtonView(View view) {
        Intent it = new Intent(MainActivity.this,ButtonActivity.class);
        startActivity(it);

    }
}
