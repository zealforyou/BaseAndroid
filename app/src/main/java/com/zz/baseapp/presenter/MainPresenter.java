package com.zz.baseapp.presenter;

import android.util.Log;

import com.zz.baseapp.base.MainApplication;
import com.zz.baseapp.mode.HttpHelp;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by ZhangZhuo on 2018/1/23.
 */

public class MainPresenter {
    HttpHelp httpHelp;

    @Inject
    public MainPresenter() {
        httpHelp = MainApplication.getInstance().getAppComponent().getHttpHelp();
        Log.i("www", httpHelp.hashCode() + "");
    }

    public void baidu() {
        httpHelp = MainApplication.getInstance().getAppComponent().getHttpHelp();
        Log.i("www", httpHelp.hashCode() + "");
        httpHelp.baidu()
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        Log.i("www", s);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
