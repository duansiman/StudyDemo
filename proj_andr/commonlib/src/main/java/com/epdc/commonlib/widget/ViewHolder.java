package com.epdc.commonlib.widget;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by wzb on 2016/5/5 005.
 */
public class ViewHolder {
    protected int layoutId;
    protected View rootView;
    protected SparseArray<View> viewHolder;

    public ViewHolder(Context context, @LayoutRes int layoutId) {
        this(context, layoutId, null);
    }

    public ViewHolder(Context context, @LayoutRes int layoutId, ViewGroup parent) {
        this(LayoutInflater.from(context).inflate(layoutId, parent));
        this.layoutId = layoutId;
    }

    public ViewHolder(View rootView) {
        if (rootView == null) {
            throw new IllegalArgumentException("The rootView cannot be null!!!");
        }
        int spec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.EXACTLY);
        rootView.measure(spec, spec);
        this.rootView = rootView;
        this.rootView.setTag(this);
    }

    public void remeasure() {
        if (rootView != null) {
            rootView.measure(0, 0);
        }
    }

    public ViewGroup.LayoutParams getMeasureLayoutParam() {
        if (rootView != null) {
            remeasure();
            return rootView.getLayoutParams();
        }
        return null;
    }

    public <T extends View> T get(@IdRes int id) {
        if (viewHolder == null) {
            viewHolder = new SparseArray<>();
//            rootView.setTag(viewHolder);
        }
        View view = viewHolder.get(id);
        if (view == null) {
            view = rootView.findViewById(id);
            viewHolder.put(id, view);
        }
        return (T) view;
    }

    public <T extends View> T getRootView() {
        return (T) this.rootView;
    }

    public int getLayoutId() {
        return layoutId;
    }

    public void setInternalViewClickListener(View.OnClickListener listener, @IdRes int... ids) {
        if (listener != null) {
            for (int id : ids) {
                View view = get(id);
                if (view != null)
                    view.setOnClickListener(listener);
            }
        }
    }

    public void release() {
        rootView = null;
    }
}
