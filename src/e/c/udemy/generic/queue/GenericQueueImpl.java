package e.c.udemy.generic.queue;

import java.util.LinkedList;
import java.util.Queue;

public class GenericQueueImpl<T> {
	private GenericQueueNode<T> head;
	private GenericQueueNode<T> tail;
	
	public void print() {
		System.out.println("printing list..");
		GenericQueueNode<T> temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public void enqueue(T data) {
		System.out.println("enqueue " + data);
		if (head == null) {
			head = new GenericQueueNode<>(data);
			tail = head;
			return;
		}
		GenericQueueNode<T> newnode = new GenericQueueNode<>(data);
		tail.next = newnode;
		tail = newnode;
	}
	
	public void deque() {
		if (head == null) {
			System.out.println("queue is empty..");
			return;
		}
		System.out.println("deque: " + head.data);
		head = head.next;
	}
	
	public static void main(String[] args) {
		GenericQueueImpl<Integer> intImpl = new GenericQueueImpl<>();
		intImpl.print();
		
		intImpl.enqueue(5);
		intImpl.print();
		
		intImpl.enqueue(8);
		intImpl.enqueue(10);
		intImpl.enqueue(2);
		intImpl.print();
		
		intImpl.deque();
		intImpl.print();
		
		Queue<Integer> queue = new LinkedList<>();
	}
}
