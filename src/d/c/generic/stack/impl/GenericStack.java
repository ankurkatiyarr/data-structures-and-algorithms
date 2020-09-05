package d.c.generic.stack.impl;

public class GenericStack<T> {
	private GenericStackNode<T> top = null;
	
	public void push(T data) {
		System.out.println("Pushing " + data + " into the stack");
		if (top == null) {
			top = new GenericStackNode<T>(data);
		} else {
			GenericStackNode<T> newnode = new GenericStackNode<T>(data);
			newnode.next = top;
			top = newnode;
		}
	}
	
	public void printStack() {
		if (top == null) {
			System.out.println("Stack is empty..");
			return;
		}
		System.out.println("Printing stack..");
		GenericStackNode<T> temp = top;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
		System.out.println();
	}
	
	public T pop() {
		System.out.println("popping element from stack..");
		if (top == null) {
			return null;
		} else {
			T pop = top.data;
			top = top.next;
			return pop;
		}
	}
	
	public static void main(String[] args) {
//		GenericStack<Integer> intStack = new GenericStack<>();
//		intStack.printStack();
//		intStack.push(5);
//		intStack.printStack();
//		intStack.push(4);
//		intStack.push(6);
//		intStack.push(2);
//		intStack.push(8);
//		intStack.printStack();
		
		GenericStack<String> stringStack = new GenericStack<>();
		stringStack.printStack();
		stringStack.push("Ankur");
		stringStack.printStack();
		stringStack.push("Rajat");
		stringStack.push("Mithila");
		stringStack.push("Shivam");
		stringStack.printStack();
		
		System.out.println(stringStack.pop());
		stringStack.printStack();
	}
}
