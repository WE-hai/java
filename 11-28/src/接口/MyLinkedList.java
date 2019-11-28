package 接口;

class Node {
    int val;
    Node next;

    Node() {
        this.val = val;
        this.next = next;
    }

    Node(int val) {
        this.val = val;
        this.next = next;
    }
}

public class MyLinkedList implements MyList {

    private Node head;
    @Override
    public void pushFront(int element) {
        Node node = new Node();
        node.val = element;
        node.next = head;
        head = node;
    }

    @Override
    public void pushBack(int element) {

    }

    @Override
    public void popFront() {

    }

    @Override
    public void popBack() {

    }

    @Override
    public int get(int index) {
        return 0;
    }

    @Override
    public void set(int index, int element) {

    }
}
