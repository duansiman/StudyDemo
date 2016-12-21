package com.epdc.gesture;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;

public class ImageActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {

    private ImageView imageView;
    private GestureDetector gestureDetector;

    private Bitmap srcBitmap;
    private int width, height;
    private float currentScale = 1.0f;
    private Matrix matrix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        imageView = (ImageView) findViewById(R.id.imageView);
        gestureDetector = new GestureDetector(this, this);

        matrix = new Matrix();
        srcBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        width = srcBitmap.getWidth();
        height = srcBitmap.getHeight();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

        System.out.println("velocityX:" + velocityX);
        System.out.println("velocityY:" + velocityY);

        velocityX = velocityX > 4000 ? 4000 : velocityX;
        velocityX = velocityX < -4000 ? -4000 : velocityX;

        //计算缩放因子
        currentScale += currentScale * velocityX / 4000.0f;
        currentScale = currentScale > 0.01f ? currentScale : 0.01f;
        System.out.println("currentScale:" + currentScale);


        //重置matrix
        matrix.reset();

        matrix.setScale(currentScale, currentScale, 160, 200);

        //是否回收
        BitmapDrawable tmp = (BitmapDrawable) imageView.getDrawable();
        if (!tmp.getBitmap().isRecycled()) {
            tmp.getBitmap().recycle();
        }

        Bitmap bitmap = Bitmap.createBitmap(srcBitmap, 0, 0, width, height, matrix, true);
        imageView.setImageBitmap(bitmap);

        return true;
    }
}
