package com.example.alexcai.httpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.tv_textView);


        new Thread  (new Runnable() {
           @Override
           public void run() {
               try {

               URL url = new URL("http://httpbin.org/get");
               HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
               InputStream inputStream = urlConnection.getInputStream();
               System.out.println(StringUtil.stringFromInputStream(inputStream));

               }catch (Exception e){

                   System.out.println(e.getMessage());

               }
           }
       }).start();

    }
}
