package com.qingmang.base;

/**
 * Created by xiejingbao on 2018/1/11.
 */

public interface PresenterFactory<P extends Presenter>{
    P crate();//创建presenter
}
