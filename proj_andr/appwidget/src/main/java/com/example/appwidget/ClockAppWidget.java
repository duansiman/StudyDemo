package com.example.appwidget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.RemoteViews;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by epdc on 2016/5/22.
 */
public class ClockAppWidget extends AppWidgetProvider {

    @Override
    public void onUpdate(final Context context, final AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);

        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.layout_clock);

//                remoteViews.setRemoteAdapter();

                remoteViews.setTextViewText(R.id.text_clock, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                //将remoteviews添加到ComponentName中
                appWidgetManager.updateAppWidget(new ComponentName(context, ClockAppWidget.class), remoteViews);

            }
        };

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0x11);
                }
        }, 0, 1000);

    }
}
