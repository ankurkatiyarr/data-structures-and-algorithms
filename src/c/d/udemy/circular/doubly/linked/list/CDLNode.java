package c.d.udemy.circular.doubly.linked.list;

public class CDLNode {
	public int data;
	public CDLNode prev;
	public CDLNode next;

	public CDLNode() {
		super();
	}

	public CDLNode(int data) {
		super();
		this.data = data;
	}

	@Override
	public String toString() {
		return data + "";
	}

}
