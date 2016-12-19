package com.epdc.resource.animation;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.epdc.resource.R;

import java.io.IOException;
import java.lang.reflect.Field;

/**
 * 爆炸动画
 */
public class BombActivity extends AppCompatActivity {

    Activity mActivity;

    int[] bombId = new int[] {
            R.mipmap.bom_f01, R.mipmap.bom_f02, R.mipmap.bom_f03, R.mipmap.bom_f04,
            R.mipmap.bom_f05, R.mipmap.bom_f06, R.mipmap.bom_f07, R.mipmap.bom_f08,
            R.mipmap.bom_f09, R.mipmap.bom_f10, R.mipmap.bom_f11, R.mipmap.bom_f12,
            R.mipmap.bom_f13, R.mipmap.bom_f14, R.mipmap.bom_f15, R.mipmap.bom_f16,
            R.mipmap.bom_f17, R.mipmap.bom_f18, R.mipmap.bom_f19, R.mipmap.bom_f20,
            R.mipmap.bom_f21, R.mipmap.bom_f22, R.mipmap.bom_f23, R.mipmap.bom_f24,
            R.mipmap.bom_f25, R.mipmap.bom_f26, R.mipmap.bom_f27,
    };
    private MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bomb);

        mActivity = this;
        player = MediaPlayer.create(this, R.raw.bomb);

        final RelativeLayout layout = (RelativeLayout) findViewById(R.id.layout);

        layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    MyImage myImage = new MyImage(mActivity);
                    System.out.println(event.getX() + ", "+event.getY());
                    myImage.setX( event.getX());
                    myImage.setY( event.getY());
                    AnimationDrawable anim = new AnimationDrawable();
                    for (int i = 1; i <= 27; i++) {
                        anim.addFrame(getResources().getDrawable(bombId[i - 1]), 60);
                    }
                    myImage.setBackground(anim);
                    anim.setOneShot(true);
                    anim.start();
                    player.start();
                    ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    layout.addView(myImage, params);
                }
                return true;
            }
        });
    }

    class MyImage extends ImageView {

        private final AnimationDrawable anim;

        public MyImage(Context context) {
            super(context);
            anim = (AnimationDrawable) this.getBackground();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            try {
                Field field = AnimationDrawable.class.getDeclaredField("mCurFrame");
                field.setAccessible(true);



                //获得当前帧
                int curFrame = field.getInt(anim);
                //为最后一帧
                if (curFrame == anim.getNumberOfFrames()-1) {
                    setVisibility(GONE);
                    //player.stop();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            super.onDraw(canvas);
        }
    }
}
