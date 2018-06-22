package com.codingman.www.a08_popupwindow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

/**
 * popwnd从屏幕下方弹框显示
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mBtnPopWnd;
    private PopupWindow mPopupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mBtnPopWnd = (Button) findViewById(R.id.btn_popwnd);
        mBtnPopWnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDownPopWnd();
            }
        });
    }

    private void showDownPopWnd() {
        //必须设置加载的PopWndWindow的布局
        View contentView = LayoutInflater.from(MainActivity.this).inflate(R.layout.activity_popwndbasicusedemo_layout,null);

        mPopupWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,true);
        mPopupWindow.setContentView(contentView);

        TextView tvZuQiu = (TextView) contentView.findViewById(R.id.tv_zuqiu);
        TextView tvLanQiu = (TextView) contentView.findViewById(R.id.tv_lanqiu);
        TextView tvTieQiu = (TextView) contentView.findViewById(R.id.tv_tieqiu);
        TextView tvYuMaoQiu = (TextView) contentView.findViewById(R.id.tv_yumaoqiu);

        tvLanQiu.setOnClickListener(this);
        tvZuQiu.setOnClickListener(this);
        tvTieQiu.setOnClickListener(this);
        tvYuMaoQiu.setOnClickListener(this);

        //显示popwnd，设置popwindow弹出的位置
        View rootView = LayoutInflater.from(MainActivity.this).inflate(R.layout.activity_main,null);
//        mPopupWindow.showAtLocation(rootView, Gravity.BOTTOM,500,-100);
//        mPopupWindow.showAtLocation(rootView, Gravity.TOP,500,-100);
//        mPopupWindow.showAtLocation(rootView, Gravity.RIGHT,0,0);
        mPopupWindow.showAtLocation(rootView, Gravity.LEFT,0,0);

    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.tv_zuqiu:
                Toast.makeText(this,"足球",Toast.LENGTH_SHORT).show();
                mPopupWindow.dismiss();
            break;

            case R.id.tv_lanqiu:
                Toast.makeText(this,"篮球",Toast.LENGTH_SHORT).show();
                mPopupWindow.dismiss();
                break;

            case R.id.tv_tieqiu:
                Toast.makeText(this,"铁球",Toast.LENGTH_SHORT).show();
                mPopupWindow.dismiss();
                break;

            case R.id.tv_yumaoqiu:
                Toast.makeText(this,"羽毛球",Toast.LENGTH_SHORT).show();
                mPopupWindow.dismiss();
                break;
            default:
                break;

        }
    }
}
