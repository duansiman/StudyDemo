package com.epdc.resource.drawable;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SumPathEffect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.epdc.resource.R;

/**
 * 绘图
 */
public class DrawActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView3(this));
    }

    class MyView3 extends View {

        public MyView3(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            Path path = new Path();
            //添加一个圆路径
            path.addCircle(50, 50, 50, Path.Direction.CW);

            Paint paint = new Paint();
            paint.setColor(Color.GREEN);
            canvas.drawPath(path, paint);

            paint.setColor(Color.RED);
            /**
             * hOffset 距离路径起始点水平距离
             * vOffset 距离路径垂直距离
             */
            canvas.drawTextOnPath("hello world", path, 100, 10, paint);
        }
    }

    class MyView2 extends View {

        Path path = new Path();
        PathEffect[] pathEffects = new PathEffect[7];
        int[] colors = new int[]{
                Color.BLACK, Color.BLUE, Color.CYAN, Color.GREEN, Color.MAGENTA, Color.RED, Color.YELLOW
        };
        //相位
        private float phase;
        Paint paint = new Paint();

        public MyView2(Context context) {
            super(context);

            /**
             *  Paint.Style.FILL : 填充内部
                Paint.Style.FILL_AND_STROKE	：填充内部和描边
                Paint.Style.STROKE ：仅描边
             */
            paint.setStyle(Paint.Style.STROKE);
            //设置边框宽度
            paint.setStrokeWidth(4);

            path.moveTo(0, 0);
            for (int i = 0; i < 40; i++) {
                path.lineTo(i*20, (float) (Math.random()*60));
            }
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            //将背景填充成白色
            //canvas.drawColor(Color.WHITE);

            /**

             CornerPathEffect  可以使用圆角来代替尖锐的角从而对基本图形的形状尖锐的边角进行平滑。
             DashPathEffect  可以使用DashPathEffect来创建一个虚线的轮廓(短横线/小圆点)，而不是使用实线。你还可以指定任意的虚/实线段的重复模式。
             DiscretePathEffect  与DashPathEffect相似，但是添加了随机性。当绘制它的时候，需要指定每一段的长度和与原始路径的偏离度。
             PathDashPathEffect  这种效果可以定义一个新的形状(路径)并将其用作原始路径的轮廓标记。
             下面的效果可以在一个Paint中组合使用多个Path Effect。
             SumPathEffect  顺序地在一条路径中添加两种效果，这样每一种效果都可以应用到原始路径中，而且两种结果可以结合起来。
             ComposePathEffect  将两种效果组合起来应用，先使用第一种效果，然后在这种效果的基础上应用第二种效果。
             对象形状的PathEffect的改变会影响到形状的区域。这就能够保证应用到相同形状的填充效果将会绘制到新的边界中。

             */

            pathEffects[0] = null;
            pathEffects[1] = new CornerPathEffect(10);
            pathEffects[2] = new DiscretePathEffect(3.0f, 5.0f);
            pathEffects[3] = new DashPathEffect(new float[]{20, 10, 5, 10}, phase);
            Path p = new Path();
            //Path.Direction.CCW 逆时针方向
            p.addRect(0, 0, 8, 8, Path.Direction.CCW);
            pathEffects[4] = new PathDashPathEffect(p, 12, phase, PathDashPathEffect.Style.ROTATE);
            pathEffects[5] = new ComposePathEffect(pathEffects[2], pathEffects[4]);
            pathEffects[6] = new SumPathEffect(pathEffects[4], pathEffects[3]);


            for (int i = 0; i < pathEffects.length; i++) {
                //绘制路径效果
                paint.setPathEffect(pathEffects[i]);
                paint.setColor(colors[i]);
                canvas.drawPath(path, paint);
                canvas.translate(0, 60);
            }
            phase += 1;
            //重画 UI线程
            //非UI线程 postInvalidate
            invalidate();
        }
    }

    class MyView extends View {

        Paint paint = new Paint();

        public MyView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {

            //剪切一个区域，放在前面能看到效果。只有该区域能看见，超过区域不可见。
//            canvas.clipRect(0, 0, 150, 150);
            //Region.OP
            //INTERSECT 取两者交集，默认的方式
            //DIFFERENCE 第一次不同于第二次的部分显示出来
            //REPLACE 显示第二次的
            //REVERSE_DIFFERENCE 第二次不同于第一次的部分显示
            //UNION 取全集
            //XOR 补集，就是全集的减去交集的剩余部分显示
            //Android还提供了一个RegionIterator来对Region中的所有矩阵进行迭代，可以使用该类，获得某个Region的所有矩阵。比较简单。
            //这个区域是从Actionbar左上角算起

            /*Region region = new Region(0, 0, 200, 200);
            canvas.clipRegion(region);
            RegionIterator iterator = new RegionIterator(region);
            Rect rect = new Rect();
            while (iterator.next(rect)) {
                System.out.println(rect.left + ", "+rect.right+", "+rect.top+", "+rect.bottom);
            }*/


            paint.setColor(Color.GRAY);
            canvas.drawRect(0, 0, 150, 150, paint);

            paint.setColor(Color.RED);
            RectF rectF = new RectF(0, 0, 100, 100);
            //画弧
            canvas.drawArc(rectF, 60, 90, true, paint);

            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.picture);
            System.out.println(bitmap.getWidth() + ", " + bitmap.getHeight());
            //330, 225
            //截取图片一部src, 显示在dst位置，大于dst压缩，小于放大。
            canvas.drawBitmap(bitmap, new Rect(0, 50, 200, 100), new Rect(100, 100, 200, 150), null);

            //变换方法
            //rotate, scale, skew, translate

            canvas.save();
            //给paint设置渐变器
            // BitmapShader主要用来渲染图像，
            // LinearGradient 用来进行梯度渲染，
            // RadialGradient 用来进行环形渲染，
            // SweepGradient 用来进行梯度渲染，
            // ComposeShader则是一个 混合渲染，可以和其它几个子类组合起来使用。
            //从p0到p1之间进行渐变
            Shader shader = new LinearGradient(200,0,100,100,
                    new int[]{Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW},
                    null, Shader.TileMode.REPEAT);
            paint.setShader(shader);

            canvas.drawRect(200, 200, 400, 400, paint);
            canvas.restore();

            //save()保存当前状态 相对于canvas
            //restore恢复前面状态  save()和restore()是用来规定操作的范围的
            //canvas.save();
            //canvas.restore();

            paint.setColor(Color.BLACK);
            Path path =new Path();
            path.moveTo(300, 0);
            path.lineTo(400, 100);
            path.lineTo(300, 100);
            path.close();

            canvas.drawPath(path, paint);

            super.onDraw(canvas);
        }
    }
}


