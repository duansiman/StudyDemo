package com.epdc.indexablelistview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.widget.ListAdapter;
import android.widget.SectionIndexer;


/**
 * Created by Administrator on 2016/2/21.
 */
public class IndexScroller {

    float mIndexbarWidth;
    float mIndexbarMargin;
    float mPreviewPadding;
    float mDensity;
    float mScaledDensity;
    float mAlphaRate;
    int mState = STATE_HIDDEN;
    int mListViewWidth;
    int mListViewHeight;
    SectionIndexer mSectionIndexer;
    String[] mSections;
    RectF mIndexbarRect;
    IndexableListView mListView;

    static final int STATE_HIDDEN = 0;
    static final int STATE_SHOWING = 1;
    static final int STATE_SHOWN = 2;
    static final int STATE_HIDING = 3;

    private int mCurrentSection = -1;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (mState) {
                case STATE_SHOWING:
                    mAlphaRate += (1 - mAlphaRate)*0.2;
                    if (mAlphaRate > 0.9) {
                        mAlphaRate = 1;
                        setState(STATE_SHOWN);
                    }
                    mListView.invalidate();
                    fade(10);
                    break;
                case STATE_SHOWN:
                    setState(STATE_HIDING);
                    break;
                case STATE_HIDING:
                    mAlphaRate -= mAlphaRate*0.2;
                    if (mAlphaRate < 0.1) {
                        mAlphaRate = 0;
                        setState(STATE_HIDDEN);
                    }
                    mListView.invalidate();
                    fade(10);
                    break;
            }
        }
    };
    private boolean mIsIndexing;

    public void setState(int state){
        if (state < STATE_HIDDEN || state > STATE_HIDING) {
            return;
        }

        mState = state;
        switch (mState) {
            case STATE_HIDDEN:
                handler.removeMessages(0);
                break;
            case STATE_SHOWING:
                mAlphaRate = 0;
                fade(0);
                break;
            case STATE_SHOWN:
                handler.removeMessages(0);
                break;
            case STATE_HIDING:
                mAlphaRate = 1;
                fade(3000);
                break;
        }
    }

    private void fade(long delay) {
        handler.removeMessages(0);
        handler.sendEmptyMessageAtTime(0, SystemClock.uptimeMillis() + delay);
    }

    public IndexScroller(Context context, IndexableListView indexableListView) {
        mDensity = context.getResources().getDisplayMetrics().density;
        mScaledDensity = context.getResources().getDisplayMetrics().scaledDensity;
        mListView = indexableListView;

        mIndexbarWidth = 20 * mDensity;
        mIndexbarMargin = 10 * mDensity;
        mPreviewPadding = 5 * mDensity;

        setAdapter(mListView.getAdapter());
    }

    public void hide() {
        mState = STATE_HIDING;
    }

    public void draw(Canvas canvas) {
        if (mState == STATE_HIDDEN) {
            return;
        }
        Paint indexbarPaint = new Paint();
        indexbarPaint.setColor(Color.BLACK);
        indexbarPaint.setAlpha((int) (64 * mAlphaRate));

        canvas.drawRoundRect(mIndexbarRect, 5 * mDensity, 5 * mDensity, indexbarPaint);

        if (mCurrentSection >= 0) {
            Paint previewPaint = new Paint();
            previewPaint.setColor(Color.BLACK);
            previewPaint.setAlpha(96);


            Paint previewTextPaint = new Paint();
            previewTextPaint.setColor(Color.WHITE);
            previewTextPaint.setTextSize(50 * mScaledDensity);

            float previewTextWidth = previewTextPaint.measureText(mSections[mCurrentSection]);
            float previewHeight = 2 * mPreviewPadding + previewTextPaint.descent() - previewTextPaint.ascent();
            RectF previewRect = new RectF(
                    (mListViewWidth - previewHeight) / 2,
                    (mListViewHeight - previewHeight) / 2,
                    (mListViewWidth - previewHeight) / 2 + previewHeight,
                    (mListViewHeight - previewHeight) / 2 + previewHeight);

            canvas.drawRoundRect(previewRect, 5*mDensity, 5*mDensity, previewPaint);
            canvas.drawText(mSections[mCurrentSection],
                    previewRect.left + (previewHeight - previewTextWidth) / 2 - 1,
                    previewRect.top + mPreviewPadding - previewTextPaint.ascent() + 1, previewTextPaint);
        }

        Paint indexTextPaint = new Paint();
        indexTextPaint.setColor(Color.WHITE);
        indexTextPaint.setAlpha((int) (255*mAlphaRate));
        indexTextPaint.setTextSize(12 * mScaledDensity);

        float sectionHeight = (mIndexbarRect.height() - 2*mIndexbarMargin)/mSections.length;
        float paddingTop = (sectionHeight - (indexTextPaint.descent() - indexTextPaint.ascent())) / 2;

        for (int i = 0; i < mSections.length; i++) {
            float paddingLeft = (mIndexbarWidth - indexTextPaint.measureText(mSections[i]))/2;
            canvas.drawText(mSections[i], mIndexbarRect.left + paddingLeft,
                    mIndexbarRect.top + paddingTop + mIndexbarMargin + sectionHeight * i - indexTextPaint.ascent(), indexTextPaint);
        }

    }

    public void show() {
        mState = STATE_SHOWN;
    }

    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (mState != STATE_HIDDEN && contains(ev.getX(), ev.getY())) {
                    setState(STATE_SHOWN);
                    mIsIndexing = true;
                    mCurrentSection = getSectionByPoint(ev.getY());
                    mListView.setSelection(mSectionIndexer.getPositionForSection(mCurrentSection));
                    return true;
                }

                break;
            case MotionEvent.ACTION_MOVE:
                if (mIsIndexing) {
                    if (contains(ev.getX(), ev.getY())) {
                        setState(STATE_SHOWN);
                        mCurrentSection = getSectionByPoint(ev.getY());
                        mListView.setSelection(mSectionIndexer.getPositionForSection(mCurrentSection));
                        return true;
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                if (mIsIndexing) {
                    mIsIndexing = false;
                    mCurrentSection = -1;
                }
                if (mState == STATE_SHOWN) {
                    setState(STATE_HIDING);
                }
                break;
        }
        return false;
    }

    private int getSectionByPoint(float y) {
        float sectionHeight = (mIndexbarRect.height() - 2*mIndexbarMargin)/mSections.length;

        int position = (int) ((y - mIndexbarMargin) / sectionHeight) - 1;
        if (position > 26) {
            position = 26;
        }
        return position;
    }

    private boolean contains(float x, float y) {
        if (x > mIndexbarRect.left && x < mIndexbarRect.right) {
            return true;
        }
        return false;
    }

    public void setAdapter(ListAdapter adapter) {
        if (adapter instanceof SectionIndexer) {
            mSectionIndexer = (SectionIndexer) adapter;
            mSections = (String[]) mSectionIndexer.getSections();
        }
    }

    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        mListViewWidth = w;
        mListViewHeight = h;

        mIndexbarRect = new RectF(w - mIndexbarWidth - mIndexbarMargin, mIndexbarMargin, w-mIndexbarMargin, h-mIndexbarMargin);
    }
}
