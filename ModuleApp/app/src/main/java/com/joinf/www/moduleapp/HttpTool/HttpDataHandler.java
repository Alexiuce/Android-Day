package com.joinf.www.moduleapp.HttpTool;

/**
 * Created by caijinzhu on 2017/12/20.
 */

public class HttpDataHandler {
    public HttpListener mListener = null;
    public Class<?> mClass = null;

    public HttpDataHandler(HttpListener listener){
        this.mListener = listener;
    }

    public HttpDataHandler(HttpListener listener,Class<?> clazz){
        this.mListener = listener;
        this.mClass = clazz;
    }

}

