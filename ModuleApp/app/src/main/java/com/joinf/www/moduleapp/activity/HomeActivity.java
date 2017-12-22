package com.joinf.www.moduleapp.activity;


import android.app.FragmentTransaction;
import android.os.Bundle;

import com.joinf.www.moduleapp.HttpTool.CommonRequest;
import com.joinf.www.moduleapp.HttpTool.CommontClient;
import com.joinf.www.moduleapp.HttpTool.HttpCallback.CommonJsonCallback;
import com.joinf.www.moduleapp.HttpTool.HttpDataHandler;
import com.joinf.www.moduleapp.HttpTool.HttpException;
import com.joinf.www.moduleapp.HttpTool.HttpListener;
import com.joinf.www.moduleapp.R;
import com.joinf.www.moduleapp.view.fragment.HomeFragment;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

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
        mHomeFragment = new HomeFragment();
        fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.add(R.id.content_linearLayout,mHomeFragment);
        fragmentTransaction.commit();

        httpTest();

    }
    /** 初始化UI*/
    private void initView(){

    }

    /** 网络请求测试*/
    private void httpTest(){

        CommontClient.sendRequest(CommonRequest.createGetRequest("https://httpbin.org/get",null), new CommonJsonCallback(new HttpDataHandler(new HttpListener() {
            @Override
            public void onSuccess(Object response) {
                System.out.println("server response :" + response.toString());
            }

            @Override
            public void onFailure(Object response) {
                System.out.println("sever error");
            }
        })));

    }
}
