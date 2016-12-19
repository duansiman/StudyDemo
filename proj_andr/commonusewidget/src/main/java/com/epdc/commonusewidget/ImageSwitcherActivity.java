package com.epdc.commonusewidget;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import com.epdc.commonusekownledge.R;

/**
 * 图像切换控件
 * Created by Epdc on 2015/8/28.
 */
public class ImageSwitcherActivity extends Activity{

    private ImageSwitcher imageSwitcher;

    private boolean isHappy = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageswitcher);
        imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);

        //会内部创建ImageView来显示图片,其实这样用imageview也可以实现
        //但imageswitcher可以设置切换动画等效果
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                return new ImageView(ImageSwitcherActivity.this);
            }
        });

        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_in));
        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_out));

        imageSwitcher.setImageResource(R.drawable.happy);

        imageSwitcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isHappy = !isHappy;
                if (isHappy) {
                    imageSwitcher.setImageResource(R.drawable.happy);
                } else {
                    imageSwitcher.setImageResource(R.drawable.duan);
                }
            }
        });
    }
}
