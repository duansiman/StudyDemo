package com.epdc.commonusewidget;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;

import com.epdc.commonusekownledge.R;

/**
 * 进度条对话框
 * Created by Epdc on 2015/8/28.
 */
public class ProgressDialogActivity extends Activity{

    private ProgressDialog progressDialog;
    private int current;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_dialog);

        progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setMax(100);
        progressDialog.setTitle("下载中...");
        progressDialog.setIndeterminate(false);
        progressDialog.setProgress(0);


        findViewById(R.id.btnShowProgressDialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //indeterminate不明确(false)就是滚动条的当前值自动在最小到最大值之间来回移动，形成这样一个动画效果，这个只是告诉别人“我正在工作”，但不能提示工作进度到哪个阶段。
                //主要是在进行一些无法确定操作时间的任务时作为提示。而“明确”(true)就是根据你的进度可以设置现在的进度值。
//                progressDialog = ProgressDialog.show(ProgressDialogActivity.this,"加载中","正在加载...",false,true);

                progressDialog.show();
                new Thread(){
                    @Override
                    public void run() {
                        while (true) {
                            try {
                                if (current >= 100) {
                                    //隐藏
                                    progressDialog.dismiss();
                                }
                                Thread.sleep(1000);
                                current += 2;
                                progressDialog.setProgress(current);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }.start();
            }
        });
    }
}
