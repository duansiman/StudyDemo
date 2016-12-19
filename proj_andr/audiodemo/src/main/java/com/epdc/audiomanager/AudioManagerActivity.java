package com.epdc.audiomanager;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

/**
 * 音频管理服务
 */
public class AudioManagerActivity extends Activity implements View.OnClickListener {

    private Button btnPlay, btnAdd, btnReduce, btnNormal;
    private ToggleButton togRudio;
    private AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        btnPlay = (Button) findViewById(R.id.btnPlay);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnReduce = (Button) findViewById(R.id.btnReduce);
        btnNormal = (Button) findViewById(R.id.btnNormal);
        togRudio = (ToggleButton) findViewById(R.id.togAudio);

        btnPlay.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnReduce.setOnClickListener(this);
        btnNormal.setOnClickListener(this);

        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        togRudio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //是否静音
                audioManager.setStreamMute(AudioManager.STREAM_MUSIC, isChecked);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPlay:
                MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.test);
                mediaPlayer.setLooping(true);
                mediaPlayer.start();
                break;
            case R.id.btnAdd:
                //增大音量
                audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI);
                break;
            case R.id.btnReduce:
                //减少音量
                audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_LOWER, AudioManager.FLAG_SHOW_UI);
                break;
            case R.id.btnNormal:
                break;
        }
    }
}
