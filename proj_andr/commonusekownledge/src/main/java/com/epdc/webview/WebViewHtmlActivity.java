package com.epdc.webview;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import com.epdc.fragment.R;

/**
 *  WebView 加载HTML代码
 * Created by Epdc on 2015/9/11.
 */
public class WebViewHtmlActivity extends Activity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview_html);


        webView = (WebView) findViewById(R.id.wvHtml);
        //支持js代码
        webView.getSettings().setJavaScriptEnabled(true);

        String html = "<html><head><title>html代码</title><script type='text/javascript'>function clickMe(){alert('你好');}</script></head><body><button onclick='clickMe()'>按钮</button></body></html>";


        //第一个参数，HTML的路径，没有路径可以指定其他的
        webView.loadDataWithBaseURL("HTML代码",html,"text/html","UTF-8",null);
//        webView.loadData();好像对中文支持不好，没有测试过。

        //配置js引擎
        webView.setWebChromeClient(new WebChromeClient());
    }
}
