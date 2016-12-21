package com.epdc.touch;

import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * 屏幕触摸事件
 */
public class MainActivity extends ActionBarActivity {

    private RelativeLayout relativeLayout;
    private ImageView imageView;

    private float currentDistance;
    private float lastDistance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        relativeLayout = (RelativeLayout) findViewById(R.id.container);
        imageView = (ImageView) findViewById(R.id.imageView);

        relativeLayout.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                //得到触摸行为
                switch (event.getAction()) {
                    //手指安下
                    case MotionEvent.ACTION_DOWN:
                        System.out.println("action_down");
                        break;

                    //手指移动
                    case MotionEvent.ACTION_MOVE:
                        System.out.println("action_move");
                        /*//获取触摸点
                        int x = (int) event.getX();
                        int y = (int) event.getY();

                        System.out.println(String.format("x:%d,y:%d", x, y));

                        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
                        lp.leftMargin = x;
                        lp.topMargin = y;

                        imageView.setLayoutParams(lp);*/

                        //获得多个触点
                        System.out.println("point:" + event.getPointerCount());
                        //System.out.println(String.format("x1:%f,y1:%f",event.getX(0),event.getY(0)));

                        if (event.getPointerCount() >= 2) {
                            float offsetX = event.getX(0) - event.getX(1);
                            float offsetY = event.getY(0) - event.getY(1);
                            currentDistance = (float) Math.sqrt(offsetX*offsetX+offsetY*offsetY);
                            if (lastDistance <= 0) {
                                lastDistance = currentDistance;
                            }
                            if (currentDistance - lastDistance > 5) {
                                System.out.println("放大");
                                RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
                                lp.width = (int) (imageView.getWidth()*1.1);
                                lp.height = (int) (imageView.getHeight()*1.1);
                                imageView.setLayoutParams(lp);
                                lastDistance = currentDistance;
                            } else if(lastDistance -currentDistance > 5){
                                System.out.println("缩小");
                                RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
                                lp.width = (int) (imageView.getWidth()*0.9);
                                lp.height = (int) (imageView.getHeight()*0.9);
                                imageView.setLayoutParams(lp);
                                lastDistance = currentDistance;
                            }
                        }


                        break;

                    //手指抬起
                    case MotionEvent.ACTION_UP:
                        System.out.println("action_up");
                        break;
                }

                //触摸事件分阶段的，先是手指按下事件，再手指移动事件，然后手指抬起事件
                //只有前一个事件处理了，后面一个事件才能触发

                //返回false表示没有处理
                return true;
            }

        });
    }


}
