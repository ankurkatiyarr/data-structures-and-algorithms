package c.c.udemy.doubly.linked.list;

public class DLLImpl {
	static DLLNode head;
	static DLLNode tail;

	public void traverse() {
		System.out.println("Traversing through the list..");
		DLLNode temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public void reverseTraverse() {
		System.out.println("Traversing backward through the list..");
		DLLNode temp = tail;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.prev;
		}
		System.out.println();
	}

	public void insertAtBegin(int data) {
		System.out.println("inserting " + data + " at the begin..");
		if (head == null && tail == null) {
			head = new DLLNode(data);
			tail = head;
			return;
		}
		DLLNode newnode = new DLLNode(data);
		newnode.next = head;
		head.prev = newnode;
		head = newnode;
	}

	public void insertAtEnd(int data) {
		System.out.println("inserting " + data + " at the end of the list..");
		if (head == null && tail == null) {
			head = new DLLNode(data);
			tail = head;
			return;
		}
		DLLNode newnode = new DLLNode(data);
		tail.next = newnode;
		newnode.prev = tail;
		tail = newnode;
	}

	public boolean search(int data) {
		DLLNode temp = head;
		while (temp != null) {
			if (temp.data == data) {
				return true;
			}
			temp = temp.next;
		}
		return false;
	}

	public void delete(int data) {
		System.out.println("Deleting " + data + " from the list..");
		DLLNode temp = head;
		boolean isDataPresent = false;
		
		while (temp != null) {
			if (temp.data == data) {
				isDataPresent = true;
				break;
			}
			temp = temp.next;
		}
		if (isDataPresent) {
			DLLNode prevNode = temp.prev;
			System.out.println("prevNode: " + prevNode);
			
			if (prevNode != null) {
				prevNode.next = temp.next;
				
				DLLNode nextNode = temp.next;
				System.out.println("nextNode: " + nextNode);
				
				if (nextNode != null) {
					nextNode.prev = prevNode;
				}
			} else {
				head = head.next;
			}
		} else {
			System.out.println("Data not present in the list..");
		}
	}

	public static void main(String[] args) {
		DLLImpl impl = new DLLImpl();
		impl.insertAtEnd(2);
		impl.insertAtBegin(10);
		impl.insertAtBegin(8);
		impl.insertAtBegin(4);
		impl.traverse();
		impl.reverseTraverse();

		impl.insertAtEnd(5);
		impl.traverse();
		impl.reverseTraverse();
		
		impl.delete(10);
		impl.traverse();
	}
}
