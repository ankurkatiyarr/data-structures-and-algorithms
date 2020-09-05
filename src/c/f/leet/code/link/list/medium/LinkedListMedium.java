package c.f.leet.code.link.list.medium;

public class LinkedListMedium {
	private void traverse(ListNode head) {
		System.out.println("Traversing the list..");
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		System.out.println();
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
	
    // https://leetcode.com/problems/rotate-list/
    public ListNode rotateRight(ListNode head, int k) {
    	System.out.println("rotating right by " + k);
    	if (head == null || head.next == null) {
			return head;
		}
    	int size = getSize(head);
    	
    	int x;
    	if (k >= size) {
			x = size - k % size - 1;
		} else {
			x = size - k - 1;
		}
    	
    	ListNode curr = head;
    	for (int i = 0; i < x; i++) {
			curr = curr.next;
		}

    	tempRoot = head;
    	head = rotateRightRec(curr);
        return head;
    }

	ListNode tempRoot = null;
    private ListNode rotateRightRec(ListNode curr) {
    	System.out.println("curr: " + curr);
    	if (curr == null || curr.next == null) {
			return tempRoot;
		}
    	
    	ListNode nextNode = curr.next;
    	curr.next = null;
    	
    	rotateRightRec(nextNode);
    	tempRoot = insertAtBegin(tempRoot, nextNode.val);
		return tempRoot;
	}

    // https://leetcode.com/problems/add-two-numbers/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long l1Sum = llToNumber(l1);
        long l2Sum = llToNumber(l2);
    	
        long sum = l1Sum + l2Sum;
        System.out.println("l1Sum: " + l1Sum + " l2Sum: " + l2Sum + " sum: " + sum);
        
        ListNode first = numberToLL(sum);
    	return first;
    }

	private ListNode numberToLL(long data) {
		char[] arr = (data + "").toCharArray();
		ListNode first = null;
		
		for (char c : arr) {
			first = insertAtBegin(first, Character.getNumericValue(c));
		}
		
		return first;
	}

	private long llToNumber(ListNode head) {
		sum = 0;
		llToNumberRec(head, 1);
		return sum;
	}

	long sum = 0;
	private void llToNumberRec(ListNode curr, long counter) {
		if (curr == null) {
			return;
		}
		llToNumberRec(curr.next, counter * 10);
		sum = sum + curr.val * counter;
	}

	// https://leetcode.com/problems/remove-nth-node-from-end-of-list/
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	System.out.println("removeNthFromEnd started with n: " + n);
        size = 0;
        counter = 0;
        removeNthFromEndRec(head, n);
    	if (size == n) {
			head = head.next;
		}
    	return head;
    }

	int size = 0;
    int counter = 0;
    private void removeNthFromEndRec(ListNode curr, int n) {
    	if (curr == null) {
			return;
		}
    	removeNthFromEndRec(curr.next, n);
    	counter = counter + 1;
    	size = size + 1;
    	if (counter == (n + 1)) {
			curr.next = curr.next.next;
		}
	}

    // https://leetcode.com/problems/reorder-list/
    public void reorderList(ListNode head) {
    	System.out.println("reordering list..");
        if (head == null || head.next == null) {
			return;
		}
        int size = getSize(head);
		rlCounter = size / 2;
        insertPos = 2;
        reorderListRec(head, null, head);
    }
    
	int rlCounter = 0;
    int insertPos = 0;
    private void reorderListRec(ListNode curr, ListNode prev, ListNode head) {
    	if (curr == null) {
			return;
		}
    	reorderListRec(curr.next, curr, head);
    	if (rlCounter > 0) {
			rlCounter = rlCounter - 1;
			prev.next = prev.next.next;
			head = insertAtPosition(head, insertPos, curr.val);
			insertPos = insertPos + 2;
		}
	}

	private ListNode insertAtPosition(ListNode head, int pos, int data) {
		int size = getSize(head);
		if (pos > (size + 1)) {
			return head;
		}
		
		ListNode temp = head;
		for (int i = 1; i < pos - 1; i++) {
			temp = temp.next;
		}
		
		ListNode newnode = new ListNode(data);
		newnode.next = temp.next;
		temp.next = newnode;
		
		return head;
	}

	public static void main(String[] args) {
		LinkedListMedium impl = new LinkedListMedium();
		
		ListNode head = null;
		head = impl.insertAtBegin(head, 5);
		head = impl.insertAtBegin(head, 4);
		head = impl.insertAtBegin(head, 3);
		head = impl.insertAtBegin(head, 2);
		head = impl.insertAtBegin(head, 1);
		impl.traverse(head);

//		impl.reorderList(head);
//		impl.traverse(head);
		
//		head = impl.removeNthFromEnd(head, 1);
//		impl.traverse(head);
		
//		ListNode head1 = null;
//		head1 = impl.insertAtBegin(head1, 9);
//		impl.traverse(head1);
//		
//		ListNode head2 = null;
//		head2 = impl.insertAtBegin(head2, 9);
//		head2 = impl.insertAtBegin(head2, 9);
//		head2 = impl.insertAtBegin(head2, 9);
//		head2 = impl.insertAtBegin(head2, 9);
//		head2 = impl.insertAtBegin(head2, 9);
//		head2 = impl.insertAtBegin(head2, 9);
//		head2 = impl.insertAtBegin(head2, 9);
//		head2 = impl.insertAtBegin(head2, 9);
//		head2 = impl.insertAtBegin(head2, 9);
//		head2 = impl.insertAtBegin(head2, 1);
//		impl.traverse(head2);
//		
//		ListNode first = impl.addTwoNumbers(head1, head2);
//		impl.traverse(first);

	}
}
