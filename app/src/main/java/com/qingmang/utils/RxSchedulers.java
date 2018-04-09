package com.qingmang.utils;

import org.reactivestreams.Publisher;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by xiejingbao on 2017/10/27.
 */

public class RxSchedulers {
    /**
     * 跟compose()配合使用,比如ObservableUtils.wrap(obj).compose(toMain())
     * @param <T>
     * @return
     */
    public static <T> ObservableTransformer<T, T> ObToMain() {

        return new ObservableTransformer<T, T>() {

            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
   // 由于新增了Flowable，同理也增加了FlowableTransformer
    public static <T> FlowableTransformer<T, T> FtToMain() {

        return new FlowableTransformer<T, T>() {

            @Override
            public Publisher<T> apply(Flowable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

}
