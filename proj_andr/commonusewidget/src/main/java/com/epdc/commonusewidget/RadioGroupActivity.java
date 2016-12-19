package com.epdc.commonusewidget;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.epdc.commonusekownledge.R;

/**
 * Created by Epdc on 2015/8/24.
 */
public class RadioGroupActivity extends Activity implements DialogInterface.OnClickListener {

    private Button btnCommit;
    private RadioButton rbMan, rbWomen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radiogroup);

        btnCommit = (Button) findViewById(R.id.btnCommit);
        rbMan = (RadioButton) findViewById(R.id.rbMan);
        rbWomen = (RadioButton) findViewById(R.id.rbWomen);

        btnCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String select = null;
                if (rbMan.isChecked()) {
                    select = "男";
                }
                if (rbWomen.isChecked()){
                    select = "女";
                }

                new AlertDialog.Builder(RadioGroupActivity.this).setTitle("选择").setMessage(String.format("你的选择是%s！", select))
                        .setPositiveButton("确定", RadioGroupActivity.this)//-1
                        .setNegativeButton("设置", RadioGroupActivity.this)//-2 放在最后
                        .setNeutralButton("取消",RadioGroupActivity.this).show();//-3 放在中间
            }
        });
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        Toast.makeText(this, String.format("which:%d",which),Toast.LENGTH_SHORT).show();
    }
}
