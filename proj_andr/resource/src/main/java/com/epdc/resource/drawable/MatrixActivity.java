package com.epdc.resource.drawable;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.epdc.resource.R;

/**
 * Matrix 矩阵工具类，控制图形和组件变换
 */
public class MatrixActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new ImageView(this));
    }

    class ImageView extends View {

        public ImageView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            Matrix matrix = new Matrix();
            //kx 相对于x轴
//            matrix.setSkew(0, 0.2f);
            //没有动画效果
            matrix.setTranslate(50, 50);

            canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.picture), matrix, new Paint());
        }

    }
}
