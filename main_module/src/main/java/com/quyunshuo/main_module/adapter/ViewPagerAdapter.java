package com.quyunshuo.main_module.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.quyunshuo.common_base.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: MiYan
 * @Time: 2019/10/28 15:07
 * @Description: 描述：
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    BaseFragment mMainFragment;
    BaseFragment mOtherFragment;
    BaseFragment mMeFragment;
    private final List<String> mFragmentsTitles = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public ViewPagerAdapter(FragmentManager fm, BaseFragment mMainFragment, BaseFragment mOtherFragment, BaseFragment mMeFragment) {
        super(fm);
        this.mMainFragment = mMainFragment;
        this.mOtherFragment = mOtherFragment;
        this.mMeFragment = mMeFragment;
        mFragmentsTitles.add("MainFragment");
        mFragmentsTitles.add("OtherFragment");
        mFragmentsTitles.add("MeFragment");
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (mFragmentsTitles.get(position)) {
            case "MainFragment":
                return mMainFragment;
            case "OtherFragment":
                return mOtherFragment;
            case "MeFragment":
                return mMeFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return mFragmentsTitles.size();
    }
}
