package com.qingmang.utils.rx;

import com.qingmang.moudle.entity.BaseEntity;
import com.qingmang.utils.Exception.ApiException;
import com.qingmang.utils.Exception.CustomException;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.functions.Function;

/**
 * Created by xiejingbao on 2018/3/20.
 */

public class ResponseTransformer {

    public static <T> ObservableTransformer<BaseEntity<T>, T> handleResult() {
        return new ObservableTransformer<BaseEntity<T>, T>() {
            @Override
            public ObservableSource<T> apply(Observable<BaseEntity<T>> upstream) {
                return upstream.onErrorResumeNext(new ErrorResumeFunction<T>())
                        .flatMap(new ResponseFunction<T>());
            }
        };
    }


    /**
     * 非服务器产生的异常，比如本地无无网络请求，Json数据解析错误等等。
     *
     * @param <T>
     */
    private static class ErrorResumeFunction<T> implements Function<Throwable, ObservableSource<? extends BaseEntity<T>>> {

        @Override
        public ObservableSource<? extends BaseEntity<T>> apply(Throwable throwable) throws Exception {
            return Observable.error(CustomException.handleException(throwable));
        }
    }

    /**
     * 服务其返回的数据解析
     * 正常服务器返回数据和服务器可能返回的exception
     *
     * @param <T>
     */
    private static class ResponseFunction<T> implements Function<BaseEntity<T>, ObservableSource<T>> {

        @Override
        public ObservableSource<T> apply(BaseEntity<T> tResponse) throws Exception {
            if ("1".equals(tResponse.getStatus())) {
                return (ObservableSource<T>) Observable.just(null==tResponse.getData()?"":tResponse.getData());
            } else if ("-99".equals(tResponse.getStatus())){
                return Observable.error(new ApiException("-99"));
            }else {
                return Observable.error(new ApiException(tResponse.getDetail()));
            }
        }
    }


}
