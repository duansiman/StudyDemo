package com.epdc.commonusewidget;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.epdc.commonusekownledge.R;

/**
 * Created by Epdc on 2015/8/26.
 */
public class DatePickerActivity extends Activity {

    private Button btnDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datepicker);

        btnDate = (Button) findViewById(R.id.btnDate);

        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(DatePickerActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        btnDate.setText(year+"-"+(monthOfYear+1)+"-"+dayOfMonth);
                    }
                },2015,8-1,26).show();
            }
        });
    }
}
