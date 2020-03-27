public class MyRunnable implements Runnable {
    @Override
    public void run() {

    }

    public static void main(String[] args) {
        MyRunnable th = new MyRunnable();
        Thread thread = new Thread(th);
    }
}
