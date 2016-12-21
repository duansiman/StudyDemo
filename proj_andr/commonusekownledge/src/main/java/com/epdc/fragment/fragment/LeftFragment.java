package com.epdc.fragment.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.epdc.fragment.FragmentDetailActivity;
import com.epdc.fragment.R;

import java.io.IOException;
import java.io.InputStream;

/**
 *  1、继承Fragment类
 *  2、重写onCreateView，这个方法作用：返回Fragment界面的布局控件
 *
 * Created by Epdc on 2015/9/5.
 */
public class LeftFragment extends Fragment implements AdapterView.OnItemClickListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.fragment_left,null);
        ListView listView = (ListView) layout.findViewById(R.id.listLeft);
        listView.setAdapter(new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,new String[]{"broadcast","activity","serivce"}));
        listView.setOnItemClickListener(this);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        return layout;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView tvDetail = (TextView) getActivity().findViewById(R.id.tvDetail);

        try {
            //加载外部资源
            InputStream is = getActivity().getResources().getAssets().open("m"+position);
            byte[] buf = new byte[1024];
            int count = is.read(buf);
            String detail = new String(buf,0,count);

            if (tvDetail == null) {
                Intent i = new Intent(getActivity(), FragmentDetailActivity.class);
                i.putExtra("detail",detail);
                getActivity().startActivity(i);
            } else {
                tvDetail.setText(detail);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
