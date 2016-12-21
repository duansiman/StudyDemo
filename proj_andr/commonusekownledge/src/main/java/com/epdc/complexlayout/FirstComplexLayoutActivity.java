package com.epdc.complexlayout;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

import com.epdc.fragment.R;

/**
 * 实现霓虹灯
 * Created by Epdc on 2015/8/31.
 */
public class FirstComplexLayoutActivity extends Activity implements Runnable{

    private int[] tvColor = new int[]{
            R.id.tvRed,R.id.tvGreen,R.id.tvBlue,R.id.tvBlack,R.id.tvGray
    };

    private int[] colors = new int[] {
        0xffff0000,0xff00ff00,0xff0000ff,0xff000000,0xffaaaaaa
    };

    //最大那个TextView的下一个背景颜色位置
    private int colorIndex = 1;

    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstcomplexlayout);

        handler = new Handler();

        //延迟执行
        handler.postDelayed(this,300);
    }

    @Override
    public void run() {
        colorIndex = colorIndex % 5;

        for (int i=0;  i<tvColor.length; i++)
        {
            //依次改变背景颜色
            findViewById(tvColor[i]).setBackgroundColor(colors[(colorIndex+i)%colors.length]);
        }
        //颜色指针移到下一个
        colorIndex ++;
        handler.postDelayed(this,300);
    }
}
