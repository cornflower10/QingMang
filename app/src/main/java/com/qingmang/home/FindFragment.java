package com.qingmang.home;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.qingmang.R;
import com.qingmang.base.BaseMvpFragment;
import com.qingmang.baselibrary.utils.LogManager;

import butterknife.BindView;

/**
 * Created by xiejingbao on 2017/9/14.
 */

public class FindFragment extends BaseMvpFragment<FindPresenter, FindView> implements FindView<Find> {
    @BindView(R.id.tv)
    TextView tv;


    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_find;
    }

    @Override
    protected void initView() {
        LogManager.i("FindFragment-----");
        loadViewHelper.showLoading("加载中...");
        mPresenter.loadData();

    }

    public static FindFragment newInstance() {

        Bundle args = new Bundle();

        FindFragment fragment = new FindFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void onFragmentVisibleChange(boolean isVisible) {

        LogManager.i("FindFragment-----" + isVisible);
    }

    @Override
    protected FindPresenter createPresenter() {
        return new FindPresenter();
    }

    @Override
    protected View getRootView() {
        return tv;
    }

    @Override
    public void onError(String msg) {
        showShortToast(msg);
    }

    @Override
    public void onDataSuccess(Find find) {
        LogManager.i("-------onDataSuccess------");
    }

}
