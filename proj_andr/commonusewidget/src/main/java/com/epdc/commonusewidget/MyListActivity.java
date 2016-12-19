package com.epdc.commonusewidget;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.epdc.commonusekownledge.R;

/**
 * 使用ListActivity 创建listView
 * Created by Epdc on 2015/8/22.
 */
public class MyListActivity extends ListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_activity_layout);
        setListAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,new String[]{"test1","test2","test1","test2","test1","test2","test1","test2","test1","test2","test1","test2","test1","test2","test1","test2","test1","test2","test1","test2","test1","test2","test1","test2","test1","test2"}));
    }
}
