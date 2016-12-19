package com.epdc.gesture;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.File;
import java.util.Locale;

/**
 * 自动朗读
 */
public class TTSActivity extends AppCompatActivity {

    TextToSpeech tts;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tts);

        editText = (EditText) findViewById(R.id.txt);

        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                //装载TTS引擎成功
                if (status == TextToSpeech.SUCCESS) {
                    //美式英语朗读，不支持中文
                    int result = tts.setLanguage(Locale.US);

                    if (result != TextToSpeech.LANG_COUNTRY_AVAILABLE && result != TextToSpeech.LANG_AVAILABLE) {
                        System.out.println("不支持该语言");

                    }
                }
            }
        });
    }

    public void speech(View view){
        tts.speak(editText.getText().toString(), TextToSpeech.QUEUE_ADD, null, "speech");
    }

    public void record(View view){
        tts.synthesizeToFile(editText.getText().toString(), null, new File("/mnt/sdcard/sound.wav"), "record");
        System.out.println("声音记录成功");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (tts != null) {
            tts.shutdown();
        }
    }
}
