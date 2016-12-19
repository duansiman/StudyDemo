package com.epdc.commonusewidget;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import com.epdc.commonusekownledge.R;

/**
 * Created by Epdc on 2015/8/26.
 */
public class TimePickerActivity extends Activity {

    private Button btnTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timepicker);

        btnTime = (Button) findViewById(R.id.btnTime);

        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TimePickerDialog(TimePickerActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        btnTime.setText(String.format("%d:%d",hourOfDay,minute));
                    }
                },14,26,true).show();
            }
        });
    }
}
