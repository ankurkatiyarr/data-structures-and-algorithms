package c.d.udemy.circular.doubly.linked.list;

public class CDLImpl {
	static CDLNode head;
	static CDLNode tail;
	
	public void traverse() {
		System.out.println("traversing through the list..");
		if (head == null && tail == null) {
			System.out.println("Empty list..");
			return;
		}
		
		CDLNode temp = head;
		System.out.print(temp.data + " ");
		temp = temp.next;
		while (temp.next != head) {
			System.out.println(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public void reverseTraverse() {
		System.out.println("reverse traversing through the list..");
		if (head == null && tail == null) {
			System.out.println("Empty list..");
			return;
		}
		
		CDLNode temp = tail;
		System.out.print(temp.data + " ");
		temp = temp.prev;
		while (temp.prev != tail) {
			System.out.print(temp.data + " ");
			temp = temp.prev;
		}
		System.out.println();
	}
	
	public void insertAtBegin(int data) {
		System.out.println("inserting " + data + " at the start..");
		if (head == null && tail == null) {
			head = new CDLNode(data);
			head.next = head;
			head.prev = head;
			tail = head;
			return;
		}
		CDLNode newnode = new CDLNode(data);
		newnode.next = head;
		tail.next = newnode;
		newnode.prev = tail;
		head = newnode;
		
//		System.out.println("head: " + head);
//		System.out.println("tail: " + tail);
	}
	
	public static void main(String[] args) {
		CDLImpl impl = new CDLImpl();
		
		impl.insertAtBegin(2);
		impl.traverse();
		impl.reverseTraverse();
		
		impl.insertAtBegin(10);
//		impl.traverse();
//		impl.reverseTraverse();
		
		System.out.println("head: " + head);
		System.out.println("head.next: " + head.next);
		System.out.println("head.next.next: " + head.next.next);
		System.out.println("head.next.next.next: " + head.next.next.next);
		
		System.out.println("tail: " + tail);
		System.out.println("tail.prev: " + tail.prev);
		System.out.println("tail.prev.prev: " + tail.prev.prev);
	}
}
