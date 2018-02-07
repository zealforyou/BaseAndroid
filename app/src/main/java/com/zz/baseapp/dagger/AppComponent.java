package com.zz.baseapp.dagger;

import com.zz.baseapp.dagger.module.AppModule;
import com.zz.baseapp.mode.HttpHelp;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ZhangZhuo on 2018/1/23.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    HttpHelp getHttpHelp();
}
