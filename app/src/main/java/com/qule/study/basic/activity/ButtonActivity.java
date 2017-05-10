package com.qule.study.basic.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.qule.study.R;
import com.qule.study.util.AppUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ButtonActivity extends AppCompatActivity {
    @BindView(R.id.button_test_01)
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        ButterKnife.bind(this);
    }
    @OnClick({R.id.button_test_01})
    public void onClick(View view){
        AppUtil.toastShort(this,"点击按钮");
    }
}
