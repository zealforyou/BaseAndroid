package com.zz.baseapp.dagger;

import com.zz.baseapp.dagger.module.Appmodule;
import com.zz.baseapp.mode.HttpHelp;
import com.zz.baseapp.presenter.MainPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ZhangZhuo on 2018/1/23.
 */
@Singleton
@Component(modules = {Appmodule.class})
public interface AppComponent {
    HttpHelp getHttpHelp();

    void inject(MainPresenter presenter);
}
