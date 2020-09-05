package d.e.leet.code.stack.medium;

class StackNode {
	public int data;
	public int index;

	public StackNode() {
		super();
	}

	public StackNode(int data) {
		super();
		this.data = data;
	}

	public StackNode(int data, int index) {
		super();
		this.data = data;
		this.index = index;
	}

	@Override
	public String toString() {
		return "" + data + "-" + index;
	}

}
