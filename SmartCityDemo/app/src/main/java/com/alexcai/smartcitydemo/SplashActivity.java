package com.alexcai.smartcitydemo;

import android.animation.StateListAnimator;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_layout);
       ConstraintLayout layout = (ConstraintLayout)findViewById(R.id.constraintLayout_splash);

        /**添加动画效果*/
        beginAnimation(layout);
    }

    /** 动画*/
    private void beginAnimation(View v) {

        // 旋转
        RotateAnimation rotateAnimation = new RotateAnimation(0,
                360,
                Animation.RELATIVE_TO_SELF,
                0.5f,Animation.RELATIVE_TO_SELF,
                0.5f);
        rotateAnimation.setDuration(1000);  // 设置动画时间 1秒
        rotateAnimation.setFillAfter(true); // 保持动画结束状态

        // 缩放
        ScaleAnimation scaleAnimation = new ScaleAnimation(0,1,0,1,
                Animation.RELATIVE_TO_SELF,
                0.5f,
                Animation.RELATIVE_TO_SELF,
                0.5f);
        scaleAnimation.setDuration(1000);
        scaleAnimation.setFillAfter(true);

        // 渐变
        AlphaAnimation alphaAnimation = new AlphaAnimation(0,1);
        alphaAnimation.setDuration(2000);
        alphaAnimation.setFillAfter(true);

        // 添加动画到动画集合中
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(rotateAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);
        // 设置动画状态监听
        animationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                System.out.println("动画结束");

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        // 添加动画集合到控件,并启动

        v.startAnimation(animationSet);


    }
}
