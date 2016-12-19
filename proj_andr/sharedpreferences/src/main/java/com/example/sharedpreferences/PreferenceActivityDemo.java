package com.example.sharedpreferences;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 *  数据持久化，设置界面
 * Created by Administrator on 2015/9/25.
 */
public class PreferenceActivityDemo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferenceactivity_demo);

        findViewById(R.id.setting).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                ComponentName componentName = new ComponentName(PreferenceActivityDemo.this,SettingsActivity.class);
                intent.setComponent(componentName);
                startActivity(intent);
            }
        });
    }
}
