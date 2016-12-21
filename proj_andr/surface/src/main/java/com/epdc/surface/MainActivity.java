package com.epdc.surface;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.epdc.surface.widget.CombinationView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new CombinationView(this));
    }
}
