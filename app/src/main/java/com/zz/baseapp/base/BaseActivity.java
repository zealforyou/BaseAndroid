package com.zz.baseapp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.zz.baseapp.R;

/**
 * Created by ZhangZhuo on 2018/1/23.
 */

public abstract class BaseActivity extends FragmentActivity {
    private TextView textview_title;
    private FrameLayout fl_left;
    private ImageView img_left;
    private FrameLayout fl_right;
    private View mRlBaseTitle;
    private View mContentView;
    private TextView tv_right;

    public abstract int layoutId();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewGroup baseRoot = (ViewGroup) getLayoutInflater().inflate(R.layout.activity_base, null);
        mRlBaseTitle = baseRoot.findViewById(R.id.rl_base_title);
        textview_title = (TextView) mRlBaseTitle.findViewById(R.id.textview_title);
        img_left = (ImageView) mRlBaseTitle.findViewById(R.id.img_left);
        tv_right = (TextView) mRlBaseTitle.findViewById(R.id.tv_right);
        fl_left = (FrameLayout) mRlBaseTitle.findViewById(R.id.fl_left);
        fl_right = (FrameLayout) mRlBaseTitle.findViewById(R.id.fl_right);
        fl_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        if (layoutId() != 0) {
            mContentView = getLayoutInflater().inflate(layoutId(), baseRoot);
        }
        init();
        setContentView(baseRoot);
        initView();
        initCtrl();
        initData();
    }

    /**
     * 隐藏标题栏
     */
    protected void hideTitle() {
        mRlBaseTitle.setVisibility(View.GONE);
    }

    protected void setTitle(String title) {
        textview_title.setText(title);
    }

    protected void setButtonLeft(int drawable, View.OnClickListener listener) {
        fl_left.setVisibility(View.VISIBLE);
        img_left.setImageResource(drawable);
        fl_left.setOnClickListener(listener);
    }

    protected void setButtonRight(int res, String name, View.OnClickListener listener) {
        fl_right.setVisibility(View.VISIBLE);
        tv_right.setText(name);
        tv_right.setCompoundDrawablesWithIntrinsicBounds(0, res, 0, 0);
        fl_right.setOnClickListener(listener);
    }

    //*******以下方法可以重写，根据自己需要**********
    public void init() {

    }

    public void initView() {

    }

    public void initCtrl() {

    }

    public void initData() {

    }
    //************************************************


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
