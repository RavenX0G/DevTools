package com.mogul.xxm.libdevtools.circleview;

import android.graphics.drawable.Drawable;

/**
 * Time:6/2/2017 9:36 AM
 * Created by Curtain.
 */

public class TagInfo {

    String url;
    int position;
    Drawable drawable;

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public int getPosition() {
        return position;
    }
    public void setPosition(int position) {
        this.position = position;
    }
    public Drawable getDrawable() {
        return drawable;
    }
    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }
}
