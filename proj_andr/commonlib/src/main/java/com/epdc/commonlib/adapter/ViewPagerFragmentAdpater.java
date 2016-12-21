package com.epdc.commonlib.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by epdc on 2016/7/3.
 */
public class ViewPagerFragmentAdpater<T extends Fragment> extends FragmentPagerAdapter {

    private List<T> data;
    private List<String> titls;

    public ViewPagerFragmentAdpater(FragmentManager fm, List<T> data,List<String> titls) {
        super(fm);
        this.data = data;
        this.titls = titls;
    }

    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titls.get(position);
    }
}
