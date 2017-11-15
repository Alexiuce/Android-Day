package com.example.caijinzhu.mobilesafeguard;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    private TextView mVersionTextView;


    private PackageInfo mPackageInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        setupUI();

    }
    private  void  setupUI(){
        mVersionTextView = (TextView) findViewById(R.id.tv_version);

        System.out.println("get version = " + getPackageInfo().versionName);
        mVersionTextView.setText("版本号:"+ getPackageInfo().versionName);


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
