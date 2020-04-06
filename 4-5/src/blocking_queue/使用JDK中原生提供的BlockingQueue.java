package blocking_queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class 使用JDK中原生提供的BlockingQueue {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> q;

        q = new ArrayBlockingQueue<>(16);   // 有容量上限
        q = new LinkedBlockingQueue<>();            // 没有容量上限
        q = new PriorityBlockingQueue<>();          // 优先级阻塞队列

        q.put("消息");
        String message = q.take();
        System.out.println(message);
    }
}
