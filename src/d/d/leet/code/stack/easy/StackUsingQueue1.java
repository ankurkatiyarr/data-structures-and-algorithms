package d.d.leet.code.stack.easy;

import java.util.LinkedList;

/*
 *  https://leetcode.com/problems/implement-stack-using-queues/#
 *  Insertion - O(n)
 *  Pop - O(1)
 */
public class StackUsingQueue1 {
	public LinkedList<Integer> q1 = new LinkedList<>();
	public LinkedList<Integer> q2 = new LinkedList<>();
	
	public void push(int x) {
//		System.out.println("inserting " + x + " into the stack..");
		// insert element in q2
		q2.push(x);
		
		// move elements from q1 to q2
		while (!q1.isEmpty()) {
			q2.push(q1.pop());
		}
		
		// move elements from q1 to q2
		while (!q2.isEmpty()) {
			q1.push(q2.pop());
		}
	}
	
	public int pop() {
//		System.out.println("popping element from the stack..");
//		if (q1.isEmpty()) {
//			System.out.println("stack is empty..");
//			throw new Exception("stack is empty");
//		}
		return q1.pop();
	}
	
	public int top() {
//		System.out.println("top element of the stack..");
//		if (q1.isEmpty()) {
//			System.out.println("stack is empty..");
//			throw new Exception("stack is empty");
//		}
		return q1.peek();
	}
	
	public boolean empty() {
//		System.out.println("is stack empty..");
		return q1.isEmpty();
	}
	
	public static void main(String[] args) {
		StackUsingQueue1 obj = new StackUsingQueue1();
		obj.push(4);
		obj.push(10);
		obj.push(8);
		obj.push(2);
		obj.push(6);
		System.out.println(obj.q1);
		
		try {
			System.out.println(obj.pop());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(obj.q1);
		
		obj.push(5);
		System.out.println(obj.q1);
	}
}
