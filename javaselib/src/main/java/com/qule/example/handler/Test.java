package com.qule.example.handler;

/**
 * @author qule
 * @version V1.0.0
 * @Description
 * @date 2017-02-06 12:13
 */
public class Test {
    public static void main(String[] args) {
//        testMessageMainThreadToSubThread();
        testMessageSubTheadToMainThread();
    }

    /**
     * 子线程往主线程发消息
     */
    public static void testMessageSubTheadToMainThread(){
        //Main
        Looper.prepare();
        Looper.loop();

    }

    /**
     * 主线程往子线程 发消息
     */
    public static void testMessageMainThreadToSubThread(){
        Activity activity =new  Activity();
        activity.onCreate();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        activity.onClick();

    }

    public static class Activity {
        Handler handler;

        public void onCreate() {

            Thread thread = new Thread() {
                @Override
                public void run() {
                    super.run();

                    Looper.prepare();
                    handler = new Handler() {
                        @Override
                        public void handleMessage(Message msg) {
                            System.out.println("handler收到消息：" + msg.toString());
                        }
                    };
                    Looper.loop();
                }
            };
            thread.start();

        }

        public void onClick() {
            Message message = new Message();
            message.what = 100;
            message.object = "你好";
            handler.post(message);

        }
    }
}
