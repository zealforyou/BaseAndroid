package com.zz.baseapp.base;

import android.app.Application;

import com.zz.baseapp.dagger.AppComponent;
import com.zz.baseapp.dagger.DaggerAppComponent;
import com.zz.baseapp.dagger.module.AppModule;

/**
 * Created by ZhangZhuo on 2018/1/22.
 */

public class MainApplication extends Application {
    private static MainApplication app;
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }

    public final static MainApplication getInstance() {
        return app;
    }

    public AppComponent getAppComponent() {
        if (appComponent == null) {
            synchronized (this) {
                if (appComponent == null) {
                    appComponent = DaggerAppComponent
                            .builder()
                            .appModule(new AppModule(this))
                            .build();
                }
            }
        }
        return appComponent;
    }
}
