package com.qule.study.fragment;


import com.qule.study.basic.activity.AnimationActivity;
import com.qule.study.basic.activity.ButtonActivity;
import com.qule.study.basic.activity.CheckBoxActivity;
import com.qule.study.basic.activity.DateAndTimeActivity;
import com.qule.study.basic.activity.EditTextActivity;
import com.qule.study.basic.activity.ProgressBarActivity;
import com.qule.study.basic.activity.RadioGroupActivity;
import com.qule.study.basic.activity.RatingBarActivity;
import com.qule.study.basic.activity.SeekBarActivity;
import com.qule.study.basic.activity.ToolBarActivity;
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
        list.add(new JumpActivityModel("ToolBar演示", ToolBarActivity.class));
        list.add(new JumpActivityModel("Button测试", ButtonActivity.class));
        list.add(new JumpActivityModel("EditText测试", EditTextActivity.class));
        list.add(new JumpActivityModel("CheckBox测试", CheckBoxActivity.class));
        list.add(new JumpActivityModel("RadioGroup测试", RadioGroupActivity.class));
        list.add(new JumpActivityModel("ProgressBar测试", ProgressBarActivity.class));
        list.add(new JumpActivityModel("SeekBar测试", SeekBarActivity.class));
        list.add(new JumpActivityModel("RatingBar测试", RatingBarActivity.class));
        list.add(new JumpActivityModel("时间选择测试", DateAndTimeActivity.class));
        return list;
    }


}
