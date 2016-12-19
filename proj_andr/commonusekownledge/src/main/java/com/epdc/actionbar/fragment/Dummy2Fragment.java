package com.epdc.actionbar.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/1/3.
 */
public class Dummy2Fragment extends Fragment {

    public static final String ARG_SECTION_NUMBER = "arg_section_number";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        TextView textView = new TextView(getActivity());
        textView.setGravity(Gravity.START);

        //获得参数
        Bundle arguments = getArguments();
        //设置textview文本别设置数字
        textView.setText(arguments.getInt(ARG_SECTION_NUMBER, -1)+"");
        textView.setTextSize(20);
        return textView;
    }
}
