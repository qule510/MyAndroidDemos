package com.qule.study.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qule.study.R;
import com.qule.study.activity.ShowTextActivity;
import com.qule.study.util.AppUtil;
import com.qule.study.util.L;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SingleTextFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SingleTextFragment extends Fragment {

    public static final String TAG = SingleTextFragment.class.getSimpleName();
    private static final String ARG_PARAM1 = "param1";

    private String mParam1;

    public SingleTextFragment() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment SingleTextFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SingleTextFragment newInstance(String param1) {
        SingleTextFragment fragment = new SingleTextFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
        L.v(TAG + " onCreate." + mParam1);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mIsViewCreated = true;
        L.v(TAG + " onCreateView." + mParam1);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_single_text, container, false);

    }

    boolean mIsViewCreated = false;
    TextView mTextview;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTextview = (TextView) view.findViewById(R.id.text);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        L.v(TAG + " onActivityCreated." + mParam1);


    }

    @Override
    public void onResume() {
        super.onResume();
        L.v(TAG + " onResume." + mParam1);
    }

    @Override
    public void onPause() {
        super.onPause();
        L.v(TAG + " onPause." + mParam1);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        L.v(TAG + " onAttach." + mParam1);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        L.v(TAG + " setUserVisibleHint." + mParam1 + ".isVisibleToUser:" + isVisibleToUser);
        loadDataInit();
    }

    private boolean mIsFirstLoadData = true;

    public void loadData() {
        L.v(TAG + " loadData." + mParam1);

        if (mTextview != null && mParam1 != null) {
            L.v(TAG + " loadData." + mParam1 + "，绑定数据");
            mTextview.setText(mParam1);
            mTextview.setClickable(true);
            mTextview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AppUtil.jump2Activity(getContext(), ShowTextActivity.class);
                }
            });
        }

    }

    public void loadDataInit() {
        if (getUserVisibleHint() && mIsViewCreated) {
            loadData();
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        L.v(TAG + " onDetach." + mParam1);
    }

    @Override
    public void onDestroy() {
        L.v(TAG + " onDestroy." + mParam1);
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        L.v(TAG + " onDestroyView." + mParam1);
        super.onDestroyView();
    }
}
