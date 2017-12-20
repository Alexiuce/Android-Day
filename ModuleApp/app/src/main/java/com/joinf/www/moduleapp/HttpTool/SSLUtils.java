package com.joinf.www.moduleapp.HttpTool;

import java.io.IOException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/**
 * Created by caijinzhu on 2017/12/20.
 */

public class SSLUtils {

    private static X509TrustManager mTrustManager;

    public static X509TrustManager getTrustManager(){
        if (mTrustManager == null){
            mTrustManager = new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {

                }

                @Override
                public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {

                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            };
        }
        return mTrustManager;
    }

    public static SSLSocketFactory getSSLSocketFactory(){
        // 1. 创建信任管理者
        X509TrustManager trustManager = getTrustManager();
        // 2. 创建ssl 上下文
        SSLContext sslContext = null;
        try {
            // 与服务器需要一致 : SSL 或TLS
            sslContext = sslContext.getInstance("SSL");
            X509TrustManager[] xTrustArray = new X509TrustManager[]{mTrustManager};
            sslContext.init(null,xTrustArray,new SecureRandom());

        }catch (Exception e){
            e.printStackTrace();
        }
        return  sslContext.getSocketFactory();
    }

}
