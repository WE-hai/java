import java.util.Arrays;

public class MyPriorityQueue {
    private int[] arr = new int[10];
    private int sz;

    public void offer(int n) {
        if (sz == arr.length) {
            arr = Arrays.copyOf(arr,arr.length*2);
        }
        //1.尾插
        //2.向上调整
        arr[sz++] = n;
        HeapDemo.shiftUpSmall(arr,sz,sz-1);
    }

    public int poll() {
        //1.交换 swap
        //2.尾删
        //3.向下调整
        if (sz > 0) {
            int peek = arr[0];
            HeapDemo.swap(arr,0,sz-1);
            --sz;
            HeapDemo.shiftDownSmall(arr,sz,0);
            return peek;
        }
        return -1;
    }

    public int peek() {
        return arr[0];
    }

    public boolean isEmpty() {
        return sz == 0;
    }

    public static void main(String[] args) {
        MyPriorityQueue mpq = new MyPriorityQueue();
        mpq.offer(9);
        mpq.offer(2);
        mpq.offer(10);
        mpq.offer(15);
        mpq.offer(3);
        mpq.offer(1);
        mpq.offer(7);
        mpq.offer(23);
        mpq.offer(89);
        while(!mpq.isEmpty()){
            System.out.print(mpq.poll() + " ");
        }
    }
}
