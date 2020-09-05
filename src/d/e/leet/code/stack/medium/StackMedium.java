package d.e.leet.code.stack.medium;

import java.util.Iterator;
import java.util.Stack;

public class StackMedium {
	// https://leetcode.com/problems/decoded-string-at-index/
    public String decodeAtIndex(String S, int K) {
        if (S == null || S.isEmpty()) {
			return S;
		}
        
        StringBuilder sb = new StringBuilder("");
    	char[] arr = S.toCharArray();
    	
    	for (int i = 0; i < arr.length; i++) {
			if (Character.isLetter(arr[i])) {
				sb.append(arr[i]);
			} else if (Character.isDigit(arr[i])) {
				StringBuilder temp = new StringBuilder(sb);
				for (int j = 1; j < Character.getNumericValue(arr[i]); j++) {
					sb.append(temp);
				}
			}
		}
    	
    	try {
    		char ch = sb.charAt(K - 1);
    		return ch + "";
    	} catch (Exception e) {
			return null;
		}
    }
    
    // https://leetcode.com/problems/remove-k-digits/
    public String removeKdigits(String num, int k) {
    	int[] arr = convertToArray(num);
    	
    	int arrSize = arr.length;
    	if (arrSize == k) {
			return "0";
		}
    	int currStackSize = 0;
    	int maxStackSize = arrSize - k;
    	
    	Stack<StackNode> stack = new Stack<>();
    	stack.push(new StackNode(arr[0], 0));
		currStackSize++;
		
		int result = Integer.MAX_VALUE;
		while (currStackSize != 0) {
			StackNode peek = stack.peek();
			if ((currStackSize != maxStackSize) && (peek.index != (arrSize - 1))) {
				stack.push(new StackNode(arr[peek.index + 1], peek.index + 1));
				currStackSize++;
				continue;
			} else {
//				System.out.println(stack);
				result = compare(stack, result, currStackSize, maxStackSize);
//				System.out.println("result: " + result);
				if (peek.index != (arrSize - 1)) {
					stack.pop();
					stack.push(new StackNode(arr[peek.index + 1], peek.index + 1));
					continue;
				} else {
					stack.pop();
					try {
						StackNode pop = stack.pop();
						stack.push(new StackNode(arr[pop.index + 1], pop.index + 1));
					} catch (Exception e) {}
					currStackSize--;
					continue;
				}
			}
		}
    	return result + "";
    }
	
	private int compare(Stack<StackNode> stack, int result, int currStackSize, int maxStackSize) {
		if (currStackSize != maxStackSize) {
			return result;
		} else {
			int sum = 0;
			int multiplier = (int) Math.pow(10, currStackSize - 1);
			
			for (Iterator<StackNode> iterator = stack.iterator(); iterator.hasNext();) {
				StackNode stackNode = (StackNode) iterator.next();
				sum = sum + (stackNode.data * multiplier);
				multiplier = multiplier/10;
			}
			return sum < result ? sum : result;
		}
	}

	private int[] convertToArray(String num) {
		char[] charArr = num.toCharArray();
		int size = num.length();
		int[] result = new int[size];
		
		for (int i = 0; i < size; i++) {
			result[i] = Character.getNumericValue(charArr[i]);
		}
		return result;
	}

	// https://leetcode.com/problems/132-pattern/
    public boolean find132pattern(int[] nums) {
        int arrSize = nums.length;
        if (arrSize < 3) {
			return false;
		}
        
        for (int i = 0; i < nums.length; i++) {
			boolean flag = false;
			for (int j = i; j < arrSize; j++) {
				if (nums[j] > nums[i]) {
					if (!flag) {
						flag = true;
					} else {
						for (int k = i; k < j; k++) {
							if (nums[k] > nums[i] && nums[k] > nums[j]) {
								System.out.println(nums[i] + " " + nums[k] + " " + nums[j]);
								return true;
							}
						}
					}
				}
			}
		}
    	return false;
    }
    
    public int sumSubarrayMins(int[] A) {
        int sum = 0;
    	for (int i = 0; i < A.length; i++) {
			Stack<Integer> stack = new Stack<>();
			for (int j = i; j < A.length; j++) {
				stack.push(A[j]);
				sum = sum + minInStack(stack);
			}
		}
    	return sum;
    }

	private int minInStack(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			return 0;
		}
		int result = stack.peek();
		for (Iterator<Integer> iterator = stack.iterator(); iterator.hasNext();) {
			Integer number = (Integer) iterator.next();
			if (number < result) {
				result = number;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		StackMedium impl = new StackMedium();
		int[] arr = {3, 1, 2, 4};
		System.out.println(impl.sumSubarrayMins(arr));
		
//		int[] arr = {1, 2, 3, 4};
//		int[] arr = {3, 1, 4, 2};
//		int[] arr = {1, 4, 2, 6};
//		int[] arr = {3, 5, 0, 3, 4};
//		int[] arr = {18, 3, 0, 2, 4, 8, 1};
//		System.out.println(impl.find132pattern(arr));
		
//		System.out.println(impl.removeKdigits("10200", 1));
//		System.out.println(impl.decodeAtIndex("leet2code3", 10));
//		System.out.println(impl.decodeAtIndex("ha22", 5));
	}
}
