package com.epdc.commonusewidget;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Epdc on 2015/8/30.
 */
public class BaseAdapterActivity extends ListActivity{

    private MyBaseAdapter<String> baseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_baseadapter);

        List<String> data = new ArrayList<>();
        data.add("javascript");
        data.add("android");
        data.add("ionic");

        baseAdapter = new MyBaseAdapter(this, android.R.layout.simple_list_item_1, data) {
            @Override
            protected void initView(int position, View view, ViewGroup parent) {
                ((TextView)view).setText(baseAdapter.getItem(position));
            }
        };

        setListAdapter(baseAdapter);
    }
}
