package d.b.udemy.stack.linked.list.impl;

public class StackNode {
	public int data;
	public StackNode next;

	public StackNode() {
		super();
	}

	public StackNode(int data) {
		super();
		this.data = data;
	}

	@Override
	public String toString() {
		return data + "";
	}
}
