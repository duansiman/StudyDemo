package com.epdc.gesture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class ViewFlipperActivity extends AppCompatActivity implements GestureDetector.OnGestureListener{

    private ViewFlipper viewFlipper;
    private GestureDetector gestureDetector;

    int FLIP_DISTANCE = 50;

    Animation[] animations = new Animation[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_flipper);

        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);

        viewFlipper.addView(addImageView(R.mipmap.picture));
        viewFlipper.addView(addImageView(R.mipmap.picture2));
        viewFlipper.addView(addImageView(R.mipmap.picture3));

        gestureDetector = new GestureDetector(this, this);

        animations[0] = AnimationUtils.loadAnimation(this, R.anim.left_in);
        animations[1] = AnimationUtils.loadAnimation(this, R.anim.left_out);
        animations[2] = AnimationUtils.loadAnimation(this, R.anim.right_in);
        animations[3] = AnimationUtils.loadAnimation(this, R.anim.right_out);


    }

    private ImageView addImageView(int resId){
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(resId);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        return imageView;
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

        if (e1.getX() - e2.getX() > FLIP_DISTANCE) {
            viewFlipper.setInAnimation(animations[0]);
            viewFlipper.setOutAnimation(animations[1]);
            viewFlipper.showPrevious();
        }

        if (e2.getX() - e1.getX() > FLIP_DISTANCE) {
            viewFlipper.setInAnimation(animations[2]);
            viewFlipper.setOutAnimation(animations[3]);
            viewFlipper.showNext();
        }

        return true;
    }
}
