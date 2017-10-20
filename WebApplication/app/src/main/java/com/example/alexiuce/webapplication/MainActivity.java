package com.example.alexiuce.webapplication;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.KeyEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.alexiuce.webapplication.StringTools.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    private Handler mHandle = new Handler(){
        @Override
        public void handleMessage(Message msg) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.wv_homeWebView);
        webView.getSettings().setJavaScriptEnabled(true);   // 开启js功能
        // 防止使用系统浏览器打开url
        webView.setWebViewClient(new WebViewClient() {
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
//                return super.shouldOverrideUrlLoading(view, request);
//            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                System.out.println(url);
                view.loadUrl(url);
                return true;
//                returna super.shouldOverrideUrlLoading(view, url);
            }

            // 页面开始加载
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                System.out.println("start load web page");
            }
            // 页面完成加载

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                System.out.println("finished loading");
            }
        });
        // 加载url
        webView.loadUrl("http://www.baidu.com");

        loadNetData();


    }

    //    加载网络数据
    private void loadNetData() {
// 开启子线程
        new Thread() {
            @Override
            public void run() {
                try {
                    URL url = new URL("https://m.baidu.com/?from=844b&vit=fps");

                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setConnectTimeout(5000);   // 请求超时
                    System.out.println("res::" + conn.getResponseCode());

                    if (conn.getResponseCode() == 200) {
                        InputStream inputStream = conn.getInputStream();

                        String result = StringUtils.streamToString(inputStream);
                        System.out.println(result);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();


    }


    // 回退键事件处理
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (webView.canGoBack()) {
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
