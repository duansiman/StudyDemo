package com.epdc.commonusewidget;

import android.content.Context;
import android.content.Intent;

/**
 * Created by Epdc on 2015/8/24.
 */
public class UIWidgetListCellData {

    private String name;
    private Context context;
    private Intent relaedIntent;

    public UIWidgetListCellData(String name, Context context, Intent relaedIntent) {
        this.name = name;
        this.context = context;
        this.relaedIntent = relaedIntent;
    }

    public void startActivity(){
        this.context.startActivity(relaedIntent);
    }

    public String getName() {
        return name;
    }

    public Context getContext() {
        return context;
    }

    public Intent getRelaedIntent() {
        return relaedIntent;
    }

    @Override
    public String toString() {
        return name;
    }
}
