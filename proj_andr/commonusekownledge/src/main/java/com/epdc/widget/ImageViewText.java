package com.epdc.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * 左边带有图片的文本
 * Created by Epdc on 2015/9/1.
 */
public class ImageViewText extends TextView{

    private final static String namespace = "com.epdc.widget";
    private Drawable drawable;

    public ImageViewText(Context context, AttributeSet attrs) {
        super(context, attrs);
        int resourceId = attrs.getAttributeResourceValue(namespace,"icon",0);

        drawable = context.getResources().getDrawable(resourceId);
    }


    @Override
    protected void onDraw(Canvas canvas) {

        int height = (int)getTextSize();
        int top = (getMeasuredHeight() - height) /2 + 1;
        drawable.setBounds(0,top,height,height+top);
        drawable.draw(canvas);

        canvas.translate(height+2,0);
        super.onDraw(canvas);

    }
}
