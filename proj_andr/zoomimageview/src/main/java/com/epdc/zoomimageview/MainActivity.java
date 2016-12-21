package com.epdc.zoomimageview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.epdc.view.ZoomImageView;

public class MainActivity extends Activity {

    private ViewPager viewPager;
    private int[] mImgs = new int[]{R.drawable.picture, R.drawable.picture2, R.drawable.picture3};
    private ZoomImageView[] mImageViews = new ZoomImageView[mImgs.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);
//        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewpage);

        viewPager.setAdapter(new PagerAdapter() {

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ZoomImageView mImageView = new ZoomImageView(MainActivity.this);
                mImageView.setImageResource(mImgs[position]);
                mImageViews[position] = mImageView;
                container.addView(mImageView);
                return mImageView;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(mImageViews[position]);
            }

            @Override
            public int getCount() {
                return mImgs.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }
        });
    }
}
