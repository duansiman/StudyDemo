package com.example.sharedpreferences;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 *  SharedPreferences 用于保存少量数据，并且这些数据类型都是基本数据类型。
 *  Created by Administrator on 2015/9/25.
 */
public class Test01 extends Activity {

    //接口
    private SharedPreferences preferences;

    //负责读写内部类
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_01);
        //第一个参数 取得名字   第二个参数 指定数据模式
        //没有，创建test01.xml文件，路径/data/data/<package name>/shared_prefs
        //MODE_PRIVATE 表示私有，其他应该不能读取。
        preferences = getSharedPreferences("test01", MODE_PRIVATE);
        editor = preferences.edit();

        try {
            //得到指定包名对应程序得Context
            Context otherContext = createPackageContext("com.epdc.test",CONTEXT_IGNORE_SECURITY);

            //得到其他应用程序的sharedpreferences
            //和前面得操作一样
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void write(View view){
        editor.putString("name","李四");
        editor.putInt("age", 23);
        //提交，类似数据库commit
        editor.commit();
        Toast.makeText(this,"数据写入成功",Toast.LENGTH_SHORT).show();
    }

    public void read(View view){
        String name = preferences.getString("name",null);
        int age = preferences.getInt("age",0);

        Toast.makeText(this,String.format("name=%s,age=%d",name,age),Toast.LENGTH_SHORT).show();
    }
}
