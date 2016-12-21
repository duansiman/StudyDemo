package com.epdc.fourwidget.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.epdc.fourwidget.R;

/**
 * 测试service组件
 * Created by Epdc on 2015/8/16.
 */
public class StartServiceActivity extends ActionBarActivity implements View.OnClickListener, ServiceConnection {

    private static String TAG = StartServiceActivity.class.getName();


    private Button btnStartService, btnStopService, btnBindService, btnUnBindService,btnGetCurrentNum;
    private Intent intentService;

    private TestService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startservice);

        this.btnStartService = (Button) findViewById(R.id.btnStartService);
        this.btnStopService = (Button) findViewById(R.id.btnStopService);
        this.btnBindService = (Button) findViewById(R.id.btnBindService);
        this.btnUnBindService = (Button) findViewById(R.id.btnUnbindSerivce);
        this.btnGetCurrentNum = (Button) findViewById(R.id.btnGetCurrentNum);

        this.btnStartService.setOnClickListener(this);
        this.btnStopService.setOnClickListener(this);
        this.btnBindService.setOnClickListener(this);
        this.btnUnBindService.setOnClickListener(this);
        this.btnGetCurrentNum.setOnClickListener(this);

        this.intentService = new Intent(this, TestService.class);
    }



    /**
     * 为什么不直接new service对象？因为service是系统组件，是由系统创建和销毁的。所有要用以下两种方法启动服务。
     * 还有就是Service在系统只有一个实例对象，也就是只会执行一次onCreate方法
     * 1、启动service用startService和stopService方法
     * 这种方法启动service，即使Activity销毁，service也在运行中
     * 2、用bind启动Service
     * 这种方法启动Service，Activity销毁了，Service也会销毁
     * 3、同时用start和bind启动Service
     * onCreate方法只执行一次，关闭服务时需要调两个方法stop和unbind
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStartService:
                startService(intentService);
                break;
            case R.id.btnStopService:
                stopService(intentService);
                break;
            case R.id.btnBindService:
                bindService(intentService, this, Context.BIND_AUTO_CREATE);
                break;
            case R.id.btnUnbindSerivce:
                unbindService(this);
                break;
            case R.id.btnGetCurrentNum:
                Log.i(TAG, "当前数字是："+service.getCurrentNumber());
                break;
        }
    }

    /**
     * 这个方法作用：用来监听Service里面的状态，如果Service里onBind方法返回null，这个方法是不会调用的
     * 在onBind之后调用
     */
    @Override
    public void onServiceConnected(ComponentName name, IBinder binder) {
        Log.i(TAG, "connected");
        service = ((TestService.EchoIBinder) binder).getService();

    }

    /**
     * 这个方法是：Service崩溃时调用，一般用不到
     */
    @Override
    public void onServiceDisconnected(ComponentName name) {
        Log.i(TAG, "disconnected");
    }
}
