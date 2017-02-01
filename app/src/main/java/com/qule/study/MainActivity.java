package com.qule.study;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.qule.study.fragment.BasicFragment;
import com.qule.study.fragment.CustomFragment;
import com.qule.study.fragment.HomeFragment;
import com.qule.study.fragment.TestFragment;

/**
 * @author qule
 * @version V1.0.0
 * @Description 主界面，包含4个Fragment,底部使用RadioGroup切换。
 * @date 2017-01-26 11:10
 */
public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    public static final String TAG = MainActivity.class.getSimpleName();

    //    底部单选
    RadioGroup mRadioGroup;

    //当前显示 Fragment
    Fragment mCurrentFragment;

    HomeFragment mHomeFragment;
    CustomFragment mCustomFragment;
    BasicFragment mBasicFragment;
    TestFragment mTestFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRadioGroup = (RadioGroup) findViewById(R.id.radiongroup_main_tab);
        mRadioGroup.setOnCheckedChangeListener(this);
        mRadioGroup.check(R.id.radiobutton_home);
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

//        toFragment需要替换（显示）的Fragment,mCurrentFragment是当前展示的（将被替换）
        Fragment toFragment = null;

        switch (checkedId) {
            case R.id.radiobutton_home:
                if (mHomeFragment == null) {
                    mHomeFragment = new HomeFragment();
                }
                toFragment = mHomeFragment;

                break;
            case R.id.radiobutton_custom:
                if (mCustomFragment == null) {
                    mCustomFragment = new CustomFragment();
                }
                toFragment = mCustomFragment;
                break;
            case R.id.radiobutton_basic:
                if (mBasicFragment == null) {
                    mBasicFragment = new BasicFragment();
                }
                toFragment = mBasicFragment;

                break;
            case R.id.radiobutton_test:
                if (mTestFragment == null) {
                    mTestFragment = new TestFragment();
                }
                toFragment = mTestFragment;
                break;
            default:
                break;
        }

        switchFrgent(mCurrentFragment, toFragment);
    }


    /**
     * 切换Fragment
     *
     * @param from 当前显示的fragment，需要被替换的
     * @param to   需要显示的fragment
     */
    public void switchFrgent(Fragment from, Fragment to) {
//       理论上不会出现to是null情况
        if (to == null) {
            return;
        }
        if (from == to) {
            return;
        }

        mCurrentFragment = to;
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (to.isAdded()) {
            if (from != null) {
//                from.setUserVisibleHint(false);
                fragmentTransaction.hide(from);

            }
//                to.setUserVisibleHint(true);
            fragmentTransaction.show(to).commit();
        } else {
            if (from != null) {
//                from.setUserVisibleHint(false);
                fragmentTransaction.hide(from);
            }
//            to.setUserVisibleHint(true);
            fragmentTransaction.add(R.id.content, to).show(to).commit();
        }

    }

}
