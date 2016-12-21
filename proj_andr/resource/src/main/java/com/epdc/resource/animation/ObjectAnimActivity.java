package com.epdc.resource.animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.epdc.resource.R;

public class ObjectAnimActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_anim);

        ImageView imageView = (ImageView) findViewById(R.id.image);

        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imageView, "rotation", 0f, 360f);
        objectAnimator.setDuration(1000);
        objectAnimator.start();

        //同时执行多个动画
        PropertyValuesHolder p1 = PropertyValuesHolder.ofFloat("rotation", 0f, 360f);
        PropertyValuesHolder p2 = PropertyValuesHolder.ofFloat("alpha", 0f, 1f);
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofPropertyValuesHolder(imageView, p1, p2);
        objectAnimator.setDuration(1000);
        objectAnimator.start();

        //同时执行多个动画
        AnimatorSet set = new AnimatorSet();
        set.playTogether(objectAnimator, objectAnimator2);
        set.setDuration(1000);
        set.start();

        //按顺序执行动画
        set.playSequentially(objectAnimator, objectAnimator2);

        //设置动画执行顺序
        set.play(objectAnimator).after(objectAnimator2);

    }
}
