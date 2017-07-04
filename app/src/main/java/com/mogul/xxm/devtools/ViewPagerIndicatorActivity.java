package com.mogul.xxm.devtools;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.mogul.xxm.devtools.viewpagerindicator.BannerActivity;
import com.mogul.xxm.devtools.viewpagerindicator.GuideActivity;
import com.mogul.xxm.devtools.viewpagerindicator.MoreTab1Activity;
import com.mogul.xxm.devtools.viewpagerindicator.MoreTab2Activity;
import com.mogul.xxm.devtools.viewpagerindicator.SingleTabActivity;
import com.mogul.xxm.devtools.viewpagerindicator.SpringActivity;
import com.mogul.xxm.devtools.viewpagerindicator.TabMainActivity;

public class ViewPagerIndicatorActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_indicator);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_1:
                toActivity(GuideActivity.class);
                break;
            case R.id.button_2:
                toActivity(BannerActivity.class);
                break;
            case R.id.button_3:
                toActivity(MoreTab1Activity.class);
                break;
            case R.id.button_4:
                toActivity(MoreTab2Activity.class);
                break;
            case R.id.button_5:
                toActivity(SpringActivity.class);
                break;
            case R.id.button_6:
                toActivity(SingleTabActivity.class);
                break;
            case R.id.button_7:
                toActivity(TabMainActivity.class);
                break;
        }
    }

    private void toActivity(Class<?> cls){
        Intent i = new Intent(this,cls);
        startActivity(i);
    }
}
