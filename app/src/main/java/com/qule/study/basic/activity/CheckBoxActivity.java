package com.qule.study.basic.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.qule.study.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;

public class CheckBoxActivity extends AppCompatActivity {

    @BindView(R.id.checkbox_football)
    CheckBox mFootBallCheckBox;

    @BindView(R.id.checkbox_song)
    CheckBox mSongCheckBox;

   @BindView(R.id.checkbox_book)
    CheckBox mBookCheckBox;


    @BindView(R.id.text)
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);
        ButterKnife.bind(this);
    }

    @OnCheckedChanged({R.id.checkbox_book,R.id.checkbox_song,R.id.checkbox_football})
    public void onCheckedChanged(CompoundButton button,boolean isChecked){

        System.out.println("开始点击了");
        System.out.println(button.getText()+ ":"+isChecked);
        StringBuffer sb = new StringBuffer("你的爱好是：");
        if(mBookCheckBox.isChecked()){
            sb.append(mBookCheckBox.getText()).append("，");
        }
        if(mFootBallCheckBox.isChecked()){
            sb.append(mFootBallCheckBox.getText()).append("，");
        }
        if(mSongCheckBox.isChecked()){
            sb.append(mSongCheckBox.getText()).append("，");
        }

        if(sb.charAt(sb.length()-1)=='，'){
            sb.setCharAt(sb.length()-1,'。');
        }
        mTextView.setText(sb);
    }
}
