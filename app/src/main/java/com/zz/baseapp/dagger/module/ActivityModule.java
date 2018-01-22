package com.zz.baseapp.dagger.module;

import android.app.Activity;

import com.zz.baseapp.dagger.scope.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ZhangZhuo on 2018/1/23.
 */
@Module
public class ActivityModule {
    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    Activity activity() {
        return this.activity;
    }
}
