package com.qlzgzg.network;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by xiejingbao on 2017/6/8.
 */

public class UpLoadProgressInterceptor implements Interceptor {
    private UploadProgressListener mUploadListener;

    public UpLoadProgressInterceptor(UploadProgressListener uploadListener) {
        mUploadListener = uploadListener;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if(null == request.body()){
            return chain.proceed(request);
        }

        Request build = request.newBuilder()
                .method(request.method(),
                        new ProgressRequestBody(request.body(),
                                mUploadListener))
                .build();
        return chain.proceed(build);
    }
}
