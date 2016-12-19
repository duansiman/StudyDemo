package com.example.qunyingchuan.scoll;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by epdc on 2016/5/26.
 */
public class DragView extends View {

    private int preX, preY;

    public DragView(Context context) {
        super(context);
    }

    public DragView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DragView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor (Color.BLACK);
        canvas.drawRect(getLeft(),getTop(), 300, 300, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int x = (int) event.getX();
        int y = (int) event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                preX = x;
                preY = y;
                break;

            case MotionEvent.ACTION_MOVE:

                int dx = x - preX;
                int dy = y - preY;

                layout(getLeft()+dx, getTop()+dy,+getRight()+dx, getBottom()+dy);
                break;
        }

        return true;
    }
}
