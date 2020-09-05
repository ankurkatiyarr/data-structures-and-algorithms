package d.c.generic.stack.impl;

public class GenericStackNode<T> {
	public T data;
	public GenericStackNode<T> next;

	public GenericStackNode() {
	}

	public GenericStackNode(T data) {
		super();
		this.data = data;
	}

	@Override
	public String toString() {
		return data + "]";
	}

}
