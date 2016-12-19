package com.epdc.service;

/**
 * Created by Epdc on 2015/9/16.
 */

import android.os.Handler;
import android.os.Message;

import com.epdc.listview.adapter.CacheAdapter;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Download extends Thread {

    private CacheAdapter mCacheAdapter;
    private String mUrl;
    private String mFilename;
    private Handler mHandler = new Handler()
    {

        @Override
        public void handleMessage(Message msg) {
            mCacheAdapter.notifyDataSetChanged();
        }

    };
    public Download(CacheAdapter adapter, String url) {
        mCacheAdapter = adapter;
        mUrl = url;
        mFilename = "/sdcard/" + url.hashCode();
    }

    @Override
    public void run() {
        try {

            URL url = new URL(mUrl);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setUseCaches(false);
            connection.setRequestMethod("GET");
            InputStream is= connection.getInputStream();
            FileOutputStream fos = new FileOutputStream(mFilename);
            byte[] buffer = new byte[8192];
            int count = 0;
            while((count = is.read(buffer)) > -1)
            {
                fos.write(buffer, 0, count);
            }
            fos.close();
            is.close();
            connection.disconnect();
            mHandler.sendEmptyMessage(0);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}

