package com.epdc.media.camera;

import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;

/**
 * Created by Administrator on 2016/1/4.
 */
public class AutoFitTextureView extends TextureView {

    private int mRatioWidth = 0;
    private int mRatioHeight = 0;

    public AutoFitTextureView(Context context) {
        super(context);
    }

    public AutoFitTextureView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AutoFitTextureView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public AutoFitTextureView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setAspectRatio(int width, int height){
        this.mRatioWidth = width;
        this.mRatioHeight = height;

        // 当view确定自身已经不再适合现有的区域时，该view本身调用这个方法
        // 要求parent view重新调用他的onMeasure onLayout来对重新设置自己位置
        requestLayout();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        System.out.println("widthMeasureSpec:"+widthMeasureSpec+", heightMeasureSpec"+heightMeasureSpec);
        /**
         * 一个MeasureSpec封装了父布局传递给子布局的布局要求，每个MeasureSpec代表了一组宽度和高度的要求。一个MeasureSpec由大小和模式组成。
         * 它有三种模式：UNSPEC IFIED(未指定),父元素部队自元素施加任何束缚，子元素可以得到任意想要的大小；
         * EXACTLY(完全)，父元素决定自元素的确切大小，子元素将被限定在给定的边界里而忽略它本身大小；
         * AT_MOST(至多)，子元素至多达到指定大小的值。
         *
         * 它常用的三个函数：
         　　1.static int getMode(int measureSpec):根据提供的测量值(格式)提取模式(上述三个模式之一)
         　　2.static int getSize(int measureSpec):根据提供的测量值(格式)提取大小值(这个大小也就是我们通常所说的大小)
         　　3.static int makeMeasureSpec(int size,int mode):根据提供的大小值和模式创建一个测量值(格式)
         */
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);

        if (mRatioWidth == 0 || mRatioHeight == 0) {
            //决定了当前View的大小
            setMeasuredDimension(width, height);
        } else {
            if (width < height * mRatioWidth / mRatioHeight) {
                setMeasuredDimension(width, width * mRatioHeight / mRatioWidth);
            } else {
                setMeasuredDimension(height * mRatioWidth / mRatioHeight, height);
            }
        }
    }
}
