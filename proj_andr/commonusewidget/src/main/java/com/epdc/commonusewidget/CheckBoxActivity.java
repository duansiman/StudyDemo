package com.epdc.commonusewidget;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.epdc.commonusekownledge.R;

/**
 * Created by Epdc on 2015/8/26.
 */
public class CheckBoxActivity extends Activity {

    private Button btnCommit;
    private CheckBox cbSwim, cbRead, cbInternet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox);

        btnCommit = (Button) findViewById(R.id.btnCommit);
        cbRead = (CheckBox) findViewById(R.id.cbRead);
        cbInternet = (CheckBox) findViewById(R.id.cbInternet);
        cbSwim = (CheckBox) findViewById(R.id.cbSwim);

        btnCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String select = "";
                if (cbSwim.isChecked()) {
                    select += cbSwim.getText();
                }
                if (cbRead.isChecked()) {
                    select += cbRead.getText();
                }
                if (cbInternet.isChecked()) {
                    select += cbInternet.getText();
                }

                new AlertDialog.Builder(CheckBoxActivity.this).setTitle("你的选择").setMessage(select).setPositiveButton("确定", null).show();
            }
        });
    }

}
