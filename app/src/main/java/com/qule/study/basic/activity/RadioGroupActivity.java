package com.qule.study.basic.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.qule.study.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RadioGroupActivity extends AppCompatActivity {

    @BindView(R.id.radio_group)
    RadioGroup mRadioGroup;
    @BindView(R.id.text)
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_group);
        ButterKnife.bind(this);

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                CharSequence text = ((RadioButton) group.findViewById(checkedId)).getText();
                mTextView.setText("你的爱好是：" + text + "。");
            }
        });
    }

}
