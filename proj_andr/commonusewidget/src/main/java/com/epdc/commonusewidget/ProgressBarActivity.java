package com.epdc.commonusewidget;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.epdc.commonusekownledge.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 进度条
 * Created by Epdc on 2015/8/26.
 */
public class ProgressBarActivity extends Activity {

    private ProgressBar pb;
    private Timer timer;
    private TimerTask task;
    private int progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progressbar);

        pb = (ProgressBar) findViewById(R.id.pb);
        //设置最大值
        pb.setMax(100);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (timer == null) {
            timer = new Timer();
            task = new TimerTask() {
                @Override
                public void run() {
                    progress += 1;
                    //设置当前进度值
                    pb.setProgress(progress);
                }
            };
            timer.schedule(task,1000,100);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (timer != null) {
            task.cancel();
            timer.cancel();
            task = null;
            timer = null;
        }
    }
}
