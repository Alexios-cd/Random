package com.fwj.random.base;

import android.app.Activity;
import android.os.Bundle;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 包名：xjy_application_com.xjy.base
 * <p/>
 * 描述：应用中Activity的父类，抽取共性
 * <p/>
 * 作者：傅文江
 * <p/>
 * 时间：2015/7/16 13:21
 * <p/>
 * 版权：Copyright © 2013-2015 北京兜子科技有限公司
 */

public abstract class BaseActivity extends Activity {
    /**
     * 记录处于前台的Activity
     */
    private static BaseActivity mForegroundActivity = null;
    /**
     * 记录所有活动的Activity
     */
    private static final List<BaseActivity> mActivities = new LinkedList<BaseActivity>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initFindViewById();
        initData();
        initEvent();

        // initActionBar();
    }


    @Override
    protected void onResume() {
        super.onResume();
        mForegroundActivity = this;
    }

    @Override
    protected void onPause() {
        super.onPause();
        mForegroundActivity = null;


    }

    abstract protected void initView();

    abstract protected void initData();

    protected void initActionBar() {

    }

    /**
     * 关闭所有Activity
     */
    public static void finishAll() {
        List<BaseActivity> copy;
        synchronized (mActivities) {
            copy = new ArrayList<BaseActivity>(mActivities);
        }
        for (BaseActivity activity : copy) {
            activity.finish();
        }
    }

    /**
     * 关闭所有Activity，除了参数传递的Activity
     */
    public static void finishAll(BaseActivity except) {
        List<BaseActivity> copy;
        synchronized (mActivities) {
            copy = new ArrayList<BaseActivity>(mActivities);
        }
        for (BaseActivity activity : copy) {
            if (activity != except)
                activity.finish();
        }
    }

    /**
     * 是否有启动的Activity
     */
    public static boolean hasActivity() {
        return mActivities.size() > 0;
    }

    /**
     * 获取当前处于前台的activity
     */
    public static BaseActivity getForegroundActivity() {
        return mForegroundActivity;
    }

    /**
     * 获取当前处于栈顶的activity，无论其是否处于前台
     */
    public static BaseActivity getCurrentActivity() {
        List<BaseActivity> copy;
        synchronized (mActivities) {
            copy = new ArrayList<BaseActivity>(mActivities);
        }
        if (copy.size() > 0) {
            return copy.get(copy.size() - 1);
        }
        return null;
    }

    protected void initFindViewById() {

    }

    protected void initEvent() {

    }

    /**
     * 退出应用
     */
    public void exitApp() {
        finishAll();
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
