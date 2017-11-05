package com.example.alexcai.httpdemo;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {


    private TextView textView;

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            String in = (String) msg.obj;
            updateText(in);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView = findViewById(R.id.tv_textView);


        /*开启子线程 发送网络请求*/
        new Thread  (new Runnable() {
           @Override
           public void run() {
               try {
               URL url = new URL("http://httpbin.org/get");
               HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
               InputStream inputStream = urlConnection.getInputStream();


               // 方式1
//               final String result = StringUtil.stringFromInputStream(inputStream);
//               runOnUiThread(new Runnable() {
//                   @Override
//                   public void run() {
//                       updateText(result);
//                   }
//               });
                   // 方式2
                   String result = StringUtil.stringFromInputStream(inputStream);
                   Message msg = new Message();
                   msg.obj = result;
                   mHandler.sendMessage(msg);

               }catch (Exception e){

                   System.out.println(e.getMessage());

               }
           }
       }).start();

    }


    private void updateText(String text){
        System.out.println(text + "====");
        textView.setText(text);
    }
}
