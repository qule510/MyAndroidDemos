package com.qule.study.basic.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.TextView;

import com.qule.study.R;
import com.qule.study.util.L;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SeekBarActivity extends AppCompatActivity {
    @BindView(R.id.seekBar)
    SeekBar mSeekBar;
    @BindView(R.id.text)
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bar);
        ButterKnife.bind(this);
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mTextView.setText("当前进度:"+progress+"%");
                L.v("SeekBar正在拖动...");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                L.v("SeekBar开始拖动");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                L.v("SeekBar停止拖动");
            }
        });
    }

}
