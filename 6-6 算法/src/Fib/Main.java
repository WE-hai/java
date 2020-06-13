package Fib;

public class Main {
    public int fib(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2;i <= n;i++) {
            arr[i] = arr[i-1]+arr[i-2];
        }
        int ret = arr[n];
        return ret;
    }

    public int fib2(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int a = 1,b = 1;
        int fn = 0;
        for (int i = 3;i <= n;i++) {
            fn = a+b;
            b = a;
            a = fn;
        }
        return fn;
    }
}
