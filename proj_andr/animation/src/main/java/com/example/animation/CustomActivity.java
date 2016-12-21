package com.example.animation;

import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;

public class CustomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);

        final ImageView imageView = (ImageView) findViewById(R.id.imageView);



        imageView.post(new Runnable() {
            @Override
            public void run() {
                float px = imageView.getPivotX();
                float py = imageView.getPivotY();

                MyAnimator myAnimator = new MyAnimator(px, py);
                myAnimator.setDuration(1000);
                imageView.startAnimation(myAnimator);
            }
        });
    }

    class MyAnimator extends Animation {

        float px, py;

        public MyAnimator(float px, float py) {
            this.px = px;
            this.py = py;
        }

        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t) {
            Matrix matrix = t.getMatrix();
            matrix.preScale(1, 1 - interpolatedTime, px, py);
        }
    }
}
