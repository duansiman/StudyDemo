package com.example.systeminfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.epdc.commonlib.utils.ActivityManagerUtil;
import com.epdc.commonlib.utils.LogUtil;

public class ActivityManagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_manager);

        LogUtil.d(String.valueOf(ActivityManagerUtil.getHeapSize(this)));
    }
}
