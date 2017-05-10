package com.qule.study.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.qule.study.model.JumpActivityModel;

import java.util.List;

/**
 * @author qule
 * @version V1.0.0
 * @Description
 * @date 2017-01-26 17:50
 */
public class JumpActivityListAdapter extends BaseAdapter {
    Context mContext;
    List<JumpActivityModel> mList;
    LayoutInflater mInflater;

    public JumpActivityListAdapter(Context context, List<JumpActivityModel> list) {
        this.mContext = context;
        this.mList = list;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        Log.v("ql","getCount:"+mList.size());
        return mList == null ? 0 : mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Hoder hoder;
        if (convertView == null) {
            TextView textView = new TextView(mContext);
            textView.setPadding(10, 10, 0, 10);
            textView.setTextColor(Color.BLACK);
            textView.setTextSize(20);

            hoder = new Hoder();
            hoder.textView = textView;

            convertView = textView;
            convertView.setTag(hoder);
        } else {
            hoder = (Hoder) convertView.getTag();
        }

        JumpActivityModel model = mList.get(position);
        Log.v("ql","name:"+model.name);
        hoder.textView.setText(model.name);

        return convertView;
    }


    static class Hoder {
        public TextView textView;
    }
}
