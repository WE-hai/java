public class Node {
	int val;
	Node next;
	
	Node(int val,Node next) {
		this.val = val;
		this.next = next;
	}
	Node(int val) {
		this(val,null);
	}
	
}

/*
ListNode last = null;
ListNode newHead = null;
ListNode cur = head;

while(cur != null) {
	if(cur.val != val) {
		if(newHead == null) {
			newHead = cur;
		} else {
			last.next = cur;
		}
		last = cur;
	}
	cur = cur.next;
}
if(last!=null) {
	last.next = null;
}
return newHead;
*/
