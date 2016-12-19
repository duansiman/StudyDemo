package com.epdc.audiomanager;

import android.app.Activity;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.IOException;

/**
 * 录音
 */
public class MediaRecorderActivity extends Activity implements View.OnClickListener {

    private Button btnStart, btnStop;
    private MediaRecorder mediaRecorder;
    private File sourceFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_recorder);

        btnStart = (Button) findViewById(R.id.btnStart);
        btnStop = (Button) findViewById(R.id.btnStop);

        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);

        mediaRecorder = new MediaRecorder();
        //设置声音来源，一般为手机麦克风
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        //声音输出格式
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        //设置声音编码格式
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStart:
                if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                    System.out.println("请插入SD卡");
                    break;
                }
                try {
                    sourceFile = new File(Environment.getExternalStorageDirectory().getCanonicalFile()
                            + "/sound.amr");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //设置声音输出目录
                System.out.println(sourceFile.getAbsolutePath());
                mediaRecorder.setOutputFile(sourceFile.getAbsolutePath());
                try {
                    mediaRecorder.prepare();
                    //开始录音
                    mediaRecorder.start();
                    System.out.println("start");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                break;
            case R.id.btnStop:
                if (sourceFile != null && sourceFile.exists()) {
                    mediaRecorder.stop();
                    System.out.println("stop");
                    //释放资源
                    mediaRecorder.release();
                    mediaRecorder = null;
                }
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (sourceFile != null && sourceFile.exists()) {
            mediaRecorder.stop();
            //释放资源
            mediaRecorder.release();
            mediaRecorder = null;
        }
    }
}
