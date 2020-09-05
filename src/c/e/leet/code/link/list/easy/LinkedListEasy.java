package c.e.leet.code.link.list.easy;

import java.util.HashMap;
import java.util.Map;

public class LinkedListEasy {
	@SuppressWarnings("unused")
	private void traverse(ListNode head) {
		System.out.println("Traversing the list..");
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	private ListNode addAtEnd(ListNode head, int val) {
		System.out.println("adding " + val + " in the list..");
		if (head == null) {
			return new ListNode(val);
		}
		
		ListNode temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		
		ListNode newnode = new ListNode(val);
		temp.next = newnode;
		return head;
	}
	
	private ListNode insertAtBegin(ListNode head, int data) {
		System.out.println("inserting " + data + " at the begin..");
		if (head == null) {
			return new ListNode(data);
		}
		ListNode newnode = new ListNode(data);
		newnode.next = head;
		head = newnode;
		return head;
	}
	
	// print the list recursively
	@SuppressWarnings("unused")
	private void printRec(ListNode head) {
		if (head == null) {
			return;
		}
		System.out.println(head.val);
		printRec(head.next);
	}
	
	// reverse print the list recursively
	@SuppressWarnings("unused")
	private void reversePrintRec(ListNode head) {
		if (head == null) {
			return;
		}
		reversePrintRec(head.next);
		System.out.println(head.val);
	}

	// https://leetcode.com/problems/remove-linked-list-elements/
    public ListNode removeElements(ListNode head, int val) {
    	System.out.println("Removing " + val + " from the list..");
        if (head == null) {
			return null;
		}
        if (head.next == null && head.val == val) {
			return null;
		}
        
        ListNode temp = head;
        ListNode prev = null;
        
        while (temp != null) {
        	if (temp.val == val) {
				if (prev == null) {
					head = head.next;
					temp = temp.next;
				} else {
					prev.next = temp.next;
					temp = temp.next;
				}
			} else {
				prev = temp;
				temp = temp.next;
			}
        }
        return head;
    }

    // https://leetcode.com/problems/palindrome-linked-list/
    public boolean isPalindrome(ListNode head) {
    	System.out.println("Checking if list is palindrome..");
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
        	count = count + 1;
        	temp = temp.next;
        }
        
        int[] arr = new int[count];
        int i = 0;
        temp = head;
        while (temp != null) {
        	arr[count - i - 1] = temp.val;
        	temp = temp.next;
        	i = i + 1;
        }
        
        temp = head;
        i = 0;
        boolean result = true;
        while (temp != null) {
        	if (temp.val != arr[i]) {
				result = false;
				break;
			}
        	temp = temp.next;
        	i = i + 1;
        }
        
        return result;
    }

    // https://leetcode.com/problems/reverse-linked-list/
    public ListNode reverseList(ListNode head) {
    	System.out.println("reversing list..");
    	if (head == null || head.next == null) {
			return head;
		}
    	ListNode t1 = null;
    	ListNode t2 = head;
    	ListNode t3 = head.next;
    	
    	while (t2 != null) {
    		t2.next = t1;
    		t1 = t2;
    		t2 = t3;
    		if (t3 == null) {
				break;
			} else {
				t3 = t3.next;
			}
    	}
    	return t1;
    }

    // Reverse a link using recursion
	ListNode root;
    public ListNode reverse(ListNode head) {
    	System.out.println("reversing the list recursively..");
    	if (head == null || head.next == null) {
			return head;
		}
    	reverseRec(head);
    	return root;
    }
	
	private void reverseRec(ListNode curr) {
		if (curr.next == null) {
			root = curr;
			return;
		}
		reverseRec(curr.next);
		curr.next = null;
		root = addAtEnd(root, curr.val);
	}
	
	// Reverse a link using recursion (Better way)
	public ListNode rev(ListNode curr) {
		if (curr == null || curr.next == null) {
			return curr;
		}
		ListNode nextNode = curr.next;
		curr.next = null;
		ListNode temp = rev(nextNode);
		nextNode.next = curr;
		return temp;
	}
	
	// with O(n) time complexity and O(1) space complexity
	public boolean isPalindromeBetter(ListNode head) {
		System.out.println("check if it is palindrome..");
		if (head == null) {
			return false;
		}
		if (head.next == null) {
			return true;
		}
		int size = getSize(head);
		ListNode prev = getPrev(head, size);
		ListNode curr = prev.next;
		
		prev.next = null;
		prev.next = rev(curr);
		
		boolean result = comparePalindrome(head, prev);
		return result;
	}
	
