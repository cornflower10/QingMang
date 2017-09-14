package com.qlzgzg.network;

import android.util.Log;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 拦截器
 *
 * 添加公共参数
 *
 */

public class HttpCommonParameterInterceptor implements Interceptor {

    private Map<String,String> paramsMap = new HashMap<>();
    public HttpCommonParameterInterceptor(Map<String,String> paramsMap) {
      this.paramsMap = paramsMap;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Log.d("HttpCommonInterceptor","add common params");
        Request oldRequest = chain.request();

        // 添加新的参数，添加到url 中
       HttpUrl.Builder authorizedUrlBuilder = oldRequest.url()
                .newBuilder()
                .scheme(oldRequest.url().scheme())
                .host(oldRequest.url().host());
        if(paramsMap.size() > 0){
            for(Map.Entry<String,String> params:paramsMap.entrySet()){
                authorizedUrlBuilder.addQueryParameter(params.getKey(),params.getValue());
            }
        }

        // 新的请求
//
//        Request.Builder requestBuilder =  oldRequest.newBuilder();
//
//                requestBuilder.method(oldRequest.method(), oldRequest.body());
//        //添加公共参数,添加到header中
//        if(mHeaderParamsMap.size() > 0){
//            for(Map.Entry<String,String> params:mHeaderParamsMap.entrySet()){
//                requestBuilder.header(params.getKey(),params.getValue());
//            }
//        }

        Request newRequest = oldRequest.newBuilder()
                .method(oldRequest.method(), oldRequest.body())
                .url(authorizedUrlBuilder.build())
                .build();

        return chain.proceed(newRequest);
    }
}
