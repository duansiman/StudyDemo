package com.epdc.fourwidget;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * 测试启动和关闭Activity，两个Activity之间数据传递，以及Activity返回数据
 * 测试两个Activity之间的生命周期
 * Created by Epdc on 2015/8/16.
 */
public class LaunchAndTransmitDataActivity extends ActionBarActivity {

    private static String TAG = LaunchAndTransmitDataActivity.class.getName();

    private Button btnStart;
    private TextView txtShowFirst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launchandtransmitdata);
        Log.i(TAG, "onCreate");

        //要关联布局后，才能调用findViewById
        this.btnStart = (Button) findViewById(R.id.btnStart);
        this.txtShowFirst = (TextView) findViewById(R.id.txtShowFirst);

        this.btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //启动另外一个Activity
                Intent intent = new Intent(LaunchAndTransmitDataActivity.this, SecondActivity.class);
                //传递数据
                //1、通过Intent对象的put方法传递数据
                intent.putExtra("value", "hello second");

                //2、通过Bundle对象（数据束）传递数据
                Bundle bundle = new Bundle();
                bundle.putString("value", "hello Second");
                //关联bundle
                intent.putExtras(bundle);

//                startActivity(intent);
                startActivityForResult(intent,1);
            }
        });
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

    /**
     * 1、启动一个新的Activity时，先调用自己onPause()方法，
     * 2、然后调用新的Activity的onCreate、onStart和onResume方法
     * 3、再调用自己onStop()方法，如果销毁了再调用onDestroy()
     */
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

    /**
     *  自己启动的Activity有返回的数据时，调用的方法
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 0 && resultCode == 0){
            this.txtShowFirst.setText(data.getStringExtra("value"));
        }
    }
}
