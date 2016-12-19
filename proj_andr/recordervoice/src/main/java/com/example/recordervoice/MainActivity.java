package com.example.recordervoice;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

/**
 * Created by epdc on 2016/5/19.
 */
public class MainActivity extends AppCompatActivity {

    String tag = "epdc";

    Button btnSay;
    ImageView imageSay;
    TextView textUpCancel;

    Context context;
    GestureDetector gestureDetector;
    RecorderVoiceUtil.OnRecorderListener recorderListener;
    boolean isCancel;
    private RecorderTask recorderTask;
    private Timer recorderTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        btnSay = (Button) findViewById(R.id.btn_say);
        imageSay = (ImageView) findViewById(R.id.image_say);
        textUpCancel = (TextView) findViewById(R.id.text_up_cancel);

        recorderListener = new RecorderVoiceUtil.SimpleRecorderListener(){
            @Override
            public void onPermissionError() {
                super.onPermissionError();
                Toast.makeText(context, "没有录音权限", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onReachMax(String outputPath, int maxDurationMs) {
                super.onReachMax(outputPath, maxDurationMs);
                cancelRecorder();
            }

            @Override
            public void onError() {
                super.onError();
                cancelRecorder();
            }
        };


        gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                Log.i(tag, "onScroll distanceY:"+distanceY);
                if (distanceY >= 10) {
                    btnSay.setText(R.string.up_finger_finish);
                    textUpCancel.setVisibility(View.GONE);
                    imageSay.setImageResource(R.drawable.mic_cancel);
                    //线程没有结束，只是不让更新界面
                    recorderTask.setCancel(true);
                    isCancel = true;
                }

                if (distanceY <= -10) {
                    btnSay.setText(R.string.up_finish);
                    textUpCancel.setVisibility(View.VISIBLE);
                    imageSay.setImageResource(R.drawable.mic_1);
                    recorderTask.setCancel(false);
                    isCancel = false;
                }
                return true;
            }

            @Override
            public boolean onDown(MotionEvent e) {
                Log.i(tag, "onDown");
                startRecorder();
                return true;
            }
        });


        btnSay.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                boolean flag = gestureDetector.onTouchEvent(event);
                if (flag) {
                    return true;
                }

                switch (event.getAction()) {
                    case MotionEvent.ACTION_UP:
                        flag = true;
                        stopRecorder();
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        cancelRecorder();
                        flag = true;
                        break;
                }

                return flag;
            }
        });
    }

    private void startRecorder() {
        btnSay.setSelected(true);
        btnSay.setText(R.string.up_finish);
        textUpCancel.setVisibility(View.VISIBLE);
        imageSay.setVisibility(View.VISIBLE);

        String filename = "recordvoice" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".mp3";
        RecorderVoiceUtil.startRecorder(FileUtil.getPathOfMusic(context, filename), 60 * 1000, recorderListener);

        recorderTime = new Timer();
        recorderTask = new RecorderTask(this, imageSay);
        recorderTime.schedule(recorderTask, 0, 200);
    }

    private void stopRecorder(){
        btnSay.setSelected(false);
        btnSay.setText(R.string.pressed_say);
        textUpCancel.setVisibility(View.GONE);
        imageSay.setVisibility(View.GONE);

        recorderTask.setCancel(true);
        recorderTime.cancel();

        if (isCancel) {
            Log.i(tag, "up 取消录音");
            RecorderVoiceUtil.cancelRecorder();
        } else {
            RecorderVoiceUtil.stopRecorder();
        }
    }

    private void cancelRecorder(){
        Log.i(tag, "cancel 取消录音");
        btnSay.setSelected(false);
        textUpCancel.setVisibility(View.GONE);
        imageSay.setVisibility(View.GONE);
        btnSay.setText(R.string.pressed_say);

        recorderTask.setCancel(true);
        recorderTime.cancel();
    }
}
