package com.epdc.fourwidget;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Epdc on 2015/8/16.
 */
public class SendBroadcastReceiver extends ActionBarActivity implements View.OnClickListener {
    private Button btnSendBroadcast,btnRegisterBroadcast,btnUnregisterBroadcast;

    private TestBroadcastReceiver broadcastReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sendbroadcastreceiver);

        this.btnSendBroadcast = (Button) findViewById(R.id.btnSendBroadcast);
        btnRegisterBroadcast = (Button) findViewById(R.id.btnRegisterBroadcast);
        btnUnregisterBroadcast = (Button) findViewById(R.id.btnUnregisterBroadcast);
        broadcastReceiver = new TestBroadcastReceiver();

        this.btnSendBroadcast.setOnClickListener(this);
        btnRegisterBroadcast.setOnClickListener(this);
        btnUnregisterBroadcast.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSendBroadcast:
//                Intent intent = new Intent(this, TestBroadcastReceiver.class);
                Intent intent = new Intent(TestBroadcastReceiver.ACTION);
                intent.putExtra("value", "hello broadcast");
                sendBroadcast(intent);
                break;
            /**
             * 动态注册广播
             */
            case R.id.btnRegisterBroadcast:
                IntentFilter intentFilter = new IntentFilter(TestBroadcastReceiver.ACTION);
                intentFilter.setPriority(200);
                registerReceiver(broadcastReceiver, intentFilter);
                break;
            case R.id.btnUnregisterBroadcast:
                unregisterReceiver(broadcastReceiver);
                break;
        }
    }
}
