
package com.fwj.random.application;

import android.app.Activity;
import android.app.Application;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;

public class RandomApplication extends Application {
    private static RandomApplication mInstance = null;
    public static Activity activity = null;
    public static Fragment fragment = null;
    private static Typeface titleTypeFace = null;

    // 主线程的上下文
    private static RandomApplication mMainContext;
    // 获取到主线程的Handler
    private static Handler mMainThreadHandler;
    // 获取到主线程的looper
    private static Looper mMainThreadLooper;
    // 获取到主线程的id
    private static int mMainThreadId;
    // 获取到程序的主线程
    private static Thread mMainThead;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        RandomApplication.mMainContext = this;
        RandomApplication.mMainThreadHandler = new Handler();
        RandomApplication.mMainThreadLooper = getMainLooper();
        RandomApplication.mMainThreadId = android.os.Process.myTid();
        RandomApplication.mMainThead = Thread.currentThread();
    }

    public static RandomApplication getApplication() {
        return mMainContext;
    }

    public static Handler getMainThreadHandler() {
        return mMainThreadHandler;
    }

    public static Looper getMainThreadLooper() {
        return mMainThreadLooper;
    }

    public static int getMainThreadId() {
        return mMainThreadId;
    }

    public static Thread getMainThread() {
        return mMainThead;
    }

}