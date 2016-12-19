package com.epdc.startsystemactivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;

import com.epdc.fragment.R;

import java.io.ByteArrayOutputStream;

/**
 *  内容共享
 * Created by Epdc on 2015/9/16.
 */
public class ContentShareActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contentshare);
    }

    public void onClick_SendText(View view)
    {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "要分享的文本数据");
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }

    public void onClick_SendBinary(View view)
    {
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        //图片压缩
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();

        shareIntent.putExtra(Intent.EXTRA_STREAM, byteArray);
        shareIntent.setType("image/jpeg");
        startActivity(shareIntent);
    }
}
