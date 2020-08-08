import java.util.ArrayList;
import java.util.Stack;

public class Solution1 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null) {
            return list;
        }
        Stack<Integer> st = new Stack<>();
        while (listNode != null) {
            st.push(listNode.val);
            listNode = listNode.next;
        }
        while (!st.isEmpty()) {
            list.add(st.pop());
        }
        return list;
    }
}
