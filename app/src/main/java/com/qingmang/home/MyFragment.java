package com.qingmang.home;

import android.os.Bundle;

import com.qingmang.BaseFragment;
import com.qingmang.R;
import com.qingmang.baselibrary.utils.LogManager;

/**
 * Created by xiejingbao on 2017/9/14.
 */

public class MyFragment extends BaseFragment {
    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initView() {

    }

    public static MyFragment newInstance() {

        Bundle args = new Bundle();

        MyFragment fragment = new MyFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void onFragmentVisibleChange(boolean isVisible) {
        LogManager.i("MyFragment-----"+isVisible);
    }
}
