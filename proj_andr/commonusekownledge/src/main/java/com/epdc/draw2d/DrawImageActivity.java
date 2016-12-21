package com.epdc.draw2d;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;

import com.epdc.draw2d.view.MyImageView;

/**
 * 绘制图像
 * Created by Epdc on 2015/9/2.
 */
public class DrawImageActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyImageView image = new MyImageView(this);
        image.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
        setContentView(image);
    }
}
