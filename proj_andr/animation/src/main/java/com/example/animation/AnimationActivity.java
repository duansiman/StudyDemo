package com.example.animation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import com.epdc.commonlib.utils.LogUtil;

public class AnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        final TextView textView = (TextView) findViewById(R.id.textView);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtil.d("click");
            }
        });

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
                alphaAnimation.setDuration(1000);

                ScaleAnimation scaleAnimation = new ScaleAnimation(0, 2, 0, 2,
                        RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                        RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                scaleAnimation.setDuration(1000);

                RotateAnimation rotateAnimation = new RotateAnimation(0, 360,
                        //设置旋转中心，为自身的中心
                        RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                        RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                rotateAnimation.setDuration(1000);

                TranslateAnimation translateAnimation = new TranslateAnimation(0, 100, 0, 100);
                translateAnimation.setDuration(1000);
                translateAnimation.setFillAfter(true);
                translateAnimation.setInterpolator(new AccelerateInterpolator());

                AnimationSet set = new AnimationSet(true);
//                set.setDuration(1000);
                set.addAnimation(alphaAnimation);
                set.addAnimation(scaleAnimation);
                set.addAnimation(rotateAnimation);
                set.addAnimation(translateAnimation);
                set.setFillAfter(true);

                set.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        LogUtil.d("start");
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        LogUtil.d("end");

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                        LogUtil.d("repeat");

                    }
                });

                switch (v.getId()) {
                    case R.id.btnAlpha:

                        textView.startAnimation(alphaAnimation);
                        break;
                    case R.id.btnScale:

                        textView.startAnimation(scaleAnimation);
                        break;
                    case R.id.btnRotate:

                        textView.startAnimation(rotateAnimation);
                        break;
                    case R.id.btnTransform:

                        textView.startAnimation(translateAnimation);
                        break;
                    case R.id.btnValueHolder:
                        textView.startAnimation(set);
                        break;
                }

            }
        };

        findViewById(R.id.btnAlpha).setOnClickListener(clickListener);
        findViewById(R.id.btnScale).setOnClickListener(clickListener);
        findViewById(R.id.btnRotate).setOnClickListener(clickListener);
        findViewById(R.id.btnTransform).setOnClickListener(clickListener);
        findViewById(R.id.btnValueHolder).setOnClickListener(clickListener);

    }
}
