package com.epdc.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Epdc on 2015/9/5.
 */
public class FragmentDetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_right);
        TextView tvDetail = (TextView) findViewById(R.id.tvDetail);
        tvDetail.setText(getIntent().getStringExtra("detail"));
    }
}
