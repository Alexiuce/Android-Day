package com.example.alexcai.jnihello;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void helloC(){
        Log.i("JINHELLO", "helloC: " + stringFromC());
    }
    public native String stringFromC();
}
