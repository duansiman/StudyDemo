package com.epdc.webview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageButton;

import com.epdc.fragment.R;

/**
 *  WebView
 * Created by Epdc on 2015/9/11.
 */
public class WebViewActivity extends Activity implements MenuItem.OnMenuItemClickListener {

    private ImageButton search;
    private EditText etUrl;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);


        search = (ImageButton) findViewById(R.id.ibBrowse);
        etUrl = (EditText) findViewById(R.id.etAddress);
        webView = (WebView) findViewById(R.id.webView);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = etUrl.getText().toString();

                System.out.println(url);

                if(URLUtil.isNetworkUrl(url)) {
                    //加载网页
                    webView.loadUrl(url);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem miBack = menu.add(0, 0, 0, "向后（back）");
        MenuItem miForward = menu.add(0, 1, 1, "向前（Forward）");
        miBack.setOnMenuItemClickListener(this);
        miForward.setOnMenuItemClickListener(this);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId())
        {
            // 向后（back）
            case 0:
                webView.goBack();
                break;
            // 向前（Forward）
            case 1:
                webView.goForward();
                break;
        }

        return false;
    }
}
