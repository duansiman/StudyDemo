package com.epdc.fourwidget.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

/**
 *  1、Service是一个无界面组件，用来与服务器交互。之所以用它，因为Activity生命周期短
 *  2、Service的生命周期只有onCreate和onDestroy
 *  3、用start启动Service调用onCreate和onDestroy方法
 *  4、用bind启动Service调用onCreate、onBind和onDestroy方法
 * Created by Epdc on 2015/8/16.
 */
public class TestService extends Service {

    private static String TAG = TestService.class.getName();
    private final EchoIBinder echoIBinder = new EchoIBinder();

    private Timer timer;
    private TimerTask task;
    private int i;

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind");
        return echoIBinder;
    }

    public class EchoIBinder extends Binder {
        public TestService getService(){
            return TestService.this;
        }
    }

    public int getCurrentNumber(){
        return i;
    }

    public void startTimer(){
        if(timer == null){
            timer = new Timer();
            task = new TimerTask() {
                @Override
                public void run() {
                  i++;
                  Log.i(TAG, ""+i);
                }
            };
            timer.schedule(task,1000,1000);
        }
    }

    public void closeTimer(){
        if (timer != null) {
            timer.cancel();
            timer = null;
            task = null;
        }
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate");
        startTimer();
    }

    /**
     * 每次调用startService都会调用onStartCommand方法，但第一次调用startService方法，
     *  onStartCommand在oncreate方法后调用，之后只调用onStartCommand方法而不调用oncreate方法。
     *
     *  @param intent 是activity传过来的携带数据intent对象
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "OnDestroy");
        closeTimer();
    }
}
