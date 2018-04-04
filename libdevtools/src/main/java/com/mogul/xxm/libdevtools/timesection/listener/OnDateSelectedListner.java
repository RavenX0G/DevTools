package com.mogul.xxm.libdevtools.timesection.listener;

import com.mogul.xxm.libdevtools.timesection.TimeSectionDialog;

/**
 * Created by Raven on 2018/4/4.
 */

public interface OnDateSelectedListner {

    void onDateSet(TimeSectionDialog timeSectionDialog, long startMillseconds,long endMillSeconds);
}
