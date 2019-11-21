public class DeleteDuplication {
    public static Node deleteDuplication(Node pHead) {
        if (pHead == null) {
            return pHead;
        }
        Node prev = new Node();
        Node fake = prev;
        prev.next = pHead;
        Node cur = pHead;
        Node next = pHead.next;

        while (next != null) {
            if (cur.val != next.val) {
                prev = prev.next;
                cur = cur.next;
                next = next.next;
            } else {
                while (next != null && cur.val == next.val) {
                    next = next.next;
                }
                // next 可能是 null

                // 删除 [cur, next)
                prev.next = next;

                cur = next;
                if (next != null) {
                    next = next.next;
                }
            }
        }

        return fake.next;
    }
}
