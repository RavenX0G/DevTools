package com.mogul.xxm.devtools;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.mogul.xxm.devtools.refreshview.BannerRecyclerViewActivity;
import com.mogul.xxm.libdevtools.dialog.BuildBean;
import com.mogul.xxm.libdevtools.dialog.DialogUIUtils;
import com.mogul.xxm.libdevtools.dialog.MaterialDialog;
import com.mogul.xxm.libdevtools.dialog.TieBean;
import com.mogul.xxm.libdevtools.dialog.listener.DialogUIItemListener;
import com.mogul.xxm.libdevtools.dialog.listener.DialogUIListener;
import com.mogul.xxm.libdevtools.pickerview.TimePickerDialog;
import com.mogul.xxm.libdevtools.pickerview.data.Type;
import com.mogul.xxm.libdevtools.pickerview.listener.OnDateSetListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "MainActivity";
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mContext = this;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_1:
                toActivity(DialogActivity.class);
                break;
            case R.id.button_2:
                toActivity(TimePickerActivity.class);
                break;
            case R.id.button_3:
                toActivity(RefreshViewActivity.class);
                break;
            case R.id.button_4:
               // toActivity(BannerRecyclerViewActivity.class);
                break;

        }
    }

    private void toActivity(Class<?> cls){
        Intent i = new Intent(this,cls);
        startActivity(i);
    }




}
