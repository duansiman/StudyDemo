package com.epdc.commonusewidget;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.epdc.commonusekownledge.R;

/**
 * 自定义 适配器
 * Created by Epdc on 2015/8/22.
 */
public class CustomListViewActivity extends ActionBarActivity {

    private ListView lvCustom;
    private String TAG = "MyTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("oncreate");
        setContentView(R.layout.activity_custom_listview);

        this.lvCustom = (ListView) findViewById(R.id.lvCustom);
        this.lvCustom.setAdapter(baseAdapter);
    }

    private BaseAdapter baseAdapter = new BaseAdapter() {

        //String[] data = new String[]{"listview1","listview2","listview3","listview4","listview5","listview6","listview7","listview8"};
        CustomListViewDate[] data = new CustomListViewDate[]{
                new CustomListViewDate(R.drawable.happy,"title1","dec1"),
                new CustomListViewDate(R.drawable.happy,"title2","dec2"),
                new CustomListViewDate(R.drawable.happy,"title3","dec3")
        };

        @Override
        public int getCount() {
            return data.length;
        }

        @Override
        public CustomListViewDate getItem(int position) {
            return this.data[position];
        }

        /**
         * list item 绑定的id，唯一就行
         */
        @Override
        public long getItemId(int position) {
            return position;
        }

        /*
            1、该方法在list item要显示时调用，来读取数据。每显示一个，调用一次。
            2、回收机制：当list item被隐藏起来，它的view会被系统回收，当做第二个参数传回来
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Log.i(TAG, "<<<<<<<<<<<<<<<<<<<<<<");
            /*TextView tv = new TextView(CustomListViewActivity.this);
            tv.setText(getItem(position));
            tv.setTextSize(60);*/

            //android UI界面耗内存比较高，这样写，占系统内存少，减少TextView创建
            /*TextView tv = null;
            if(convertView != null){
                tv = (TextView) convertView;
            } else {
                tv = new TextView(CustomListViewActivity.this);
            }
            tv.setText(getItem(position));
            tv.setTextSize(60);
            return tv;*/

            LinearLayout ll = null;
            if (convertView == null) {
                ll = (LinearLayout) LayoutInflater.from(CustomListViewActivity.this).inflate(R.layout.custom_listcell,null);
            } else {
                ll = (LinearLayout) convertView;
            }

            ImageView ivIcon = (ImageView) ll.findViewById(R.id.ivIcon);
            TextView tvTitle = (TextView) ll.findViewById(R.id.tvTitle);
            TextView tvDec = (TextView) ll.findViewById(R.id.tvDec);

            ivIcon.setImageResource(getItem(position).getIconId());
            tvTitle.setText(getItem(position).getTitle());
            tvDec.setText(getItem(position).getDec());

            return ll;
        }
    };
}
