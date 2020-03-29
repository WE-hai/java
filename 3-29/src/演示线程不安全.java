public class 演示线程不安全 {
    private static long n = 0;

    static class Add extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10000_0000; i++) {
                n++;
            }
        }
    }

    static class Sub extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10000_0000; i++) {
                n--;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Sub sub = new Sub();
        sub.start();
        Add add = new Add();
        add.start();

        add.join();
        sub.join();

        System.out.println(n);  // 我期望中 n 的值应该是多少
    }
}
