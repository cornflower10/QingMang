package com.qingmang.baselibrary.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import java.util.Stack;


public class ForegroundCallbacks implements Application.ActivityLifecycleCallbacks{
    private static Stack<Activity> activityStack;
    private static ForegroundCallbacks instance;

    public static ForegroundCallbacks init(Application application){
        if (instance == null) {
            instance = new ForegroundCallbacks();
            application.registerActivityLifecycleCallbacks(instance);
        }
        return instance;
    }
    public static ForegroundCallbacks get(Application application){
        if (instance == null) {
            init(application);
        }
        return instance;
    }
    public static ForegroundCallbacks get(Context ctx){
        if (instance == null) {
            Context appCtx = ctx.getApplicationContext();
            if (appCtx instanceof Application) {
                init((Application)appCtx);
            }
            throw new IllegalStateException(
                    "Foreground is not initialised and " +
                            "cannot obtain the Application object");
        }
        return instance;
    }
    public static ForegroundCallbacks get(){
        if (instance == null) {
            throw new IllegalStateException(
                    "Foreground is not initialised - invoke " +
                            "at least once with parameterised init/get");
        }
        return instance;
    }

    @Override
    public void onActivityResumed(Activity activity) {

    }
    @Override
    public void onActivityPaused(final Activity activity) {

    }
    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
//        StatusBarUtil.setTranslucent(activity);
        addActivity(activity);
    }
    @Override
    public void onActivityStarted(Activity activity) {}
    @Override
    public void onActivityStopped(Activity activity) {}
    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {}
    @Override
    public void onActivityDestroyed(Activity activity) {

        finishActivity(activity);
    }


    /**
     * add Activity 添加Activity到栈
     */
    public void addActivity(Activity activity){
        if (activityStack ==null){
            activityStack =new Stack<Activity>();
        }
        activityStack.add(activity);
    }

    /**
     * 结束指定的Activity
     */
    private void finishActivity(Activity activity) {
        if (activity != null) {
            activityStack.remove(activity);
            activity.finish();
        }
    }


    /**
     * 结束指定的Activity
     */
    public void mFinishActivity(Activity activity) {
        if (activity != null) {
            if(activityStack.contains(activity)){
                activityStack.remove(activity);
                activity.finish();
            }
        }
    }


    /**
     * 结束所有Activity除了指定的Activity
     */
    public void finishExceptActivity(Class<?> mActivity) {

        for (int i=0; i<activityStack.size();i++){
            if (!(activityStack.get(i).getClass().equals(mActivity))) {
//                activityStack.remove(activity);
                mFinishActivity(activityStack.get(i));
                i--;
            }
        }

    }


    /**
     * 结束指定类名的Activity
     */
    public void finishActivity(Class<?> cls) {
        Activity temActivity = null;
        for (Activity activity : activityStack) {
            if (activity.getClass().equals(cls)) {
                temActivity = activity;
            }
        }
        finishActivity(temActivity);
    }

    /**
     * 结束所有Activity
     */
    public void finishAllActivity() {
        for (int i = 0, size = activityStack.size(); i < size; i++) {
            if (null != activityStack.get(i)) {
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
    }
    /**
     * 退出应用程序
     */
    public void appExit() {
        try {
            finishAllActivity();
        } catch (Exception e) {
        }
    }
}
