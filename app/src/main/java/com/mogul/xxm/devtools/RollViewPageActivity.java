package com.mogul.xxm.devtools;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.mogul.xxm.devtools.rollviewpage.LoopActivity;
import com.mogul.xxm.devtools.rollviewpage.NetImageActivity;
import com.mogul.xxm.devtools.rollviewpage.SimpleActivity;

public class RollViewPageActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roll_view_page);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_1:
                toActivity(SimpleActivity.class);
                break;
            case R.id.button_2:
                toActivity(LoopActivity.class);
                break;
            case R.id.button_3:
                toActivity(NetImageActivity.class);
                break;
        }
    }

    private void toActivity(Class<?> cls){
        Intent i = new Intent(this,cls);
        startActivity(i);
    }
}
