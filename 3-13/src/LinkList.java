class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
//复制带随机指针的链表
public class LinkList {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            Node copy = new Node(cur.val);
            cur.next = copy;
            copy.next = next;
            cur = next;
        }
        cur = head;
        Node copy = head.next;
        while (cur != null) {
            copy = cur.next;
            Node next = copy.next;
            if (cur.random != null) {
                copy.random = cur.random.next;
            } else {
                copy.random = null;
            }
            cur = next;

        }
        cur = head;
        Node newHead = head.next;
        copy = newHead;
        while (cur != null) {
            Node next = copy.next;
            cur.next = next;
            if (next != null) {
                copy.next = next.next;
            }
            cur = next;
            copy = copy.next;
        }
        return newHead;
    }
}
