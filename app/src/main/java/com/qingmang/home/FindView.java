package com.qingmang.home;

/**
 * Created by xiejingbao on 2018/3/16.
 */

import com.qingmang.base.BaseView;

public interface  FindView<D> extends BaseView{
    void onDataSuccess(D d);
}
