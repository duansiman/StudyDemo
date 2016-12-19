package com.epdc.fragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.epdc.fragment.fragment.MyFragment;

/**
 *  Activity 与 Fragment 之间传值
 * Created by Epdc on 2015/9/5.
 */
public class FragmentParameterActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parameter);

        findViewById(R.id.btnParams).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                bundle.putString("name","hello fragment");

                MyFragment fragment = new MyFragment();
                //给Fragment传递参数
                fragment.setArguments(bundle);

                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                //第一个参数：表示把fragment加入到容器中，作为其子控件
                //第三个参数:tag标签
                transaction.add(R.id.containerFragment,fragment,"fragment");
                transaction.commit();
            }
        });
    }

    public void showParam(View v){
        //找到fragment标签对应的Fragment，并得到Activity传过来的值
        String value = getFragmentManager().findFragmentByTag("fragment").getArguments().getString("name");
        EditText etShowParam = (EditText) findViewById(R.id.evShowParam);
        etShowParam.setText(value);
    }
}
