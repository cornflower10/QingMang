package com.qingmang;

import android.app.Application;

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

    public RetrofitServiceManager getRetrofitServiceManager() {
        return  retrofitServiceManager;
    }

    public ForegroundCallbacks getForegroundCallbacks() {
        return foregroundCallbacks;
    }

    public void setForegroundCallbacks(ForegroundCallbacks foregroundCallbacks) {
        this.foregroundCallbacks = foregroundCallbacks;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
        retrofitServiceManager  = new RetrofitServiceManager(BuildConfig.URL);
        foregroundCallbacks = ForegroundCallbacks.init(this);

    }


}
