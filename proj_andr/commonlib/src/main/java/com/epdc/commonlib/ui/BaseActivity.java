package com.epdc.commonlib.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
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
public abstract class BaseActivity extends AppCompatActivity implements OnPresenterNotifyListener {


    protected ViewHolder holder;
    private TextView textTitle;
    protected Context mContext;
    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(initWidget());

        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    private View initWidget(){
        ViewHolder viewHolder = new ViewHolder(this, R.layout.activity_base);


        toolbar = viewHolder.get(R.id.toolbar);
        setSupportActionBar(toolbar);

        textTitle = viewHolder.get(R.id.title);
        textTitle.setText(getTitle());
        ImageView imageBack = viewHolder.get(R.id.image_back);
        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                close();
            }
        });

        FrameLayout contentMain = viewHolder.get(R.id.content_main);
        holder = initHolder();
        initView();
        initEvent();
        initData();
        contentMain.addView(holder.getRootView());

        return viewHolder.getRootView();
    }

    protected abstract ViewHolder initHolder();
    protected  void initView(){}
    protected  void initEvent(){}
    protected  void initData(){}

    public void close(){finish();}
    public void setEnableTitle(boolean enable) {
        toolbar.setVisibility(enable?View.VISIBLE:View.GONE);
    }

    public void setTitle(String title) {
        textTitle.setText(title);
    }

    @Override
    public void onPresenterNotify(int reqCode, int resultCode, Map<String, Object> data) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void onEvent(MsgBean msgBean){
    }
}
