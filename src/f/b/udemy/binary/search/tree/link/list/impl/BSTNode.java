package f.b.udemy.binary.search.tree.link.list.impl;

public class BSTNode {
	public int data;
	public BSTNode left;
	public BSTNode right;

	public BSTNode() {
		super();
	}

	public BSTNode(int data) {
		super();
		this.data = data;
	}

	@Override
	public String toString() {
		return data + "";
	}
}
