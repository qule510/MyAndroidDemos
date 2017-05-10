package com.qule.study.basic.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatRatingBar;
import android.widget.RatingBar;
import android.widget.TextView;

import com.qule.study.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RatingBarActivity extends AppCompatActivity {
    @BindView(R.id.ratingBar_normal)
    RatingBar mRatingBar;

    @BindView(R.id.ratingBar_compat)
    AppCompatRatingBar mCompatRatingBar;

    @BindView(R.id.text)
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_bar);
        ButterKnife.bind(this);
        RatingBar.OnRatingBarChangeListener listener = new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                mTextView.setText("选择的星："+rating);
            }
        };
        mRatingBar.setOnRatingBarChangeListener(listener);
        mCompatRatingBar.setOnRatingBarChangeListener(listener);


    }
}
