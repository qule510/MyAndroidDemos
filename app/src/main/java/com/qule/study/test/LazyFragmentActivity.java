package com.qule.study.test;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;

import com.qule.study.BaseButterKnifeActivity;
import com.qule.study.R;
import com.qule.study.fragment.SingleTextFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class LazyFragmentActivity extends BaseButterKnifeActivity {


    @BindView(R.id.pager_01)
    ViewPager mPager01;
    @BindView(R.id.pager_02)
    ViewPager mPager02;

    @BindView(R.id.pager_03)
    ViewPager mPager03;
    LinearLayoutCompat mLinearLayoutCompat;

    @Override
    public int getLayoutId() {
        return R.layout.activity_lazy_fragment;
    }


    @Override
    public void initData(Bundle bundle) {
//        ArrayList<Fragment> list01 = new ArrayList<>();
//        list01.add(SingleTextFragment.newInstance("PagerAdapter01"));
//        list01.add(SingleTextFragment.newInstance("MyFragmentPagerAdapter"));
//        list01.add(SingleTextFragment.newInstance("PagerAdapter03"));
//        list01.add(SingleTextFragment.newInstance("PagerAdapter04"));

//        mPager01.setAdapter(new PagerAdapter01(list01));

        ArrayList<Fragment> list02 = new ArrayList<>();
        list02.add(SingleTextFragment.newInstance("pager2_01"));
        list02.add(SingleTextFragment.newInstance("pager2_02"));
        list02.add(SingleTextFragment.newInstance("pager2_03"));
        list02.add(SingleTextFragment.newInstance("pager2_04"));

        mPager02.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(), list02));

//        ArrayList<Fragment> list03 = new ArrayList<>();
//        list03.add(SingleTextFragment.newInstance("MyFragmentStatePagerAdapter01"));
//        list03.add(SingleTextFragment.newInstance("MyFragmentStatePagerAdapter02"));
//        list03.add(SingleTextFragment.newInstance("MyFragmentStatePagerAdapter03"));
//        list03.add(SingleTextFragment.newInstance("MyFragmentStatePagerAdapter04"));
//
//        mPager03.setAdapter(new MyFragmentStatePagerAdapter(getSupportFragmentManager(), list03));

    }

    public class PagerAdapter01 extends PagerAdapter {

        private final List<Fragment> list;

        public PagerAdapter01(List<Fragment> list) {
            this.list = list;
        }

        @Override
        public int getCount() {
            return list == null ? 0 : list.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return false;
        }
    }

    public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> list;

        public MyFragmentPagerAdapter(FragmentManager fragmentManager, List<Fragment> list) {
            super(fragmentManager);
            this.list = list;
        }

        @Override
        public int getCount() {
            return list == null ? 0 : list.size();
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

    }


    public class MyFragmentStatePagerAdapter extends FragmentStatePagerAdapter {

        private final List<Fragment> list;

        public MyFragmentStatePagerAdapter(FragmentManager fragmentManager, List<Fragment> list) {
            super(fragmentManager);
            this.list = list;
        }

        @Override
        public int getCount() {
            return list == null ? 0 : list.size();
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
