package com.joinf.www.moduleapp.HttpTool.HttpCallback;


import android.os.Handler;
import android.os.Looper;

import com.joinf.www.moduleapp.HttpTool.HttpDataHandler;
import com.joinf.www.moduleapp.HttpTool.HttpException;
import com.joinf.www.moduleapp.HttpTool.HttpListener;

import org.json.JSONObject;

import java.io.IOException;



import okhttp3.Call;
import okhttp3.Response;
import okhttp3.Callback;

/**
 * Created by caijinzhu on 2017/12/20.
 */

public class CommonJsonCallback implements Callback {

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
    public void onFailure(Call call, final IOException e) {
        mDeliveryHandler.post(new Runnable() {
            @Override
            public void run() {
                mListener.onFailure(new HttpException(NETWORK_ERROR,e));
            }
        });

    }
    // 请求成功处理
    @Override
    public void onResponse(Call call, final Response response) throws IOException {

        final String result = response.body().string();
        mDeliveryHandler.post(new Runnable() {
            @Override
            public void run() {
                handleResponse(result);
            }
        });

    }

    /** 处理服务器返回的响应数据*/
    private void handleResponse(Object responseObj){
        if (responseObj == null || responseObj.toString().trim().equals("")){
            mListener.onFailure(new HttpException(NETWORK_ERROR,EMPTY_MSG));
            return;
        }
        mListener.onSuccess(responseObj);
        return;

//        try {
//
//            JSONObject resultJson = new JSONObject(responseObj.toString());
//            if (resultJson.has(RESULT_CODE)){
//                // 从json对象中取出响应码,若为0,则表示正确响应
//                if (resultJson.getInt(RESULT_CODE) == RESULT_CODE_VALUE){
//                    if (mClass == null){
//                        mListener.onSuccess(responseObj);
//                    }else {
//                        // 需要将json 对象转换为实体对象
//                        Object obj = ResponseObjFromJson.parseJsonToObject(resultJson,mClass);
//                        if (obj != null){
//                            mListener.onSuccess(obj);
//                        }else {
//                            // 服务器返回的json不合法
//                            mListener.onFailure(new HttpException(JSON_ERROR,EMPTY_MSG));
//                        }
//                    }
//                }
//            }else {
//                // 将服务器返回的异常回调到应用去处理
//                mListener.onFailure(new HttpException(OTHER_ERROR,resultJson.get(RESULT_CODE)));
//            }
//
//        }catch (Exception e){
//            mListener.onFailure(new HttpException(OTHER_ERROR,e.getMessage()));
//        }

    }
}
