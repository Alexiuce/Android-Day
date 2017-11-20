package com.example.caijinzhu.mobilesafeguard;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class SplashActivity extends AppCompatActivity {

    private TextView mVersionTextView;
    private PackageInfo mPackageInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setupUI();        // 设置UI
        checkVersion();   // 检测新版本
    }
    // 设置UI
    private  void  setupUI(){
        mVersionTextView = (TextView) findViewById(R.id.tv_version);
        System.out.println("get version = " + getPackageInfo().versionName);
        mVersionTextView.setText("版本号:"+ getPackageInfo().versionName);
    }

    // 检测版本(使用HttpURLConnection)
    private void  checkVersion(){
        new Thread(){
            @Override
            public void run() {
                try {
                    URL url = new URL("http://192.168.0.117:8999/");

                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                    // connection.setConnectTimeout(5000);  // 设置请求超时
                    // 请求方式
                    //connection.setRequestMethod("GET");
                    System.out.println("responsed code :" + connection.getResponseCode());
                    if (connection.getResponseCode() == 200){

                        InputStream inputStream = connection.getInputStream();
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        byte [] buffer = new  byte[1024];
                        int flag = -1;
                        while ((flag = inputStream.read(buffer)) != -1){
                            baos.write(buffer,0,flag);
                        }
                        System.out.println(baos.toString());


                        Gson gson = new Gson();

                        Type mTpye = new TypeToken<Map<String,Object>>(){}.getType();
                        Map<String,Object> result = gson.fromJson(baos.toString(),mTpye);
                        System.out.println("resutl :" + result.toString());
                        baos.close();



                    }


                } catch (MalformedURLException e) {
                    Log.i("Splash","url error");

                    e.printStackTrace();
                }catch (IOException e){
                    Log.i("Splash","input stream error");

                    e.printStackTrace();
                }
            }
        }.start();
    }


    public PackageInfo getPackageInfo() {
        if (mPackageInfo == null){
            try {
                mPackageInfo = getPackageManager().getPackageInfo(getPackageName(),0);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        return mPackageInfo;
    }

}
