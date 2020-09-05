package e.b.udemy.queue.link.list.impl;

public class QueueLinkListImpl {
	private QueueNode head;
	private QueueNode tail;
	
	public void print() {
		System.out.println("printing list..");
		QueueNode temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public void enqueue(int data) {
		if (head == null) {
			head = new QueueNode(data);
			tail = head;
			return;
		}
		QueueNode newnode = new QueueNode(data);
		tail.next = newnode;
		tail = newnode;
	}
	
	public void deque() {
		if (head == null) {
			System.out.println("queue is empty..");
			return;
		}
		System.out.println("Dequed emelemt: " + head.data);
		head = head.next;
	}
	
	public void peek() {
		if (head == null) {
			System.out.println("queue is empty..");
			return;
		}
		System.out.println("top element is: " + head.data);
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public static void main(String[] args) {
		QueueLinkListImpl impl = new QueueLinkListImpl();
		impl.print();
		
		impl.enqueue(4);
		impl.print();
		
		impl.enqueue(8);
		impl.enqueue(2);
		impl.enqueue(10);
		impl.enqueue(5);
		impl.print();
		
		impl.deque();
		impl.print();
		
		impl.peek();
	}
}
