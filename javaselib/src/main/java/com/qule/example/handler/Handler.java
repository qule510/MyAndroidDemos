package com.qule.example.handler;

/**
 * @author qule
 * @version V1.0.0
 * @Description
 * @date 2017-02-06 9:35
 */
public class Handler {
    Looper mLooper;

    public Handler() {
        this(Looper.myLooper());
    }

    public Handler(Looper looper) {
        mLooper = looper;
    }

    public void post(Message message) {
        message.target = this;
        mLooper.getQueue().enqueueMessage(message);
    }

    public void handleMessage(Message msg) {
    }

    public void dispatchMessage(Message msg) {
        handleMessage(msg);
    }
}
