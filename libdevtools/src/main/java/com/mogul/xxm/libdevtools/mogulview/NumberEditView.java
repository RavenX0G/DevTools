package com.mogul.xxm.libdevtools.mogulview;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mogul.xxm.libdevtools.R;

/**
 * Created by Curtain on 2016/9/21.
 */
public class NumberEditView extends LinearLayout {

    private Context mContext;
    private Button down;
    private Button up;
    private TextView numberText;
    private int value = 1;
    private OnNumChangeListener numChangeListener;
    private int beforeNum = 1;
    public NumberEditView(Context context) {
        super(context);
        mContext = context;
        initView();
    }

    public NumberEditView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView();
    }

    public void initView(){
        LayoutInflater.from(mContext).inflate(R.layout.number_edit_view, this);
        down = (Button)findViewById(R.id.down);
        up = (Button)findViewById(R.id.up);
        numberText = (TextView) findViewById(R.id.number_text);

        down.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(value > 1){
                    value--;
                    numberText.setText(""+value);
                    if(null != numChangeListener) {
                        numChangeListener.onNumChange(getVal());
                    }
                }else if (value == 1){

                    if(null != numChangeListener) {
                        numChangeListener.onDelete();
                    }

                }



            }
        });

        up.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                value ++;
                numberText.setText(""+value);
                if(null != numChangeListener) {
                    numChangeListener.onNumChange(getVal());
                }
            }
        });
/*
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                try {
                    beforeNum = Integer.parseInt(editText.getText().toString());
                }catch  (NumberFormatException e){
                    //Util.showToast(mContext,""+e.toString());
                }

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length() > 5){
                    ToastUtils.showShort(mContext,"您选择的数量超出限定范围");
                    editText.setText(s.toString().substring(0,s.length()-1));
                    return;
                }
                else if(s.length() == 0 ){
                    value = 1;
                    editText.setText(""+value);
                    editText.setSelection(1);
                }else{
                    try {
                        value = Integer.parseInt(s.toString());
                    }catch (NumberFormatException e){
                        //Util.showToast(mContext,""+e.toString());
                    }
                    editText.setSelection(s.length());
                }

                if(s.length()>1 && s.charAt(0)=='0'){
                    LogRUtils.d("Test","s -===" +s);
                    String s1 = (s.toString()).substring(1,s.length());
                    LogRUtils.d("Test","s1 -===" +s1);
                    editText.setText(s1) ;
                    try {
                        value = Integer.parseInt(s1.toString());
                    }catch (NumberFormatException e){
                        //Util.showToast(mContext,""+e.toString());
                    }
                    editText.setSelection(s1.length());
                }

            }
        });*/
    }

    public void setOnNumChangerListener(OnNumChangeListener numChangeListener){
        this.numChangeListener = numChangeListener;
    }

    public int getVal(){
        int val = 1;
        try {
            val = Integer.parseInt(numberText.getText().toString());
        }catch (NumberFormatException e) {
            //Util.showToast(mContext,""+e);
        }

        return val;
    }

    public interface OnNumChangeListener {
        void onNumChange(int num);
        void onDelete();
    }

    public void setVal(int val){
        value = val;
        numberText.setText(""+val);
    }
}
