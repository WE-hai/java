public class 查看一个线程的主要属性 {
    public static void main(String[] args) {
        Thread thread = new Thread();   // 因为没有覆写过 run 方法，所以线程什么都不做就退出了
        long id = thread.getId();
        System.out.println("线程的唯一标识: " + id);
        String name = thread.getName();
        System.out.println("线程的名字: " + name);
        int priority = thread.getPriority();
        System.out.println("线程的优先级: " + priority);
        Thread.State state = thread.getState();
        System.out.println("线程的当前状态: " + state);
        boolean alive = thread.isAlive();
        System.out.println("线程是否还活着: " + alive);
        boolean interrupted = thread.isInterrupted();
        System.out.println("线程是否被通知停止: " + interrupted);
        boolean daemon = thread.isDaemon();
        System.out.println("线程是否是后台线程: " + daemon);
    }
}
