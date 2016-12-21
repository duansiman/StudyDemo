package com.epdc.commonusewidget;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.epdc.commonusekownledge.R;

/**
 * 任务栏通知
 * Created by Epdc on 2015/8/28.
 */
public class NotificationActivity extends Activity{

    //通知管理器
    private NotificationManager nm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        //取消通知
        nm.cancel(R.layout.activity_notification);

        findViewById(R.id.btnSendNotification).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //通知用户时，显示的图标，内容
                Notification n = new Notification(R.mipmap.ic_launcher,"ticker",System.currentTimeMillis());
                //打开任务栏，是看到的信息,PendingIntent延时Intent
                n.setLatestEventInfo(NotificationActivity.this,"title","content", PendingIntent.getActivity(NotificationActivity.this,0,getIntent(),0));

                //第一个参数 id  唯一的
                nm.notify(R.layout.activity_notification,n);
            }
        });
    }
}
