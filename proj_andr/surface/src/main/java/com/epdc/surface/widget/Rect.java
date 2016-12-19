package com.epdc.surface.widget;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by Epdc on 2015/9/20.
 */
public class Rect extends Container {
    private Paint paint;

    public Rect(){
        paint = new Paint();
        paint.setColor(Color.GREEN);
    }

    @Override
    public void drawChildern(Canvas canvas) {
        canvas.drawRect(0,0,100,100,paint);
        this.y = this.y + 1;
    }
}
