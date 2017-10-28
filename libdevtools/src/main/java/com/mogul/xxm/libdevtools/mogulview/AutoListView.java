package com.mogul.xxm.libdevtools.mogulview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Time:4/1/2017 9:40 AM
 * Created by Curtain.
 */

public class AutoListView extends ListView {

    //嵌套在ScrollView中全展开，重写onMeasure导致adapter的getView方法反复执行
    //设置一个boolean变量，onMeasure时设为ture，onLayout时设为false
    public boolean isOnMeasure ;

    public AutoListView(Context context) {
        super(context);
    }

    public AutoListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AutoListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        isOnMeasure = true;
        int expandSpec = MeasureSpec.makeMeasureSpec(
                Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        isOnMeasure = false;
        super.onLayout(changed, l, t, r, b);
    }
}
