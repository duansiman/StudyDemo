package com.epdc.media;

import android.media.MediaRecorder;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import java.io.File;
import java.io.IOException;

/**
 * 录制视频
 */
public class VideoActivity extends AppCompatActivity {

    private SurfaceView surfaceView;
    //视频文件
    private File videoFile;
    private MediaRecorder mediaRecorder;

    private boolean isRecording;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        surfaceView = (SurfaceView) findViewById(R.id.surfaceView);

        //不需要自己维护的缓存区
        surfaceView.getHolder().setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        //设置分辨率
        surfaceView.getHolder().setFixedSize(320, 480);
        //设置组件让屏幕不会自动关闭
        surfaceView.getHolder().setKeepScreenOn(true);

        setValue();
    }

    private void setValue(){
        videoFile = SDUtil.createFile("myvideo.mp4");

        try {
            System.out.println(videoFile.exists() + ", " + videoFile.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        mediaRecorder = new MediaRecorder();

        //ediaRecorder.reset();
        //声音来源麦克风
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        //画面来说摄像头
        mediaRecorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);

        //视频输出格式
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
        //声音格式
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
        //图像格式
        mediaRecorder.setVideoEncoder(MediaRecorder.VideoEncoder.MPEG_4_SP);

        mediaRecorder.setVideoSize(320, 280);
        //每秒4帧
        mediaRecorder.setVideoFrameRate(4);

        

        try {
            mediaRecorder.setOutputFile(videoFile.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        mediaRecorder.setPreviewDisplay(surfaceView.getHolder().getSurface());

        try {
            mediaRecorder.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void record(View view){

            mediaRecorder.start();

            view.setEnabled(false);
            isRecording = true;
    }

    public void stop(View view){
        if (isRecording == true) {
            mediaRecorder.stop();
            mediaRecorder.release();
            mediaRecorder = null;
            view.setEnabled(false);
        }
    }

}
