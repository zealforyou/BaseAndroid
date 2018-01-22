package com.zz.baseapp.mode;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ZhangZhuo on 2018/1/23.
 */

public class HttpHelp {
    CommonService commonService;

    public HttpHelp(CommonService commonService) {
        this.commonService = commonService;
    }

    public Observable<String> baidu() {
        return commonService.baidu().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
