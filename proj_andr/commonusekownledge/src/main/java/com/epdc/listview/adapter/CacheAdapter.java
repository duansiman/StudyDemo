package com.epdc.listview.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.epdc.fragment.R;
import com.epdc.service.Download;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Epdc on 2015/9/16.
 */
public class CacheAdapter extends BaseAdapter {

    private List<String> mUrls = new ArrayList<String>();
    private Context context;

    public  CacheAdapter(Context context){
        mUrls.add("http://ww4.sinaimg.cn/bmiddle/84217b4fjw1e3zvdsjtupj20ih0ppn13.jpg");
        mUrls.add("http://ww2.sinaimg.cn/bmiddle/76a19fefjw1e3zr5z0zi7j20sg0fjtdg.jpg");
        mUrls.add("http://ww1.sinaimg.cn/bmiddle/475b3d56jw1e3zvdwoln1j208c08c0tr.jpg");
        mUrls.add("http://ww1.sinaimg.cn/bmiddle/6e3fa31fjw1e3zvfd6zqlj20c807fwfr.jpg");
        mUrls.add("http://ww1.sinaimg.cn/bmiddle/6adce985jw1e3zttk0v20j20b408cglh.jpg");
        mUrls.add("http://ww1.sinaimg.cn/bmiddle/63918611jw1e3ztipg4lij205r064dge.jpg");
        this.context = context;
    }

    @Override
    public int getCount() {
        return mUrls.size();
    }

    @Override
    public String getItem(int position) {
        return mUrls.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_listview,null);
        }
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageview);

        imageView.setImageBitmap(getBitmap(position));

        return convertView;
    }

    private Bitmap getBitmap(int position) {
        Bitmap bitmap = null;
        String filename = "/sdcard/"+mUrls.get(position).hashCode();
        //缓存有数据
        if (new File(filename).exists()) {
            bitmap = BitmapFactory.decodeFile(filename);
        } else {
            //没有缓存
            bitmap = BitmapFactory.decodeResource(context.getResources(),
                    R.mipmap.ic_launcher);
            new Download(this, mUrls.get(position)).start();
        }

        return bitmap;
    }
}
