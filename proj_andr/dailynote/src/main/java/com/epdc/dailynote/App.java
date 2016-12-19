package com.epdc.dailynote;

import android.app.Application;

import cn.bmob.v3.Bmob;

/**
 * Created by epdc on 2016/7/3.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

//        //第二：自v3.4.7版本开始,设置BmobConfig,允许设置请求超时时间、文件分片上传时每片的大小、文件的过期时间(单位为秒)，
//        BmobConfig config =new BmobConfig.Builder(this)
//        //设置appkey
//        .setApplicationId("4f65a584acea32766dcf06f318f7e704")
//        //请求超时时间（单位为秒）：默认15s
//        .setConnectTimeout(30)
//        //文件分片上传时每片的大小（单位字节），默认512*1024
//        .setUploadBlockSize(1024*1024)
//        //文件的过期时间(单位为秒)：默认1800s
//        .setFileExpiration(2500)
//        .eventBus();
//        Bmob.initialize(config);

        //第二：默认初始化
        Bmob.initialize(this,"4f65a584acea32766dcf06f318f7e704");

    }
}
