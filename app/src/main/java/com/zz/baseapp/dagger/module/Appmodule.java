package com.zz.baseapp.dagger.module;

import android.content.Context;
import android.util.Log;

import com.zz.baseapp.api.HttpConfig;
import com.zz.baseapp.base.MainApplication;
import com.zz.baseapp.mode.CommonService;
import com.zz.baseapp.mode.HttpHelp;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by ZhangZhuo on 2018/1/23.
 */
@Module
public class Appmodule {
    private static final long TIMEOUT = 20000;
    private final MainApplication application;

    public Appmodule(MainApplication application) {
        this.application = application;
    }


    @Singleton
    @Provides
    Context provideApplicationContext() {
        return this.application;
    }


    @Singleton
    @Provides
    Retrofit provideRetrofit(OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(HttpConfig.BASE_URL)
                // 添加Gson转换器
//                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                // 添加Retrofit到RxJava的转换器
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();
    }

    @Provides
    @Singleton
    public CommonService provideCommonService(Retrofit retrofit) {
        return retrofit.create(CommonService.class);
    }


    @Provides
    @Singleton
    OkHttpClient provideOkhttp() {
        return new OkHttpClient.Builder()
                // 添加通用的Header
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request.Builder builder = chain.request().newBuilder();
                        builder.addHeader("token", "123");
                        return chain.proceed(builder.build());
                    }
                })
            /*
            这里可以添加一个HttpLoggingInterceptor，因为Retrofit封装好了从Http请求到解析，
            出了bug很难找出来问题，添加HttpLoggingInterceptor拦截器方便调试接口
             */
                .addInterceptor(new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                    @Override
                    public void log(String message) {
                        Log.i("www", message);
                    }
                }).setLevel(HttpLoggingInterceptor.Level.BASIC))
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .build();
    }

    @Singleton
    @Provides
    public HttpHelp provideHttpHelp(CommonService commonService) {
        return new HttpHelp(commonService);
    }
}
