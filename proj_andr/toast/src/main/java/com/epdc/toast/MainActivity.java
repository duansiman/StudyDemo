package com.epdc.toast;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showToast(View v){
        Toast toast = Toast.makeText(this, "显示在中间的Toast", Toast.LENGTH_SHORT);
        //第二个参数，是相对当前位置
        toast.setGravity(Gravity.CENTER, 200, 0);
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.mipmap.ic_launcher);
        toast.setView(imageView);
        toast.show();
    }
}
