public class LinkedList {
    public static Node reverseList(Node head) {
        //链表逆置
       Node newHead = null;
       Node cur = head;
       while(cur != null) {
           Node next = cur.next;
           cur.next = newHead;
           newHead = cur;
           cur = next;
       }
       return newHead;
    }

    public static void print(Node head) {
        Node cur = head;
        while(cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

    private static Node buildLinked() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        return n1;
    }

    public static Node merge(Node list1,Node list2) {
        if(list1 == null) {
            return list2;
        }
        if(list2 == null) {
            return list1;
        }

        Node cur1 = list1;
        Node cur2 = list2;

        Node nhead = null;
        Node nlast = null;

        while(cur1 != null && cur2 !=null) {
            if(cur1.val <= cur2.val) {
                if(cur1 != null) {
                    nhead = cur1;
                } else {
                    nlast.next = cur1;
                }
                nlast = cur1;
                cur1 = cur1.next;
            } else {
                if(cur2 != null) {
                    nhead = cur2;
                } else {
                    nlast.next = cur2;
                }
                nlast = cur2;
                cur2 = cur2.next;
            }
        }
        if(cur1 != null) {
            nlast.next = cur1;
        } else {
            nlast.next = cur2;
        }
        return nhead;
    }

    public static Node partition(Node head,int x) {
        Node cur = head;
        Node shead = null;
        Node bhead = null;
        Node slast = null;
        Node blast = null;
        while(cur != null) {
            if(cur.val < x) {
                if(shead == null) {
                    shead = cur;
                } else {
                    slast.next = cur;
                }
                slast = cur;
            } else {
                if(bhead == null) {
                    bhead = cur;
                } else {
                    blast.next = cur;
                }
                blast = cur;
            }
            cur = cur.next;
        }
        if(shead == null) {
            return bhead;
        }
        if(bhead == null) {
            return  shead;
        }
        slast.next = bhead;
        blast.next = null;
        return shead;
    }

    public static Node middleNode(Node head) {
        Node cur = head;
        int sz = 0;
        while(cur != null) {
            sz++;
            cur = cur.next;
        }

        for(int i = 0;i < sz/2;i++) {
            head = head.next;
        }
        return head;
    }
    public static void main(String[] args) {
       // Node head = buildLinked();
        //print(head);
        //Node nhead = reverseList(head);
        //print(nhead);
        Node n4 = new Node(9);
        Node n3 = new Node(8,n4);
        Node n2 = new Node(3,n3);
        Node n1 = new Node(1,n2);

        Node m3 = new Node(6);
        Node m2 = new Node(5,m3);
        Node m1 = new Node(2,m2);

        Node s = merge(n1,m1);
        print(s);


    }
}
