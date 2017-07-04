package com.mogul.xxm.libdevtools.mogulview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mogul.xxm.libdevtools.R;
import com.mogul.xxm.libdevtools.utils.DensityUtil;

/**
 * Time:7/4/2017 1:55 PM
 * Created by Curtain.
 */

public class RightArrowButton extends LinearLayout {

    private Context mContext;
    private ImageView mLeftImage;
    private TextView mNameText;
    private ImageView mRightArrow;
    private TextView mDivideLine;
    private TextView mRightText;
    private TypedArray typedArray;

    public RightArrowButton(Context context) {
        super(context);
        mContext = context;
    }

    public RightArrowButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext=context;

        View v = LayoutInflater.from(mContext).inflate(R.layout.right_arrow_button, this);
        mLeftImage = (ImageView)v.findViewById(R.id.left_image_view);
        mNameText = (TextView)v.findViewById(R.id.name_text);
        mRightArrow = (ImageView)v.findViewById(R.id.arrow_image);
        mDivideLine = (TextView)v.findViewById(R.id.divide_line);
        mRightText = (TextView)v.findViewById(R.id.right_text);
        typedArray = mContext.obtainStyledAttributes(attrs, R.styleable.RightArrowButton);
        int N = typedArray.getIndexCount();
        for (int i = 0; i < N; i++) {
            int attr = typedArray.getIndex(i);
            if(attr == R.styleable.RightArrowButton_leftImageSrc){
                mLeftImage.setImageResource(typedArray.getResourceId(
                        R.styleable.RightArrowButton_leftImageSrc, R.mipmap.default_pic));
                mLeftImage.setVisibility(VISIBLE);
            }else if(attr == R.styleable.RightArrowButton_rightArrowText){
                mNameText.setText(typedArray.getString(R.styleable.RightArrowButton_rightArrowText));
            }else if(attr == R.styleable.RightArrowButton_rightArrowTextSize){
                float textSize = typedArray.getDimension(R.styleable.RightArrowButton_rightArrowTextSize,16);
                //Log.d("test------","textSize:"+textSize);
                textSize = DensityUtil.px2sp(context,textSize);
                mNameText.setTextSize(textSize);
            }else if (attr == R.styleable.RightArrowButton_rightArrowTextColor){
                int textColor = typedArray.getColor(R.styleable.RightArrowButton_rightArrowTextColor, 0x000000);
                mNameText.setTextColor(textColor);
            }else if(attr == R.styleable.RightArrowButton_rightArrowSrc){
                int resourceId = typedArray.getResourceId(
                        R.styleable.RightArrowButton_rightArrowSrc, R.mipmap.arrow_right);
                mRightArrow.setImageResource(resourceId);
            }else if(attr == R.styleable.RightArrowButton_divideLineColor){
                int divideColor = typedArray.getColor(R.styleable.RightArrowButton_divideLineColor,0);
                mDivideLine.setBackgroundColor(divideColor);
            }else if(attr ==  R.styleable.RightArrowButton_rightArrowRightText){
                String str1 = typedArray.getString(R.styleable.RightArrowButton_rightArrowRightText);
                if (str1.equals("")){
                    mRightText.setVisibility(View.GONE);
                } else {
                    mRightText.setVisibility(View.VISIBLE);
                    mRightText.setText(str1);
                }
            }else if(attr == R.styleable.RightArrowButton_rightArrowRightTextColor){
                int rightTextColor = typedArray.getColor(R.styleable.RightArrowButton_rightArrowRightTextColor, 0x000000);
                mRightText.setTextColor(rightTextColor);
            }else if(attr == R.styleable.RightArrowButton_rightArrowRightTextSize){
                float rightTextSize = typedArray.getDimension(R.styleable.RightArrowButton_rightArrowRightTextSize,16);
                rightTextSize = DensityUtil.px2sp(context,rightTextSize);
                mRightText.setTextSize(rightTextSize);
            }
        }
        typedArray.recycle();
        this.setClickable(true);
        this.setFocusable(true);
    }
}
