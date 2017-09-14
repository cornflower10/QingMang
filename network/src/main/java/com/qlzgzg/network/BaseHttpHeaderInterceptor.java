package com.qlzgzg.network;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by qlzg-cmy on 2017/5/5.
 */

public class BaseHttpHeaderInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        Request request = original.newBuilder()
                .addHeader("X-App-Type", "android")
                .addHeader("X-App-Version", String.valueOf(BuildConfig.VERSION_NAME))
                .addHeader("X-App-Env", "dev")
                .addHeader("X-App-Key", "android")
                .method(original.method(), original.body())
                .build();
        return chain.proceed(request);

    }


}
