package com.epdc.commonusewidget;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.epdc.commonusekownledge.R;

/**
 * 下拉列表
 * Created by Epdc on 2015/8/26.
 */
public class SpinnerActivity extends Activity {

    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        spinner = (Spinner) findViewById(R.id.spinner);

        spinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, new String[]{"android", "java", "c++"}));
    }
}
