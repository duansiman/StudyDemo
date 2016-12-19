package com.epdc.indexablelistview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SectionIndexer;
import android.widget.Toast;

import com.epdc.fragment.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class IndexableListViewActivity extends Activity {

    ArrayList<String> mItems;
    IndexableListView indexableListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indexable_list_view);

        indexableListView = (IndexableListView) findViewById(R.id.listview_indexable);

        mItems = new ArrayList<>();
        mItems.add("123");
        mItems.add("A hello world");
        mItems.add("B hello world");
        mItems.add("C hello world");
        mItems.add("D hello world");
        mItems.add("E hello world");
        mItems.add("F hello world");
        mItems.add("G hello world");
        mItems.add("H hello world");
        mItems.add("I hello world");
        mItems.add("J hello world");
        mItems.add("L hello world");
        mItems.add("N hello world");
        mItems.add("M hello world");
        mItems.add("O hello world");
        mItems.add("P hello world");
        mItems.add("Q hello world");
        mItems.add("R hello world");
        mItems.add("S hello world");

        Collections.sort(mItems);

        ContextAdapter contextAdapter = new ContextAdapter(this, android.R.layout.simple_list_item_1, mItems);
        indexableListView.setAdapter(contextAdapter);
        indexableListView.setFastScrollEnabled(true);

        indexableListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(IndexableListViewActivity.this, "hehe", Toast.LENGTH_LONG).show();
            }
        });
    }

    private class ContextAdapter extends ArrayAdapter<String> implements SectionIndexer {


        private String mSections = "#ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        public ContextAdapter(Context context, int resource, List<String> objects) {
            super(context, resource, objects);
        }

        @Override
        public Object[] getSections() {
            String[] temps = mSections.split("");
            return Arrays.copyOfRange(temps, 1, temps.length);
        }

        @Override
        public int getPositionForSection(int sectionIndex) {
            for (int i = sectionIndex; i >= 0; i--) {
                for (int j = 0; j < getCount(); j++) {

                    //查数字
                    if (i == 0) {

                        for (int k = 0; k < 10; k++) {
                            if (StringMatcher.match(String.valueOf(getItem(j).charAt(0)), String.valueOf(k))) {
                                return j;
                            }
                        }

                    } else {
                        if (StringMatcher.match(String.valueOf(getItem(j).charAt(0)), String.valueOf(mSections.charAt(i)))) {
                            return j;
                        }
                    }
                }
            }
            return 0;
        }

        @Override
        public int getSectionForPosition(int position) {
            return 0;
        }
    }
}
