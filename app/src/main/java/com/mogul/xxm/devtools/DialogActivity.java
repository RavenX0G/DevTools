package com.mogul.xxm.devtools;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.mogul.xxm.libdevtools.dialog.DialogUIUtils;
import com.mogul.xxm.libdevtools.dialog.MaterialDialog;
import com.mogul.xxm.libdevtools.dialog.TieBean;
import com.mogul.xxm.libdevtools.dialog.listener.DialogUIItemListener;
import com.mogul.xxm.libdevtools.dialog.listener.DialogUIListener;

import java.util.ArrayList;
import java.util.List;

public class DialogActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "DialogActivity";
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        this.mContext = this;
        DialogUIUtils.init(mContext);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_1:
                showNorDialog();
                break;
            case R.id.button_2:
                showListDialog();
                break;
            //DialogUiUtils
            case R.id.button_3:
                showDialogTie();
                break;
            case R.id.button_4:
                showLoadingDialog((String) view.getTag());
                break;
            case R.id.button_5:
                showLoadingDialog((String) view.getTag());
                break;
            case R.id.button_6:
                showLoadingDialog((String) view.getTag());
                break;
            case R.id.button_7:
                showMDAlert();
                break;

            case R.id.button_8:
                showMdMultiChoose();
                break;

            case R.id.button_9:
                showSingleChoose();
                break;
            case R.id.button_10:
                showAlert((String) view.getTag());
                break;
            case R.id.button_11:
                showCenterSheet();
                break;

            case R.id.button_12:
                showMdBottomSheet1();
                break;

            case R.id.button_13:
                showMdBottomSheet2();
                break;

            case R.id.button_14:
                showToast();
                break;

            case R.id.button_15:
                showCustomAlert();
                break;
        }
    }


        /**对话框*/

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

    private void showListDialog(){
        final ArrayAdapter<String> arrayAdapter
                = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1);
        for (int j = 0; j < 38; j++) {
            arrayAdapter.add("This is item " + j);
        }

        ListView listView = new ListView(this);
        listView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        float scale = getResources().getDisplayMetrics().density;
        int dpAsPixels = (int) (8 * scale + 0.5f);
        listView.setPadding(0, dpAsPixels, 0, dpAsPixels);
        listView.setDividerHeight(0);
        listView.setAdapter(arrayAdapter);

        final MaterialDialog alert = new MaterialDialog(this)
                //.setTitle("MaterialDialog")
                .setContentView(listView);

        alert.setPositiveButton("OK", new View.OnClickListener() {
            @Override public void onClick(View v) {
                alert.dismiss();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(mContext,"this is item "+i+" onclicked",Toast.LENGTH_SHORT).show();
            }
        });

        alert.show();
    }

    private void showDialogTie(){
        DialogUIUtils.showDialogTie(mContext,"showDialogTie").show();
    }

    private void showLoadingDialog(String tag){
        if(tag.equals("Horizontal")) {
            DialogUIUtils.showLoadingHorizontal(mContext, "loadingHorizontal").show();
        }else if(tag.equals("Vertical")){
            DialogUIUtils.showLoadingVertical(mContext,"loadingHorizontal").show();
        }else  if(tag.equals("MdLoadingVertical")){
            DialogUIUtils.showMdLoadingVertical(mContext,"MdLoadingVertical").show();
        }
    }

    private void showMDAlert(){
        DialogUIUtils.showMdAlert((Activity) mContext, "title", "msg", new DialogUIListener() {
            @Override
            public void onPositive() {

            }

            @Override
            public void onNegative() {

            }
        }).show();
    }

    private void showMdMultiChoose(){
        String[] words = {"words1","words2","words3","words4","words5"};
        final boolean[] checkedItems = {false,true,false,true,false};
        DialogUIUtils.showMdMultiChoose((Activity) mContext, "title", words, checkedItems, new DialogUIListener() {
            @Override
            public void onPositive() {

            }

            @Override
            public void onNegative() {

            }

            @Override
            public void onGetChoose(boolean[] states) {
                super.onGetChoose(states);
            }
        }).show();


    }

    private int defaultPosition = 0 ;

    private void showSingleChoose(){
        String[] words = {"words0","words1","words2","words3","words4","words5",
                "words6","words7","words8","words9","words10",
                "words11","words12","words13","words14","words15",};
        DialogUIUtils.showSingleChoose((Activity) mContext, "title", defaultPosition, words, new DialogUIItemListener() {
            @Override
            public void onItemClick(CharSequence text, int position) {
                defaultPosition = position;
                Toast.makeText(mContext,""+text,Toast.LENGTH_SHORT).show();
            }

        }).show();
    }


    private void showAlert(String tag){

        if(tag.equals("Alert1")){
            final String hint1 = "hint1";
            String hint2 = "hint2";
            DialogUIUtils.showAlert((Activity) mContext, "title", "msg", hint1, hint2, "firstTxt", "secondTxt", false, new DialogUIListener() {
                @Override
                public void onPositive() {


                }

                @Override
                public void onNegative() {

                }

                @Override
                public void onGetInput(CharSequence input1, CharSequence input2) {
                    super.onGetInput(input1, input2);
                    Toast.makeText(mContext,"input1 = "+input1 + "\ninput2 = " + input2,Toast.LENGTH_SHORT).show();
                }
            }).show();

        }
    }

    private void showCenterSheet(){
        List<TieBean> tieBeans = new ArrayList<>();
        tieBeans.add(new TieBean("tiebean1",0));
        tieBeans.add(new TieBean("tiebean2",2));
        tieBeans.add(new TieBean("tiebean3",4));
        tieBeans.add(new TieBean("tiebean4",8));
        DialogUIUtils.showCenterSheet(mContext, tieBeans, new DialogUIItemListener() {
            @Override
            public void onItemClick(CharSequence text, int position) {
                Toast.makeText(mContext,"text = "+text + "\nposition = " + position,Toast.LENGTH_SHORT).show();
            }
        }).show();
    }

    private void showMdBottomSheet1(){
        List<TieBean> tieBeans = new ArrayList<>();
        tieBeans.add(new TieBean("tiebean1",0));
        tieBeans.add(new TieBean("tiebean2",2));
        tieBeans.add(new TieBean("tiebean3",4));
        tieBeans.add(new TieBean("tiebean4",8));
        tieBeans.add(new TieBean("tiebean6",1));
        tieBeans.add(new TieBean("tiebean7",3));
        tieBeans.add(new TieBean("tiebean8",5));
        tieBeans.add(new TieBean("tiebean9",7));
        DialogUIUtils.showMdBottomSheet(mContext, false, "title", tieBeans, "bottomTxt", 1, new DialogUIItemListener() {
            @Override
            public void onItemClick(CharSequence text, int position) {
                Toast.makeText(mContext,"text = "+text + "\nposition = " + position,Toast.LENGTH_SHORT).show();
            }
        }).show();
    }

    private void showMdBottomSheet2(){
        List<TieBean> tieBeans = new ArrayList<>();
        tieBeans.add(new TieBean("tiebean1",0));
        tieBeans.add(new TieBean("tiebean2",2));
        tieBeans.add(new TieBean("tiebean3",4));
        tieBeans.add(new TieBean("tiebean4",8));
        tieBeans.add(new TieBean("tiebean6",1));
        tieBeans.add(new TieBean("tiebean7",3));
        tieBeans.add(new TieBean("tiebean8",5));
        tieBeans.add(new TieBean("tiebean9",7));
        DialogUIUtils.showMdBottomSheet(mContext, false, "title", tieBeans, "", 4, new DialogUIItemListener() {
            @Override
            public void onItemClick(CharSequence text, int position) {
                Toast.makeText(mContext,"text = "+text + "\nposition = " + position,Toast.LENGTH_SHORT).show();
            }
        }).show();
    }

    private int i = 0 ;
    private void showToast(){
        switch (i%3){
            case 0 :
                DialogUIUtils.showToast("1");
                break;
            case 1:
                DialogUIUtils.showToastCenter("center");
                break;
            case 2:
                DialogUIUtils.showToastTop("top");
                break;
        }

        ++i;

    }


    private void showCustomAlert(){
        ImageView image = new ImageView(mContext);
        image.setImageResource(R.mipmap.ic_launcher_round);
        image.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        DialogUIUtils.showCustomAlert(mContext,image).show();
    }
}
