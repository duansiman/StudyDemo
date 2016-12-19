package com.epdc.resource.animation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.epdc.resource.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 蝴蝶飞舞
 */
public class ButterActivity extends AppCompatActivity {

    float curX = 0, curY = 30;
    float nextX = 0, nextY = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butter);

        final ImageView butter = (ImageView) findViewById(R.id.butter);

        AnimationDrawable animationDrawable = (AnimationDrawable) butter.getBackground();
        animationDrawable.start();

        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (curX > 320) {
                    curX = nextX = 0;
                } else {
                    nextX += 8;
                }

                nextY = (float) (curY + Math.random() * 10 -5);
                TranslateAnimation animation = new TranslateAnimation(curX, nextX, curY, nextY);
                animation.setDuration(200);
                curX = nextX;
                curY = nextY;
                butter.startAnimation(animation);
            }
        };
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
            }
        }, 0, 200);
    }
}
