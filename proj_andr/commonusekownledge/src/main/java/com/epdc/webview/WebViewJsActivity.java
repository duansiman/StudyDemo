package com.epdc.webview;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

import com.epdc.fragment.R;

import java.io.InputStream;


/**
 *  Js调用
 * Created by Epdc on 2015/9/11.
 */
public class WebViewJsActivity extends Activity {

    private Button button;
    private WebView webView;

    private String startRandomMoveJavascript;
    private String stopRandomMoveJavascript;

    private Handler moveHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int x = msg.arg1;
            int y = msg.arg2;

            button.layout(x, y, button.getMeasuredWidth() + x,
                    button.getMeasuredHeight() + y);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview_js);

        button = (Button) findViewById(R.id.button);
        webView = new WebView(this);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        //这个地方是异步处理，所有里面不能处理控件
        webView.addJavascriptInterface(new Object(){

            public void move(int x, int y){
                Message msg = new Message();
                msg.arg1 = x;
                msg.arg2 = y;
                moveHandler.sendMessage(msg);
            }
        },"demo");

        // 读javascript代码
        InputStream is = getResources()
                .openRawResource(R.raw.start_random_move);
        byte[] buffer = new byte[1024];
        try
        {
            int count = is.read(buffer);
            startRandomMoveJavascript = new String(buffer, 0, count, "utf-8");

        }
        catch (Exception e)
        {
        }
        is = getResources().openRawResource(R.raw.stop_random_move);
        buffer = new byte[1024];
        try
        {
            int count = is.read(buffer);
            stopRandomMoveJavascript = new String(buffer, 0, count, "utf-8");

        }
        catch (Exception e)
        {
        }
    }

    public void move(View v){
        webView.loadDataWithBaseURL(null, startRandomMoveJavascript,
                "text/html", "utf-8", null);
    }

    public void stop(View v){
        webView.loadDataWithBaseURL(null, stopRandomMoveJavascript,
                "text/html", "utf-8", null);
    }
}
