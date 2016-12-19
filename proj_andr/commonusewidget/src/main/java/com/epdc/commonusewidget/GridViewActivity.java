package com.epdc.commonusewidget;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.epdc.commonusekownledge.R;

/**
 * 网格布局,和ListView用法差不多，相当于水平和垂直ListView
 * Created by Epdc on 2015/8/28.
 */
public class GridViewActivity extends Activity{

    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);

        gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,new String[]{"java","javascript","ionic","c++","c","android"}));

    }
}
