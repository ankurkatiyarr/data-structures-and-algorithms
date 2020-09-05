package f.c.leet.code.binary.search.tree.easy;

import java.util.LinkedList;

public class BSTImpl {
	public void inorderTraversal(TreeNode root) {
		if (root != null) {
			inorderTraversal(root.left);
			System.out.println(root);
			inorderTraversal(root.right);
		}
	}

	public void preOrderTraversal(TreeNode root) {
		if (root != null) {
			System.out.println(root);
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);
		}
	}

	public void postOrderTraversal(TreeNode root) {
		if (root != null) {
			postOrderTraversal(root.left);
			postOrderTraversal(root.right);
			System.out.println(root);
		}
	}
	
	public TreeNode search(TreeNode root, int value) {
		System.out.println("searching " + value + " in bst");
		if (root == null) {
			System.out.println("Empty bst..");
			return null;
		}
		while (root != null) {
			if (root.val == value) {
				return root;
			} else if (root.val > value) {
				root = root.left;
			} else {
				root = root.right;
			}
		}
		return null;
	}
	
	public TreeNode insert(TreeNode root, int value) {
		System.out.println("inserting " + value + " in the bst..");
		if (root == null) {
			return new TreeNode(value);
		}
		if (this.search(root, value) != null) {
			System.out.println(value + " is already present in the bst..");
			return root;
		}
		TreeNode temp = root;
		while (temp != null) {
			if (value < temp.val) {
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
		
		if (temp.val > value) {
			temp.left = new TreeNode(value);
		} else {
			temp.right = new TreeNode(value);
		}
		return root;
	}

	public void levelOrderTraversal(TreeNode root) {
		System.out.println("level order traversal started..");
		if (root == null) {
			return;
		}

		LinkedList<TreeNode> queue = new LinkedList<>();
		TreeNode temp = null;
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

	// https://leetcode.com/problems/range-sum-of-bst/
    public int rangeSumBST(TreeNode root, int L, int R) {
    	rangeSumBSTResult = 0;
        rangeSumBSTRec(root, L, R);
        return rangeSumBSTResult;
    }
    
    int rangeSumBSTResult = 0;
    private void rangeSumBSTRec(TreeNode root, int L, int R) {
        if (root != null) {
        	rangeSumBSTRec(root.left, L, R);
        	rangeSumBSTRec(root.right, L, R);
        	if (root.val <= R && root.val >= L) {
        		rangeSumBSTResult = rangeSumBSTResult + root.val;
			}
		}
    }
    
    // https://leetcode.com/problems/merge-two-binary-trees/
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return null;
    }

	public static void main(String[] args) {
		BSTImpl impl = new BSTImpl();
		TreeNode root = null;
		root = impl.insert(root, 50);
		root = impl.insert(root, 70);
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
		
	}
}
