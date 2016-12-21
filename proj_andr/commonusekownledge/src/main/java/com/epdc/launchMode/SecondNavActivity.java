package com.epdc.launchMode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.epdc.fragment.R;

/**
 * Created by Epdc on 2015/9/7.
 */
public class SecondNavActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_nav);

        findViewById(R.id.btnStartSecondNav).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondNavActivity.this,SecondNavActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btnStartNav).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondNavActivity.this,ActivityNavigationActivity.class);
                startActivity(intent);
            }
        });
        setTitle(this.hashCode()+"");
    }
}
