class PalindromList {

    public int getLength(Node head) {
        int count = 0;
        Node cur = head;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }

    Node getMiddle(Node head) {
        int length = getLength(head);
        int half = length / 2;
        Node cur = head;
        for (int i = 0; i < half; i++) {
            cur = cur.next;
        }

        return cur;
    }

    public Node reverseList(Node head) {
        Node nHead = null;
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;

            cur.next = nHead;
            nHead = cur;

            cur = next;
        }

        return nHead;
    }

    public boolean chkPalindrome(Node A) {
        Node middle = getMiddle(A);
        Node rHead = reverseList(middle);
        Node c1 = A;
        Node c2 = rHead;

        while (c1 != null && c2 != null) {
            if (c1.val != c2.val) {
                return false;
            }

            c1 = c1.next;
            c2 = c2.next;
        }

        return true;
    }
}
