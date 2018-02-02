package com.joinf.www.moduleapp.activity;


import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

import com.joinf.www.moduleapp.R;
import com.joinf.www.moduleapp.view.fragment.HomeFragment;


public class HomeActivity extends BaseActivity {

    private HomeFragment mHomeFragment;
    private android.app.FragmentManager fm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_layout);

        // 初始化页面的所有控件
        initView();
        // 添加默认显示的fragment
//        mHomeFragment = new HomeFragment();
//        fm = getFragmentManager();
//        FragmentTransaction fragmentTransaction = fm.beginTransaction();
//        fragmentTransaction.add(R.id.content_linearLayout,mHomeFragment);
//        fragmentTransaction.commit();

        httpTest();



    }
    /** 初始化UI*/
    private void initView(){

    }

    /** 网络请求测试*/
    private void httpTest(){



    }


    public void showCamera(View v){



    }
}
