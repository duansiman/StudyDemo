package com.epdc.gesture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class GestureActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {

    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture);

        gestureDetector = new GestureDetector(this, this);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }


    /**
     * 触碰事件按下时触发
     * @param e
     * @return
     */
    @Override
    public boolean onDown(MotionEvent e) {
        System.out.println("onDown");
        return false;
    }

    /**
     * 触碰事件按下,还未移动和松开时触发
     * @param e
     */
    @Override
    public void onShowPress(MotionEvent e) {
        System.out.println("onShowPress");

    }

    /**
     *  轻击事件时触发
     * @param e
     * @return
     */
    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        System.out.println("onSingleTapUp");

        return false;
    }

    /**
     * 滚动时触发
     * @param e1
     * @param e2
     * @param distanceX
     * @param distanceY
     * @return
     */
    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        System.out.println("onScroll");

        return false;
    }


    /**
     * 长按时触发
     * @param e
     */
    @Override
    public void onLongPress(MotionEvent e) {
        System.out.println("onLongPress");


    }

    /**
     * 拖动时触发
     * @param e1
     * @param e2
     * @param velocityX
     * @param velocityY
     * @return
     */
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        System.out.println("onFling");

        return false;
    }
}
