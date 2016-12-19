package com.epdc.actionbar;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.epdc.fragment.R;

/**
 * 只要targetSdkVersion版本高于11（Android 3.0）就支持 actionbar
 *
 *  关闭ActionBar 设置该应用的主题为Xxx.NoActionBar
 *
 * Created by Epdc on 2015/9/5.
 */
public class ActionBarActivity extends Activity {

    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actionbar_first);

        actionBar = getActionBar();

        findViewById(R.id.btnShowOrClose).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (actionBar != null) {
                    if (actionBar.isShowing()) {
                        //隐藏
                        actionBar.hide();
                    } else {
                        //显示
                        actionBar.show();
                    }
                }
            }
        });

        //设置是否显示应用程序图标
        actionBar.setDisplayShowHomeEnabled(true);
        //设置应用程序图标是否可点击
        //actionBar.setHomeButtonEnabled(true);

        //设置图标可点击，且加上向左箭头
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        //自定义菜单
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.isCheckable()) {
            item.setCheckable(true);
        }
        switch (item.getItemId()) {
            case android.R.id.home:
                System.out.println("home");
                break;
        }
        return true;
    }
}
