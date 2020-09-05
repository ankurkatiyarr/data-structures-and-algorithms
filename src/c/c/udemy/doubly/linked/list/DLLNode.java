package c.c.udemy.doubly.linked.list;

public class DLLNode {
	public int data;
	public DLLNode next;
	public DLLNode prev;

	public DLLNode() {
		super();
	}

	public DLLNode(int data) {
		super();
		this.data = data;
	}

	@Override
	public String toString() {
		return data + "";
	}

}
