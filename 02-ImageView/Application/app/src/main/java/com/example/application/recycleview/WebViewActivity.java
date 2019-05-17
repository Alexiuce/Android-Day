package com.example.application.recycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.example.application.R;

public class WebViewActivity extends AppCompatActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        mWebView = findViewById(R.id.web_1);
        // 加载本地html
//        loadLoadHtml();
        // 加载远程html
        loadRemoteHtml();
    }

    private void loadRemoteHtml() {
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl("https://m.baidu.com");
    }

    private void loadLoadHtml() {
        mWebView.loadUrl("file:///android_asset/hello.html");
    }
}
