package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DialogTitle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class ButtonActivity extends AppCompatActivity {
    private static final String TAG = "ButtonActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
    }
    public void  showToast(View v){
        Toast.makeText(this,"clicked the button",Toast.LENGTH_LONG).show();
        Log.d(TAG, "showToast: click3d ........");
    }
}
