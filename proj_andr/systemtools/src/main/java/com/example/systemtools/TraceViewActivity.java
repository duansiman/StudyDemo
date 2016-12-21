package com.example.systemtools;

import android.os.Bundle;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;

import com.epdc.commonlib.utils.LogUtil;

/**
 *  TraceView  app性能测试工具,会把日志文件写到sd卡上，需要添加权限
 */

public class TraceViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Debug.startMethodTracing();
    }

    @Override
    protected void onResume() {
        super.onResume();
        for (int i = 0; i < 1000; i++) {
            LogUtil.d(i+"_" + i);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Debug.stopMethodTracing();
    }
}
