package com.qlzgzg.network;


import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitServiceManager {


    private static final int DEFAULT_TIME_OUT = 10;
    private static final int DEFAULT_READ_TIME_OUT = 10;
    private Retrofit mRetrofit;

    public RetrofitServiceManager(String baseUrl){
        // 创建 OKHttpClient
        OkHttpClient.Builder builder = getBuild();
        // 创建Retrofit
        mRetrofit= getmRetrofit(baseUrl,builder);
    }

    public RetrofitServiceManager(String baseUrl,Interceptor interceptor){
        // 创建 OKHttpClient
        OkHttpClient.Builder builder = getBuild();
        builder.addInterceptor(interceptor);
        // 创建Retrofit
        mRetrofit = getmRetrofit(baseUrl,builder);
    }

    public RetrofitServiceManager(String baseUrl,List<Interceptor> interceptors){

        OkHttpClient.Builder builder = getBuild();
        for (Interceptor interceptor1:interceptors){
            builder.addInterceptor(interceptor1);
        }
        // 创建Retrofit
        mRetrofit = getmRetrofit(baseUrl,builder);
    }

    /**
     * 获取对应的Service
     * @param service Service 的 class
     * @param <T>
     * @return
     */
    public <T> T create(Class<T> service){
        return mRetrofit.create(service);
    }


    private OkHttpClient.Builder getBuild(){
        // 创建 OKHttpClient
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS);//连接超时时间
        builder.writeTimeout(DEFAULT_READ_TIME_OUT,TimeUnit.SECONDS);//写操作 超时时间
        builder.readTimeout(DEFAULT_READ_TIME_OUT,TimeUnit.SECONDS);//读操作超时时间
//        builder.cookieJar(new JavaNetCookieJar(new CookieManager(new PersistentCookieStoreS(context), CookiePolicy.ACCEPT_ALL)));
        // 添加公共参数拦截器,请求头
        builder.addInterceptor(new BaseHttpHeaderInterceptor());
//
     return   builder.addInterceptor(new LogIntercepter());//请求日志

    }


    private Retrofit getmRetrofit(String url, OkHttpClient.Builder builder){

      return   mRetrofit = new Retrofit.Builder()
                .client(builder.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(url)
                .build();
    }
}
