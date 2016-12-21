package com.epdc.surface.widget;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by Epdc on 2015/9/20.
 */
public class Circle extends Container {

    private Paint paint;

    public Circle(){
        paint = new Paint();
        paint.setColor(Color.RED);
    }

    @Override
    public void drawChildern(Canvas canvas) {
        canvas.drawCircle(50,50,50,paint);
    }


}
