import java.util.*;

public class Solution {
    //复制带指针的链表
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node,Node> map = new HashMap<>();
        Node newH,newT;
        newH = newT = null;
        Node cur = head;
        while (cur != null) {
            Node node = new Node(cur.val);
            if (newH == null) {
                newH = newT = node;
            } else {
                newT.next = node;
                newT = newT.next;
            }
            map.put(cur,node);
            cur = cur.next;
        }
        cur = head;
        newT = newH;
        while (cur != null) {
            if (cur.random != null) {
                newT.random = map.get(cur.random);
            } else {
                newT.random = null;
            }
            cur = cur.next;
            newT = newT.next;
        }
        return newH;
    }

    //前k个高频单词
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word,map.getOrDefault(word,0)+1);
        }
        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<>(new EntryComparator());
        for (Map.Entry<String,Integer> en : map.entrySet()) {
            pq.offer(en);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        LinkedList<String> list = new LinkedList<>();
        while (!pq.isEmpty()) {
            list.addFirst(pq.poll().getKey());
        }
        return list;
    }
}
class EntryComparator implements Comparator<Map.Entry<String,Integer>> {
    @Override
    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        int diff = o1.getValue()-o2.getValue();
        if (diff == 0) {
            return o1.getKey().compareTo(o2.getKey());
        }
        return diff;
    }
}