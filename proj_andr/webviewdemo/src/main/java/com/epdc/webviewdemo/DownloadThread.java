package com.epdc.webviewdemo;

import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 下载文件线程
 * Created by epdc on 2015/11/28.
 */
public class DownloadThread implements Runnable {

    private String downloadUrl;

    public DownloadThread(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    @Override
    public void run() {
        System.out.println("download start");
        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            URL url = new URL(downloadUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            //允许输入
            httpURLConnection.setDoInput(true);
            inputStream = httpURLConnection.getInputStream();
            File downloadFile = null;

            //判断是否有sdcard
            if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                downloadFile = new File(Environment.getExternalStorageDirectory().toString(), "Download/test.apk");
                outputStream = new FileOutputStream(downloadFile);
            }

            //1M buf
            byte[] buf = new byte[1024 * 1024];
            int length = 0;
            while ((length = inputStream.read(buf)) != -1) {
                if (downloadFile != null) {
                    outputStream.write(buf, 0, length);
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                    outputStream = null;
                }
                if (inputStream != null) {
                    inputStream.close();
                    inputStream = null;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("download end");
    }
}
