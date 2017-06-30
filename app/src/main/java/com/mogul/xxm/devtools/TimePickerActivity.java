package com.mogul.xxm.devtools;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.mogul.xxm.libdevtools.pickerview.TimePickerDialog;
import com.mogul.xxm.libdevtools.pickerview.data.Type;
import com.mogul.xxm.libdevtools.pickerview.listener.OnDateSetListener;

public class TimePickerActivity extends AppCompatActivity implements OnDateSetListener,View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker);
        initTimeConfig();
    }

    /**时间选择器*/
    TimePickerDialog mDialogAll;
    TimePickerDialog mDialogYearMonth;
    TimePickerDialog mDialogYearMonthDay;
    TimePickerDialog mDialogMonthDayHourMinute;
    TimePickerDialog mDialogHourMinute;

    private void initTimeConfig(){
        long tenYears = 10L * 365 * 1000 * 60 * 60 * 24L;
        mDialogAll = new TimePickerDialog.Builder()
                .setCallBack(this)
                .setCancelStringId("取消")
                .setSureStringId("确认")
                .setTitleStringId("所有时间")
                .setYearText("年")
                .setMonthText("月")
                .setDayText("日")
                .setHourText("时")
                .setMinuteText("分")
                .setCyclic(true)
                .setMinMillseconds(System.currentTimeMillis())
                .setMaxMillseconds(System.currentTimeMillis() + tenYears)
                .setCurrentMillseconds(System.currentTimeMillis())
                //.setThemeColor(ContextCompat.getColor(mContext,R.color.timepicker_dialog_bg))
                .setType(Type.ALL)
                //.setWheelItemTextNormalColor(ContextCompat.getColor(mContext,R.color.timetimepicker_default_text_color))
                //.setWheelItemTextSelectorColor(ContextCompat.getColor(mContext,R.color.timepicker_toolbar_bg))
                .setWheelItemTextSize(12)
                .build();

        mDialogYearMonth = new TimePickerDialog.Builder()
                .setType(Type.YEAR_MONTH)
                .setThemeColor(getResources().getColor(R.color.colorPrimary))
                .setCallBack(this)
                .build();
        mDialogYearMonthDay = new TimePickerDialog.Builder()
                .setType(Type.YEAR_MONTH_DAY)
                .setCallBack(this)
                .build();
        mDialogMonthDayHourMinute = new TimePickerDialog.Builder()
                .setType(Type.MONTH_DAY_HOUR_MIN)
                .setCallBack(this)
                .build();
        mDialogHourMinute = new TimePickerDialog.Builder()
                .setType(Type.HOURS_MINS)
                .setCallBack(this)
                .build();
    }

    private void showTimerPick(){
        if(!mDialogAll.isAdded())
            mDialogAll.show(getSupportFragmentManager(), "all");
    }


    @Override
    public void onDateSet(TimePickerDialog timePickerView, long millseconds) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_16:
                showTimerPick();
                break;

        }
    }
}
