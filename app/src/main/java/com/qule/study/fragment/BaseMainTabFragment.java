package com.qule.study.fragment;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.qule.study.R;
import com.qule.study.adapter.JumpActivityListAdapter;
import com.qule.study.model.JumpActivityModel;
import com.qule.study.util.AppUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;


/**
 * @author qule
 * @version V1.0.0
 * @Description 主界面的fragment，
 * @date 2017-02-01 16:28
 */
public abstract class BaseMainTabFragment extends BaseFragement {

    @BindView(R.id.listview)
    ListView mListview;

    JumpActivityListAdapter mJumpActivityListAdapter;

    public BaseMainTabFragment() {
    }


    List<JumpActivityModel> mList;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_basic;
    }

    @Override
    public void initData(Bundle bundle) {
        ArrayList<JumpActivityModel> list = getJumpActivityModelList();
        mList = list == null ? Collections.EMPTY_LIST : list;
        mJumpActivityListAdapter = new JumpActivityListAdapter(getContext(), mList);
    }

    @Override
    public void initView(View view) {

        mListview.setAdapter(mJumpActivityListAdapter);
        mListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                JumpActivityModel model = (JumpActivityModel) parent.getAdapter().getItem(position);
                AppUtil.jump2Activity(getContext(), model.getClazz(), model.bundle);
            }
        });
    }

    abstract ArrayList<JumpActivityModel> getJumpActivityModelList();


}
