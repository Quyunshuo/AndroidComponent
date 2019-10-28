package com.quyunshuo.main_module.ui;

import com.quyunshuo.common_base.base.BaseActivity;
import com.quyunshuo.common_base.constants.ARouterConfig;
import com.quyunshuo.common_base.utils.ARouterUtils;
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
}
