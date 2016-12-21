package com.epdc.commonusewidget;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

import com.epdc.commonusekownledge.R;

/**
 * 自动文本提示框
 * Created by Epdc on 2015/8/27.
 */
public class AutoCompleteViewTextActivity extends Activity {

    private AutoCompleteTextView actv;
    private MultiAutoCompleteTextView mActv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autocompleteviewtext);

        actv = (AutoCompleteTextView) findViewById(R.id.actv);
        mActv = (MultiAutoCompleteTextView) findViewById(R.id.mActv);

        actv.setAdapter(new ArrayAdapter<>(this,R.layout.autocompleteviewtext_dropdown,
                new String[]{"java","android","c++","javascript"}));


        mActv.setAdapter(new ArrayAdapter<>(this,R.layout.autocompleteviewtext_dropdown,
                new String[]{"java","android","c++","javascript"}));
        //设置分隔符
        mActv.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }
}
