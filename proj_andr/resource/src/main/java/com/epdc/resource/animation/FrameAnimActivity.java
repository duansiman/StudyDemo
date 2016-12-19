package com.epdc.resource.animation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.epdc.resource.R;

/**
 * 帧动画
 */
public class FrameAnimActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_anim);

        ImageView imageView = (ImageView) findViewById(R.id.image);
//        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getBackground();
//        animationDrawable.start();

//        Animation animation = null;
//        imageView.startAnimation(animation);

        AnimationDrawable anim = new AnimationDrawable();
//        getResources().getDrawable(R.mipmap.fat_po_f01);
        anim.addFrame(getDrawable(R.mipmap.fat_po_f01), 60);
        anim.addFrame(getDrawable(R.mipmap.fat_po_f02), 60);
        anim.addFrame(getDrawable(R.mipmap.fat_po_f03), 60);
        anim.setOneShot(false);

        imageView.setBackground(anim);
        anim.start();

    }
}
