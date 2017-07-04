package com.mogul.xxm.devtools.viewpagerindicator;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.mogul.xxm.devtools.R;
import com.mogul.xxm.libdevtools.utils.DensityUtil;
import com.mogul.xxm.libdevtools.viewpagerindicator.view.indicator.IndicatorViewPager;
import com.mogul.xxm.libdevtools.viewpagerindicator.view.indicator.ScrollIndicatorView;
import com.mogul.xxm.libdevtools.viewpagerindicator.view.indicator.slidebar.DrawableBar;
import com.mogul.xxm.libdevtools.viewpagerindicator.view.indicator.slidebar.ScrollBar;
import com.mogul.xxm.libdevtools.viewpagerindicator.view.indicator.transition.OnTransitionTextListener;

public class MoreTab2Activity extends AppCompatActivity {

    private IndicatorViewPager indicatorViewPager;
    private LayoutInflater inflate;
    private String[] names = {"CUPCAKE", "DONUT", "FROYO", "GINGERBREAD", "HONEYCOMB", "ICE CREAM SANDWICH", "JELLY BEAN", "KITKAT"};
    private ScrollIndicatorView scrollIndicatorView;
    private ToggleButton pinnedToggleButton;
    private ToggleButton splitAutotoggleButton;
    private int unSelectTextColor;
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_tab2);
        mContext = this;
        splitAutotoggleButton = (ToggleButton) findViewById(R.id.toggleButton1);
        pinnedToggleButton = (ToggleButton) findViewById(R.id.toggleButton2);
        ViewPager viewPager = (ViewPager) findViewById(R.id.moretab_viewPager);
        scrollIndicatorView = (ScrollIndicatorView) findViewById(R.id.moretab_indicator);
        scrollIndicatorView.setBackgroundColor(Color.RED);
        scrollIndicatorView.setScrollBar(new DrawableBar(this, R.drawable.round_border_white_selector, ScrollBar.Gravity.CENTENT_BACKGROUND) {
            @Override
            public int getHeight(int tabHeight) {
                return tabHeight - DensityUtil.dip2px(mContext,12);
            }

            @Override
            public int getWidth(int tabWidth) {
                return tabWidth - DensityUtil.dip2px(mContext,12);
            }
        });

        unSelectTextColor = Color.WHITE;
        // 设置滚动监听
        scrollIndicatorView.setOnTransitionListener(new OnTransitionTextListener().setColor(Color.RED, unSelectTextColor));

        viewPager.setOffscreenPageLimit(2);
        indicatorViewPager = new IndicatorViewPager(scrollIndicatorView, viewPager);
        inflate = LayoutInflater.from(getApplicationContext());
        indicatorViewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));

        // 默认true ，自动布局
        splitAutotoggleButton.setChecked(scrollIndicatorView.isSplitAuto());
        splitAutotoggleButton.setOnCheckedChangeListener(onCheckedChangeListener);
        pinnedToggleButton.setOnCheckedChangeListener(onCheckedChangeListener);
    }

    private CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (buttonView == splitAutotoggleButton) {
                // 设置是否自动布局
                scrollIndicatorView.setSplitAuto(isChecked);
            } else if (buttonView == pinnedToggleButton) {
                scrollIndicatorView.setPinnedTabView(isChecked);
                // 设置固定tab的shadow，这里不设置的话会使用默认的shadow绘制
                scrollIndicatorView.setPinnedShadow(R.mipmap.tabshadow, DensityUtil.dip2px(mContext,4));
                scrollIndicatorView.setPinnedTabBgColor(Color.CYAN);//第一个被固定的背景色
            }
        }
    };

    private int size = 3;

    public void on3(View view) {
        size = 3;
        indicatorViewPager.getAdapter().notifyDataSetChanged();
    }

    public void on4(View view) {
        size = 4;
        indicatorViewPager.getAdapter().notifyDataSetChanged();
    }

    public void on5(View view) {
        size = 5;
        indicatorViewPager.getAdapter().notifyDataSetChanged();
    }

    public void on12(View view) {
        size = 12;
        indicatorViewPager.getAdapter().notifyDataSetChanged();
    }

    private class MyAdapter extends IndicatorViewPager.IndicatorFragmentPagerAdapter {

        public MyAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public int getCount() {
            return size;
        }

        @Override
        public View getViewForTab(int position, View convertView, ViewGroup container) {
            if (convertView == null) {
                convertView = inflate.inflate(R.layout.tab_top, container, false);
            }
            TextView textView = (TextView) convertView;
            textView.setText(names[position % names.length]);
            int padding = DensityUtil.dip2px(mContext,10);
            textView.setPadding(padding, 0, padding, 0);
            return convertView;
        }

        @Override
        public Fragment getFragmentForPage(int position) {
            MoreFragment fragment = new MoreFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(MoreFragment.INTENT_INT_INDEX, position);
            fragment.setArguments(bundle);
            return fragment;
        }

        @Override
        public int getItemPosition(Object object) {
            //这是ViewPager适配器的特点,有两个值 POSITION_NONE，POSITION_UNCHANGED，默认就是POSITION_UNCHANGED,
            // 表示数据没变化不用更新.notifyDataChange的时候重新调用getViewForPage
            return PagerAdapter.POSITION_NONE;
        }

    }
}
