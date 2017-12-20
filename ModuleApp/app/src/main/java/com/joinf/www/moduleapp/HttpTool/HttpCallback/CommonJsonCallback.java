package com.joinf.www.moduleapp.HttpTool.HttpCallback;


import android.os.Handler;
import android.os.Looper;

import com.joinf.www.moduleapp.HttpTool.HttpDataHandler;
import com.joinf.www.moduleapp.HttpTool.HttpListener;

import java.io.IOException;

import java.util.logging.LogRecord;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by caijinzhu on 2017/12/20.
 */

public class CommonJsonCallback implements okhttp3.Callback {

    protected final String RESULT_CODE = "ecode";
    protected final int RESULT_CODE_VALUE = 0;
    protected final String ERROR_MSG = "emsg";
    protected final String EMPTY_MSG = "";

    protected final int NETWORK_ERROR = -1;
    protected final int JSON_ERROR = -2;
    protected final int OTHER_ERROR = -3;

    private Handler mDeliveryHandler;     // 消息转发
    private Class<?> mClass;
    private HttpListener mListener;


    public CommonJsonCallback(HttpDataHandler handler){
        this.mClass = handler.mClass;
        this.mListener = handler.mListener;
        this.mDeliveryHandler = new Handler(Looper.getMainLooper());
    }


    // 请求失败处理
    @Override
    public void onFailure(Call call, IOException e) {
        mDeliveryHandler.post(new Runnable() {
            @Override
            public void run() {
                mListener.on
            }
        });

    }
    // 请求成功处理
    @Override
    public void onResponse(Call call, Response response) throws IOException {

    }
}
