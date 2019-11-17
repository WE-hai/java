public class ReverseList {
	public static Node buildLinkedList() {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		return n1;
	}
	
	public static void printLinkedList(Node head) {
		Node cur = head;
		while(cur != null) {
			System.out.println(cur.val);
			cur = cur.next;
		}
	}
	public static Node reverseList1(Node head) {
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
		//同上，链表反转
	public static Node reverseList2(Node head) {
		if(head ==null) {
			return null;
		}
		Node p1 = null;
		Node p2 = head;
		Node p3 = head.next;
		
		while(p2 != null) {
			p2.next = p1;
			
			p1 = p2;
			p2 = p3;
			if(p3 != null) {
				p3 = p3.next;
			}
			
		}
		return p1;
	}
	
	public static void main(String[] args) {
		Node head = buildLinkedList();
		head = reverseList1(head);
		printLinkedList(head);
		head = reverseList2(head);
		printLinkedList(head);
		
	}
}