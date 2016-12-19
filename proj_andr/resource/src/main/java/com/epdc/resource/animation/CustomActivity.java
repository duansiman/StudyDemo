package com.epdc.resource.animation;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import android.widget.ListView;

import com.epdc.resource.R;

/**
 * 自定义 动画
 *
 *     继承Animation，实现applyTransformation方法
 *      参数说明：
 *          interpolatedTime：动画的时间进行比，从0变化到1
 *          Transformation: 不同时刻对图形和组件的变形程度，里面封装了Matrix
 *      Camera表示三维空间变换
 */
public class CustomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);

        ListView list = (ListView) findViewById(R.id.list);
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        System.out.println(metrics.xdpi+","+metrics.ydpi);
        //程序要实现切换到下一项时要有动画的效果 调用setAnimation
//        list.setAnimation(new MyAnimation(metrics.xdpi / 2, metrics.ydpi/2,3500));
        list.startAnimation(new MyAnimation(metrics.xdpi / 2, metrics.ydpi/2,3500));
    }

    class MyAnimation extends Animation {

        float centerX, centerY;
        private int duration;

        private Camera camera = new Camera();

        public MyAnimation(float centerX, float centerY, int duration) {
            this.centerX = centerX;
            this.centerY = centerY;
            this.duration = duration;
        }

        @Override
        public void initialize(int width, int height, int parentWidth, int parentHeight) {
            super.initialize(width, height, parentWidth, parentHeight);
            setDuration(duration);
            setFillAfter(true);
            setInterpolator(new LinearInterpolator());
        }

        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t) {
            camera.save();

            camera.translate(100f - 100f * interpolatedTime, 150f * interpolatedTime - 150f, 80 - 80 * interpolatedTime);
            camera.rotateX(360 * interpolatedTime);
            camera.rotateY(360 * interpolatedTime);

            Matrix matrix = t.getMatrix();
            //preTranslate是指在setScale前,平移,postTranslate是指在setScale后平移
            //由于缩放是以(0,0)为中心的,所以为了把界面的中心与(0,0)对齐,就要preTranslate(-centerX, -centerY),
            //setScale完成后,调用postTranslate(centerX, centerY),再把图片移回来,这样看到的动画效果就是activity的界面图片从中心不停的缩放了
            /**
             * pre表示回受到先前的变换的影响，而post不会。比如
                 (1)
                 matrxi.scale(0.5, 0.5);
                 matrix.preTranslate(100, 0);
                 (2)
                 matrix.scale(0.5, 0.5);
                 matrix.postTranslate(100, 0);
                 第一段代码缩放后会再平移100*0.5=50的距离，而第二段代码缩放后会平移坐标给定的100的距离。
             */
            camera.getMatrix(matrix);
            matrix.preTranslate(-centerX, -centerY);
            matrix.postTranslate(centerX, centerY);
            camera.restore();
        }
    }
}
