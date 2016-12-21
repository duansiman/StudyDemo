package com.epdc.commonusewidget;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;

import com.epdc.commonusekownledge.R;

/**
 * 拖动条
 * Created by Epdc on 2015/8/28.
 */
public class SeekBarActivity extends Activity{

    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seekbar);

        seekBar = (SeekBar) findViewById(R.id.seekBar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("MyLog", String.valueOf(fromUser));
                TextView currentValue = (TextView) findViewById(R.id.tvCurrentValue);
                currentValue.setText(String.format("%d",progress)+"%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }
}
