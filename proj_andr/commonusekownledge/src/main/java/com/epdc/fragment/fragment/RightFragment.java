package com.epdc.fragment.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.epdc.fragment.R;

/**
 * Created by Epdc on 2015/9/5.
 */
public class RightFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.fragment_right,null);
        return layout;
    }
}
