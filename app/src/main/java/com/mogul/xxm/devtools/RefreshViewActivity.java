package com.mogul.xxm.devtools;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.mogul.xxm.devtools.refreshview.BannerRecyclerViewActivity;
import com.mogul.xxm.devtools.refreshview.CustomViewActivity;
import com.mogul.xxm.devtools.refreshview.EmptyViewActivity;
import com.mogul.xxm.devtools.refreshview.GridRecyclerViewActivity;
import com.mogul.xxm.devtools.refreshview.GridViewActivity;
import com.mogul.xxm.devtools.refreshview.HeadAdActivity;
import com.mogul.xxm.devtools.refreshview.LinearRecyclerViewActivity;
import com.mogul.xxm.devtools.refreshview.ListViewActivity;
import com.mogul.xxm.devtools.refreshview.MultiItemRecyclerViewActivity;
import com.mogul.xxm.devtools.refreshview.NotFullScreenActivity;
import com.mogul.xxm.devtools.refreshview.NotFullScreenWithoutFooterActivity;
import com.mogul.xxm.devtools.refreshview.ScrollViewActivity;
import com.mogul.xxm.devtools.refreshview.ShowFooterWhenNoMoreDataRecyclerViewActivity;
import com.mogul.xxm.devtools.refreshview.SilenceRecyclerViewActivity;
import com.mogul.xxm.devtools.refreshview.SmileViewActivity;
import com.mogul.xxm.devtools.refreshview.StaggeredRecyclerViewActivity;
import com.mogul.xxm.devtools.refreshview.WithoutBaseAdapterRecyclerViewActivity;


public class RefreshViewActivity extends AppCompatActivity implements View.OnClickListener{




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh_view);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            /**Linear样式的RecyclerView*/
            case R.id.button_1:
                toActivity(LinearRecyclerViewActivity.class);
                break;
            /**Grid样式的RecyclerView*/
            case R.id.button_2:
                toActivity(GridRecyclerViewActivity.class);
                break;
            /**Staggered样式的RecyclerView*/
            case R.id.button_3:
                toActivity(StaggeredRecyclerViewActivity.class);
                break;
            /**带Banner的Recyclerview*/
            case R.id.button_4:
                toActivity(BannerRecyclerViewActivity.class);
                break;

            /**多种布局的RecyclerView*/
            case R.id.button_5:
                toActivity(MultiItemRecyclerViewActivity.class);
                break;

            /**静默加载的RecyclerView*/
            case R.id.button_6:
                toActivity(SilenceRecyclerViewActivity.class);
                break;

            /**不使用BaseRecyclerView*/
            case R.id.button_7:
                toActivity(WithoutBaseAdapterRecyclerViewActivity.class);
                break;

            /**没有更多数据时显示footerview*/
            case R.id.button_8:
                toActivity(ShowFooterWhenNoMoreDataRecyclerViewActivity.class);
                break;

            /**ListView*/
            case R.id.button_9:
                toActivity(ListViewActivity.class);
                break;

            /**GridView*/
            case R.id.button_10:
                toActivity(GridViewActivity.class);
                break;
            /**自定义View*/
            case R.id.button_11:
                toActivity(CustomViewActivity.class);
                break;
            /**ScrollView*/
            case R.id.button_12:
                toActivity(ScrollViewActivity.class);
                break;

            /**使用空布局*/
            case R.id.button_13:
                toActivity(EmptyViewActivity.class);
                break;

            /**数据不满一屏*/
            case R.id.button_14:
                toActivity(NotFullScreenActivity.class);
                break;

            /**数据量少，不现实加载更多*/
            case R.id.button_15:
                toActivity(NotFullScreenWithoutFooterActivity.class);
                break;

            /**笑脸刷新*/
            case R.id.button_16:
                toActivity(SmileViewActivity.class);
                break;

            /**WebView*/
            case R.id.button_17:
                toActivity(WebViewActivity.class);
                break;

            /**WebView*/
            case R.id.button_18:
                toActivity(HeadAdActivity.class);
                break;

        }
    }

    private void toActivity(Class<?> cls){
        Intent i = new Intent(this,cls);
        startActivity(i);
    }
}
