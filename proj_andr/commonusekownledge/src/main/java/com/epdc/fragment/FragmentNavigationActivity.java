package com.epdc.fragment;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

import com.epdc.fragment.fragment.PageFragment;

/**
 *  Fragment实现窗口导航
 * Created by Epdc on 2015/9/7.
 */
public class FragmentNavigationActivity extends Activity implements FragmentManager.OnBackStackChangedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_nav);

        nextFragment(false);
    }

    public void onClick_NextPage(View view)
    {
        nextFragment(true);

    }

    private void nextFragment(boolean flag) {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        //创建Fragment
        PageFragment pageFragment = new PageFragment();
        transaction.add(R.id.fragment_container,pageFragment);

        //是否入栈
        if (flag) {
            transaction.addToBackStack(String.valueOf(getFragmentManager().getBackStackEntryCount()+1));
        }

        transaction.commit();
        //Fragment栈发生变化
        manager.addOnBackStackChangedListener(this);
    }

    public void onClick_PrevPage(View view)
    {
        FragmentManager fragmentManager = getFragmentManager();
        //出栈
        fragmentManager.popBackStack();
        //  将回退栈在Fragment状态全部出栈，恢复到第1页
        //fragmentManager.popBackStackImmediate("1",FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

    @Override
    public void onBackStackChanged() {
        setTitle("当前第" + (getFragmentManager().getBackStackEntryCount() + 1)
                + "页");
    }
}
