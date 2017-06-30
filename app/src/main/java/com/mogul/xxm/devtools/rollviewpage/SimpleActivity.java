package com.mogul.xxm.devtools.rollviewpage;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mogul.xxm.devtools.R;
import com.mogul.xxm.libdevtools.rollviewpager.RollPagerView;
import com.mogul.xxm.libdevtools.rollviewpager.adapter.StaticPagerAdapter;

public class SimpleActivity extends AppCompatActivity {


    private RollPagerView mViewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
        mViewPager = (RollPagerView) findViewById(R.id.view_pager);
        mViewPager.setAdapter(new ImageNormalAdapter());
    }

    private class ImageNormalAdapter extends StaticPagerAdapter {
        int[] imgs = new int[]{
                R.mipmap.img1,
                R.mipmap.img2,
                R.mipmap.img3,
                R.mipmap.img4,
                R.mipmap.img5,
        };

        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            view.setImageResource(imgs[position]);
            return view;
        }


        @Override
        public int getCount() {
            return imgs.length;
        }
    }
}
