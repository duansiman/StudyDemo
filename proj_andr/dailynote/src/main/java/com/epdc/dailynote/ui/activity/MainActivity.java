package com.epdc.dailynote.ui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.epdc.commonlib.adapter.ViewPagerFragmentAdpater;
import com.epdc.commonlib.ui.BaseActivity;
import com.epdc.commonlib.ui.BaseFragment;
import com.epdc.commonlib.widget.ViewHolder;
import com.epdc.dailynote.R;
import com.epdc.dailynote.ui.fragment.DetialFragment;
import com.epdc.dailynote.ui.fragment.SharerFragment;
import com.epdc.dailynote.ui.fragment.TotalFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {


    @Override
    protected ViewHolder initHolder() {
        return new ViewHolder(mContext, R.layout.activity_main);
    }

    @Override
    protected void initView() {
        setEnableTitle(false);

        TabLayout tabLayout = holder.get(R.id.tablayout);
        final ViewPager viewPager = holder.get(R.id.viewpager);

        List<BaseFragment> data = new ArrayList<>(3);
        data.add(new DetialFragment());
        data.add(new SharerFragment());
        data.add(new TotalFragment());

        List<String> titles = new ArrayList<>();
        titles.add("明细");
        titles.add("合租人");
        titles.add("合计");

        viewPager.setAdapter(new ViewPagerFragmentAdpater<>(getSupportFragmentManager(), data, titles));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_menu_copy_holo_light);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_menu_allfriends);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_menu_emoticons);
    }
}
