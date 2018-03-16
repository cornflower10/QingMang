package com.qingmang.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.qlzgzg.nettrade.android.customview.loadview.LoadViewHelper;
import com.qlzgzg.nettrade.android.fragment.BaseFragment;

/**
 * Created by xiejingbao on 2018/3/14.
 */

public abstract class MVPBaseFragment<P extends Presenter<V>,V extends BaseView>  extends BaseFragment{
    protected P mPresenter;
    private LoadViewHelper loadViewHelper;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        mPresenter.attachView((V) this);
        if(null!=getRootView())
        loadViewHelper = new LoadViewHelper(getRootView());
    }

    protected abstract P createPresenter();
    protected abstract View getRootView();
    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }
}
