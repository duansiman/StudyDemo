package com.example.animation;

import android.view.View;

/**
 * Created by epdc on 2016/8/28.
 */
public class WrapperView {

    private View mTarget;

    public WrapperView(View mTarget) {
        this.mTarget = mTarget;
    }

    public int getWidth(){
        return mTarget.getLayoutParams().width;
    }

    public void setWidth(int width){
        mTarget.getLayoutParams().width = width;
        mTarget.requestLayout();

    }
}
