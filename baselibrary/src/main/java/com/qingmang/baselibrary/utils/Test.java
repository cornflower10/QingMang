package com.qingmang.baselibrary.utils;

import com.qingmang.baselibrary.BuildConfig;

/**
 * Created by xiejingbao on 2017/9/15.
 */

public class Test {
    private boolean debug = AppUtils.isDebug();

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = BuildConfig.DEBUG;
    }
}
