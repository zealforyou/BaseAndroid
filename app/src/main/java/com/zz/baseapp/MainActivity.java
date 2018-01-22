package com.zz.baseapp;

import android.os.Bundle;

import com.zz.baseapp.base.BaseActivity;
import com.zz.baseapp.base.MainApplication;
import com.zz.baseapp.dagger.DaggerActivityComponent;
import com.zz.baseapp.dagger.module.ActivityModule;
import com.zz.baseapp.presenter.MainPresenter;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {
    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerActivityComponent.builder()
                .appComponent(MainApplication.getInstance().getAppComponent())
                .activityModule(new ActivityModule(this))
                .build()
                .inject(this);
//        httpHelp = MainApplication.getInstance().getAppComponent().getHttpHelp();
        initData();
    }

    public void initData() {
        mainPresenter.baidu();
    }
}
