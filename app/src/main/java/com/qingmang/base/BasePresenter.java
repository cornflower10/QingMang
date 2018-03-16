package com.qingmang.base;

import android.content.Context;

/**
 * Created by xiejingbao on 2017/5/30.
 */

public  class BasePresenter<T> {
    public Context mContext;
    public T view;
    public BasePresenter(Context mContext,T view){
        this.mContext = mContext;
        this.view = view;
    }


}
