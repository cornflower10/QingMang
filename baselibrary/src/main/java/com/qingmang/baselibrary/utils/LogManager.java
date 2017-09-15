package com.qingmang.baselibrary.utils;

import android.util.Log;


/**
 * Created by caomingyu on 15/10/29.
 */
public class LogManager {

    private static final String TAG = "QINGMANG";
    public static final boolean DEBUG = AppUtils.isDebug();
    public static void i(String msg){
        if(DEBUG){
            Log.i(TAG, msg);
        }
    }
    public static void d(String msg){
        if(DEBUG){
            Log.d(TAG, msg);
        }
    }
    public static void e(String msg){
        if(DEBUG){
            Log.e(TAG, msg);
        }
    }

    public static void i(String tag, String msg){
        if(DEBUG){
            Log.i(tag, msg);
        }
    }
    public static void d(String tag, String msg){
        if(DEBUG){
            Log.d(tag, msg);
        }
    }
    public static void e(String tag, String msg){
        if(DEBUG){
            Log.e(tag, msg);
        }
    }
}
