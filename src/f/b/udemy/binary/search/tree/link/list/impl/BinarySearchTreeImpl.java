package f.b.udemy.binary.search.tree.link.list.impl;

import java.util.LinkedList;

public class BinarySearchTreeImpl {
	public void inorderTraversal(BSTNode root) {
		if (root != null) {
			inorderTraversal(root.left);
			System.out.println(root);
			inorderTraversal(root.right);
		}
	}
	
	public void preOrderTraversal(BSTNode root) {
		if (root != null) {
			System.out.println(root);
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);
		}
	}
	
	public void postOrderTraversal(BSTNode root) {
		if (root != null) {
			postOrderTraversal(root.left);
			postOrderTraversal(root.right);
			System.out.println(root);
		}
	}
	
	public void levelOrderTraversal(BSTNode root) {
		System.out.println("level order traversal started..");
		if (root == null) {
			return;
		}
		
		LinkedList<BSTNode> queue = new LinkedList<>();
		BSTNode temp = null;
		queue.add(root);
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
	
	public BSTNode search(BSTNode root, int value) {
		System.out.println("searching " + value + " in bst");
		if (root == null) {
			System.out.println("Empty bst..");
			return null;
		}
		while (root != null) {
			if (root.data == value) {
				return root;
			} else if (root.data > value) {
				root = root.left;
			} else {
				root = root.right;
			}
		}
		return null;
	}
	
	public BSTNode searchRec(BSTNode root, int value) {
		return null;
	}
	
	public BSTNode insert(BSTNode root, int value) {
		System.out.println("inserting " + value + " in the bst..");
		if (root == null) {
			return new BSTNode(value);
		}
		if (this.search(root, value) != null) {
			System.out.println(value + " is already present in the bst..");
			return root;
		}
		BSTNode temp = root;
		while (temp != null) {
			if (value < temp.data) {
				if (temp.left != null) {
					temp = temp.left;
				} else {
					break;
				}
			} else {
				if (temp.right != null) {
					temp = temp.right;
				} else {
					break;
				}
			}
		}
		
		if (temp.data > value) {
			temp.left = new BSTNode(value);
		} else {
			temp.right = new BSTNode(value);
		}
		return root;
	}
	
	public void delete(int value, BSTNode root) {
		System.out.println("deleting " + value + " from the list");
		if (root == null) {
			System.out.println("list is empty..");
			return;
		}
		
		BSTNode nodeToBeDeleted = null;
		BSTNode parent = null;
		BSTNode temp = root;
		while (temp != null) {
			if (value == temp.data) {
				nodeToBeDeleted = temp;
				break;
			} else if (value < temp.data) {
				parent = temp;
				temp = temp.left;
			} else {
				parent = temp;
				temp = temp.right;
			}
		}
		System.out.println("nodeToBeDeleted: " + nodeToBeDeleted);
		System.out.println("parent: " + parent);
		
		if (nodeToBeDeleted == null) {
			System.out.println(value + " not found in the bst..");
			return;
		}
		
		// where node to be deleted is a leaf node
		if (nodeToBeDeleted.left == null && nodeToBeDeleted.right == null) {
			if (parent.left.data == nodeToBeDeleted.data) {
				parent.left = null;
			} else {
				parent.right = null;
			}
			return;
		}
		
		// where node to be deleted has one child
		if (nodeToBeDeleted.left == null && nodeToBeDeleted.right != null) { // where node to be deleted has one right child
			if (parent.left.data == nodeToBeDeleted.data) {
				parent.left = nodeToBeDeleted.right;
			} else {
				parent.right = nodeToBeDeleted.right;
			}
			return;
		}
		if (nodeToBeDeleted.left != null && nodeToBeDeleted.right == null) { // where node to be deleted has one left child
			if (parent.left.data == nodeToBeDeleted.data) {
				parent.left = nodeToBeDeleted.left;
			} else {
				parent.right = nodeToBeDeleted.left;
			}
			return;
		}
		
		// where node to be deleted has two children
		if (nodeToBeDeleted.left != null && nodeToBeDeleted.right != null) {
			BSTNode predecessor = this.predecessor(root, value);
			delete(predecessor.data, root);
			nodeToBeDeleted.data = predecessor.data;
		}
	}
	
	BSTNode predecessor;
	public BSTNode predecessor(BSTNode root, int value) {
		// check if the value is present in the bst
		if (search(root, value) == null) {
			System.out.println(value + " not present in the bst");
			return null;
		}

		predecessor = null; // reset the value
		predecessorRec(root, value);
		
		return predecessor.data == value ? null : predecessor;
	}
	
	public void predecessorRec(BSTNode bstNode, int value) {
		if (bstNode != null) {
			predecessorRec(bstNode.left, value);
			if (predecessor == null) {
				predecessor = bstNode;
			} else {
				if (bstNode.data < value && bstNode.data > predecessor.data) {
					predecessor = bstNode;
				}
			}
			predecessorRec(bstNode.right, value);
		}
	}
	
	public static void main(String[] args) {
		BinarySearchTreeImpl impl = new BinarySearchTreeImpl();
		BSTNode root = null;
		
		root = impl.insert(root, 50);
//		impl.inorderTraversal(root);
		root = impl.insert(root, 70);
//		System.out.println("inorder traversal");
//		impl.inorderTraversal(root);
		
		root = impl.insert(root, 60);
		root = impl.insert(root, 65);
		root = impl.insert(root, 80);
		root = impl.insert(root, 40);
		root = impl.insert(root, 30);
		root = impl.insert(root, 20);
		root = impl.insert(root, 40);
		root = impl.insert(root, 35);
		root = impl.insert(root, 34);
		root = impl.insert(root, 55);
		root = impl.insert(root, 62);
		root = impl.insert(root, 75);
		root = impl.insert(root, 90);
//		System.out.println("inorder traversal");
//		impl.inorderTraversal(root);
		
//		System.out.println("preOrderTraversal traversal");
//		impl.preOrderTraversal(root);
//		
//		System.out.println("postOrderTraversal traversal");
//		impl.postOrderTraversal(root);
		
//		impl.levelOrderTraversal(root);
		
//		System.out.println(impl.search(root, 60));
//		System.out.println(impl.search(root, 35));
//		System.out.println(impl.search(root, 50));
//		System.out.println(impl.search(root, 22));
		
//		System.out.println(impl.predecessor(root, 40));
		
		impl.delete(70, root);
		System.out.println("inorder traversal");
		impl.inorderTraversal(root);
		impl.levelOrderTraversal(root);
	}
}
