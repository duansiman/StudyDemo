package com.epdc.commonusewidget;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Gallery;

import com.epdc.commonusekownledge.R;

/**
 * 画廊 控件
 * Created by Epdc on 2015/8/28.
 */
public class GalleryActivity extends Activity{

    private Gallery gallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        gallery = (Gallery) findViewById(R.id.gallery);

        gallery.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,new String[]{"item1","item2","item3","item4","item5","item6","item7"}));

    }
}
