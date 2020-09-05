package e.b.udemy.queue.link.list.impl;

public class QueueNode {
	public int data;
	public QueueNode next;

	public QueueNode() {
		super();
	}

	public QueueNode(int data) {
		super();
		this.data = data;
	}

	@Override
	public String toString() {
		return data + "";
	}

}
