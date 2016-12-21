package com.epdc.drawerLayout;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.epdc.fragment.R;

public class DrawerLayoutActivity extends Activity implements AdapterView.OnItemClickListener {

    private ListView mLv;
    private String[] str;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_layout);

        mLv = (ListView) findViewById(R.id.id_lv);
        str = new String[] { "item1", "item2", "item3"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, str);
        mLv.setAdapter(adapter);
        mLv.setOnItemClickListener(this);

        mDrawerLayout = (DrawerLayout)findViewById(R.id.id_drawerlayout);

        /*mDrawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
            *//**
             * 当抽屉滑动状态改变的时候被调用
             * 状态值是STATE_IDLE（闲置--0）, STATE_DRAGGING（拖拽的--1）, STATE_SETTLING（固定--2）中之一。
             * 抽屉打开的时候，点击抽屉，drawer的状态就会变成STATE_DRAGGING，然后变成STATE_IDLE
             *//*
            @Override
            public void onDrawerStateChanged(int arg0) {
                Log.i("drawer", "drawer的状态：" + arg0);
            }

            *//**
             * 当抽屉被滑动的时候调用此方法
             * arg1 表示 滑动的幅度（0-1）
             *//*
            @Override
            public void onDrawerSlide(View arg0, float arg1) {
                Log.i("drawer", arg1 + "");
            }

            *//**
             * 当一个抽屉被完全打开的时候被调用
             *//*
            @Override
            public void onDrawerOpened(View arg0) {
                Log.i("drawer", "抽屉被完全打开了！");
            }

            *//**
             * 当一个抽屉完全关闭的时候调用此方法
             *//*
            @Override
            public void onDrawerClosed(View arg0) {
                Log.i("drawer", "抽屉被完全关闭了！");
            }
        });
*/
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.drawable.ic_launcher, R.string.drawer_open,
                R.string.drawer_close) {
            @Override
            public void onDrawerClosed(View drawerView) {
                getActionBar().setTitle("closed");
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                getActionBar().setTitle("opend");
                invalidateOptionsMenu();
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
