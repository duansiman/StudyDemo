package com.epdc.commonlib.utils;

import android.util.Log;

/**
 * Created by epdc on 2016/6/29.
 */
public class LogUtil {

    /**
     * Priority constant for the println method; use Log.v.
     */
    public static final int VERBOSE = 2;

    /**
     * Priority constant for the println method; use Log.d.
     */
    public static final int DEBUG = 3;

    /**
     * Priority constant for the println method; use Log.i.
     */
    public static final int INFO = 4;

    /**
     * Priority constant for the println method; use Log.w.
     */
    public static final int WARN = 5;

    /**
     * Priority constant for the println method; use Log.e.
     */
    public static final int ERROR = 6;

    /**
     * Priority constant for the println method.
     */
    public static final int ASSERT = 7;


    public static final String TAG = "epdc";
    public static final boolean isOpen = true;

    private LogUtil() {
    }

    public static void v(String msg) {
        Log.v(TAG, msg);
    }

    public static void v(String msg, Throwable tr) {
        Log.v(TAG, msg, tr);
    }

    public static void d(String msg) {
        Log.d(TAG, msg);
    }

    public static void d(String msg, Throwable tr) {
        Log.d(TAG, msg, tr);
    }
    
    public static void i(String msg) {
        Log.i(TAG, msg);
    }
    
    public static void i(String msg, Throwable tr) {
        Log.i(TAG, msg, tr);
    }

    public static void w(String msg) {
        Log.w(TAG, msg);
    }


    public static void w(String msg, Throwable tr) {
        Log.w(TAG, msg, tr);
    }


    public static void w(Throwable tr) {
        Log.w(TAG, tr);
    }


    public static void e(String msg) {
        Log.e(TAG, msg);
    }


    public static void e(String msg, Throwable tr) {
        Log.e(TAG, msg, tr);
    }

}
