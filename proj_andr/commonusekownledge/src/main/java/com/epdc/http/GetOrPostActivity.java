package com.epdc.http;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.epdc.fragment.R;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 网络通信 HttpGet HttpPost
 * Created by Epdc on 2015/9/11.
 */
public class GetOrPostActivity extends Activity {

    private TextView tvshow;

    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_post);
        tvshow = (TextView) findViewById(R.id.tvShow);

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                String result = (String) msg.obj;
                tvshow.setText(result.replaceAll("\r", ""));
            }
        };
    }

    public void http(View v) {
        final String url = "http://192.16.137.1:8888/AndroidServer/AndroidServlet";

        switch (v.getId()) {
            case R.id.btnGet:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            // 第1步：创建HttpGet对象
                            HttpGet httpGet = new HttpGet(url);
                            // 第2步：使用execute方法发送HTTP GET请求，并返回HttpResponse对象
                            HttpResponse httpResponse = new DefaultHttpClient().execute(httpGet);
                            // 判断请求响应状态码，状态码为200表示服务端成功响应了客户端的请求
                            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                                // 第3步：使用getEntity方法获得返回结果
                                String result = EntityUtils.toString(httpResponse
                                        .getEntity());
                                // 去掉返回结果中的“\r”字符，否则会在结果字符串后面显示一个小方格
                                //tvshow.setText(result.replaceAll("\r", ""));
                                Message msg = new Message();
                                msg.obj = result;
                                handler.sendMessage(msg);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                break;
            case R.id.btnPost:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            // 第1步：创建HttpPost对象
                            HttpPost httpPost = new HttpPost(url);
                            // 设置HTTP POST请求参数必须用NameValuePair对象
                            List<NameValuePair> params = new ArrayList<NameValuePair>();
                            params.add(new BasicNameValuePair("param", "你好，server"));
                            // 设置HTTP POST请求参数
                            httpPost.setEntity(new UrlEncodedFormEntity(params,
                                    HTTP.UTF_8));
                            // 第2步：使用execute方法发送HTTP POST请求，并返回HttpResponse对象
                            HttpResponse httpResponse = new DefaultHttpClient(new BasicHttpParams()).execute(httpPost);
                            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                                // 第3步：使用getEntity方法获得返回结果
                                String result = EntityUtils.toString(httpResponse
                                        .getEntity());
                                // 去掉返回结果中的“\r”字符，否则会在结果字符串后面显示一个小方格
                                //tvshow.setText(result.replaceAll("\r", ""));
                                Message msg = new Message();
                                msg.obj = result;
                                handler.sendMessage(msg);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                break;
        }

    }
}
