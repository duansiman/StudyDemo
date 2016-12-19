package com.epdc.surface.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Epdc on 2015/9/20.
 */
public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback{

    private Paint paint;

    public MySurfaceView(Context context) {
        super(context);
        getHolder().addCallback(this);
        paint = new Paint();
        paint.setColor(Color.RED);
    }

    /**
     * 绘画方法，应该在surfaceCreated和surfaceDestroyed之间调用
     */
    public void draw() {
        //锁住画布
        Canvas canvas = getHolder().lockCanvas();
        canvas.drawColor(Color.WHITE);

        //对画布做 平移、旋转等操作
        canvas.save();

        canvas.rotate(90, getWidth() / 2, getHeight() / 2);
        canvas.drawLine(0, getHeight() / 2, getWidth(), getHeight(), paint);

        //恢复原来画布
        canvas.restore();

        canvas.drawLine(0, getHeight() / 2, getWidth(), getHeight(), paint);
        canvas.drawLine(0, getHeight() / 2 + 100, getWidth(), getHeight() + 100, paint);
        paint.setStrokeWidth(5);
        canvas.drawPoint(getWidth()/2,getHeight()/2,paint);


        //释放画布
        getHolder().unlockCanvasAndPost(canvas);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        draw();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
