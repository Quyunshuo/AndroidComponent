package com.quyunshuo.main_module;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.quyunshuo.common_base.base.BaseActivity;
import com.quyunshuo.common_base.utils.StatusBarUtil;

@Route(path = "/main/MainActivity")
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void setStatusBarColor(int resId) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            StatusBarUtil.setColor(MainActivity.this, Color.WHITE);
            StatusBarUtil.setDarkMode(MainActivity.this);
        } else {
            StatusBarUtil.setColor(MainActivity.this, Color.GRAY);
        }
    }
}
