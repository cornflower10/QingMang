package com.qingmang.base;

import android.content.Context;
import android.support.v4.content.Loader;

/**
 * Created by xiejingbao on 2018/1/11.
 */

public class PresenterLoder <P extends Presenter> extends Loader<P> {
    private  final PresenterFactory<P>  factory;
    private P presenter;
    public PresenterLoder(Context context, PresenterFactory<P> factory) {
        super(context);
        this.factory = factory;
    }
    /**
     * 在Activity的onStart()调用之后
     */
    @Override
    protected void onStartLoading() {
        if(presenter != null){
            deliverResult(presenter);//会将Presenter传递给Activity/Fragment。
            return;
        }
        forceLoad();
    }

    /**
     * 在调用forceLoad()方法后自动调用，我们在这个方法中创建Presenter并返回它。
     */
    @Override
    protected void onForceLoad() {
        presenter = factory.crate();//创建presenter
        deliverResult(presenter);
    }

    @Override
    protected void onStopLoading() {
       cancelLoad();
    }

    /**
     * 会在Loader被销毁之前调用，我们可以在这里告知Presenter以终止某些操作或进行清理工作。
     */
    @Override
    protected void onReset() {
        onStopLoading();
        presenter = null;
    }
}
