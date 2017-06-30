package com.mogul.xxm.devtools.refreshview;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mogul.xxm.devtools.R;
import com.mogul.xxm.devtools.refreshview.adapter.ScrollAdapter;

public class ScrollViewActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view);
        mViewPager = (ViewPager) findViewById(R.id.index_viewpager);
        ScrollAdapter adapter = new ScrollAdapter(this);
        mViewPager.setAdapter(adapter);
    }
}
