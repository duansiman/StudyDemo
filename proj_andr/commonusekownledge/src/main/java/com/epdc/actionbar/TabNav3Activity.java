package com.epdc.actionbar;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.epdc.actionbar.fragment.DummyFragment;
import com.epdc.fragment.R;

public class TabNav3Activity extends Activity implements ActionBar.OnNavigationListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_nav3);

        ActionBar actionBar = getActionBar();
        //下拉列表导航
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

        actionBar.setListNavigationCallbacks(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, new String[]{"第一页","第二页","第三页"}), this);
    }

    /**
     * 下拉列表 监听
     * @param itemPosition
     * @param itemId
     * @return
     */
    @Override
    public boolean onNavigationItemSelected(int itemPosition, long itemId) {
        DummyFragment fragment = new DummyFragment();
        //传递参数
        Bundle args = new Bundle();
        args.putInt(DummyFragment.ARG_SECTION_NUMBER, itemPosition);
        fragment.setArguments(args);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        //替换R.id.container组件
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
        return true;
    }
}
