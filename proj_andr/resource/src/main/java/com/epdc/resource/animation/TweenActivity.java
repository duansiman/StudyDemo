package com.epdc.resource.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.epdc.resource.R;

/**
 * 补间动画 指定开始和结束帧，中间帧有系统计算补齐
 * AlphaAnimation       透明度改变动画
 * ScaleAnimation       大小缩放动画
 * TranslateAnimation   位移变化动画
 * RotateAnimation      旋转动画
 *
 * Interpolator控制动画期间需要动态”补入“多少帧，根据算法计算需要动态插入帧的密度和位置，即动画变化速度
 * LinearInterpolator 均匀的速度改变
 * AccelerateInterpolator 开始改变速度较慢，然后开始加速
 * AccelerateDecelerateInterpolator 开始和结束改变速度较慢，中间加速
 * CycleInterpolator 循环播放特定次数，速度按正弦曲线改变
 * DecelerateInterpolator 开始速度较快，然后开始减速
 */
public class TweenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween);

        ImageView flower = (ImageView) findViewById(R.id.flower);

        Animation anim = AnimationUtils.loadAnimation(this, R.anim.anim_first);
        anim.setFillAfter(true);
        flower.startAnimation(anim);
    }
}
