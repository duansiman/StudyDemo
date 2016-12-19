package com.epdc.actionbar;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.epdc.actionbar.fragment.DummyFragment;
import com.epdc.fragment.R;

public class TabNavActivity extends Activity implements ActionBar.TabListener {

    private ActionBar actionBar;
    final String SELECT_ITEM = "select_item";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_nav);

        actionBar = getActionBar();

        //设置Actionbar导航方式
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        actionBar.addTab(actionBar.newTab().setText("第一页").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("第二页").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("第三页").setTabListener(this));
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        //恢复数据
        int selectItem = savedInstanceState.getInt(SELECT_ITEM);
        actionBar.setSelectedNavigationItem(selectItem);
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //保存数据
        outState.putInt(SELECT_ITEM, actionBar.getSelectedNavigationIndex());
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        DummyFragment fragment = new DummyFragment();
        //传递参数
        Bundle args = new Bundle();
        args.putInt(DummyFragment.ARG_SECTION_NUMBER, tab.getPosition());
        fragment.setArguments(args);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        //替换R.id.container组件
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
