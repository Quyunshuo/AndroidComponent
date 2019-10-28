package com.quyunshuo.main_module;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.quyunshuo.common_base.base.BaseActivity;

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
        super.setStatusBarColor(R.color.main_color);
    }
}
