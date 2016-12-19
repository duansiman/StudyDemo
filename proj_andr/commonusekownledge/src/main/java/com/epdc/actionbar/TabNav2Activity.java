package com.epdc.actionbar;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.epdc.actionbar.fragment.Dummy2Fragment;
import com.epdc.actionbar.fragment.DummyFragment;
import com.epdc.fragment.R;

/**
 * 早期版本是否fragment 借助于FragmentActivity
 *
 * 该类提供 getSupportFragmentManager() 获取FragmentManager
 */

public class TabNav2Activity extends android.support.v4.app.FragmentActivity implements ActionBar.TabListener {

    ViewPager viewPager;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_nav2);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        actionBar = getActionBar();

        FragmentPagerAdapter pagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Dummy2Fragment fragment = new Dummy2Fragment();
                //传递参数
                Bundle args = new Bundle();
                args.putInt(DummyFragment.ARG_SECTION_NUMBER, position);
                fragment.setArguments(args);
                return fragment;
            }

            @Override
            public int getCount() {
                return 3;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position) {
                    case 0:
                        return "第一页";
                    case 1:
                        return "第二页";
                    case 2:
                        return "第三页";

                }
                return null;
            }
        };

        viewPager.setAdapter(pagerAdapter);

        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        for (int i = 0; i<pagerAdapter.getCount(); i++) {
            //添加tab
            actionBar.addTab(actionBar.newTab().setTabListener(this).setText(pagerAdapter.getPageTitle(i)));
        }

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
