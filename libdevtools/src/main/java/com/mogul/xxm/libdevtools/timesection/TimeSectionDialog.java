package com.mogul.xxm.libdevtools.timesection;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.mogul.xxm.libdevtools.R;
import com.mogul.xxm.libdevtools.pickerview.TimeWheel;
import com.mogul.xxm.libdevtools.pickerview.config.PickerConfig;
import com.mogul.xxm.libdevtools.timesection.config.TimeSectionConfig;

/**
 * Created by Raven on 2018/4/4.
 */

public class TimeSectionDialog extends DialogFragment implements View.OnClickListener{


    TimeSectionConfig mTimeSectionConfig;
    private TimeWheel mTimeWheel;
    private long mCurrentMillSeconds;

    private static TimeSectionDialog newIntance(TimeSectionConfig config) {
        TimeSectionDialog timeSectionDialog = new TimeSectionDialog();
        timeSectionDialog.initialize(config);
        return timeSectionDialog;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Activity activity = getActivity();
        activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

    }

    @Override
    public void onResume() {
        super.onResume();
        int height = getResources().getDimensionPixelSize(R.dimen.picker_height);

        Window window = getDialog().getWindow();
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, height);//Here!
        window.setGravity(Gravity.CENTER);
    }

    private void initialize(TimeSectionConfig sectionConfig) {
        mTimeSectionConfig = sectionConfig;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = new Dialog(getActivity(), R.style.Dialog_NoTitle);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setContentView(initView());
        return dialog;
    }

    View initView() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.time_section_layout, null);
        TextView cancel = (TextView) view.findViewById(R.id.tv_cancel);
        cancel.setOnClickListener(this);
        TextView sure = (TextView) view.findViewById(R.id.tv_sure);
        sure.setOnClickListener(this);
        TextView title = (TextView) view.findViewById(R.id.tv_title);

        View toolbar = view.findViewById(R.id.toolbar);

        title.setText(mTimeSectionConfig.mTitleString);
        cancel.setText(mTimeSectionConfig.mCancelString);
        sure.setText(mTimeSectionConfig.mSureString);
        toolbar.setBackgroundColor(mTimeSectionConfig.mThemeColor);

//        mTimeWheel = new TimeWheel(view, mTimeSectionConfig);
        return view;
    }

    @Override
    public void onClick(View view) {

    }
}
