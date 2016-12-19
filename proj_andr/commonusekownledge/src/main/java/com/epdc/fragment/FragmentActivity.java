package com.epdc.fragment;

import android.app.Activity;
import android.os.Bundle;

/**
 *  Fragment 是封装UI和逻辑代码的组件
 * Created by Epdc on 2015/9/5.
 */
public class FragmentActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
    }
}
