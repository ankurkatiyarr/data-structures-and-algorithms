package c.b.udemy.circular.linked.list;

public class CLLNode {
	public int data;
	public CLLNode next;

	public CLLNode() {
		super();
	}

	public CLLNode(int data) {
		super();
		this.data = data;
	}

	@Override
	public String toString() {
		return data + "";
	}
}
