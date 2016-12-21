package com.epdc.startsystemactivity;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 *  调用系统应用APP，以及查看源码怎么调用应用APP
 *
 *  应用APP会配置intent-filter中action、category、data:schame,minType，以便其他APP启动。
 *  1、如果应用配置有多个action、category和data，要启动该应用必须满足一个action、category和data，否则启动不了。
 *  2、启动其他应用，action只能指定一个，category可以指定多个。
 * Created by Epdc on 2015/9/10.
 */
public class InvokeSystemAppActivity extends ListActivity {

    private String[] sysAppName = {
            "直接拨号","调用拨号程序","将电话号传入拨号程序","浏览网页","查看联系人",
            "系统设置","Wifi设置","选择音频程序","回到Home界面"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,sysAppName));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        TextView text = (TextView) v;
        String name = text.getText().toString();
        Intent intent = null;
        switch (name) {
            case "直接拨号":
                //置于前面为啥加tel，是由于intent-filter配置了<data android:scheme="tel"/>
                intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:12345678901"));
//                intent.setData(Uri.parse("tel:12345678901"));
                break;
            case "调用拨号程序":
                intent = new Intent("com.android.phone.action.TOUCH_DIALER");
                break;
            case "将电话号传入拨号程序":
                intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:87654321"));
                break;
            case "浏览网页":
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://blog.csdn.net/nokiaguy"));
                break;
            case "查看联系人":
                intent = new Intent("com.android.contacts.action.LIST_CONTACTS");
                break;
            case "系统设置":
                intent = new Intent("android.settings.SETTINGS");
                break;
            case "Wifi设置":
                intent = new Intent("android.settings.WIFI_SETTINGS");
                break;
            case "选择音频程序":
                intent = new Intent("Intent.ACTION_GET_CONTENT");
                intent.setType("audio/*");
                //如果有多个应用对应这个action，会弹出一个list选择框。第二个参数是个选择框的标题
                Intent.createChooser(intent,"选择音频程序");
                break;
            case "回到Home界面":
                intent = new Intent("android.intent.action.MAIN");
                intent.addCategory("android.intent.category.HOME");
                break;
        }
        startActivity(intent);
    }
}
