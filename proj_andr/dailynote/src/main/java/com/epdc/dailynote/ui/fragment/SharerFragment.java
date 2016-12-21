package com.epdc.dailynote.ui.fragment;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.epdc.commonlib.adapter.BaseRcyclerAdapter;
import com.epdc.commonlib.decoration.DividerItemDecoration;
import com.epdc.commonlib.entity.MsgBean;
import com.epdc.commonlib.ui.BaseFragment;
import com.epdc.commonlib.utils.IntentUtil;
import com.epdc.commonlib.widget.ViewHolder;
import com.epdc.dailynote.R;
import com.epdc.dailynote.entity.Sharer;
import com.epdc.dailynote.presenter.SharerPresenter;
import com.epdc.dailynote.ui.activity.EditSharerInfoActivity;
import com.epdc.dailynote.ui.activity.SharerInfoActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by epdc on 2016/7/3.
 */
public class SharerFragment extends BaseFragment {

    private RecyclerView recyclerView;
    private List<Sharer> sharers = new ArrayList<>();
    private SharerPresenter presenter;
    private SharerAdapter sharerAdapter;

    @Override
    protected ViewHolder initHolder() {
        return new ViewHolder(mActivity, R.layout.fragment_sharer);
    }

    @Override
    protected void initView() {
        setTitle("合租人");
        recyclerView = holder.get(R.id.recyclerView);

        sharerAdapter = new SharerAdapter(mActivity, sharers, R.layout.recycler_item_sharer);
        recyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        recyclerView.setAdapter(sharerAdapter);

        recyclerView.addItemDecoration(new DividerItemDecoration(mActivity,
                DividerItemDecoration.VERTICAL_LIST));

        presenter = new SharerPresenter(this);
    }

    @Override
    protected void initEvent() {
        holder.setInternalViewClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentUtil.startActivity(mActivity, EditSharerInfoActivity.class);
            }
        }, R.id.add_sharer);
    }

    @Override
    protected void initData() {
        presenter.queryAllSharer(0, true);
    }

    @Override
    public void onEvent(MsgBean msgBean) {
        super.onEvent(msgBean);
        if (msgBean.type == MsgBean.Type.REFRESH_SHARER) {
            presenter.queryAllSharer(0, false);
        }
    }

    @Override
    public void onPresenterNotify(int reqCode, int resultCode, Map<String, Object> data) {
        if (resultCode == 0) {
            List<Sharer> temps = (List<Sharer>) data.get("data");
            sharers.clear();
            sharers.addAll(temps);
            sharerAdapter.notifyDataSetChanged();
        }
    }

    private class SharerAdapter extends BaseRcyclerAdapter<Sharer> {

        public SharerAdapter(Context mContext, List<Sharer> datas, @LayoutRes int resId) {
            super(mContext, datas, resId);
        }

        @Override
        public void bindView(ViewHolder viewHolder, Sharer data, final int position) {
            ImageView imageHead = viewHolder.get(R.id.image_head);
            TextView textName = viewHolder.get(R.id.text_name);
            textName.setText(data.getName());

            viewHolder.getRootView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    IntentUtil.startActivity(mActivity, SharerInfoActivity.class,
                            SharerInfoActivity.KEY_SHARER, sharers.get(position));
                }
            });

        }
    }
}
