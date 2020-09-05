package f.a.udemy.binary.tree.link.list.impl;

import java.util.LinkedList;

public class BinaryTreeImpl {
	public void preorder(BTNode root) {
		if (root != null) {
			System.out.println(root);
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	public void postorder(BTNode root) {
		if (root != null) {
			postorder(root.left);
			postorder(root.right);
			System.out.println(root);
		}
	}
	
	public void inorder(BTNode root) {
		if (root != null) {
			inorder(root.left);
			System.out.println(root);
			inorder(root.right);
		}
	}
	
	public void levelorder(BTNode root) {
		if (root == null) {
			System.out.println("Empty list");
			return;
		}
		LinkedList<BTNode> queue = new LinkedList<>();
		queue.add(root);
		
		BTNode temp = null;
		while (!queue.isEmpty()) {
			temp = queue.pop();
			System.out.println(temp);
			if (temp.left != null) {
				queue.add(temp.left);
			}
			if (temp.right != null) {
				queue.add(temp.right);
			}
		}
	}
	
	public BTNode insert(int data, BTNode root) {
		System.out.println("inserting " + data + " in the binary tree..");
		if (root == null) {
			return new BTNode(data);
		}
		
		// find the node whose left or right child will be added
		LinkedList<BTNode> queue = new LinkedList<>();
		queue.add(root);
		
		BTNode temp = null;
		while (!queue.isEmpty()) {
			temp = queue.pop();
			if (temp.left != null && temp.right != null) {
				if (temp.left != null) {
					queue.add(temp.left);
				}
				if (temp.right != null) {
					queue.add(temp.right);
				}
			} else {
				break;
			}
		}
		System.out.println("temp: " + temp);
		
		if (temp.left == null) {
			temp.left = new BTNode(data);
		} else {
			temp.right = new BTNode(data);
		}
		
		return root;
	}
	
	public boolean search(int data, BTNode root) {
		System.out.println("searching " + data + " in the list..");
		if (root == null) {
			return false;
		}
		LinkedList<BTNode> queue = new LinkedList<>();
		queue.add(root);
		
		BTNode temp = null;
		while (!queue.isEmpty()) {
			temp = queue.pop();
			if (temp.data == data) {
				return true;
			}
			if (temp.left != null) {
				queue.add(temp.left);
			}
			if (temp.right != null) {
				queue.add(temp.right);
			}
		}
		return false;
	}
	
	public void delete(int data, BTNode root) {
		System.out.println("deleting " + data + " from the list..");
		// if binary tree is empty
		if (root == null) {
			System.out.println("binary tree is empty..");
			return;
		}
		
		// find deepest node
		LinkedList<BTNode> queue = new LinkedList<>();
		queue.add(root);

		BTNode deepest = null;
		while (!queue.isEmpty()) {
			deepest = queue.pop();
			if (deepest.left != null) {
				queue.add(deepest.left);
			}
			if (deepest.right != null) {
				queue.add(deepest.right);
			}
		}
		System.out.println("deepest: " + deepest);
		
		// delete the deepest node
		BTNode temp = null;
		queue.add(root);
		while (!queue.isEmpty()) {
			temp = queue.pop();
			if (temp.left != null) {
				if (temp.left.data == deepest.data) {
					temp.left = null;
				} else {
					queue.add(temp.left);
				}
			}
			if (temp.right != null) {
				if (temp.right.data == deepest.data) {
					temp.right = null;
				} else {
					queue.add(temp.right);
				}
			}
		}
		
		// replace it with the element to be deleted
		queue.add(root);
		while (!queue.isEmpty()) {
			temp = queue.pop();
			if (data == temp.data) {
				temp.data = deepest.data;
			}
			if (temp.left != null) {
				queue.add(temp.left);
			}
			if (temp.right != null) {
				queue.add(temp.right);
			}
		}
	}
	
	public static void main(String[] args) {
		BTNode root = null;
		BinaryTreeImpl impl = new BinaryTreeImpl();
		
		root = impl.insert(11, root);
		impl.preorder(root);
		
		root = impl.insert(20, root);
		root = impl.insert(17, root);
		root = impl.insert(12, root);
		root = impl.insert(8, root);
		root = impl.insert(2, root);
		root = impl.insert(6, root);
		root = impl.insert(5, root);
		root = impl.insert(14, root);
		System.out.println("preorder traversal..");
		impl.preorder(root);
		
		System.out.println("inorder traversal..");
		impl.inorder(root);
		
		System.out.println("postorder traversal..");
		impl.postorder(root);
		
		System.out.println("levelorder traversal..");
		impl.levelorder(root);
		
		System.out.println(impl.search(8, root));
		System.out.println(impl.search(11, root));
		System.out.println(impl.search(14, root));
		System.out.println(impl.search(6, root));
		System.out.println(impl.search(22, root));
		
		impl.delete(20, root);
		System.out.println("levelorder traversal..");
		impl.levelorder(root);
		
		impl.delete(5, root);
		System.out.println("levelorder traversal..");
		impl.levelorder(root);
		
		impl.delete(11, root);
		System.out.println("levelorder traversal..");
		impl.levelorder(root);
	}
}
