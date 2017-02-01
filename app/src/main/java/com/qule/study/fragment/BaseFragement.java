package com.qule.study.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qule.study.util.L;

import butterknife.ButterKnife;

/**
 * @author qule
 * @version V1.0.0
 * @Description 所有Fragment 的基类。使用了{@link #getLayoutId()}获取 布局资源文件ID。加载完成后执行{@link #initView(View)}，可以用于获取view的引用
 * @date 2017-01-26 15:48
 */
public abstract class BaseFragement extends Fragment {
    public BaseFragement() {
        super();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData(getArguments());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);

        L.v(this.getClass().getSimpleName() + ":onCreateView");
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        L.v(this.getClass().getSimpleName() + ":onViewCreated");
        ButterKnife.bind(this, view);
        initView(view);
    }

    //   API链接 https://developer.android.google.cn/reference/android/support/v4/app/Fragment.html#setUserVisibleHint(boolean)
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
//        Log.e("BaseFragment", this.getClass().getSimpleName() + "isVisibleToUser:" + isVisibleToUser);
    }


    @Override
    public void onDestroyView() {

        super.onDestroyView();
    }

    /**
     * 这里使用抽象，是因为父类需要使用。
     *
     * @return 布局资源文件ID
     */
    public abstract int getLayoutId();

    /**
     * onCreate后执行，可以数据初始化，或者获取传递进来的数据
     *
     * @param bundle 初始化带进来的，可能为null
     */
    public abstract void initData(Bundle bundle);

    /**
     * onViewCreated后执行，也就是view inflate之后
     *
     * @param view inflate的view
     */
    public abstract void initView(View view);


    @Override
    public void onPause() {
        super.onPause();
        L.v(this.getClass().getSimpleName()+" onPause");
    }
    @Override
    public void onResume() {
        super.onResume();
        L.v(this.getClass().getSimpleName()+" onResume");
    }
}
