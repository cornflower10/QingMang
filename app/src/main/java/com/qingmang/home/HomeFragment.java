package com.qingmang.home;

import android.os.Bundle;

import com.qingmang.BaseFragment;
import com.qingmang.R;
import com.qingmang.baselibrary.utils.LogManager;

/**
 * Created by xiejingbao on 2017/9/14.
 */

public class HomeFragment extends BaseFragment {
    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_index;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void onFragmentVisibleChange(boolean isVisible) {
        LogManager.i("HomeFragment-----"+isVisible);
    }

    public static HomeFragment newInstance() {

        Bundle args = new Bundle();

        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
