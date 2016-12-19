package com.epdc.surface.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Epdc on 2015/9/20.
 */
public class CombinationView extends SurfaceView implements SurfaceHolder.Callback {

    private Paint paint;
    private Rect rect;
    private TimerTask task;
    private Timer timer;

    public CombinationView(Context context) {
        super(context);
        paint = new Paint();

        rect = new Rect();
        Circle circle = new Circle();
        rect.addChildern(circle);

        getHolder().addCallback(this);
    }

    public void start(){
        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                draw();
            }
        };
        timer.schedule(task, 1000, 1000);
    }

    public void cancel(){
        if (timer != null) {
            task.cancel();
            timer.cancel();
            timer = null;
        }
    }

    public void draw(){
        Canvas canvas = getHolder().lockCanvas();

        canvas.drawColor(Color.WHITE);
        rect.draw(canvas);

        getHolder().unlockCanvasAndPost(canvas);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        cancel();
    }
}
