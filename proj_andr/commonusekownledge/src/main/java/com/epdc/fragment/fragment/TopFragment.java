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
public class TopFragment extends Fragment {

    private TopButtonClickListener listener;

    //回调接口
    public interface TopButtonClickListener{
        void onClick();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        final LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.fragment_top,null);
        layout.findViewById(R.id.btnClick).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick();
            }
        });
        return layout;
    }

    public void setListener(TopButtonClickListener listener) {
        this.listener = listener;
    }
}
