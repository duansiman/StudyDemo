package com.epdc.fragment;

import android.app.Activity;
import android.os.Bundle;

import com.epdc.fragment.fragment.BottomFragment;
import com.epdc.fragment.fragment.TopFragment;

/**
 *  Fragment回调机制，独立性
 * Created by Epdc on 2015/9/5.
 */
public class FragmentCallBackActivity extends Activity implements TopFragment.TopButtonClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_callback);

        TopFragment topFragment = (TopFragment) getFragmentManager().findFragmentById(R.id.top);
        topFragment.setListener(this);
    }

    @Override
    public void onClick() {
        System.out.println("activity onclick");
        BottomFragment fragmentBottom = (BottomFragment) getFragmentManager().findFragmentById(R.id.bottom);
        fragmentBottom.setValue("hello bottom");
    }
}
