package com.mogul.xxm.libdevtools.mogulview;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mogul.xxm.libdevtools.R;
import com.mogul.xxm.libdevtools.utils.DensityUtil;

/**
 * Time:7/24/17 16:20
 * Created by Curtain.
 */

public class InputTextView extends LinearLayout{

    private Context mContext;
    private ImageView mLeftImage;
    private TextView mNameText;
    private EditText mEditText;
    private TextView mDivideLine;
    private ImageButton mClearBtn;
    private TypedArray typedArray;

    public InputTextView(Context context) {
        super(context);
        mContext = context;
    }

    public InputTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        View v = LayoutInflater.from(mContext).inflate(R.layout.input_text_view, this);
        mLeftImage = (ImageView)v.findViewById(R.id.left_image_view);
        mNameText = (TextView)v.findViewById(R.id.name_text);
        mEditText = (EditText)v.findViewById(R.id.edit_text);
        mDivideLine = (TextView)v.findViewById(R.id.divide_line);
        mClearBtn = (ImageButton)v.findViewById(R.id.clear_btn);
        typedArray = mContext.obtainStyledAttributes(attrs, R.styleable.InputTextView);
        int N = typedArray.getIndexCount();
        for (int i = 0; i < N; i++) {
            int attr = typedArray.getIndex(i);
            if(attr == R.styleable.InputTextView_leftImageSrc){
                mLeftImage.setImageResource(typedArray.getResourceId(
                        R.styleable.InputTextView_leftImageSrc, R.mipmap.default_pic));
                mLeftImage.setVisibility(VISIBLE);
            }else if(attr == R.styleable.InputTextView_nameText){
                mNameText.setText(typedArray.getString(R.styleable.InputTextView_nameText));
            }else if(attr == R.styleable.InputTextView_nameTextSize){
                float textSize = typedArray.getDimension(R.styleable.InputTextView_nameTextSize,16);
                //Log.d("test------","textSize:"+textSize);
                textSize = DensityUtil.px2sp(context,textSize);
                mNameText.setTextSize(textSize);
            }else if (attr == R.styleable.InputTextView_nameTextColor){
                int textColor = typedArray.getColor(R.styleable.InputTextView_nameTextColor, 0x000000);
                mNameText.setTextColor(textColor);
            }else if(attr == R.styleable.InputTextView_divideLineColor){
                int divideColor = typedArray.getColor(R.styleable.InputTextView_divideLineColor,0);
                mDivideLine.setBackgroundColor(divideColor);
            }else if(attr ==  R.styleable.InputTextView_meditText){
                String str1 = typedArray.getString(R.styleable.InputTextView_meditText);
                mEditText.setText(str1);
            }else if(attr == R.styleable.InputTextView_meditTextColor){
                int textColor = typedArray.getColor(R.styleable.InputTextView_meditTextColor, 0x000000);
                mEditText.setTextColor(textColor);
            }else if(attr == R.styleable.InputTextView_meditTextSize) {
                float textSize = typedArray.getDimension(R.styleable.InputTextView_meditTextSize, 16);
                textSize = DensityUtil.px2sp(context, textSize);
                mEditText.setTextSize(textSize);
            }else if(attr ==  R.styleable.InputTextView_meditTextHint){
                String str1 = typedArray.getString(R.styleable.InputTextView_meditTextHint);
                mEditText.setHint(str1);
            }else if(attr == R.styleable.InputTextView_meditTextHintColor){
                int textColor = typedArray.getColor(R.styleable.InputTextView_meditTextHintColor, 0x000000);
                mEditText.setHintTextColor(textColor);
            }
        }
        typedArray.recycle();
        this.setClickable(true);
        this.setFocusable(true);
        mClearBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                setEditText("");
            }
        });
    }

    public void setEditEnable(boolean b){
        mEditText.setFocusable(b);
        mEditText.setFocusableInTouchMode(b);
        if(b){
            mClearBtn.setVisibility(VISIBLE);

        }else{
            mClearBtn.setVisibility(GONE);
        }
    }

    public void setTextWatcher(TextWatcher textWatcher){
        mEditText.addTextChangedListener(textWatcher);
    }

    public void setInputType(int type){
        mEditText.setInputType(type);
    }

    public void setNameText(CharSequence str){
        mNameText.setText(str);
    }

    public String getNameText(){
        return mNameText.getText().toString();
    }

    public void setEditText(CharSequence str){
        mEditText.setText(str);
    }

    public String getEditText(){
        return mEditText.getText().toString();
    }

    public void setEditHint(String str){
        mEditText.setHint(str);
    }
}
