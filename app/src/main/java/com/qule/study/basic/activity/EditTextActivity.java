package com.qule.study.basic.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.qule.study.R;
import com.qule.study.linstener.SimpeTextWatcher;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EditTextActivity extends AppCompatActivity {

    AppCompatEditText mEditText;
    @BindView(R.id.text)
    TextView mTextView;

    @BindView(R.id.list)
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
        ButterKnife.bind(this);

        mListView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getData()));
        View footerView = View.inflate(this, R.layout.item_footer_01, null);
        mEditText = (AppCompatEditText) footerView.findViewById(R.id.edit_text);
        mEditText.addTextChangedListener(new SimpeTextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
                mTextView.setText(s.toString());
            }
        });
        mListView.addFooterView(footerView);
    }

    private List<String> getData() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add("item" + i);
        }
        return list;
    }

    @OnClick({R.id.button_dialog})
    public void onClick(View view) {
        if (view.getId() == R.id.button_dialog) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);  //先得到构造器
            builder.setTitle("提示"); //设置标题
            builder.setMessage("是否确认退出?\n" +
                    "a\na\na\na\na\na\na\na\na\na\n" +
                    "a\n" +
                    "a\n" +
                    "a\n" +
                    "a\n" +
                    "a\n" +
                    "a\n" +
                    "a\n" +
                    "a\n" +
                    "a\n" +
                    "a\n" +
                    "a\n" +
                    "a"); //设置内容
            builder.setIcon(R.mipmap.ic_launcher);//设置图标，图片id即可
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() { //设置确定按钮
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss(); //关闭dialog
                    Toast.makeText(EditTextActivity.this, "确认" + which, Toast.LENGTH_SHORT).show();
                }
            });
            builder.setNegativeButton("取消", new DialogInterface.OnClickListener() { //设置取消按钮
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    Toast.makeText(EditTextActivity.this, "取消" + which, Toast.LENGTH_SHORT).show();
                }
            });

            builder.setNeutralButton("忽略", new DialogInterface.OnClickListener() {//设置忽略按钮
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    Toast.makeText(EditTextActivity.this, "忽略" + which, Toast.LENGTH_SHORT).show();
                }
            });
            //参数都设置完成了，创建并显示出来
            builder.create().show();
        }
    }
}
