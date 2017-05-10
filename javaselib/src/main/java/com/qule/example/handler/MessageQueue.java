package com.qule.example.handler;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author qule
 * @version V1.0.0
 * @Description 存放消息的消息队列
 * @date 2017-02-06 9:26
 */
public class MessageQueue {


    private BlockingQueue<Message> mMessageBlockingQueue;


    public MessageQueue() {
        this(false);
    }


    boolean mQuitAllowed;

    public MessageQueue(boolean quitAllowed) {
        mMessageBlockingQueue = new LinkedBlockingQueue<>();
        this.mQuitAllowed = quitAllowed;
    }


    public void enqueueMessage(Message message) {
        try {
            mMessageBlockingQueue.put(message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Message next() {
        try {
            //如果没有数据，可能阻塞
            return mMessageBlockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
