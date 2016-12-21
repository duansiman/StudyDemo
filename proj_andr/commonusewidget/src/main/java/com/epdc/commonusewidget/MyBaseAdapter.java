package com.epdc.commonusewidget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Epdc on 2015/8/30.
 */
public abstract class MyBaseAdapter<T> extends BaseAdapter {

    private Context context;
    private int resId;
    private List<T> data;

    public MyBaseAdapter(Context context, int resId, List<T> data) {
        this.context = context;
        this.resId = resId;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public T getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(resId,null);
        }

        initView(position,convertView,parent);

        return convertView;
    }

    protected abstract void initView(int position, View view, ViewGroup parent);
}
