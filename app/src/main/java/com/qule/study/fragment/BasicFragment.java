package com.qule.study.fragment;


import com.qule.study.basic.activity.AnimationActivity;
import com.qule.study.model.JumpActivityModel;

import java.util.ArrayList;


/**
 * @author qule
 * @version V1.0.0
 * @Description 主界面的第3个fragment:基础复习demo的入口
 * @date 2017-01-26 16:10
 */
public class BasicFragment extends BaseMainTabFragment {


    public BasicFragment() {
        // Required empty public constructor
    }


    @Override
    ArrayList<JumpActivityModel> getJumpActivityModelList() {
        ArrayList list = new ArrayList<>();
        list.add(new JumpActivityModel("动画基础练习", AnimationActivity.class));
        return list;
    }


}
