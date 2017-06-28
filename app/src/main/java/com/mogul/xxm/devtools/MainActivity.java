package com.mogul.xxm.devtools;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.mogul.xxm.libdevtools.dialog.MaterialDialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mContext = this;

    }


    private void showNorDialog(){
        MaterialDialog materialDialog = new MaterialDialog(this);
        materialDialog
                .setTitle("这个是标题")
                //.setTitleColor(R.color.colorAccent)
                .setMessage("消息内容")
                .setPositiveButton("确认", new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        }).setNegativeButton("取消", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext,"取消按钮",Toast.LENGTH_SHORT).show();
            }
        }).setCanceledOnTouchOutside(true)
                .setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialogInterface) {

                    }
                })
                .show();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_1:
                showNorDialog();
                break;
        }
    }
}
