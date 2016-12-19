package com.example.qunyingchuan.scoll;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.example.qunyingchuan.R;

public class SystemLocationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_location);

        final TextView text = (TextView) findViewById(R.id.text);

        assert text != null;

        text.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        //相关博客http://blog.csdn.net/imyfriend/article/details/8564781

                        int[] locations = new int[2];
                        //获取view左上角坐标，在整个屏幕内的绝对坐标，注意这个值是要从屏幕顶端算起，也就是包括了通知栏的高度
                        text.getLocationOnScreen(locations);

                        Log.d("epdc", "getLocationOnScreen "+ locations[0] + " : " + locations[1]);

                        int[] locations2 = new int[2];
                        //获取view左上角坐标，当前窗口内的绝对坐标
                        text.getLocationInWindow(locations2);

                        Log.d("epdc", "getLocationInWindow " + locations2[0] + " : " + locations2[1]);

                        //非全屏，上面两个输出都是390 : 288
                        //全屏 上面两个输出是390 : 120

                        Log.d("epdc", "getRawX " + event.getRawX() + ", getRawY " + event.getRawY());

                        Log.d("epdc", "getX " + event.getX() + ", getY " + event.getY());

                        //相对于父控件视图坐标
                        Log.d("epdc", "getLeft " + text.getLeft() + ", getRight " + text.getRight());
                        Log.d("epdc", "getTop " + text.getTop() + ", getBottom " + text.getBottom());
                        break;
                }

                return true;
            }
        });
    }
}
