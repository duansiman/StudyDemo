package com.epdc.commonusewidget;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.epdc.commonusekownledge.R;

/**
 * Created by Epdc on 2015/8/22.
 */
public class ListViewFirstActivity extends ActionBarActivity implements AdapterView.OnItemClickListener {

    private ListView lvFirst;
    //适配器
    private ArrayAdapter<ListViewData> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listviewfirst);

        this.lvFirst = (ListView) findViewById(R.id.lvFirst);

        this.listAdapter = new ArrayAdapter<ListViewData>(this, android.R.layout.simple_list_item_1);
        //使用自己定义的list item
        //this.listAdapter = new ArrayAdapter<>(this, R.layout.list_cell,new String[]{"test","eoe"});
        this.lvFirst.setAdapter(listAdapter);

        //是对象时，显示对象toString返回的内容
        this.listAdapter.add(new ListViewData("张三", "男", 23));
        this.listAdapter.add(new ListViewData("小丽","女",23));
        this.listAdapter.add(new ListViewData("小丽","女",24));
        this.listAdapter.add(new ListViewData("小丽","女",25));
//        this.listAdapter.add("test");
//        this.listAdapter.add("eoe");

        this.lvFirst.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ListViewData data = this.listAdapter.getItem(position);
        Toast.makeText(this,String.format("名字：%s，性别：%s，年龄：%d",data.getName(),data.getSex(),data.getAge()),Toast.LENGTH_SHORT).show();
    }
}
