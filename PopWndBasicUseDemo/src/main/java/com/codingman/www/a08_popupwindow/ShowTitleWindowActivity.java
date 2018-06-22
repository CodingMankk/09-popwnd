package com.codingman.www.a08_popupwindow;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @function
 */

public class ShowTitleWindowActivity extends Activity implements View.OnClickListener{

    private PopupWindow popupWindow;
    private TextView mTvMenu;
//    private boolean mIsPoPWndShow =false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);
        mTvMenu = (TextView) findViewById(R.id.tv_menu);
        mTvMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (!mIsPoPWndShow){
//                    showPopWnd();
//                    mIsPoPWndShow = true;
//                }

                showPopWnd();
            }
        });

    }

    private void showPopWnd() {
        View contentView = LayoutInflater.from(ShowTitleWindowActivity.this)
                .inflate(R.layout.activity_popwndbasicusedemo_layout, null);
        popupWindow = new PopupWindow(contentView);
//        popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
//        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);

        popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);

        TextView tvZuQiu = (TextView) contentView.findViewById(R.id.tv_zuqiu);
        TextView tvLanQiu = (TextView) contentView.findViewById(R.id.tv_lanqiu);
        TextView tvTieQiu = (TextView) contentView.findViewById(R.id.tv_tieqiu);
        TextView tvYuMaoQiu = (TextView) contentView.findViewById(R.id.tv_yumaoqiu);
        EditText etInput = (EditText) contentView.findViewById(R.id.et_input);

        tvLanQiu.setOnClickListener(this);
        tvZuQiu.setOnClickListener(this);
        tvTieQiu.setOnClickListener(this);
        tvYuMaoQiu.setOnClickListener(this);
        //设置可点击
        popupWindow.setTouchable(true);
        //设置动画
        popupWindow.setAnimationStyle(R.style.contextMenuAnim);
        //是否可以获取焦点
        popupWindow.setFocusable(true);

        //外部可点击
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);

        contentView.setOnKeyListener(new View.OnKeyListener() {

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode == KeyEvent.KEYCODE_BACK) {
                    popupWindow.dismiss();
                    return true;
                }
                return false;
            }
        });

        //点击menu显示各个item
        popupWindow.showAsDropDown(mTvMenu);


    }


    @Override
    public void onClick(View v) {

        int id = v.getId();
        switch(id){
            case R.id.tv_zuqiu:
                Toast.makeText(this,"足球",Toast.LENGTH_SHORT).show();
                popupWindow.dismiss();
                break;

            case R.id.tv_lanqiu:
                Toast.makeText(this,"篮球",Toast.LENGTH_SHORT).show();
                popupWindow.dismiss();
                break;

            case R.id.tv_tieqiu:
                Toast.makeText(this,"铁球",Toast.LENGTH_SHORT).show();
                popupWindow.dismiss();
                break;

            case R.id.tv_yumaoqiu:
                Toast.makeText(this,"羽毛球",Toast.LENGTH_SHORT).show();
                popupWindow.dismiss();
                break;
            case R.id.et_input:
                Toast.makeText(this,"输入",Toast.LENGTH_SHORT).show();
                popupWindow.dismiss();
                break;

            default:
                break;

        }
    }

}
