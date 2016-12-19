package com.epdc.fourwidget;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Epdc on 2015/8/16.
 */
public class SecondActivity extends ActionBarActivity {

    private static String TAG = SecondActivity.class.getName();

    private Button btnClose;
    private TextView txtShowSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        this.txtShowSecond = (TextView) findViewById(R.id.txtShowSecond);
        //得到Intent对象
        this.txtShowSecond.setText(getIntent().getStringExtra("value"));
        //得到bundle对象
        this.txtShowSecond.setText(getIntent().getExtras().getString("value"));

        this.btnClose = (Button) findViewById(R.id.btnClose);
        this.btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //返回数据给启动自己的Activity
                Intent intent = new Intent();
                intent.putExtra("value", "hello first");
                setResult(1,intent);
                //关闭Activity
                finish();
            }
        });

        Log.i(TAG, "onCreate");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }
}
