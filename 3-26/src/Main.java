public class Main {
    private static final long COUNT = 1000;
    private static final int N = 10;

    public static void cal() {
        long r = 0;
        for (int i = 0;i < COUNT;i++) {
            r += i;
        }
        System.out.println(r);
    }

    private static class MyThread extends Thread {
        @Override
        public void run() {
            cal();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long start = System.nanoTime();
        MyThread[] threads = new MyThread[N-1];
        for (int i = 0;i < N-1;i++) {
            MyThread thread = new MyThread();
            thread.start();
            threads[i] = thread;
        }
        cal();
        for (int i = 0;i < N-1;i++) {
            threads[i].join();
        }
        long end = System.nanoTime();
        double ms = (end-start) * 1.0 / 1000 / 1000;
        System.out.println("耗时: " + ms);

         /*
        long start = System.nanoTime();
        for (int i = 0; i < N; i++) {
            calc();
        }
        long end = System.nanoTime();
        double ms = (end - start) * 1.0 / 1000 / 1000;
        System.out.println("耗时: " + ms);
        */
    }
}
