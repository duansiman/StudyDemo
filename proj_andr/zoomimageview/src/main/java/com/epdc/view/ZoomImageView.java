package com.epdc.view;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

/**
 *  可以缩放、移动ImageView
 * Created by epdc on 2015/12/5.
 */
public class ZoomImageView extends ImageView implements ViewTreeObserver.OnGlobalLayoutListener, ScaleGestureDetector.OnScaleGestureListener, View.OnTouchListener {

    private boolean isOnce;
    /**
     * 初始化缩放因子
     */
    private float mInitScale;

    /**
     * 双击缩放因子
     */
    private float mMidScale;

    /**
     * 最大缩放因子
     */
    private float mMaxScale;

    /**
     * 缩放平移矩阵  该对象拥有长度为9的一维数组 保存着9个float值。
     *  其实是一个三行三列矩阵, 后面三个值少用设置为0
     *  xScale xSkew xTrans
     *  ySkew yScale yTrans
     *  0      0     0
     */
    private Matrix matrix;

    /**
     * 捕获多指触碰时缩放比例
     */
    private ScaleGestureDetector scaleGestureDetector;

    /**
     * 双击 放大或缩小
     */
    private GestureDetector gestureDetector;
    /**
     * 是否在双击缩放中
     */
    private boolean isDoubleScale;

    /**
     * 自由移动
     */
    private int lastPointerCount;
    private float lastCenterX, lastCenterY;
    /**
     * 上下，左右移动距离
     */
    private float touchSlop;
    private boolean isCanDrag;

