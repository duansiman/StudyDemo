package com.example.animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.epdc.commonlib.utils.LogUtil;

public class AnimatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator);

        final TextView textView = (TextView) findViewById(R.id.textView);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtil.d("click");
            }
        });
        LogUtil.d("x="+textView.getX()+", y="+textView.getY());

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                switch (v.getId()) {
                    case R.id.btnAlpha:

                        break;
                    case R.id.btnScale:

                        break;
                    case R.id.btnRotate:

                        break;
                    case R.id.btnTransform:

                        ObjectAnimator animator = ObjectAnimator.ofFloat(textView, "translationX", 100, 200,300);
                        animator.setDuration(1000);
                        animator.addListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animation) {

                            }

                            @Override
                            public void onAnimationEnd(Animator animation) {
                                LogUtil.d("x="+textView.getX()+", y="+textView.getY());
                            }

                            @Override
                            public void onAnimationCancel(Animator animation) {

                            }

                            @Override
                            public void onAnimationRepeat(Animator animation) {

                            }
                        });

                        animator.start();

                        break;
                    case R.id.btnValueHolder:
                        //同时多个属性
                        PropertyValuesHolder pvh1 = PropertyValuesHolder.ofFloat("translationX", 100f, 300f);
                        PropertyValuesHolder pvh2 = PropertyValuesHolder.ofFloat("scaleX", 1f, 0f, 1f);
                        PropertyValuesHolder pvh3 = PropertyValuesHolder.ofFloat("scaleY", 1f, 0f, 1f);
                        ObjectAnimator.ofPropertyValuesHolder(textView, pvh1, pvh2, pvh3)
                                .setDuration(1000).start();


                        break;
                    case R.id.btnWidth:
                        WrapperView wrapper = new WrapperView(textView);
                        ObjectAnimator.ofInt(wrapper, "width", 100, 500).setDuration(1000).start();
                        break;

                    case R.id.btnSet:
                        ObjectAnimator animator1 = ObjectAnimator.ofFloat(textView, "translationX", 300f);
                        ObjectAnimator animator2 = ObjectAnimator.ofFloat(textView, "scaleX", 1f, 0f, 1f);
                        ObjectAnimator animator3 = ObjectAnimator.ofFloat(textView, "scaleY", 1f, 0f, 1f);

                        AnimatorSet st = new AnimatorSet();
                        st.setDuration(1000);
                        //一起执行
//                        st.playTogether(animator1, animator2);
                        //顺序执行
//                        st.playSequentially(animator1, animator2);
                        st.play(animator2).with(animator3).after(animator1);

                        st.start();

                        break;

                    case R.id.btnValueAnimator:
                        //不提供动画效果，是一个数值发生器
                        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 1);
                        valueAnimator.setTarget(textView);
                        valueAnimator.setDuration(1000).start();
                        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            @Override
                            public void onAnimationUpdate(ValueAnimator animation) {
                                Float value = (Float) animation.getAnimatedValue();
                                LogUtil.d("value="+value);
                                textView.setScaleX(value);
                            }
                        });

                        valueAnimator.addListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                LogUtil.d("end");
                            }
                        });
                        break;
                    case R.id.btnXml:
                        Animator anim = AnimatorInflater.loadAnimator(AnimatorActivity.this, R.animator.anim);
                        anim.setTarget(textView);
                        anim.start();
                        break;
                    case R.id.btnMethod:
                        textView.animate().alpha(0).y(200).setDuration(1000)
                                .withStartAction(new Runnable() {
                                    @Override
                                    public void run() {
                                        LogUtil.d("start");
                                    }
                                }).withEndAction(new Runnable() {
                            @Override
                            public void run() {
                                LogUtil.d("end");
                            }
                        });
                        break;
                }

            }
        };

        findViewById(R.id.btnAlpha).setOnClickListener(clickListener);
        findViewById(R.id.btnScale).setOnClickListener(clickListener);
        findViewById(R.id.btnRotate).setOnClickListener(clickListener);
        findViewById(R.id.btnTransform).setOnClickListener(clickListener);
        findViewById(R.id.btnWidth).setOnClickListener(clickListener);
        findViewById(R.id.btnValueHolder).setOnClickListener(clickListener);
        findViewById(R.id.btnValueAnimator).setOnClickListener(clickListener);
        findViewById(R.id.btnSet).setOnClickListener(clickListener);
        findViewById(R.id.btnXml).setOnClickListener(clickListener);
        findViewById(R.id.btnMethod).setOnClickListener(clickListener);
    }
}
