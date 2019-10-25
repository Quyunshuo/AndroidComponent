package com.quyunshuo.common_base;

import android.app.Application;
import android.content.Context;

import com.quyunshuo.common_base.manager.ActivityManage;

/**
 * @Author: MiYan
 * @Time: 2019/10/25 16:05
 * @Description: 描述：在BaseApplication对第三方库初始化、全局Context的获取等操作
 */
public class BaseApplication extends Application {
    //全局唯一的context
    private static BaseApplication mContext;

    //Activity管理器
    private ActivityManage mActivityManage;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        mContext = this;
        //MultiDex分包方法初始化写在这里
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mActivityManage = new ActivityManage();
        initARouter();
        initLogger();
    }

    /**
     * 获取全局唯一上下文
     *
     * @return BaseApplication
     */
    public static BaseApplication getApplication() {
        return mContext;
    }

    private void initLogger() {
    }

    private void initARouter() {
    }

    /**
     * 返回Activity管理器
     */
    public ActivityManage getActivityManage() {
        if (mActivityManage == null) {
            mActivityManage = new ActivityManage();
        }
        return mActivityManage;
    }
}
