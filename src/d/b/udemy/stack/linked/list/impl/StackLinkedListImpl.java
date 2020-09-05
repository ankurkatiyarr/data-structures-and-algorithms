package d.b.udemy.stack.linked.list.impl;

public class StackLinkedListImpl {
	private static StackNode top = null;
	
	public static void push(int data) {
		System.out.println("pushing " + data);
		if (top == null) {
			top = new StackNode(data);
		} else {
			StackNode newnode = new StackNode(data);
			newnode.next = top;
			top = newnode;
		}
	}
	
	public static void printStack() {
		System.out.println("printing stack..");
		StackNode temp = top;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	
	public static Integer pop() {
		if (top == null) {
			System.out.println("stack is empty..");
			return null;
		}
		int result = top.data;
		top = top.next;
		return result;
	}
	
	public static Integer peek() {
		if (top == null) {
			System.out.println("stack is empty..");
			return null;
		} else {
			return top.data;
		}
	}
	
	public static void delete() {
		System.out.println("deleting the stack..");
		top = null;
	}
	
	public static void main(String[] args) {
		printStack();
		
		push(5);
		printStack();
		
		push(4);
		push(6);
		push(2);
		push(8);
		push(0);
		printStack();
		
		System.out.println("popped: " + pop());
		System.out.println("top element: " + peek());
		
		delete();
		printStack();
	}
}
