package c.b.udemy.circular.linked.list;

public class CLLImpl {
	static CLLNode head;
	static CLLNode tail;
	
	public void traverse() {
		System.out.println("traversing circular linked list..");
		if (head == null && tail == null) {
			System.out.println("list is empty..");
			return;
		}

		CLLNode temp = head;
		System.out.print(temp.data + " ");
		temp = temp.next;
		
		while (temp != head) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public void insertAtBegin(int data) {
		System.out.println("inserting " + data + " at the begin..");
		
		if (head == null && tail == null) {
			head = new CLLNode(data);
			head.next = head;
			tail = head;
			return;
		}
		// create new node
		CLLNode newnode = new CLLNode(data);
		// point new node to head
		newnode.next = head;
		// point head to new node
		head = newnode;
		// point tail to head
		tail.next = head;
	}
	
	public void insertAtEnd(int data) {
		System.out.println("inserting " + data + " at the end..");
		
		if (head == null && tail == null) {
			head = new CLLNode(data);
			head.next = head;
			tail = head;
			return;
		}
		
		CLLNode newnode = new CLLNode(data);
		tail.next = newnode;
		newnode.next = head;
		tail = newnode;
	}
	
	public int getSize() {
		System.out.println("Getting size of the list..");
		if (head == null && tail == null) {
			return 0;
		}
		
		int result = 1;
		CLLNode temp = head;
		temp = temp.next;
		while (temp != head) {
			result = result + 1;
			temp = temp.next;
		}
		return result;
	}
	
	public boolean search(int data) {
		System.out.println("Searching " + data + " in the list..");
		if (head == null && tail == null) {
			return false;
		}
		
		if (head.data == data) {
			return true;
		}
		
		CLLNode temp = head.next;
		while (temp != head) {
			if (temp.data == data) {
				return true;
			}
			temp = temp.next;
		}
		return false;
	}
	
	public void delete(int data) {
		System.out.println("deleting " + data + " from the list..");
		if (head == null && tail == null) {
			return;
		}
		
		if (head.data == data) {
			head = head.next;
			tail.next = head;
			return;
		}
		
		boolean isDataPresent = false;
		CLLNode temp = head.next;
		while (temp != head) {
			if (temp.next.data == data) {
				isDataPresent = true;
				break;
			}
			temp = temp.next;
		}
		
		if (isDataPresent) {
			if (temp.next.data == tail.data) {
				tail = temp;
			}
			temp.next = temp.next.next;
		}
	}
	
	public static void main(String[] args) {
		CLLImpl impl = new CLLImpl();
		
		impl.insertAtEnd(10);
		impl.insertAtEnd(8);
		impl.insertAtBegin(6);
		impl.insertAtBegin(4);
		impl.insertAtBegin(5);
		impl.insertAtEnd(2);
		impl.traverse();
		
		impl.delete(2);
		impl.traverse();
		
		impl.insertAtEnd(2);
		impl.traverse();
	}
}
