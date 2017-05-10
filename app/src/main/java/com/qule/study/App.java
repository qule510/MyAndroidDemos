package com.qule.study;

import android.app.Application;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.view.ViewAnimationUtils;

import butterknife.ButterKnife;

/**
 * @author qule
 * @version V1.0.0
 * @Description
 * @date 2017-01-26 11:22
 */
public class App extends Application {

    public void onCreate() {
        super.onCreate();
        ButterKnife.setDebug(true);
    }

    public void test(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ViewAnimationUtils.createCircularReveal(null,0,0,0,0);
        }
//        Message 实现了 Parcelable接口
        Message message  = Message.obtain();
        ThreadLocal<Object> threadLocal = new ThreadLocal<>();
        //先到ThreadLocal取一次，如果取到了，说明调用过了，不能再调用（直接抛异常返回）。
        // 使用ThreadLocal存放Looper确保每个线城只有一个Looper.
        Looper.prepare();
//        会去ThreadLocal 取一次，如果没有，说明没有调用prepare.
//        会死循环读取消息队列MessageQueue。
        Looper.loop();
        //这里是通过Looper获取当前线城的消息队列
        MessageQueue messageQueue = Looper.myQueue();

//        Handler 如果是在主线程创建的话，可以获取到非空的Looper。
        //非主线程创建的话，会有
        Handler handler = new Handler();
        handler.sendMessageAtTime(null,0L);
        //往MessageQueue里面 enqueueMessage
    }
}
