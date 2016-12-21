package com.epdc.commonusewidget;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;
import android.widget.QuickContactBadge;

import com.epdc.commonusekownledge.R;

/**
 * Created by Epdc on 2015/8/28.
 */
public class EditTextActivity extends Activity{

    Activity activity = new Activity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edittext);

        /*EditText editText = (EditText) findViewById(R.id.username);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (EditorInfo.IME_ACTION_GO == v.getImeOptions()) {
                    Toast.makeText(getBaseContext(), "go", Toast.LENGTH_LONG).show();
                }
                return true;
            }
        });*/

        final Chronometer chronometer = (Chronometer) findViewById(R.id.chronometer);
        chronometer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.start();
            }
        });

        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {

            int value=59;

            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if (value > 0) {
                    chronometer.setText(String.format("%ds", value));
                    chronometer.setTextColor(getResources().getColor(android.R.color.darker_gray));
                    value--;
                } else {
                    value = 59;
                    chronometer.stop();
                    chronometer.setText("获取验证码");
                    chronometer.setTextColor(getResources().getColor(android.R.color.black));
                    chronometer.setClickable(true);
                }
            }
        });

        QuickContactBadge quickContactBadge = (QuickContactBadge) findViewById(R.id.quick);
        quickContactBadge.assignContactFromPhone("13975219237", false);
    }
}
