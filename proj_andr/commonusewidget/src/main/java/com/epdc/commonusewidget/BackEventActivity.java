package com.epdc.commonusewidget;


import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.epdc.commonusekownledge.R;

/**
 * Activity退回事件处理
 * Created by Epdc on 2015/8/30.
 */
public class BackEventActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backevent);
    }

//    private boolean flag = true;
    private long currentTime  = 0;
    @Override
    public void onBackPressed() {
//        super.onBackPressed();
//        if (flag) {
//            Toast.makeText(this,"再按一次退出应用？",Toast.LENGTH_SHORT).show();
//            flag = false;
//        } else {
//            flag = true;
//            finish();
//        }

        if (currentTime <= 0) {
            Toast.makeText(this,"你确定退出应用？",Toast.LENGTH_SHORT).show();
            currentTime = System.currentTimeMillis();
        }
        else if (System.currentTimeMillis() - currentTime <= 1000) {
            finish();
        } else {
            Toast.makeText(this,"你确定退出应用？",Toast.LENGTH_SHORT).show();
            currentTime = System.currentTimeMillis();
        }
    }
}
