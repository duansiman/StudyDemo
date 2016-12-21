package com.epdc.draw2d;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;

import com.epdc.draw2d.view.Draw2DView;

/**
 * 2D绘制
 * Created by Epdc on 2015/9/1.
 */
public class Draw2DWidgetActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Draw2DView view = new Draw2DView(this);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        setContentView(view);
    }
}
