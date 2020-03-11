public class MyLinkedList<E> {
    Node<E> head;
    int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    public void pushFront(E e) {
        Node<E> node = new Node<>(e);
        node.next = head;
        head = node;
        size++;
    }

    public void popFront() {
        if (size == 0) {
            throw new RuntimeException("kong");
        }
        head = head.next;
        size--;
    }
}
