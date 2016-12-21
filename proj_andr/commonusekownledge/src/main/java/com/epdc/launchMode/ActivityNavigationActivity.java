package com.epdc.launchMode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.epdc.fragment.R;

/**
 *  1、activity导航
 *
 *
     task是一个具有栈结构的对象，一个task可以管理多个Activity，启动一个应用，也就创建一个与之对应的task
     android:launchMode设置Activity启动模式，默认standard。在manifest中配置Activity时指定
         1、standard 不管是否存在，都会创建新Activity
         2、singleInstance task栈中只有这个Activity，其他Activity放在新创建的task栈中
         3、singleTop，如果该Activity在栈顶，就不会创建新的实例
         4、singleTask 如果该Activity存在实例，把该Activity置于栈顶。
 * Created by Epdc on 2015/9/7.
 */
public class ActivityNavigationActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);

        findViewById(R.id.btnStartSecond).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityNavigationActivity.this,SecondNavActivity.class);
                startActivity(intent);
            }
        });

        setTitle(this.hashCode()+"");
    }
}
