package c.a.udemy.single.linked.list;

public class SLLImpl {
	public void traverse(SLLNode root) {
		System.out.println("Printing Link List..");
		while (root != null) {
			System.out.print(root.data + " ");
			root = root.next;
		}
		System.out.println();
	}
	
	public void traverseRec(SLLNode root) {
		if (root == null) {
			return;
		}
		System.out.println(root.data);
		traverseRec(root.next);
	}
	
	public SLLNode insertAtEnd(SLLNode root, int data) {
		if (root == null) {
			root = new SLLNode();
			root.data = data;
			return root;
		}
		
		SLLNode temp = root;
		while (temp.next != null) {
			temp = temp.next;
		}
		
		SLLNode newnode = new SLLNode();
		newnode.data = data;
		temp.next = newnode;
		return root;
	}
	
	public SLLNode insertAtEndRec(SLLNode root, int data) {
		if (root == null) {
			root = new SLLNode();
			root.data = data;
			return root;
		}
		
		if (root.next == null) {
			SLLNode newnode = new SLLNode();
			newnode.data = data;
			root.next = newnode;
			return null;
		}
		insertAtEndRec(root.next, data);
		return root;
	}
	
	public SLLNode insertAtBegin(SLLNode root, int data) {
		SLLNode newnode = new SLLNode();
		newnode.data = data;
		newnode.next = root;
		return newnode;
	}
	
	public boolean search(SLLNode root, int data) {
		boolean result = false;
		while (root != null) {
			if (root.data == data) {
				result = true;
				break;
			}
			root = root.next;
		}
		return result;
	}
	
	public boolean searchRec(SLLNode root, int data) {
		if (root == null) {
			return false;
		}
		
		if (root.data == data) {
			return true;
		} else {
			return searchRec(root.next, data);
		}
	}
	
	public SLLNode delete(SLLNode root, int data) {
		if (root == null) {
			return null;
		}
		
		if (root != null && root.data == data) {
			return root.next;
		}

		SLLNode temp = root;
		while (temp.next != null && temp.next.data != data) {
			temp = temp.next;
		}
		if (temp.next != null) {
			temp.next = temp.next.next;
		}
		return root;
	}
	
	public static void main(String[] args) {
		SLLNode root = null;
		
		SLLImpl impl = new SLLImpl();
		root = impl.delete(root, 5);
		impl.traverse(root);
		
		root = impl.insertAtBegin(root, 4);
//		impl.traverse(root);
		
		root = impl.insertAtEnd(root, 6);
		root = impl.insertAtEnd(root, 10);
		root = impl.insertAtEnd(root, 8);
		root = impl.insertAtEndRec(root, 2);
		root = impl.insertAtBegin(root, 5);
//		impl.traverse(root);
		
//		root = impl.delete(root, 5);
		impl.traverse(root);

//		System.out.println("traversing recursively..");
//		impl.traverseRec(root);
		
//		System.out.println(impl.search(root, 5));
//		System.out.println(impl.search(root, 2));
//		System.out.println(impl.search(root, 10));
//		System.out.println(impl.search(root, 11));
//		
//		System.out.println(impl.searchRec(root, 5));
//		System.out.println(impl.searchRec(root, 2));
//		System.out.println(impl.searchRec(root, 10));
//		System.out.println(impl.searchRec(root, 11));
	}
}
