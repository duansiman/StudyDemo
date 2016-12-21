package com.epdc.customview.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import java.util.Calendar;

/**
 * 时钟控件
 * Created by Epdc on 2015/9/2.
 */
public class ClockView extends View {

    private Bitmap clockBitmap;
    private float scale;

    public ClockView(Context context, AttributeSet attrs) {
        super(context, attrs);

        int resourceId = attrs.getAttributeResourceValue(null,"src",0);
        clockBitmap = BitmapFactory.decodeResource(getResources(), resourceId);

        scale = attrs.getAttributeFloatValue(null, "scale", 1);
        System.out.println("scale" + scale);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();

        Rect src = new Rect();
        src.left = 0;
        src.top = 0;
        src.right = clockBitmap.getWidth();
        src.bottom = clockBitmap.getHeight();

        Rect target = new Rect();
        target.left = 0;
        target.top = 0;
        target.bottom = (int) (clockBitmap.getWidth() * scale);
        target.right = (int) (clockBitmap.getHeight() * scale);
        //canvas.drawBitmap(clockBitmap,0,0,p);//这种情况，并没有缩放。只是截取一部分显示
        canvas.drawBitmap(clockBitmap,src,target,p);

        float centerX = (float)(clockBitmap.getWidth() * scale*0.5);
        float centerY = (float)(clockBitmap.getHeight() * scale*0.5);
        canvas.drawCircle(centerX,centerY,5,p);

        // 设置分针为3个象素粗
        p.setStrokeWidth(3);
        Calendar calendar = Calendar.getInstance();
        int currentMinute = calendar.get(Calendar.MINUTE);
        int currentHour = calendar.get(Calendar.HOUR);
        // 计算分针和时间的弧度
        double minuteRadian = Math
                .toRadians((360 - ((currentMinute * 6) - 90)) % 360);
        double hourRadian = Math.toRadians((360 - ((currentHour * 30) - 90))
                % 360 - (30 * currentMinute / 60));
        // 在表盘上画分针
        canvas.drawLine(centerX, centerY, (int) (centerX + 154
                * Math.cos(minuteRadian)), (int) (centerY - 100
                * Math.sin(minuteRadian)), p);
        // 设置实针为4个象素粗
        p.setStrokeWidth(4);
        // 在表盘上画时针
        canvas.drawLine(centerX, centerY, (int) (centerX + 154
                * Math.cos(hourRadian)), (int) (centerY - 100
                * Math.sin(hourRadian)), p);
    }

    //该方法确定自定义控件大小
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //setMeasuredDimension((int)(clockBitmap.getWidth()*scale),(int)(clockBitmap.getHeight()*scale));
    }
}
