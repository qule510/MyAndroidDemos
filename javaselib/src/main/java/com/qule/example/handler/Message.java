package com.qule.example.handler;

/**
 * @author qule
 * @version V1.0.0
 * @Description 线城间消息通信实体
 * @date 2017-02-06 9:22
 */
public class Message {
    int what;
    public Object object;
    public Handler target;

    @Override
    public String toString() {
        return "Message{" +
                "what=" + what +
                ", object=" + object +
                '}';
    }
}
