package com.qule.study.basic.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.qule.study.R;
import com.qule.study.util.L;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DateAndTimeActivity extends AppCompatActivity {


    @BindView(R.id.text_date)
    TextView mTextDate;
    @BindView(R.id.text_time)
    TextView mTextTime;
    @BindView(R.id.timePicker)
    TimePicker mTimePicker;
    @BindView(R.id.datePicker)
    DatePicker mDatePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_and_time);
        ButterKnife.bind(this);
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        mDatePicker.init(year, month, dayOfMonth, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                mTextDate.setText("选择的日期：" + year + "-" + monthOfYear + "-" + dayOfMonth);
                L.v(mTextDate.getText().toString());
            }
        });
        mTimePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                mTextTime.setText("选择的时间：" + hourOfDay + ":" + minute);
                L.v(mTextTime.getText().toString());

            }
        });
    }
}
