public class LinkedList {

    public static Node partition(Node head,int x) {
        Node cur = head;
        Node shead = new Node();
        Node slast = shead;
        Node bhead = new Node();
        Node blast = bhead;
        while(cur != null) {
            if (cur.val < x) {
                ;
            }
        }
        return shead.next;
    }

    //重要判断边界
    public static Node deieteDuplication(Node head) {
        Node pre = new Node();
        Node flag = pre;
        pre.next = head;

        return flag;
    }

    public static Node getMiddle(Node head) {
        int sz = 0;
        Node cur = head;
        while(cur != null) {
            sz++;
            cur = cur.next;
        }
        int steps = sz/2;
        Node ret = head;
        for(int i = 0;i < steps;i++) {
            ret = ret.next;
        }
        return ret;
    }
    public static Node reverseList(Node head) {
        Node nhead = null;
        Node cur = head;
        while(cur != null) {
            Node next = cur.next;

            cur.next = nhead;
            nhead = cur;

            cur = next;
        }
        return nhead;
    }

    public static boolean chkPalindRome(Node head) {
        Node mid = getMiddle(head);
        Node ret = reverseList(mid);
        Node cur1 = head;
        Node cur2 = ret;

        while(cur1 != null && cur2 != null) {
            if (cur1.val != cur2.val) {
                return false;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return true;
    }


    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(2);
        Node n5 = new Node(1);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        boolean a = chkPalindRome(n1);
        System.out.println(a);
    }
}
