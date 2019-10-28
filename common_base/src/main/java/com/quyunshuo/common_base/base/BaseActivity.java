package com.quyunshuo.common_base.base;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

/**
 * @Author: MiYan
 * @Time: 2019/10/28 10:27
 * @Description: 描述：
 */
public abstract class BaseActivity extends FragmentActivity {

    protected Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(getLayoutId());
        initView();
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

}
