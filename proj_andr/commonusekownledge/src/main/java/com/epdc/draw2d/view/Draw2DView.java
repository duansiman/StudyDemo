package com.epdc.draw2d.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

/**
 * Created by Epdc on 2015/9/1.
 */
public class Draw2DView extends View {

    public Draw2DView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();
        p.setStrokeWidth(4);
        p.setColor(Color.RED);
        canvas.drawPoint(50, 50, p);

        p.setStrokeWidth(8);
        p.setColor(Color.GRAY);
        canvas.drawPoint(50, 100, p);

        Paint p1 = new Paint();
        canvas.drawLine(100, 50, 100, 100, p1);

        p1.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(200, 200, 30, p1);
        p1.setStyle(Paint.Style.FILL);
        canvas.drawCircle(300, 300, 30, p1);

        Paint p2 = new Paint();
        RectF rectF = new RectF();
        rectF.left = 30;
        rectF.top = 190;
        rectF.right = 120;
        rectF.bottom = 280;

        canvas.drawArc(rectF, 0, 200, true, p2);

        Paint p3 = new Paint();
        p3.setColor(Color.BLUE);
        canvas.drawText("hello world",400,400,p3);


    }
}
