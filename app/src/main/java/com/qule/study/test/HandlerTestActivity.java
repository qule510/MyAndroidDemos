package com.qule.study.test;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;

import com.qule.study.BaseButterKnifeActivity;
import com.qule.study.R;
import com.qule.study.util.AppUtil;

import butterknife.BindView;
import butterknife.OnClick;

//

/**
 * @author qule
 * @version V1.0.0
 * @Description 主线程和子线程通过Handler双向通信
 * @date 2017-02-05 16:10
 */
public class HandlerTestActivity extends BaseButterKnifeActivity {

    @BindView(R.id.button_post01)
    Button mButtonPost01;
    @BindView(R.id.button_post02)
    Button mButtonPost02;
    @BindView(R.id.button_post03)
    Button mButtonPost03;

    Handler mMainHandler;
    Handler mSubHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_handler_test;
    }

    Thread mSubThread;

    @Override
    public void initData(Bundle bundle) {

        //这里就是在主线程中，UI线程已经内部已经自动消息循环
        mMainHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                String text = (String) msg.obj;
                AppUtil.toastShort(HandlerTestActivity.this, "主线程收到的信息：" + text);
            }
        };
        mSubThread = new Thread() {
            @Override
            public void run() {
                //建立消息循环的步骤
                Looper.prepare();//1、初始化Looper
                mSubHandler = new Handler() {//2、绑定handler到CustomThread实例的Looper对象
                    public void handleMessage(Message msg) {//3、定义处理消息的方法
                        String text = (String) msg.obj;
                        AppUtil.toastShort(HandlerTestActivity.this, "子线程收到的信息：" + text);
                    }
                };
                Looper.loop();//4、启动消息循环
            }


        };
        mSubThread.start();

    }


    @OnClick({R.id.button_post01, R.id.button_post02, R.id.button_post03})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_post01:
//                子线程向主线程发消息,
//                需要子线程拿到主线程的handler,通过handler发送消息
                new Thread() {
                    @Override
                    public void run() {
                        //需要拿到主线程的handler
                        Message msg = Message.obtain();
                        msg.obj = "我是子线程，主线程，你要更新UI啦!";
                        mMainHandler.sendMessage(msg);
                    }
                }.start();
                break;
            case R.id.button_post02:
                //子线程往主线程发消息，需要主线程拿到子线程的handler,通过handler，发送消息.
                //子线程，单单创建handler，是不够的，子线程还需要消息队列。

                Message msg = Message.obtain();
                msg.obj = "我是主线程，子线程你收到了吗?";
                mSubHandler.sendMessage(msg);


                break;
            case R.id.button_post03:
                //
//                new Handler().getLooper().quit();
                //主线程不允许退出的
                mSubHandler.getLooper().quit();

                AppUtil.toastLong(this, "子线程状态：" + mSubThread.getState());
                break;
            default:
                break;
        }
    }

//注意点
    //
// 1.如果子线程开启Looper.loop()，不使用的时候，记得退出，以免内存泄露。而主线程不允许退出的。如果强制退出会抛异常：java.lang.RuntimeException: Main thread not allowed to quit.

}
