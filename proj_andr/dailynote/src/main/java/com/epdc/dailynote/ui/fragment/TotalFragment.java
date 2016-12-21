package com.epdc.dailynote.ui.fragment;

import com.epdc.commonlib.ui.BaseFragment;
import com.epdc.commonlib.widget.ViewHolder;
import com.epdc.dailynote.R;

/**
 * Created by epdc on 2016/7/3.
 */
public class TotalFragment extends BaseFragment {

    @Override
    protected ViewHolder initHolder() {
        return new ViewHolder(mActivity, R.layout.fragment_total);
    }

    @Override
    protected void initView() {
        setTitle("合计");
    }
}
