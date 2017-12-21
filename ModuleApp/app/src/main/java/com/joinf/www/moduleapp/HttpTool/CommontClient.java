package com.joinf.www.moduleapp.HttpTool;

import com.joinf.www.moduleapp.HttpTool.HttpCallback.CommonJsonCallback;

import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;

import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by caijinzhu on 2017/12/20.
 * 复杂请求的发送
 * 请求参数的配置
 * https的支持
 *
 */

public class CommontClient {
    private static final int TIME_OUT = 30;     // 默认超时时间

    private static OkHttpClient mHttpClient;

    // 给client 配置参数
    static {
        // 创建构件者
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        // 设置超时时间
        clientBuilder.connectTimeout(TIME_OUT, TimeUnit.SECONDS);
        clientBuilder.readTimeout(TIME_OUT,TimeUnit.SECONDS);
        clientBuilder.writeTimeout(TIME_OUT,TimeUnit.SECONDS);

        clientBuilder.followRedirects(true);  // 开启支持url重定向

        // https 支持
//        clientBuilder.hostnameVerifier(new HostnameVerifier() {
//            @Override
//            public boolean verify(String hostname, SSLSession session) {
//                return true;   // 信任任意类型的主机名称
//            }
//        });

//        clientBuilder.sslSocketFactory(SSLUtils.getSSLSocketFactory(),SSLUtils.getTrustManager());

        // 生成 client 对象
        mHttpClient = clientBuilder.build();
    }

    /** 发送http / https 请求
     * */
    public static Call sendRequest(Request request, CommonJsonCallback callback){

        Call call = mHttpClient.newCall(request);
        call.enqueue(callback);
        return call;
    }

}
