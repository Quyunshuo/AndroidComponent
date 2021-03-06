package com.quyunshuo.main_module.ui;

import android.graphics.Color;
import android.os.Build;

import com.quyunshuo.common_base.base.BaseActivity;
import com.quyunshuo.common_base.constants.ARouterConfig;
import com.quyunshuo.common_base.utils.ARouterUtils;
import com.quyunshuo.common_base.utils.StatusBarUtil;
import com.quyunshuo.main_module.R;

public class SplashActivity extends BaseActivity {

    @Override
    protected void initView() {
        mHandler.postDelayed(() -> {
            ARouterUtils.getActivity(ARouterConfig.MAIN_ACTIVITY);
            finish();
        }, 2500);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void setStatusBarColor(int resId) {
        super.setStatusBarColor(resId);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            StatusBarUtil.setColor(SplashActivity.this, Color.WHITE);
            StatusBarUtil.setDarkMode(SplashActivity.this);
        } else {
            StatusBarUtil.setColor(SplashActivity.this, Color.GRAY);
        }
    }
}
