package e.c.udemy.generic.queue;

public class GenericQueueNode<T> {
	public T data;
	public GenericQueueNode<T> next;

	public GenericQueueNode() {
	}

	public GenericQueueNode(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return data + "";
	}
}
