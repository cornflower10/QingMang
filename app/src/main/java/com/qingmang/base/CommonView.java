package com.qingmang.base;

/**
 * Created by xiejingbao on 2018/3/16.
 */

public interface CommonView<D> extends BaseView {
    void onDataSuccess(D d);
}
