package com.joinf.www.moduleapp.HttpTool;

/**
 * Created by caijinzhu on 2017/12/20.
 # 自定义的事件监听
 */


public interface HttpListener {

    // 请求成功回调
    void onSuccess(Object response);
    // 请求失败回调
    void onFailure(Object response);
}
