package com.quyunshuo.main_module.ui;

import android.graphics.Color;
import android.os.Build;

import com.quyunshuo.common_base.base.BaseActivity;
import com.quyunshuo.common_base.utils.StatusBarUtil;
import com.quyunshuo.main_module.R;

/**
 * 此Activity作为当前module单独运行时的启动Activity，集成开发模式下可忽略
 */
public class MainModuleActivity extends BaseActivity {

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main_module;
    }

    @Override
    public void setStatusBarColor(int resId) {
        super.setStatusBarColor(resId);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            StatusBarUtil.setColor(MainModuleActivity.this, Color.WHITE);
            StatusBarUtil.setDarkMode(MainModuleActivity.this);
        } else {
            StatusBarUtil.setColor(MainModuleActivity.this, Color.GRAY);
        }
    }
}
