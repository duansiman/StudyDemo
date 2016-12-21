package com.example.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LayoutAnimationController;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

import com.epdc.commonlib.utils.IntentUtil;

public class AnimatoeLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animatoe_layout);

        RelativeLayout rl = (RelativeLayout) findViewById(R.id.context);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0, 1, 0, 1);
        scaleAnimation.setDuration(1000);

        LayoutAnimationController lac = new LayoutAnimationController(scaleAnimation, 0.5f);
        lac.setOrder(LayoutAnimationController.ORDER_NORMAL);
        rl.setLayoutAnimation(lac);


        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentUtil.startActivity(AnimatoeLayoutActivity.this, SecondActivity.class);
            }
        });
    }
}
