package timer;

public class MyTimer {
    static abstract class MyTimerTask {
        abstract void run();
    }

    void schedule(MyTimerTask task, long delay) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(delay);    // 等待一段时间
                    task.run();             // 执行任务
                } catch (InterruptedException e) {
                }
            }
        }).start();
    }
}
