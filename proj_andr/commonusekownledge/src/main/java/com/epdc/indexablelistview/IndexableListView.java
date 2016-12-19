package com.epdc.indexablelistview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by Administrator on 2016/2/21.
 */
public class IndexableListView extends ListView {

    private boolean mIsFastScrollEnabled = false;
    //绘制右边索引条
    private IndexScroller indexScroller;

    private GestureDetector gestureDetector;

    public IndexableListView(Context context) {
        super(context);
    }

    public IndexableListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public IndexableListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setOnItemClickListener(OnItemClickListener listener) {
        super.setOnItemClickListener(listener);
    }

    public boolean isFastScrollEnabled(){
        return mIsFastScrollEnabled;
    }

    @Override
    public void setFastScrollEnabled(boolean enabled) {
        mIsFastScrollEnabled = enabled;

        if (mIsFastScrollEnabled) {
            if (indexScroller == null) {
                indexScroller = new IndexScroller(getContext(), this);
            }
        } else {
            if (indexScroller != null) {
                indexScroller.hide();
                indexScroller = null;
            }
        }

        super.setFastScrollEnabled(enabled);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (indexScroller != null) {
            indexScroller.draw(canvas);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        if (indexScroller != null && indexScroller.onTouchEvent(ev)) {
            return true;
        }

        if (gestureDetector == null) {
            gestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener(){
                @Override
                public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                    indexScroller.show();
                    return super.onFling(e1, e2, velocityX, velocityY);
                }
            });
        }
        gestureDetector.onTouchEvent(ev);
        return super.onTouchEvent(ev);
    }

    @Override
    public void setAdapter(ListAdapter adapter) {
        super.setAdapter(adapter);
        if (indexScroller != null) {
            indexScroller.setAdapter(adapter);
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (indexScroller != null) {
            indexScroller.onSizeChanged(w, h, oldw, oldh);
        }
    }
}
