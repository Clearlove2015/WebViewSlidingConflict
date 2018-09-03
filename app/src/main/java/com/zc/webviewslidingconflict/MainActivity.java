package com.zc.webviewslidingconflict;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.zc.webviewslidingconflict.view.MyWebView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.webview)
    MyWebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initWebView();
    }

    public void initWebView(){
        WebSettings settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);//支持JavaScript
        webview.loadUrl("http://www.feng-go.com/mobile?app=ios");
        webview.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);//不调用系统浏览器而在当前应用加载网页
                return true;
            }
        });
    }

}
