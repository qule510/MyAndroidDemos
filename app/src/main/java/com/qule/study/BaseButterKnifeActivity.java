package com.qule.study;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * @author qule
 * @version V1.0.0
 * @Description
 * @date 2017-01-29 16:27
 */
public abstract class BaseButterKnifeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        //绑定activity
        ButterKnife.bind(this);
        initData(savedInstanceState);

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
//    public abstract void initView(View view);
}
