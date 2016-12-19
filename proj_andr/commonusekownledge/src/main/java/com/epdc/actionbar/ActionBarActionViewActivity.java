package com.epdc.actionbar;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.epdc.fragment.R;

/**
 * Created by Epdc on 2015/9/7.
 */
public class ActionBarActionViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_view);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_view_menu,menu);
        return true;
    }
}
