package com.mogul.xxm.devtools.viewpagerindicator;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.mogul.xxm.devtools.R;
import com.mogul.xxm.libdevtools.utils.DensityUtil;
import com.mogul.xxm.libdevtools.viewpagerindicator.view.indicator.FixedIndicatorView;
import com.mogul.xxm.libdevtools.viewpagerindicator.view.indicator.Indicator;
import com.mogul.xxm.libdevtools.viewpagerindicator.view.indicator.RecyclerIndicatorView;
import com.mogul.xxm.libdevtools.viewpagerindicator.view.indicator.ScrollIndicatorView;
import com.mogul.xxm.libdevtools.viewpagerindicator.view.indicator.slidebar.ColorBar;
import com.mogul.xxm.libdevtools.viewpagerindicator.view.indicator.transition.OnTransitionTextListener;

public class SingleTabActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_tab);

        ScrollIndicatorView scrollIndicatorView = (ScrollIndicatorView) findViewById(R.id.singleTab_scrollIndicatorView);
        FixedIndicatorView fixedIndicatorView = (FixedIndicatorView) findViewById(R.id.singleTab_fixedIndicatorView);
        RecyclerIndicatorView recyclerIndicatorView = (RecyclerIndicatorView) findViewById(R.id.singleTab_reyclerIndicatorView);

        set(scrollIndicatorView, 16);
        set(fixedIndicatorView, 5);
        set(recyclerIndicatorView, 10000);
    }

    private void set(Indicator indicator, int count) {
        indicator.setAdapter(new MyAdapter(count));

        indicator.setScrollBar(new ColorBar(getApplicationContext(), Color.RED, 5));

        float unSelectSize = 16;
        float selectSize = unSelectSize * 1.2f;
        int selectColor = getResources().getColor(R.color.tab_top_text_2);
        int unSelectColor = getResources().getColor(R.color.tab_top_text_1);
        indicator.setOnTransitionListener(new OnTransitionTextListener().setColor(selectColor, unSelectColor).setSize(selectSize, unSelectSize));
        indicator.setOnIndicatorItemClickListener(new Indicator.OnIndicatorItemClickListener() {
            @Override
            public boolean onItemClick(View clickItemView, int position) {

                Toast.makeText(getBaseContext(),"selectPosition = " + position,Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        indicator.setCurrentItem(2,true);
    }

    private class MyAdapter extends Indicator.IndicatorAdapter {

        private final int count;

        public MyAdapter(int count) {
            super();
            this.count = count;
        }

        @Override
        public int getCount() {
            return count;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.tab_top, parent, false);
            }
            TextView textView = (TextView) convertView;
            //用了固定宽度可以避免TextView文字大小变化，tab宽度变化导致tab抖动现象
            textView.setWidth(DensityUtil.dip2px(getApplicationContext(),100));
            textView.setText(String.valueOf(position)+"蒙爷");
            return convertView;
        }
    }
}
