package f.a.udemy.binary.tree.link.list.impl;

public class BTNode {
	public int data;
	public BTNode left;
	public BTNode right;

	public BTNode() {
		super();
	}

	public BTNode(int data) {
		super();
		this.data = data;
	}

	@Override
	public String toString() {
		return data + " ";
	}
}
