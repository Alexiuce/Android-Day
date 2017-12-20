package com.joinf.www.moduleapp.HttpTool;

import com.joinf.www.moduleapp.HttpTool.HttpRequestParams.RequestParams;

import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Request;

/**
 * Created by caijinzhu on 2017/12/20.
 *
 * 接收请求参数,生成Post Reques对象
 */

public class CommonRequest {

    // 生成post 请求
    public static Request createPostRequest(String url, RequestParams params){

        FormBody.Builder builder = new FormBody.Builder();
        if (params != null){
            for (Map.Entry<String,String> entry : params.urlParams.entrySet()){
                // 1. 遍历请求参数,添加到请求构件体中
                builder.add(entry.getKey(),entry.getValue());
            }
        }
        // 2. 通过请求构件体的build方法,获取真正的请求体对象
        FormBody formBody = builder.build();
        // 3. 返回Request 对象
        return new Request.Builder().url(url).post(formBody).build();
    }
    // 生成get 请求
    public static  Request createGetRequest(String url, RequestParams params){
        StringBuilder stringBuilder = new StringBuilder(url).append("?");
        if (params != null){
            for (Map.Entry<String,String> entry : params.urlParams.entrySet()){
                stringBuilder.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
        }
        return new Request.Builder().url(stringBuilder.substring(0,stringBuilder.length() -1)).get().build();

    }
}
