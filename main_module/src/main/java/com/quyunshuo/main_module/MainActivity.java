package com.quyunshuo.main_module;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.quyunshuo.common_base.base.BaseActivity;
import com.quyunshuo.common_base.utils.StatusBarUtil;

import static com.ashokvarma.bottomnavigation.BottomNavigationBar.BACKGROUND_STYLE_RIPPLE;
import static com.ashokvarma.bottomnavigation.BottomNavigationBar.MODE_FIXED;

@Route(path = "/main/MainActivity")
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        initBottomNavigationBar();

    }

    /**
     * 初始化BottomNavigationBar
     */
    private void initBottomNavigationBar() {
        BottomNavigationBar mBottomNavigationBar = findViewById(R.id.bottom_navigation);
        mBottomNavigationBar.setMode(MODE_FIXED) // 设置mode
                .setBackgroundStyle(BACKGROUND_STYLE_RIPPLE)  // 背景样式
                .setBarBackgroundColor("#2FA8E1") // 背景颜色
                .setInActiveColor("#929292") // 未选中状态颜色
                .setActiveColor("#ffffff") // 选中状态颜色
                .addItem(new BottomNavigationItem(R.mipmap.ic_home, "Home"))
                .addItem(new BottomNavigationItem(R.mipmap.ic_other, "Other"))
                .addItem(new BottomNavigationItem(R.mipmap.ic_me, "Me"))
                .setFirstSelectedPosition(0) //设置默认选中位置
                .setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(int position) {
                        //本次选择的item
                        Toast.makeText(mContext, "选择", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onTabUnselected(int position) {
                        //上一次选择的item
                    }

                    @Override
                    public void onTabReselected(int position) {
                        //重复选择的item
                    }
                })
                .initialise();  // 提交初始化（完成配置）
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
