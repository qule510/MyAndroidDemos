package com.qule.example.handler;

/**
 * @author qule
 * @version V1.0.0
 * @Description
 * @date 2017-02-06 11:17
 */
public class MainThread extends Thread {
    @Override
    public void run() {
        Looper.prepare();
        Looper.loop();
    }
}
