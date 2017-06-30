package com.mogul.xxm.devtools;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mogul.xxm.libdevtools.circleview.CircleImageView;

public class CircleHeadImageActivity extends AppCompatActivity {

    CircleImageView normalCircle;
    CircleImageView netCircle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_head_image);
        netCircle = (CircleImageView) findViewById(R.id.net_circle_view);
        netCircle.setNetImage("http://up.qqjia.com/z/01/tu3945_9.jpg",R.mipmap.test03);
    }
}
