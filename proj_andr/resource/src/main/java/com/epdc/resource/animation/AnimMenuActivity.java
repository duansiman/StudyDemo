package com.epdc.resource.animation;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnticipateInterpolator;
import android.widget.ImageView;

import com.epdc.resource.R;

public class AnimMenuActivity extends AppCompatActivity implements View.OnClickListener {

    int[] imageIds = new int[]{
            R.id.a, R.id.b,
            R.id.c, R.id.d,
            R.id.e, R.id.f,
            R.id.g
    };

    ImageView[] imageViews = new ImageView[imageIds.length];

    ObjectAnimator[] openAnimators = new ObjectAnimator[imageViews.length];
    ObjectAnimator[] closeAnimators = new ObjectAnimator[imageViews.length];

    boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_menu);

        for (int i = 0; i < imageViews.length; i++) {
            imageViews[i] = (ImageView) findViewById(imageIds[i]);
            imageViews[i].setOnClickListener(this);
            openAnimators[i] = ObjectAnimator.ofFloat(imageViews[i], "translationY", 0f, i * 80f);
            openAnimators[i].setStartDelay(i * 150);
            openAnimators[i].setDuration(500);
            openAnimators[i].setInterpolator(new AnticipateInterpolator());

            closeAnimators[i] = ObjectAnimator.ofFloat(imageViews[i], "translationY", i * 80f, 0);
            closeAnimators[i].setStartDelay(i * 150);
            closeAnimators[i].setDuration(300);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.a:
                ImageView view = (ImageView) v;
                if (flag == false) {
                    for (int i = 1; i < openAnimators.length; i++) {
                        openAnimators[i].start();
                    }
                    view.setImageResource(R.mipmap.composer_button_pressed);
                    flag = true;
                } else {
                    for (int i = 1; i < openAnimators.length; i++) {
                        closeAnimators[i].start();
                    }
                    view.setImageResource(R.mipmap.composer_button_normal);
                    flag = false;
                }

                break;
        }
    }
}
