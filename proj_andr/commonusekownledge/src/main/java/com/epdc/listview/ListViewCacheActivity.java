package com.epdc.listview;

import android.app.ListActivity;
import android.os.Bundle;

import com.epdc.listview.adapter.CacheAdapter;

/**
 *  ListView 实现图片缓存
 * Created by Epdc on 2015/9/16.
 */
public class ListViewCacheActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new CacheAdapter(this));
    }
}
