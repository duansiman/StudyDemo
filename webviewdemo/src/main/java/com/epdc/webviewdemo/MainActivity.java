package com.epdc.webviewdemo;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class MainActivity extends Activity {

    private static final String URL = "http://guanjia.weijuju.com/";
    private WebView webView;
    private ActionBar actionBar;
    private TextView errorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionBar = getActionBar();
        webView = (WebView) findViewById(R.id.webview);
        errorView = (TextView) findViewById(R.id.errorView);
        initWebView();
    }

    private void initWebView() {
        //设置WebViewClient，让WebView打开网页，否则会让系统默认浏览器打开。
        //WebViewClient帮助WebView处理各种通知、请求事件
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
                //加载本地错误页面
                view.loadUrl("file:///android_asset/error.html");
                //在这使用控件显示错误也可以
                //errorView.setText("404 错误");
                //view.setVisibility(View.GONE);
            }
        });
        //设置WebChromeClient，处理Javascript的对话框、网站图标、网站title、加载进度等
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {
                //截取网页标题
                actionBar.setTitle(title);
                super.onReceivedTitle(view, title);
            }
        });
        //设置下载监听
        webView.setDownloadListener(new DownloadListener() {
            /**
             * @param url http://7xo0ym.dl1.z0.glb.clouddn.com/@/android/HuaerWeiguanjia_v1.2.apk
             * @param userAgent Mozilla/5.0 (Linux; Android 5.1; Google Nexus 10 - 5.1.0 - API 22 - 2560x1600 Build/LMY47D) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/39.0.0.0 Mobile Safari/537.36
             * @param contentDisposition attachment; filename="HuaerWeiguanjia_v1.2.apk"
             * @param mimetype application/vnd.android.package-archive
             * @param contentLength 11833449
             */
            @Override
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
                System.out.println("download");
                //new Thread(new DownloadThread(url)).start();
                //用系统浏览器去下载
                Uri uri = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        webView.loadUrl(URL);
    }


}
