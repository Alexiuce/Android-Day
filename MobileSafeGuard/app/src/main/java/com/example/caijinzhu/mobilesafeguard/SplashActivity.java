package com.example.caijinzhu.mobilesafeguard;

import android.app.Application;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.BulletSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SplashActivity extends AppCompatActivity {

    private TextView mVersionTextView;
    private PackageInfo mPackageInfo;
    private String mDownloadURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setupUI();        // 设置UI
      //  checkVersion();   // 检测新版本 HttpURLConnect 请求网络
        checkNewVersion();  // 检测新版本 OKHttp 请求网络
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

    // 检测新版本: 使用OKHttp发送网络请求
    private  void checkNewVersion(){
        String url = "http://192.168.0.117:8088/newVersion";
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();

                System.out.println("network error ");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                // 网络请求失败,进入home页面
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        enterHome();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                Type mTpye = new TypeToken<Map<String,Object>>(){}.getType();
                Map responseMap = gson.fromJson(response.body().string(),mTpye);
                System.out.println(responseMap);
                Double versionCode =  (Double) responseMap.get("versionCode");
                final String updateMsg = (String) responseMap.get("updateMessage");
                mDownloadURL = (String) responseMap.get("downloadUrl");
                if (versionCode.intValue() > mPackageInfo.versionCode) {  // 有新版本 ,提示更新
                    System.out.println("need update version");
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                           showUpdateDialog(updateMsg);
                        }
                    });
                }else { // 进行home 页面
                    System.out.println("enter home activity");
                }
            }
        });
    }

    /*显示更新提示对话框*/
    private void  showUpdateDialog(String msg){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // 禁用点击背景取消
        builder.setCancelable(false);
        // 设置左上角图标
        builder.setIcon(R.mipmap.ic_launcher);
        // 设置标题
        builder.setTitle("update message");
        // 设置更新提示
        builder.setMessage(msg);
        // 设置确定按钮
        builder.setPositiveButton("update", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 下载新版本,更新
                downloadApk();

            }
        });
        // 设置取消按钮
        builder.setNegativeButton("later", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 取消更新,关闭提示对话框,进入home页面
                enterHome();
            }
        });


        builder.show();
    }

    /* 进入Home 页面*/
    private void enterHome(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    /* 获取app 包信息 */
    private PackageInfo getPackageInfo() {
        if (mPackageInfo == null){
            try {
                mPackageInfo = getPackageManager().getPackageInfo(getPackageName(),0);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        return mPackageInfo;
    }

    /* 下载更新的apk文件 */
    private  void downloadApk(){
        // 1. 检测SD卡是否可用
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){ // sd卡可用
          String filepath =  Environment.getExternalStorageDirectory().getAbsolutePath() ;
          String filename = "mobileSafe.apk";

            DownloadHelper downloadHelper = new DownloadHelper(mDownloadURL, filepath, filename);
            downloadHelper.startDownload(new DownloadHelper.DownloadHelperListener() {
                @Override
                public void onDownloadSuccess(File file) {
                    System.out.println("下载成功");
                    installNewApk(file);
                }

                @Override
                public void onDownloadFailed(Exception error) {
                    System.out.println("下载失败");
                    error.printStackTrace();
                }

                @Override
                public void onDownloadProgress(int progress) {

                }
            });


        }
    }

    /** 安装新版本apk*/
    private void installNewApk(File apkfile){
        // 开启隐式意图,调用系统应用安装
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.setDataAndType(Uri.fromFile(apkfile), "application/vnd.android.package-archive");

        startActivity(intent);

    }

}
