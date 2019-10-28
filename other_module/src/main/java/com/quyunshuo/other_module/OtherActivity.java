package com.quyunshuo.other_module;

import android.graphics.Color;
import android.os.Build;

import com.quyunshuo.common_base.base.BaseActivity;
import com.quyunshuo.common_base.utils.StatusBarUtil;

public class OtherActivity extends BaseActivity {

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_other;
    }

    @Override
    public void setStatusBarColor(int resId) {
        super.setStatusBarColor(resId);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            StatusBarUtil.setColor(OtherActivity.this, Color.WHITE);
            StatusBarUtil.setDarkMode(OtherActivity.this);
        } else {
            StatusBarUtil.setColor(OtherActivity.this, Color.GRAY);
        }
    }
}
