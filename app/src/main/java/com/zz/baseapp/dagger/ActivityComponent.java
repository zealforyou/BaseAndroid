package com.zz.baseapp.dagger;

import android.app.Activity;

import com.zz.baseapp.MainActivity;
import com.zz.baseapp.dagger.module.ActivityModule;
import com.zz.baseapp.dagger.scope.PerActivity;

import dagger.Component;

/**
 * Created by ZhangZhuo on 2018/1/23.
 */
@PerActivity
@Component(dependencies = {AppComponent.class}, modules = {ActivityModule.class})
public interface ActivityComponent {
    Activity activity();

    void inject(MainActivity activity);
}
