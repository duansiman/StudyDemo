package com.epdc.resource.drawable;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

import com.epdc.resource.R;

import java.util.Timer;
import java.util.TimerTask;

public class MoveBackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));
    }

    class MyView extends View {

        Bitmap backBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.back_img);
        Bitmap planeBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.plane);
        final int BACK_HEIGHT = backBitmap.getHeight();

        final int WIDTH = backBitmap.getWidth();
        final int HEIGHT = 880;

        private Matrix matrix;
        private int startY = BACK_HEIGHT -HEIGHT-10;
        private final DisplayMetrics metrics;

        public MyView(Context context) {
            super(context);

            metrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(metrics);

            float scale = (float) metrics.widthPixels/WIDTH;
            matrix = new Matrix();
            matrix.setScale(scale, scale);

            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    if (startY <= 3) {
                        startY = BACK_HEIGHT -HEIGHT;
                    } else {
                        startY -= 3;
                    }
                    postInvalidate();
                }
            }, 0, 100);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            System.out.println(metrics.widthPixels + ", " + metrics.heightPixels);
            System.out.println(backBitmap.getWidth() + ", " + backBitmap.getHeight());
            canvas.drawBitmap(Bitmap.createBitmap(backBitmap, 0, startY, WIDTH, HEIGHT, matrix, false), 0, 0, new Paint());
            canvas.drawBitmap(planeBitmap, metrics.widthPixels/2 - 50,  metrics.heightPixels-200, new Paint());
        }
    }
}
