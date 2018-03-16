package com.qingmang.base;

/**
 * Created by xiejingbao on 2018/1/9.
 */

public interface Presenter<V extends BaseView> {
    /**
     * presenter和对应的view绑定
     * @param mvpView  目标view
     */
    void attachView(V mvpView);
    /**
     * presenter与view解绑
     */
    void detachView();
}

