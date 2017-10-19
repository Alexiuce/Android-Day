package com.example.alexiuce.webapplication;

import android.graphics.Bitmap;
import android.support.v4.view.KeyEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.wv_homeWebView);
        // 防止使用系统浏览器打开url
        webView.setWebViewClient(new WebViewClient(){
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
//                return super.shouldOverrideUrlLoading(view, request);
//            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                System.out.println(url);
                view.loadUrl(url);
                return true;
//                return super.shouldOverrideUrlLoading(view, url);
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


    }


    // 回退键事件处理
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (webView.canGoBack()){
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
