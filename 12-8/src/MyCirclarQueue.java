public class MyCirclarQueue {
    private int[] array;
    private int size;
    private int front;
    private int rear;

    public MyCirclarQueue(int k) {
        array  = new int[k+1];
        front = rear = 0;
        size = 0;
    }

    public boolean enQueue(int value) {
        if(isFull()) {
            return false;
        }
        array[rear++] = value;
        size++;
        return true;
    }
    public boolean deQueue() {
        if (isFull()) {
            return false;
        }
        front++;
        front = front%array.length;
        size--;
        return true;
    }
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return array[front];
    }
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        if (rear == 0) {
            return array[array.length-1];
        }
        return array[size];
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public boolean isFull() {
        return size == array.length;
    }
}
