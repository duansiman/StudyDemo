package com.epdc.http;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.epdc.fragment.R;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *  HttpUrlConnection
 * Created by Epdc on 2015/9/14.
 */
public class HttpUrlConnActivity extends Activity{

    TextView tvShow;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_httpurlconn);
        tvShow = (TextView) findViewById(R.id.tvShow);

        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                tvShow.setText(msg.obj.toString());
            }
        };

    }

    public void upload(View view){
        new Thread(new Runnable() {
            @Override
            public void run() {
                String uploadUrl = "http://192.16.137.1:8888/AndroidServer/UploadServlet";
                String end = "\r\n";
                String twoHyphens = "--";
                String boundary = "******";
                try
                {
                    URL url = new URL(uploadUrl);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url
                            .openConnection();
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                    httpURLConnection.setRequestProperty("Charset", "UTF-8");
                    httpURLConnection.setRequestProperty("Content-Type",
                            "multipart/form-data;boundary=" + boundary);

                    DataOutputStream dos = new DataOutputStream(
                            httpURLConnection.getOutputStream());
                    dos.writeBytes(twoHyphens + boundary + end);
                    String filename = "/mnt/sdcard/duan.jpg";
                    dos.writeBytes("Content-Disposition: form-data; name=\"file\"; filename=\""
                            + filename.substring(filename.lastIndexOf("/") + 1)
                            + "\""
                            + end);
                    dos.writeBytes(end);

                    FileInputStream fis = new FileInputStream(filename);
                    byte[] buffer = new byte[8192]; // 8k
                    int count = 0;
                    while ((count = fis.read(buffer)) != -1)
                    {
                        dos.write(buffer, 0, count);

                    }
                    fis.close();

                    dos.writeBytes(end);
                    dos.writeBytes(twoHyphens + boundary + twoHyphens + end);
                    dos.flush();

                    InputStream is = httpURLConnection.getInputStream();
                    InputStreamReader isr = new InputStreamReader(is, "utf-8");
                    BufferedReader br = new BufferedReader(isr);
                    String result = br.readLine();
                    //Toast.makeText(this, result, Toast.LENGTH_LONG).show();
                    Message msg = new Message();
                    msg.obj = result;
                    handler.sendMessage(msg);
                    dos.close();
                    is.close();

                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
