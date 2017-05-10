package com.qule.study.basic.activity;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

import com.qule.study.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProgressBarActivity extends AppCompatActivity {
    @BindView(R.id.progress_bar)
    ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
        ButterKnife.bind(this);
        new Thread(){
            @Override
            public void run() {
                while (mProgressBar.getProgress()<mProgressBar.getMax()){
                    mProgressBar.setProgress(mProgressBar.getProgress()+1);
                    SystemClock.sleep(100);
                }
            }
        }.start();
    }
}
