package com.mogul.xxm.devtools;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.mogul.xxm.libdevtools.dialog.DialogUIUtils;
import com.mogul.xxm.libdevtools.dialog.utils.ToolUtils;
import com.mogul.xxm.libdevtools.mogulview.BadgeView;
import com.mogul.xxm.libdevtools.mogulview.NumberEditView;
import com.mogul.xxm.libdevtools.mogulview.RightArrowButton;

public class RightArrowBtnActivity extends AppCompatActivity implements View.OnClickListener{

    private RightArrowButton rBtn;
    private NumberEditView numberEditView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_right_arrow_btn);
        DialogUIUtils.init(this);
        numberEditView = (NumberEditView) findViewById(R.id.number_edit);
        numberEditView.setOnNumChangerListener(new NumberEditView.OnNumChangeListener() {
            @Override
            public void onNumChange(int num) {
                DialogUIUtils.showToastTop("num has changed : num = " + num);
            }

            @Override
            public void onDelete() {
                DialogUIUtils.showToastTop("call delete ");
            }
        });

//        BadgeView badgeView = new BadgeView(this,numberEditView);
//        badgeView.setText("1");
//        badgeView.show();
    }

    @Override
    public void onClick(View view) {
        DialogUIUtils.showToast("button is onClick");
    }
}
