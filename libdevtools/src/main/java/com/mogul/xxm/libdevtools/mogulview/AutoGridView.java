package com.mogul.xxm.libdevtools.mogulview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * com.zysm.curtain.caraid.base
 * Created by Curtain on 2016/12/14.
 */

public class AutoGridView extends GridView {

    public AutoGridView(Context context) {
        super(context);
    }

    public AutoGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AutoGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(
                Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
