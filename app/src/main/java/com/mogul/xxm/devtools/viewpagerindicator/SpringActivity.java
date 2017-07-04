package com.mogul.xxm.devtools.viewpagerindicator;

import android.graphics.Color;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mogul.xxm.devtools.R;
import com.mogul.xxm.libdevtools.utils.DensityUtil;
import com.mogul.xxm.libdevtools.viewpagerindicator.view.indicator.Indicator;
import com.mogul.xxm.libdevtools.viewpagerindicator.view.indicator.IndicatorViewPager;
import com.mogul.xxm.libdevtools.viewpagerindicator.view.indicator.ScrollIndicatorView;
import com.mogul.xxm.libdevtools.viewpagerindicator.view.indicator.slidebar.ColorBar;
import com.mogul.xxm.libdevtools.viewpagerindicator.view.indicator.slidebar.SpringBar;
import com.mogul.xxm.libdevtools.viewpagerindicator.view.indicator.transition.OnTransitionTextListener;

public class SpringActivity extends AppCompatActivity {

    private IndicatorViewPager indicatorViewPager;
    private LayoutInflater inflate;
    private int unSelectColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spring);

        ViewPager viewPager = (ViewPager) findViewById(R.id.spring_viewPager);
        Indicator indicator = (ScrollIndicatorView) findViewById(R.id.spring_indicator);
        int selectColor = Color.parseColor("#f8f8f8");
        unSelectColor = Color.parseColor("#010101");
        indicator.setOnTransitionListener(new OnTransitionTextListener().setColor(selectColor, unSelectColor));
        indicator.setScrollBar(new SpringBar(getApplicationContext(), Color.RED));
//        indicator.setScrollBar(new ColorBar(getApplicationContext(), Color.RED, 5));
        viewPager.setOffscreenPageLimit(4);
        indicatorViewPager = new IndicatorViewPager(indicator, viewPager);
        inflate = LayoutInflater.from(getApplicationContext());
        indicatorViewPager.setAdapter(adapter);
        indicatorViewPager.setCurrentItem(5, false);
    }

    private IndicatorViewPager.IndicatorPagerAdapter adapter = new IndicatorViewPager.IndicatorViewPagerAdapter() {

        @Override
        public View getViewForTab(int position, View convertView, ViewGroup container) {
            if (convertView == null) {
                convertView = inflate.inflate(R.layout.tab_top, container, false);
            }
            TextView textView = (TextView) convertView;
            int padding = DensityUtil.dip2px(getApplicationContext(), 30);
            textView.setPadding(padding, 0, padding, 0);
            textView.setText(String.valueOf(position));
            textView.setTextColor(unSelectColor);
            return convertView;
        }

        @Override
        public View getViewForPage(int position, View convertView, ViewGroup container) {
            if (convertView == null) {
                convertView = inflate.inflate(R.layout.fragment_tabmain_item, container, false);
            }
            final TextView textView1 = (TextView) convertView.findViewById(R.id.fragment_mainTab_item_textView);

            textView1.setText(" " + position + " 界面加载完毕");
            final ProgressBar progressBar = (ProgressBar) convertView.findViewById(R.id.fragment_mainTab_item_progressBar);
            new Handler() {
                public void handleMessage(android.os.Message msg) {
                    textView1.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.GONE);
                }
            }.sendEmptyMessageDelayed(1, 2000);
            return convertView;
        }

        @Override
        public int getItemPosition(Object object) {
            //这是ViewPager适配器的特点,有两个值 POSITION_NONE，POSITION_UNCHANGED，默认就是POSITION_UNCHANGED,
            // 表示数据没变化不用更新.notifyDataChange的时候重新调用getViewForPage
            return PagerAdapter.POSITION_UNCHANGED;
        }

        @Override
        public int getCount() {
            return 16;
        }
    };
}
