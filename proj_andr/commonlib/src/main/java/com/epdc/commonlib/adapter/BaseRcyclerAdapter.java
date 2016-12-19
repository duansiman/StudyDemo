package com.epdc.commonlib.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.epdc.commonlib.utils.LogUtil;
import com.epdc.commonlib.widget.ViewHolder;

import java.util.List;

/**
 * Created by epdc on 2016/7/4.
 */
public abstract class BaseRcyclerAdapter<D> extends RecyclerView.Adapter<BaseRcyclerAdapter.RcyclerHolder> {

    private List<D> datas;
    private int resId;

    private Context mContext;

    public BaseRcyclerAdapter(Context mContext, List<D> datas, int resId) {
        LogUtil.d("BaseRcyclerAdapter");
        this.datas = datas;
        this.resId = resId;
        this.mContext = mContext;
    }

    @Override
    public RcyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LogUtil.d("onCreateViewHolder");
        ViewHolder viewHolder = new ViewHolder(mContext, resId);
        return new RcyclerHolder(viewHolder.getRootView());
    }

    @Override
    public void onBindViewHolder(RcyclerHolder holder, int position) {
        LogUtil.d("onBindViewHolder");
        ViewHolder viewHolder = (ViewHolder) holder.getItemView().getTag();
        LogUtil.d("viewHolder: " + viewHolder);
        bindView(viewHolder, datas.get(position), position);
    }

    public abstract void bindView(ViewHolder viewHolder, D data, int position);

    @Override
    public int getItemCount() {
        return datas.size();
    }

    static class RcyclerHolder extends RecyclerView.ViewHolder {

        private View view;

        public RcyclerHolder(View itemView) {
            super(itemView);
            view = itemView;
        }

        public View getItemView() {
            return view;
        }
    }
}
