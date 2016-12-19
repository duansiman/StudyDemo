package com.epdc.commonlib.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.epdc.commonlib.R;
import com.epdc.commonlib.entity.MsgBean;
import com.epdc.commonlib.listener.OnPresenterNotifyListener;
import com.epdc.commonlib.widget.ViewHolder;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.Map;

/**
 * Created by epdc on 2016/7/3.
 */
public abstract class BaseFragment extends Fragment implements OnPresenterNotifyListener{

    protected ViewHolder holder;
    private TextView textTitle;
    protected BaseActivity mActivity;
    private RelativeLayout toolbar;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mActivity = (BaseActivity) getActivity();

        return initWidget();
    }

    private View initWidget(){
        ViewHolder viewHolder = new ViewHolder(mActivity, R.layout.fragment_base);

        toolbar = viewHolder.get(R.id.toolbar);
        textTitle = viewHolder.get(R.id.title);

        FrameLayout contentMain = viewHolder.get(R.id.content_main);
        holder = initHolder();
        initView();
        initEvent();
        initData();
        contentMain.addView(holder.getRootView());


        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }


        return viewHolder.getRootView();
    }

    protected abstract ViewHolder initHolder();
    protected  void initView(){}
    protected  void initEvent(){}
    protected  void initData(){}

    public void setTitle(String title) {
        textTitle.setText(title);
    }

    public void setEnableTitle(boolean enable) {
        toolbar.setVisibility(enable?View.VISIBLE:View.GONE);
    }

    @Override
    public void onPresenterNotify(int reqCode, int resultCode, Map<String, Object> data) {
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void onEvent(MsgBean msgBean){
    }
}
