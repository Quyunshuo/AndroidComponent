package com.quyunshuo.main_module;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.quyunshuo.common_base.base.BaseActivity;
import com.quyunshuo.common_base.base.BaseFragment;
import com.quyunshuo.common_base.constants.ARouterConfig;
import com.quyunshuo.common_base.utils.ARouterUtils;
import com.quyunshuo.common_base.utils.StatusBarUtil;
import com.quyunshuo.main_module.adapter.ViewPagerAdapter;

import java.util.ArrayList;

import static com.ashokvarma.bottomnavigation.BottomNavigationBar.BACKGROUND_STYLE_RIPPLE;
import static com.ashokvarma.bottomnavigation.BottomNavigationBar.MODE_FIXED;

@Route(path = "/main/MainActivity")
public class MainActivity extends BaseActivity {
    private BottomNavigationBar mBottomNavigationBar;
    private ViewPager mViewPager;
    private ViewPagerAdapter mViewPagerAdapter;
    private ArrayList<Fragment> mFragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        initBottomNavigationBar();
        initViewPager();
    }

    /**
     * 初始化ViewPager
     */
    private void initViewPager() {
        BaseFragment mMainFragment = ARouterUtils.getFragment(ARouterConfig.MAIN_FRAGMENT);
        BaseFragment mOtherFragment = ARouterUtils.getFragment(ARouterConfig.OTHER_FRAGMENT);
        BaseFragment mMeFragment = ARouterUtils.getFragment(ARouterConfig.ME_FRAGMENT);
        mFragments.add(mMainFragment);
        mFragments.add(mOtherFragment);
        mFragments.add(mMeFragment);
        mViewPager = findViewById(R.id.main_view_pager);
        mViewPager.setOffscreenPageLimit(mFragments.size());
        mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), mMainFragment, mOtherFragment, mMeFragment);
        mViewPager.setAdapter(mViewPagerAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mBottomNavigationBar.selectTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * 初始化BottomNavigationBar
     */
    private void initBottomNavigationBar() {
        mBottomNavigationBar = findViewById(R.id.bottom_navigation);
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
                        mViewPager.setCurrentItem(position);
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
