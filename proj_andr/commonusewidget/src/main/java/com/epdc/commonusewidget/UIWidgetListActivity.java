package com.epdc.commonusewidget;

import android.app.ListActivity;
import android.content.Intent;
import android.media.Rating;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Epdc on 2015/8/24.
 */
public class UIWidgetListActivity extends ListActivity {

    private ArrayAdapter<UIWidgetListCellData> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1);
        setListAdapter(arrayAdapter);

        arrayAdapter.add(new UIWidgetListCellData("RadioGroup", this, new Intent(this, RadioGroupActivity.class)));
        arrayAdapter.add(new UIWidgetListCellData("CheckBox",this, new Intent(this, CheckBoxActivity.class)));
        arrayAdapter.add(new UIWidgetListCellData("DatePicker",this, new Intent(this, DatePickerActivity.class)));
        arrayAdapter.add(new UIWidgetListCellData("TimePicker",this, new Intent(this, TimePickerActivity.class)));
        arrayAdapter.add(new UIWidgetListCellData("Spinner",this, new Intent(this, SpinnerActivity.class)));
        arrayAdapter.add(new UIWidgetListCellData("ProgressBar",this, new Intent(this, ProgressBarActivity.class)));
        arrayAdapter.add(new UIWidgetListCellData("AutoCompleteViewText",this, new Intent(this, AutoCompleteViewTextActivity.class)));
        arrayAdapter.add(new UIWidgetListCellData("CustomView",this, new Intent(this, CustomViewActivity.class)));
        arrayAdapter.add(new UIWidgetListCellData("SeekBar",this, new Intent(this, SeekBarActivity.class)));
        arrayAdapter.add(new UIWidgetListCellData("GridView",this, new Intent(this, GridViewActivity.class)));
        arrayAdapter.add(new UIWidgetListCellData("ProgressDialog",this, new Intent(this, ProgressDialogActivity.class)));
        arrayAdapter.add(new UIWidgetListCellData("Notification",this, new Intent(this, NotificationActivity.class)));
        arrayAdapter.add(new UIWidgetListCellData("ScrollView",this, new Intent(this, ScrollViewActivity.class)));
        arrayAdapter.add(new UIWidgetListCellData("RatingBar",this, new Intent(this, RatingBarActivity.class)));
        arrayAdapter.add(new UIWidgetListCellData("ImageSwitcher",this, new Intent(this, ImageSwitcherActivity.class)));
        arrayAdapter.add(new UIWidgetListCellData("Gallery",this, new Intent(this, GalleryActivity.class)));
        arrayAdapter.add(new UIWidgetListCellData("EditText",this, new Intent(this, EditTextActivity.class)));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        UIWidgetListCellData data = arrayAdapter.getItem(position);
        data.startActivity();
    }
}
