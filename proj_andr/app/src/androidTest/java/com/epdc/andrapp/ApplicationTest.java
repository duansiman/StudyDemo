package com.epdc.andrapp;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.test.ApplicationTestCase;
import android.util.Log;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
        ApplicationInfo info = getApplication().getApplicationInfo();
        Log.d("TAG", info.dataDir);
    }
}