package com.epdc.customview;

import android.app.Activity;
import android.os.Bundle;

import com.epdc.fragment.R;

/**
 * 组合控件，通过继承容器来实现
 * Created by Epdc on 2015/8/31.
 */
public class FirstCombinationWidgetActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstcombinationwidget);
    }
}
