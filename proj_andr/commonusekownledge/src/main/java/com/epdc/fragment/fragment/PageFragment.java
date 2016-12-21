package com.epdc.fragment.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.epdc.fragment.R;

import java.util.Random;

/**
 * Created by Epdc on 2015/9/7.
 */
public class PageFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_page, null);

        EditText editText = (EditText)view.findViewById(R.id.edittext);

        editText.setText(String.valueOf(Math.abs(new Random().nextLong())));
        return view;
    }

}
