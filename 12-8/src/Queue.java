class Node {
    int value;
    Node next;
    public Node() {
        this.value = value;
        this.next = next;
    }
    public Node(int value,Node next) {
        this.value = value;
        this.next = next;
    }
    public Node(int value) {
        this(value,null);
    }
}
public class Queue {
    Node front;
    Node rear;
    int size = 0;
    public Queue() {
        front = rear = null;
    }

    public void offer(int value) {
        Node newNode = new Node(value);
        if(front == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = rear.next;
        }
        ++size;
    }

    public void poll() {
        if (front == null) {
            return;
        }
        front = front.next;
        if (front == null) {
            rear = null;
        }
        --size;

    }
    public int size() {
        return size;
    }
    public int peek() {
        if(size == 0) {
            return -1;
        }
        return front.value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        Queue qu = new Queue();
        System.out.println(qu.isEmpty());
        System.out.println(qu.size());
        qu.offer(1);
        qu.offer(2);
        qu.offer(3);
        qu.offer(4);
        System.out.println(qu.isEmpty());
        System.out.println(qu.size());
        while(!qu.isEmpty())  {
            System.out.println(qu.peek());
            qu.poll();
        }
        System.out.println(qu.isEmpty());
        System.out.println(qu.size());
    }
}
