package com.mogul.xxm.devtools.refreshview;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import com.mogul.xxm.devtools.R;
import com.mogul.xxm.devtools.refreshview.adapter.StickylistAdapter;
import com.mogul.xxm.devtools.refreshview.bean.StickyListBean;
import com.mogul.xxm.devtools.refreshview.smileyloadingview.SmileyHeaderView;
import com.mogul.xxm.devtools.refreshview.ui.CustomHeader;
import com.mogul.xxm.libdevtools.refreshview.XRefreshView;
import com.mogul.xxm.libdevtools.refreshview.listener.OnBottomLoadMoreTime;
import com.mogul.xxm.libdevtools.refreshview.listener.OnTopRefreshTime;
import com.mogul.xxm.libdevtools.refreshview.stickyListHeaders.StickyListHeadersListView;

import java.util.ArrayList;
import java.util.List;


public class CustomViewActivity extends AppCompatActivity {

    private StickyListHeadersListView stickyLv;
    private List<StickyListBean> list = new ArrayList<StickyListBean>();
    private XRefreshView refreshView;
    private int mTotalItemCount;
    private StickylistAdapter adapter;
    private final int mPinnedTime = 1000;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
        initData();
        stickyLv = (StickyListHeadersListView) findViewById(R.id.sticky_list);
        adapter = new StickylistAdapter(getApplicationContext(), list);
        stickyLv.setAdapter(adapter);
        refreshView = (XRefreshView) findViewById(R.id.custom_view);
        refreshView.setPullLoadEnable(true);
        refreshView.setAutoRefresh(true);
        refreshView.setPinnedTime(mPinnedTime);
        refreshView.setCustomHeaderView(new SmileyHeaderView(this));
        refreshView.setCustomHeaderView(new CustomHeader(CustomViewActivity.this,mPinnedTime));
        refreshView.setOnTopRefreshTime(new OnTopRefreshTime() {

            @Override
            public boolean isTop() {
                if (stickyLv.getFirstVisiblePosition() == 0) {
                    View firstVisibleChild = stickyLv.getListChildAt(0);
                    return firstVisibleChild.getTop() >= 0;
                }
                return false;
            }
        });
        refreshView.setOnBottomLoadMoreTime(new OnBottomLoadMoreTime() {

            @Override
            public boolean isBottom() {
                if (stickyLv.getLastVisiblePosition() == mTotalItemCount - 1) {
                    View lastChild = stickyLv.getListChildAt(stickyLv.getListChildCount() - 1);
                    return (lastChild.getBottom() + stickyLv.getPaddingBottom()) <= stickyLv.getMeasuredHeight();
                }
                //没有到达底部则返回false
                return false;
            }
        });
        stickyLv.setOnScrollListener(new AbsListView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {
                mTotalItemCount = totalItemCount;
            }
        });
        refreshView.setXRefreshViewListener(new XRefreshView.SimpleXRefreshListener() {

            @Override
            public void onRefresh(boolean isPullDown) {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshView.stopRefresh();
                    }
                }, 2000);
            }

            @Override
            public void onLoadMore(boolean isSilence) {

                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        refreshView.stopLoadMore();
                    }
                }, 2000);
            }
        });
    }

    int section = 0;
    String YM = null;
    String content = null;

    private void initData() {

        for (int i = 0; i < 20; i++) {
            if (i % 5 == 0) {
                section++;
                YM = "第" + section + "个头";
            }
            content = "第" + i + "项数据";
            StickyListBean bean = new StickyListBean(section, YM, content);
            list.add(bean);
        }

    }
}
