package com.joinf.www.mutilthreaddownloaddemo;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.joinf.www.mutilthreaddownloaddemo.DownloaderManager.Downloader;

public class MainActivity extends AppCompatActivity {


    private final int REQUEST_PERMISSION_CODE = 0x001;
    private String downloadURL = "http://sw.bos.baidu.com/sw-search-sp/software/c708b60c87c21/AliIM2017_taobao_9.11.05C.exe";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] requestPermissons = {Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE};


        if (Build.VERSION.SDK_INT > 23){
            Downloader.downloadFileOnURL(downloadURL);
        }else {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this,requestPermissons,REQUEST_PERMISSION_CODE);
            }else {
                Downloader.downloadFileOnURL(downloadURL);

            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case REQUEST_PERMISSION_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Downloader.downloadFileOnURL(downloadURL);
                }else {

                }
                break;
        }
    }
}
