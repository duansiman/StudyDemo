package com.epdc.commonusewidget;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.epdc.commonusekownledge.R;

/**
 * Created by Epdc on 2015/8/27.
 */
public class CustomViewActivity extends Activity {

    private CustomView customView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_view);

        customView = (CustomView) findViewById(R.id.customView);
        customView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                customView.setX(event.getX());
                customView.setY(event.getY());

                //重画
                customView.invalidate();


                //表示处理方法已经处理改事件
                return true;
            }
        });
    }
}
