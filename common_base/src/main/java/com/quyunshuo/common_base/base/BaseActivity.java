package com.quyunshuo.common_base.base;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import com.quyunshuo.common_base.R;
import com.quyunshuo.common_base.utils.StatusBarUtil;

/**
 * @Author: MiYan
 * @Time: 2019/10/28 10:27
 * @Description: 描述：
 */
public abstract class BaseActivity extends FragmentActivity {

    protected Context mContext;
    //用于发送延时任务
    protected Handler mHandler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(getLayoutId());
        setStatusBarColor(R.color.main);
        initView();
    }

    /**
     * 设置状态栏的颜色
     *
     * @param resId
     */
    public void setStatusBarColor(int resId) {
        StatusBarUtil.setColor(this, ContextCompat.getColor(this, resId), 0);
    }

    /**
     * 初始化View
     */
    protected abstract void initView();

    /**
     * 布局ID
     *
     * @return
     */
    protected abstract int getLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //移除延时任务
        if (mHandler != null) {
            mHandler.removeCallbacksAndMessages(null);
        }
    }
}
