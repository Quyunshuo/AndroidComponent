package com.quyunshuo.common_base.application;

import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;
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
//        if (isDebug()) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
//        }
        ARouter.init(mContext); // 尽可能早，推荐在Application中初始化
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
