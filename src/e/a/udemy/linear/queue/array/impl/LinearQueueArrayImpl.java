package e.a.udemy.linear.queue.array.impl;

public class LinearQueueArrayImpl {
	private static int queueSize = 5;
	private static int[] queue = new int[queueSize];
	private static int head = 0;
	private static int tail = -1;
	
	public static void enque(int data) {
		System.out.println("pushing " + data + " into the queue..");
		// if queue is full
		if (tail + 1 == queueSize) {
			System.out.println("Queue is full..");
			return;
		}
		tail = tail + 1;
		queue[tail] = data;
	}
	
	public static void print() {
		if (tail == -1) {
			System.out.println("Empty queue..");
			return;
		}
		System.out.println("printing list..");
		for (int i = (head == -1) ? 0 : head; i <= tail; i++) {
			System.out.print(queue[i] + " ");
		}
		System.out.println();
	}
	
	public static void dequeue() {
		// if queue is empty
		if (tail == -1) {
			System.out.println("Empty queue..");
			return;
		}
		System.out.println("Dequeue element: " + queue[head]);
		head++;
	}
	
	public static void peek() {
		// if queue is empty
		if (tail == -1) {
			System.out.println("Empty queue..");
			return;
		}
		System.out.println("Top element: " + queue[head]);
	}
	
	public static boolean isEmpty() {
		return tail == -1;
	}
	
	public static boolean isFull() {
		return tail + 1 == queueSize;
	}
	
	public static void main(String[] args) {
		System.out.println(isEmpty());
		print();
		enque(5);
		enque(2);
		enque(10);
		enque(8);
		print();
		dequeue();
		print();
		dequeue();
		print();
		peek();
		System.out.println(isEmpty());
		enque(2);
		enque(11);
		print();
		enque(12);
		print();
	}
}
