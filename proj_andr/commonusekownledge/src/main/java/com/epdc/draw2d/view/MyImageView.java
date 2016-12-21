package com.epdc.draw2d.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.epdc.fragment.R;

import java.io.InputStream;

/**
 * Created by Epdc on 2015/9/2.
 */
public class MyImageView extends ImageView{

    private Bitmap bitmap1,bitmap2,bitmap3,bitmap4;
    private Drawable drawable;

    public MyImageView(Context context) {
        super(context);

        //解析 res/raw 目录下资源
        InputStream is = context.getResources().openRawResource(R.raw.panda);
        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inSampleSize = 2;//返回原图像，宽高1/2 像素1/4
        bitmap1 = BitmapFactory.decodeStream(is, null, opts);

        bitmap2 = BitmapFactory.decodeResource(getResources(),R.drawable.tiger);

        int w = bitmap2.getWidth();
        System.out.println("w"+w);
        int h = bitmap2.getHeight();
        //保存图像像素
        int[] pixels = new int[w*h];
        bitmap2.getPixels(pixels,0,w,0,0,w,h);

        bitmap3 = Bitmap.createBitmap(pixels,0,w,w,h,Bitmap.Config.ARGB_8888);

        bitmap4 = Bitmap.createBitmap(pixels,0,w,w,h,Bitmap.Config.ARGB_8888);

        drawable = context.getResources().getDrawable(R.drawable.button);
        //左上点，宽和高
        drawable.setBounds(50, 350, 180, 420);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap1, 10, 10, null);
        canvas.drawBitmap(bitmap2, 10, 200, null);
        canvas.drawBitmap(bitmap3,160,200,null);
        canvas.drawBitmap(bitmap4,310,200,null);
        drawable.draw(canvas);
    }
}
