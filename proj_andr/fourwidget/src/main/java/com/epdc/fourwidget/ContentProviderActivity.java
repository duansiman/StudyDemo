package com.epdc.fourwidget;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

/**
 * ContentProvider 应用程序之间共享数据
 * Created by Epdc on 2015/8/16.
 */
public class ContentProviderActivity extends ActionBarActivity {
    private static String TAG = ContentProviderActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Cursor cursor = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        while(cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
            Log.i(TAG, "name:" + name);
        }
    }
}
