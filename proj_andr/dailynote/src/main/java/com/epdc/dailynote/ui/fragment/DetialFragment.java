package com.epdc.dailynote.ui.fragment;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.TextView;

import com.epdc.commonlib.adapter.BaseRcyclerAdapter;
import com.epdc.commonlib.ui.BaseFragment;
import com.epdc.commonlib.utils.LogUtil;
import com.epdc.commonlib.widget.ViewHolder;
import com.epdc.dailynote.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by epdc on 2016/7/3.
 */
public class DetialFragment extends BaseFragment {

    private RecyclerView recyclerView;

    @Override
    protected ViewHolder initHolder() {
        return new ViewHolder(mActivity, R.layout.fragment_detial);
    }

    @Override
    protected void initView() {
        super.initView();
        setTitle("明细");
        recyclerView = holder.get(R.id.recyclerView);
        List<String> detials = new ArrayList<>();
        detials.add("hello");
        detials.add("world");

        DetialAdapter detialAdapter = new DetialAdapter(mActivity, detials, R.layout.recycler_item_detial);
        recyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        recyclerView.setAdapter(detialAdapter);
    }

    private class DetialAdapter extends BaseRcyclerAdapter<String> {

        public DetialAdapter(Context mContext, List<String> datas, @LayoutRes int resId) {
            super(mContext, datas, resId);
        }

        @Override
        public void bindView(ViewHolder viewHolder, String data, int position) {

            LogUtil.d("bindView");
            TextView text = viewHolder.getRootView();
            text.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            text.setText(data);

        }
    }
}
