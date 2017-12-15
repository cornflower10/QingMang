package com.qingmang;

import android.app.Application;

import com.qingmang.baselibrary.utils.AppUtils;
import com.qingmang.baselibrary.utils.ForegroundCallbacks;
import com.qlzgzg.network.RetrofitServiceManager;

/**
 * Created by xiejingbao on 2017/9/14.
 */

public class App extends Application {

    private  RetrofitServiceManager retrofitServiceManager;

    private ForegroundCallbacks foregroundCallbacks;

    private static App singleton;
    // Returns the application instance
    public static App getInstance() {
        return singleton;
    }

    public ForegroundCallbacks getForegroundCallbacks() {
        return foregroundCallbacks;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
        retrofitServiceManager  = RetrofitServiceManager.getInstance(BuildConfig.URL);
        foregroundCallbacks = ForegroundCallbacks.init(this);

//        /**
//         * 初始化log,获取是否为debug模式
//          */
        AppUtils.syncIsDebug(getApplicationContext());
        AppUtils.isDebug();

    }


}
