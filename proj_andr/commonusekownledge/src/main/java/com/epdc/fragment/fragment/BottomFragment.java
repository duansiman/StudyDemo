package com.epdc.fragment.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.epdc.fragment.R;

/**
 * Created by Epdc on 2015/9/5.
 */
public class BottomFragment extends Fragment {

//    private TextView tvShow;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
//        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.fragment_bottom, null);
//        tvShow = (TextView) layout.findViewById(R.id.tvShow);
        return inflater.inflate(R.layout.fragment_bottom, null);
    }

    public void setValue(String value){
        System.out.println("bottom setvalue:"+value);
//        tvShow.setText(value);
//        tvShow.setText("hsdfhosidfhioh");
        TextView tvShow = (TextView) getView();
        tvShow.setText(value);
    }
}
