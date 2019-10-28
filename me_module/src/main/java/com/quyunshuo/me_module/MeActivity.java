package com.quyunshuo.me_module;

import android.graphics.Color;
import android.os.Build;

import com.quyunshuo.common_base.base.BaseActivity;
import com.quyunshuo.common_base.utils.StatusBarUtil;

public class MeActivity extends BaseActivity {

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_me;
    }

    @Override
    public void setStatusBarColor(int resId) {
        super.setStatusBarColor(resId);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            StatusBarUtil.setColor(MeActivity.this, Color.WHITE);
            StatusBarUtil.setDarkMode(MeActivity.this);
        } else {
            StatusBarUtil.setColor(MeActivity.this, Color.GRAY);
        }
    }
}
