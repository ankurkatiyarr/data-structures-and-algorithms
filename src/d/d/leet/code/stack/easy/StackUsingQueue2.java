package d.d.leet.code.stack.easy;

import java.util.LinkedList;

/*
 *  https://leetcode.com/problems/implement-stack-using-queues/#
 *  Insertion - O(1)
 *  Pop - O(n)
 */
public class StackUsingQueue2 {
	public LinkedList<Integer> q1 = new LinkedList<>();
	public LinkedList<Integer> q2 = new LinkedList<>();
	
	public void push(int x) {
		System.out.println("inserting " + x + " into the stack..");
		q1.push(x);
	}
	
	public int pop() {
		System.out.println("popping element from the stack..");
		int result = 0;
		
		// move (n - 1) elements from q1 to q2
		while (!q1.isEmpty()) {
			int x = q1.pop();
			if (!q1.isEmpty()) {
				q2.push(x);
			} else {
				result = x;
			}
		}
		
		// move elements from q2 to q1
		while (!q2.isEmpty()) {
			q1.push(q2.pop());
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		StackUsingQueue2 obj = new StackUsingQueue2();
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
