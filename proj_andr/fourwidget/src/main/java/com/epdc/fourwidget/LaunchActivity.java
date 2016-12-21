package com.epdc.fourwidget;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

import java.io.File;

/**
 * Created by Epdc on 2015/8/17.
 */
public class LaunchActivity extends ActionBarActivity {

    private Button btnLaunchByIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        btnLaunchByIntent = (Button) findViewById(R.id.btnLaunchByIntent);

        btnLaunchByIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1、通过组件名字启动，即显式Intent
//                Intent i = new Intent();
//                i.setComponent(new ComponentName("com.epdc.fourwidget", "com.epdc.fourwidget.IntentAndIntentFilter"));

                //2、通过Action启动，即隐式Intent
                Intent i = new Intent();
                i.setAction("com.epdc.fourwidget.intent.action.Intent");
                startActivity(i);
            }
        });

        findViewById(R.id.btnOpenImage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                //打开系统浏览图片应用程序
                i.setAction(Intent.ACTION_VIEW);
                File file = new File("/mnt/sdcard/happy.jpg");
                i.setDataAndType(Uri.fromFile(file), "image/*");
                startActivity(i);
            }
        });

        findViewById(R.id.btnCall).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                //打开系统打电话程序
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse("tel:10086"));
                startActivity(i);
            }
        });

        findViewById(R.id.btnOpenBrower).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                //打开系统浏览器程序
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse("http://www.baidu.com"));
                startActivity(i);
            }
        });
    }
}
