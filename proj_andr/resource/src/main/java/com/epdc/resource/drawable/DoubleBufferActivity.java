package com.epdc.resource.drawable;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.SweepGradient;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;

import com.epdc.resource.R;

/**
 * 双缓冲
 */
public class DoubleBufferActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //关于显示的通用信息，如显示大小，分辨率和字体
        //DisplayMetrics {density=1.0, width=320, height=480, scaledDensity=1.0,
        //        xdpi=159.37254, ydpi=160.42105}
        DisplayMetrics displayMetrics = new DisplayMetrics();
        //getRealMetrics() 获取屏幕完整宽高，包含状态栏
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;
        DrawView drawView = new DrawView(this, width, height);
        setContentView(drawView);
    }

    class DrawView extends View {
        Path path = new Path();
        Paint paint = new Paint();
        //把图片作为缓冲区
        Bitmap cacheBitmap;
        Canvas cacheCanvas;

        float preX, preY;

        public DrawView(Context context, int width, int height) {
            super(context);
            /**
             Bitmap.Config  ALPHA_8      8位      只有透明度，没有颜色
             Bitmap.Config  ARGB_4444    16位     每个像素  占四位
             Bitmap.Config  ARGB_8888    32位     每个像素  占八位
             Bitmap.Config  RGB_565      16位     R占5位 R占6位 B占5位  没有透明度（A）
             */
            cacheBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

            cacheCanvas = new Canvas();
            cacheCanvas.setBitmap(cacheBitmap);

            paint.setColor(Color.RED);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(1);

            //反锯齿  图像边缘相对清晰一点，锯齿痕迹不那么明显
            paint.setAntiAlias(true);
            // 图像的抖动处理，当每个颜色值以低于8位表示时，
            // 对应图像做抖动处理可以实现在可显示颜色总数比较低（比如256色）时还保持较好的显示效果
            paint.setDither(true);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {

            // getAction()方法返回的是int类型，事件类型，用到的只有低16位，
            // 其中：低八位是动作的类型，高8位是触摸点索引值的表示（单点为0，双点为1）
            // getActionMasked() 与 getAction() 区别
            /**
             *  public static final int ACTION_MASK             = 0xff;

                public final int getAction() {
                    return mAction;
                }

                public final int getActionMasked() {
                    return mAction & ACTION_MASK;
                }

                 如果mAction的值是0x0000，则表示是第一个触控点的ACTION_DOWN操作。

                 如果mAction的值是0x0100呢，则表示是第二个触控点的ACTION_DOWN操作。

                 第三个的ACTION_DOWN呢？相信你可以推出来是0x0200。

                 总而言之，mAction时的低8位（也就是0-7位）是动作类型信息。

                 mAction的8-15位呢，是触控点的索引信息。（即表示是哪一个触控点的事件）。
             */

            /**
             当TouchEvent发生时，首先Activity将TouchEvent传递给最顶层的View，
             TouchEvent最先到达最顶层 view 的 dispatchTouchEvent ，
             然后由  dispatchTouchEvent 方法进行分发，如果dispatchTouchEvent返回true ，
             则交给这个view的onTouchEvent处理，如果dispatchTouchEvent返回 false ，
             则交给这个 view 的 interceptTouchEvent 方法来决定是否要拦截这个事件，
             如果 interceptTouchEvent 返回 true ，也就是拦截掉了，则交给它的 onTouchEvent 来处理，
             如果 interceptTouchEvent 返回 false ，那么就传递给子 view ，由子 view 的 dispatchTouchEvent
             再来开始这个事件的分发。如果事件传递到某一层的子 view 的 onTouchEvent 上了，这个方法返回了 false ，
             那么这个事件会从这个 view 往上传递，都是 onTouchEvent 来接收。
             而如果传递到最上面的 onTouchEvent 也返回 false 的话，这个事件就会“消失”，而且接收不到下一次事件。
             */
            float x = event.getX();
            float y = event.getY();
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    path.moveTo(x, y);
                    preX = x;
                    preY = y;
                    break;
                case MotionEvent.ACTION_MOVE:
                    /**
                     该方法的实现是当我们不仅仅是画一条线甚至是画弧线时会形成平滑的曲线，该曲线又称为"贝塞尔曲线"(Bezier curve)，其中，x1，y1为控制点的坐标值，x2，y2为终点的坐标值；
                     贝塞尔曲线的形成，就比如我们把一条橡皮筋拉直，橡皮筋的头尾部对应起点和终点，然后从拉直的橡皮筋中选择任意一点（除头尾对应的点外）扯动橡皮筋形成的弯曲形状，而那个扯动橡皮筋的点就是控制点；
                     */
                    path.quadTo(preX, preY, x, y);
                    preX = x;
                    preY = y;
                    break;
                case MotionEvent.ACTION_UP:
                    //BlurMaskFilter，EmbossMaskFilter，一个是让目标部分模糊不清，一个是让目标部分有凹凸的水印图案
                    paint.setMaskFilter(new BlurMaskFilter(8, BlurMaskFilter.Blur.NORMAL));
                    cacheCanvas.drawPath(path, paint);
                    path.reset();
                    break;
            }
            invalidate();
            return true;
        }

        @Override
        protected void onDraw(Canvas canvas) {
            Paint paint = new Paint();
            canvas.drawBitmap(cacheBitmap, 0, 0, paint);
        }
    }
}
