package com.alexcai.smartcitydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_layout);

        /**添加动画效果*/
        beginAnimation();
    }

    /** 动画*/
    private void beginAnimation() {
        RotateAnimation rotateAnimation = new RotateAnimation(0,
                360,
                Animation.RELATIVE_TO_SELF,
                0.5f,Animation.RELATIVE_TO_SELF,
                0.5f);
        rotateAnimation.setDuration(1000);  // 设置动画时间 1秒
        rotateAnimation.setFillAfter(true); // 保持动画结束状态

    }
}
