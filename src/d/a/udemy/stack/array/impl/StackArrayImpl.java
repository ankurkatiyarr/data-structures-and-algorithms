package d.a.udemy.stack.array.impl;

public class StackArrayImpl {
	private static int size = 5;
	private static int[] STACK = new int[size];
	private static int topOfStack = -1;
	
	public static void push(int data) {
		System.out.println("pushing: " + data);
		if (topOfStack == (size -1)) {
			System.out.println("stack is full, could not push " + data);
			return;
		}
		
		topOfStack = topOfStack + 1;
		STACK[topOfStack] = data;
	}
	
	public static void printStack() {
		if (topOfStack == -1) {
			System.out.println("Empty stack..");
			return;
		}
		
		System.out.println("printing stack..");
		for (int i = topOfStack; i >= 0; i--) {
			System.out.println(STACK[i]);
		}
	}
	
	public static Integer pop() {
		if (topOfStack == -1) {
			System.out.println("Stack is empty..");
			return null;
		}
		int result = STACK[topOfStack];
		System.out.println("popped: " + result);
		topOfStack = topOfStack - 1;
		return result;
	}
	
	public static Integer peek() {
		if (topOfStack == -1) {
			System.out.println("Stack is empty..");
			return null;
		}
		return STACK[topOfStack];
	}
	
	public static boolean isEmpty() {
		return topOfStack == -1;
	}
	
	public static boolean isFull() {
		return topOfStack == (size - 1);
	}
	
	public static void deleteStack() {
		System.out.println("deleting stack..");
		topOfStack = -1;
	}
	
	public static void main(String[] args) {
		printStack();
		System.out.println("isEmpty: " + isEmpty());
		System.out.println("isFull: " + isFull());
		
		push(5);
		printStack();
		
		push(4);
		push(6);
		push(2);
		push(8);
		push(0);
		printStack();
		
		pop();
		printStack();
		
		push(8);
		printStack();
		
		System.out.println("Top element is: " + peek());
		System.out.println("isEmpty: " + isEmpty());
		System.out.println("isFull: " + isFull());
		
		deleteStack();
		System.out.println("isEmpty: " + isEmpty());
	}
}
