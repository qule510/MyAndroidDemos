package com.qule.example.handler;

/**
 * @author qule
 * @version V1.0.0
 * @Description
 * @date 2017-02-06 9:35
 */
public class Looper {
    static final ThreadLocal<Looper> sThreadLocal = new ThreadLocal<Looper>();
    private final MessageQueue mQueue;

    public Looper() {
        this(false);
    }

    public Looper(boolean quitAllowed) {
        mQueue = new MessageQueue(quitAllowed);
    }

    public static void prepare() {
        //会在Thread有个变量存放了值
        sThreadLocal.set(new Looper());
    }

    public static void loop() {
        Looper looper = myLooper();
        if (looper == null) {
            //没有Looper，该线程之前没有调用Looper.prepare()
            throw new RuntimeException("No Looper; Looper.prepare() wasn't called on this thread.");
        }
        MessageQueue messageQueue =looper.mQueue;
        for (;;){
            Message msg = messageQueue.next();
            if(msg!=null){
                msg.target.dispatchMessage(msg);
            }
        }

    }

    public MessageQueue getQueue() {
        return mQueue;
    }

    //主线程的Looper
    private static Looper sMainLooper = null;

    //主线程会调用
    public static void prepareMainLooper() {
        prepare();
        synchronized (Looper.class) {
            if (sMainLooper != null) {
                throw new IllegalStateException("The main Looper has already been prepared.");
            }
            sMainLooper = myLooper();
        }
    }

    public static Looper myLooper() {
        return sThreadLocal.get();
    }


}