    public ZoomImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        matrix = new Matrix();
        scaleGestureDetector = new ScaleGestureDetector(context, this);
        this.setOnTouchListener(this);
        touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        setScaleType(ScaleType.MATRIX);
        gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onDoubleTap(MotionEvent e) {
                if (isDoubleScale) {
                    return true;
                }

                System.out.println("ondouble tap");
                isDoubleScale = true;

                float x = e.getX();
                float y = e.getY();
                float currentScale = getScale();
                //缩小
                if (currentScale >= mMidScale) {
//                    matrix.postScale(mInitScale/currentScale, mInitScale/currentScale, x, y);
                    postDelayed(new AutoScaleRunnable(mInitScale, x, y), 20);
                } else {//放大
//                    matrix.postScale(mMidScale/currentScale, mMidScale/currentScale, x, y);
                    postDelayed(new AutoScaleRunnable(mMidScale, x, y), 20);
                }
                setImageMatrix(matrix);
                return true;
            }
        });
    }

    private class AutoScaleRunnable implements Runnable {

        /**
         * 目标缩放比例
         */
        private float targetScale;
        /**
         * 中心点
         */
        private float centerX, centerY;
        private static final float BIGGER = 1.07f;
        private static final float SMALLER = 0.93f;

        private float tempScale;

        public AutoScaleRunnable(float targetScale, float centerX, float centerY) {
            this.targetScale = targetScale;
            this.centerX = centerX;
            this.centerY = centerY;

            if (getScale() < targetScale) {
                tempScale = BIGGER;
            } else {
                tempScale = SMALLER;
            }
        }

        @Override
        public void run() {
            matrix.postScale(tempScale, tempScale, centerX, centerY);
            checkBorderAndCenterWhenScale();
            setImageMatrix(matrix);

            float currentScale = getScale();
            if ((tempScale > 1 && currentScale < targetScale) || (tempScale < 1 && currentScale > targetScale)) {
                postDelayed(this, 20);
            } else {
                matrix.postScale(targetScale/currentScale, targetScale/currentScale, centerX, centerY);
                checkBorderAndCenterWhenScale();
                setImageMatrix(matrix);
            }

            isDoubleScale = false;
        }


    }

    public ZoomImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public ZoomImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ZoomImageView(Context context) {
        this(context, null);
    }


    /**
     * 当view加到window中时调用
     */
    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        //注册事件
        getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    /**
     * 当view从window上销毁时调用
     */
    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        //移除事件
        getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }

    /**
     *  该接口 OnGlobalLayoutListener
     *  当全局布局完成以后调用该方法
     */
    @Override
    public void onGlobalLayout() {
        //因为图片宽高度可能大于或小于控件宽高度，所以要把图片进行缩放。
        //当控件加载完图片后， 得到控件和图片的宽度以及高度。并计算缩放因子。

        //只初始化一次
        if (isOnce == false) {

            float scale = 1.0f;

            //控件宽度和高度
            int width = getWidth();
            int height = getHeight();

            //得到图片宽度和高度
            Drawable drawable = getDrawable();
            //没有设置图片
            if (drawable == null) {
                return;
            }

            int dw = drawable.getIntrinsicWidth();
            int dh = drawable.getIntrinsicHeight();

            if (dh > height && dw < width) {
                scale = height * 1.0f / dh;
            }

            if (dh < height && dw > width) {
                scale = width * 1.0f / dw;
            }

            if ((dh > height && dw > width) || (dh < height && dw < width)) {
                scale = Math.min(height*1.0f / dh, width*1.0f/dw);
            }

            //得到缩放因子
            mInitScale = scale;
            mMidScale = scale * 2;
            mMaxScale = scale * 4;

            //平移到控件中心
            int dx = getWidth()/2 - dw/2;
            int dy = getHeight()/2 - dh/2;

            matrix.postTranslate(dx, dy);
            //前面两个参数是x和y方向缩放比例，后面两个参数是中心点。
            matrix.postScale(mInitScale, mInitScale, getWidth()/2, getHeight()/2);

            setImageMatrix(matrix);

            isOnce = true;
        }
    }

    /**
     * 获得当前缩放比例
     * @return
     */
    private float getScale(){
        float[] values = new float[9];
        matrix.getValues(values);
        return  values[Matrix.MSCALE_X];
    }

    /**
        多指缩放
     */
    @Override
    public boolean onScale(ScaleGestureDetector detector) {
        float scaleFactor = detector.getScaleFactor();
        float currentScale = getScale();

        if (getDrawable() == null) {
            return true;
        }

        //是否允许缩放
        if ((currentScale <= mMaxScale && scaleFactor > 1.0f) || (currentScale >= mInitScale && scaleFactor < 1.0f)) {


            if (currentScale*scaleFactor > mMaxScale) {
                scaleFactor = mMaxScale / currentScale;
            }

            if (currentScale*scaleFactor < mInitScale) {
                scaleFactor = mInitScale / currentScale;
            }

            //在多点的中心进行缩放
            matrix.postScale(scaleFactor, scaleFactor, detector.getFocusX(), detector.getFocusY());

            checkBorderAndCenterWhenScale();
            setImageMatrix(matrix);
        }
        return true;
    }

    private void checkBorderAndCenterWhenScale() {

        //获得图片四个顶点和宽高度
        RectF rect = getImageRect();
        if (rect != null) {
            float dx = 0.0f, dy = 0.0f;
            //当图片宽或高度大于控件宽和高度时，别让留下空白区域。
            if (rect.width() >= getWidth()) {
                if (rect.left > 0) {
                    dx = -rect.left;
                }
                if (rect.right < getWidth()){
                    dx = getWidth() - rect.right;
                }
            }
            if (rect.height() >= getHeight()) {
                if (rect.top > 0) {
                    dy = -rect.top;
                }
                if(rect.bottom < getHeight()){
                    dy = getHeight() -rect.bottom;
                }
            }

            //当图片宽或高度小于控件宽和高度时，让其居中。
            if (rect.width() < getWidth()) {
                dx = getWidth()/2.0f - rect.right + rect.width()/2.0f;
            }
            if (rect.height() < getHeight()) {
                dy = getHeight()/2.0f - rect.bottom + rect.height()/2.0f;
            }

            matrix.postTranslate(dx, dy);
        }

    }

    private RectF getImageRect(){
        RectF rectF = new RectF();
        Drawable drawable = getDrawable();
        if (drawable != null) {

            rectF.set(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            matrix.mapRect(rectF);
            return rectF;
        }
        return null;
    }

    @Override
    public boolean onScaleBegin(ScaleGestureDetector detector) {

        return true;
    }

    @Override
    public void onScaleEnd(ScaleGestureDetector detector) {

    }

    public boolean isMoveTrans(float x, float y){
        return Math.sqrt(x*x + y*y) > touchSlop;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        System.out.println("imageview ontouch");

        if (this.gestureDetector.onTouchEvent(event)) {
            return true;
        }
        this.scaleGestureDetector.onTouchEvent(event);

        float centerX = 0.0f, centerY = 0.0f;
        for (int i = 0; i < event.getPointerCount(); i++) {
            centerX += event.getX(i);
            centerY += event.getY(i);
        }

        if (event.getPointerCount() != lastPointerCount) {
            lastPointerCount = event.getPointerCount();
            lastCenterX = centerX;
            lastCenterY = centerY;
            isCanDrag = false;
        }

        //获得多触控点的中心点
        centerX /= event.getPointerCount();
        centerY /= event.getPointerCount();

        RectF rect = getImageRect();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (rect.width() > getWidth() || rect.height() > getHeight()) {
                    if (getParent() instanceof ViewPager) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (rect.width() > getWidth() || rect.height() > getHeight()) {
                    if (getParent() instanceof ViewPager) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                }

                float dx = centerX - lastCenterX;
                float dy = centerY - lastCenterY;

                if (!isCanDrag) {
                    isCanDrag = isMoveTrans(dx, dy);
                }

                if (isCanDrag) {
                    Drawable drawable = getDrawable();
                    if (drawable == null) {
                        return true;
                    }
                    RectF imageRect = getImageRect();

                    if (imageRect.width() < getWidth()) {
                        dx = 0;
                    }

                    if (imageRect.height() < getHeight()) {
                        dy = 0;
                    }

                    matrix.postTranslate(dx, dy);
                    checkBorderWhenTran();
                    setImageMatrix(matrix);
                }
                lastCenterX = centerX;
                lastCenterY = centerY;
                break;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                lastPointerCount = 0;
                break;
        }


        return true;
    }

    private void checkBorderWhenTran() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            RectF imageReacF = getImageRect();
            float dx=0.0f, dy=0.0f;

            /**
             * 当图片宽度大于控件宽度时， 移动检查边界问题
             */
            if (imageReacF.width() > getWidth()) {
                if (imageReacF.left > 0) {
                    dx = -imageReacF.left;
                }
                if (imageReacF.right < getWidth()) {
                    dx = getWidth() - imageReacF.right;
                }
            }

            /**
             * 当图片高度大于控件高度时， 移动检查边界问题
             */
            if (imageReacF.height() > getHeight()) {
                if (imageReacF.top > 0) {
                    dy = -imageReacF.top;
                }

                if (imageReacF.bottom < getHeight()) {
                    dy = getHeight() - imageReacF.bottom;
                }
            }
            matrix.postTranslate(dx, dy);
        }
    }
}

