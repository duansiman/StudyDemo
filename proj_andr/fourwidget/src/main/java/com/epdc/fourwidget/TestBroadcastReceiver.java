package com.epdc.fourwidget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 *  广播，应用程序之间通信。主要特点：通信数据量少、通信频率低
 * Created by Epdc on 2015/8/16.
 */
public class TestBroadcastReceiver extends BroadcastReceiver
{
    private static String TAG = TestBroadcastReceiver.class.getName();
    public  static final String ACTION = "com.epdc.intent.action.MyBroadcast";


    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "onReceive,data=" + intent.getStringExtra("value"));
    }
}