	private boolean comparePalindrome(ListNode head, ListNode prev) {
		System.out.println("comparePalindrome started with head: " + head + " and prev: " + prev);
		ListNode p1 = head;
		ListNode p2 = prev.next;
		boolean result = true;
		
		while (p2 != null) {
			if (p1.val != p2.val) {
				result = false;
				break;
			}
			p1 = p1.next;
			p2 = p2.next;
		}
		return result;
	}

	private ListNode getPrev(ListNode head, int size) {
		int mid = size % 2 == 0 ? size / 2 : (size / 2 + 1);
		ListNode prev = head;
		for (int i = 1; i < mid; i++) {
			prev = prev.next;
		}
		return prev;
	}

	private int getSize(ListNode head) {
		ListNode temp = head;
		int count = 0;
		while (temp != null) {
			count = count + 1;
			temp = temp.next;
		}
		return count;
	}
	
	// https://leetcode.com/problems/linked-list-cycle/
	public boolean hasCycle(ListNode head) {
    	if (head == null || head.next == null) {
			return false;
		}
    	
        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;
        
        while(fast != null) {
        	slow = slow.next;
        	fast = fast.next;
        	if (fast != null) {
				fast = fast.next;
			} else {
				break;
			}
        	
        	if (slow == fast) {
				hasCycle = true;
				break;
			}
        }
        return hasCycle;
    }

    // https://leetcode.com/problems/intersection-of-two-linked-lists/
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	if (headA == null || headB == null) {
			return null;
		}
    	
    	int aLength = getSize(headA);
    	int bLength = getSize(headB);
    	int diff = aLength > bLength ? (aLength - bLength) : (bLength - aLength);
    	
    	if (aLength > bLength) {
			for (int i = 0; i < diff; i++) {
				headA = headA.next;
			}
		} else {
			for (int i = 0; i < diff; i++) {
				headB = headB.next;
			}
		}
    	
    	while (headA != null) {
    		if (headA == headB) {
				return headA;
			}
			headA = headA.next;
			headB = headB.next;
    	}
    	return null;
    }

    // https://leetcode.com/problems/remove-duplicates-from-sorted-list/
    public ListNode deleteDuplicates(ListNode head) {
    	System.out.println("deleting duplicates from the list..");
        if (head == null || head.next == null) {
			return head;
		}
    	ListNode prev = head;
    	ListNode curr = head.next;
    	
    	Map<Integer, String> map = new HashMap<>();
    	map.put(prev.val, "abc");
    	
    	while (curr != null) {
    		if (map.get(curr.val) != null) {
				prev.next = curr.next;
				curr = curr.next;
			} else {
				map.put(curr.val, "abc");
	    		prev = prev.next;
	    		curr = curr.next;
			}
    	}
    	return head;
    }
    
	public static void main(String[] args) {
		LinkedListEasy impl = new LinkedListEasy();

		ListNode head = null;
		head = impl.insertAtBegin(head, 5);
		head = impl.insertAtBegin(head, 4);
		head = impl.insertAtBegin(head, 3);
		head = impl.insertAtBegin(head, 2);
		head = impl.insertAtBegin(head, 1);
		impl.traverse(head);
				
//		head1 = impl.rotateRight(head1, 0);
//		impl.traverse(head1);
		
//		head = impl.deleteDuplicates(head);
//		impl.traverse(head);
		
//		head = impl.reverse(head);
//		impl.traverse(head);
		
//		head = impl.rev(head);
//		impl.traverse(head);
		
//		impl.traverse(head);
//		impl.printRec(head);
//		impl.reversePrintRec(head);
		
//		head = impl.removeElements(head, 6);
//		impl.traverse(head);
		
//		System.out.println(impl.isPalindrome(head));
//		System.out.println(impl.isPalindromeBetter(head));
		
//		head = impl.reverseList(head);
//		impl.traverse(head);
		
//		head = impl.reverse(head);
//		impl.traverse(head);
		
//		ListNode juncNode = new ListNode(8);
//		
//		ListNode headA = juncNode;
////		headA.next = new ListNode(4);
////		headA.next.next = new ListNode(5);
//		impl.traverse(headA);
//		
//		ListNode headB = new ListNode(4);
////		headB.next = new ListNode(0);
////		headB.next.next = new ListNode(1);
//		headB.next = juncNode;
////		headB.next.next.next.next = new ListNode(4);
////		headB.next.next.next.next.next = new ListNode(5);
//		impl.traverse(headB);
//		
//		ListNode intersectionNode = impl.getIntersectionNode(headA, headB);
//		System.out.println("intersectionNode: " + intersectionNode);
	}
}
