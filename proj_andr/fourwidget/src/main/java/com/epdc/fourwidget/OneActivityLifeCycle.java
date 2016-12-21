package com.epdc.fourwidget;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

/**
 * 测试单个Activity生命周期
 * Created by Epdc on 2015/8/15.
 */
public class OneActivityLifeCycle extends Activity {

    private static final String TAG = "MyLog";

    /**
     * onCreate onStart onResume这三个方法是创建activity到完全显示出来调用的
     * 注：改变手机横竖屏时，调用onPause、onStop和onDestroy。并调用onCrate、onStart和onResume方法重新创建activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oneactivitylifecycle);
        Log.i(TAG, "onCreate");
        if (savedInstanceState!=null) {
            Log.d(TAG, savedInstanceState.getString("key"));
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    /**
     * 从暂停状态，重新显示最前面
     */
    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    /**
     * 其他activity出现前面时，且还可见
     * 调用这个方法  表示activity是暂停状态
     * 注：
     *      1、按手机home键，调用onPause和onStop方法
     *      2、按手机返回键，调用onPause、onStop和onDestroy方法
     */
    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    /**
     * 从停止状态，重新显示最前面，并且调用onStart和onResume方法
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }

    /**
     * 其他activity出现前面时，且还不可见
     * 调用这个方法  表示activity是停止状态
     */
    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("key", "value");
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.i(TAG, "onSaveInstanceState persistable");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "onRestoreInstanceState");
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);
        Log.i(TAG, "onRestoreInstanceState persistable");
    }
}
