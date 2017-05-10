package com.qule.study.fragment;


import com.qule.study.R;
import com.qule.study.model.JumpActivityModel;
import com.qule.study.test.HandlerTestActivity;

import java.util.ArrayList;

/**
 * @author qule
 * @version V1.0.0
 * @Description
 * @date 2017-01-26 16:10
 */
public class TestFragment extends BaseMainTabFragment {


    public TestFragment() {
        super();
    }

    @Override
    ArrayList<JumpActivityModel> getJumpActivityModelList() {
        ArrayList list = new ArrayList<>();
//        list.add(new JumpActivityModel("Fragment延迟加载Demo", LazyFragmentActivity.class));
        list.add(new JumpActivityModel("主线程和子线程通信", HandlerTestActivity.class));
        return list;
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_test;
    }


}
