package com.zz.baseapp.api;

import com.zz.baseapp.base.AppConfig;

/**
 * Created by ZhangZhuo on 2018/1/23.
 */

public class HttpConfig {

    public static String BASE_URL = "http://baidu.com";

    static {
        switch (AppConfig.env) {
            case 1:
                BASE_URL = "http://baidu.com";
                break;
        }
    }
}
