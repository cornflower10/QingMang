package com.qingmang.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.qingmang.BaseFragment;


/**
 * Created by xiejingbao on 2018/3/14.
 */

public abstract class BaseMvpFragment<P extends Presenter<V>,V extends BaseView>  extends BaseFragment {
    protected P mPresenter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        mPresenter.attachView((V) this);

    }

    protected abstract P createPresenter();

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }
}
