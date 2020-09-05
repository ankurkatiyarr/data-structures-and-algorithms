package b.leet.code.array.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayEasy {
	// 1. https://leetcode.com/problems/find-lucky-integer-in-an-array/
	public int findLucky(int[] arr) {
		Arrays.sort(arr);
		int result = -1;
		
		for (int i = 0; i < arr.length; i++) {
			int count = 0;
			for (int j = i; j < arr.length; j++) {
				if (arr[j] == arr[i]) {
					count++;
				} else {
					break;
				}
			}
			if (count == arr[i]) {
				if (result < arr[i]) {
					result = arr[i];
				}
			} else {
				i = i + count - 1;
			}
		}
		return result;
	}
	
	// 2. https://leetcode.com/problems/shift-2d-grid/
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
    	int m = grid.length;
    	int n = grid[0].length;
    	while (k != 0) {
    		int[][] newGrid = new int[m][n];
        	
    		for (int i = 0; i < grid.length; i++) {
    			for (int j = 0; j < grid[i].length; j++) {
    				
					if (((i != (m - 1)) && (j != n - 1)) || (i == (m - 1) && (j != n - 1))) {
						newGrid[i][j + 1] = grid[i][j];
					} else if ((i != (m - 1)) && j == (n - 1)) {
						newGrid[i + 1][0] = grid[i][j];
					} else {
						newGrid[0][0] = grid[i][j];
					}
    			}
    		}
        	k = k - 1;
        	System.arraycopy(newGrid, 0, grid, 0, m);
    	}
    	
    	List<List<Integer>> result = new ArrayList<>();
    	for (int i = 0; i < m; i++) {
			List<Integer> list = new ArrayList<>();
    		for (int j = 0; j < n; j++) {
				list.add(grid[i][j]);
			}
    		result.add(list);
		}
    	return result;
    }
    
    // 3. https://leetcode.com/problems/duplicate-zeros/
    public void duplicateZeros(int[] arr) {
    	int length = arr.length;
        for (int i = 0; i < length; i++) {
			if (arr[i] == 0 && i != (length - 1)) {
				shiftByOne(arr, i + 1);
				i = i  + 1;
			}
		}
        System.out.println(Arrays.toString(arr));
    }
	
	private void shiftByOne(int[] arr, int start) {
		int temp = arr[start];
		arr[start] = 0;
		for (int i = start + 1; i < arr.length; i++) {
			int temp2 = arr[i];
			arr[i] = temp;
			temp = temp2;
		}
	}
	
	// 4. https://leetcode.com/problems/add-to-array-form-of-integer/
    public List<Integer> addToArrayForm2(int[] A, int K) {
    	List<Integer> result = new ArrayList<>();
    	int length = A.length;
        long arrToNumber = 0;
    	for (int i = 0; i < A.length; i++) {
			arrToNumber = arrToNumber + (A[i] * ((long) Math.pow(10, (length - i - 1))));
		}
    	System.out.println("arrToNumber: " + arrToNumber);
    	arrToNumber = arrToNumber + K;
     	System.out.println("arrToNumber: " + arrToNumber);
    	
    	int numberOfDigits = 1;
    	long denominator = 10;
    	while (!(arrToNumber % denominator == arrToNumber)) {
    		numberOfDigits = numberOfDigits + 1;
    		denominator = denominator * 10;
    	}
    	System.out.println("numberOfDigits: " + numberOfDigits);
    	
    	for (int i = numberOfDigits - 1; i >= 0; i--) {
    		long deno = (long) Math.pow(10, i);
    		
    		int n = (int) (arrToNumber/deno);
    		
			result.add(n);
			
			arrToNumber = arrToNumber - n*deno;
		}
    	System.out.println("result: " + result);
    	return result;
    }

    // 5. https://leetcode.com/problems/third-maximum-number/
    public int thirdMax(int[] nums) {
        int firstHeighest = Integer.MIN_VALUE;
    	for (int i = 0; i < nums.length; i++) {
			if (nums[i] > firstHeighest) {
				firstHeighest = nums[i];
			}
		}
    	System.out.println("firstHeighest: " + firstHeighest);
    	
        int secondHeighest = Integer.MIN_VALUE;
    	for (int i = 0; i < nums.length; i++) {
    		if (nums[i] == firstHeighest) {
				continue;
			}
    		if (nums[i] > secondHeighest) {
				secondHeighest = nums[i];
			}
    	}
    	System.out.println("secondHeighest: " + secondHeighest);
    	
        int thirdHeighest = Integer.MIN_VALUE;
    	for (int i = 0; i < nums.length; i++) {
    		if (nums[i] == firstHeighest || nums[i] == secondHeighest) {
				continue;
			}
    		if (nums[i] > thirdHeighest) {
    			thirdHeighest = nums[i];
			}
    	}
    	System.out.println("thirdHeighest: " + thirdHeighest);
    	
    	int result = Integer.MIN_VALUE;
    	if (thirdHeighest != Integer.MIN_VALUE) {
			result = thirdHeighest;
		} else {
			result = firstHeighest;
		}
    	
    	if (thirdHeighest == Integer.MIN_VALUE && secondHeighest == Integer.MIN_VALUE) {
    		return firstHeighest;
    	}
    	
    	if (thirdHeighest == Integer.MIN_VALUE) {
        	for (int i = 0; i < nums.length; i++) {
        		if (nums[i] == Integer.MIN_VALUE) {
					return Integer.MIN_VALUE;
				}
        	}
		}
    	
    	return result;
    }
    
    // 6. https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
    public int findUnsortedSubarray(int[] nums) {
    	System.out.println("For: " + Arrays.toString(nums));
    	int arrSize = nums.length;    	
    	int[] sortedArr = new int[arrSize];
    	System.arraycopy(nums, 0, sortedArr, 0, arrSize);
    	Arrays.sort(sortedArr);
    	
    	int count = 0;
    	
    	for (int i = 0; i < arrSize; i++) {
			if (nums[i] == sortedArr[i]) {
				count++;
			} else {
				break;
			}
		}
    	
    	for (int i = arrSize - 1; i >= 0; i--) {
			if (nums[i] == sortedArr[i]) {
				count++;
			} else {
				break;
			}
		}
    	
    	return (arrSize - count) < 0 ? 0 : (arrSize - count);
    }

    // 7. https://leetcode.com/problems/k-diff-pairs-in-an-array/
    public int findPairs(int[] nums, int k) {
    	if (k < 0) {
			return 0;
		}
    	int size = nums.length;
    	
    	Map<Integer, Integer> map = new HashMap<>();
    	
    	for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				if ((nums[i] - nums[j] == k) || (nums[j] - nums[i] == k)) {
					if (nums[i] < nums[j]) {
						map.put(nums[i], nums[j]);
					} else {
						map.put(nums[j], nums[i]);
					}
				}
			}
		}
    	
    	return map.keySet().size();
    }

    // 8. https://leetcode.com/problems/can-place-flowers/
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
    	int size = flowerbed.length;
    	int result = 0;
    	
        for (int i = 0; i < flowerbed.length; i++) {
        	// corner case 1: where first element is 0
        	if (i == 0 && flowerbed[i] == 0) {
				if (size == 1) { // 0 i.e. only one element in the array
					result = result + 1;
					flowerbed[i] = 1;
				} else { // 0, 0, 1 or 0, 0
					if (flowerbed[i + 1] == 0) {
						result = result + 1;
						flowerbed[i] = 1;
					}
				}
				continue;
			}
        	
        	if (flowerbed[i] == 0) {
            	// corner case 2: where array ends with 0
            	if (i == (size - 1)) {
					if (flowerbed[i - 1] == 0) {
						result = result + 1;
						flowerbed[i] = 1;
					}
					continue;
    			}

    			if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
    				result = result + 1;
					flowerbed[i] = 1;
					continue;
    			}
			}
		}
    	return n <= result;
    }

    // 9.1 https://leetcode.com/problems/rotate-array/
    public void rotate(int[] nums, int k) {
		while (k != 0) {
			int temp = nums[0];
			
        	for (int i = 1; i < nums.length; i++) {
				int temp2 = nums[i];
				nums[i] = temp;
				temp = temp2;
			}
        	nums[0] = temp;
        	k = k - 1;
        }
    }
    
    // 9.2 https://leetcode.com/problems/rotate-array/
    public void rotateRec(int[] nums, int k) {
    	int size = nums.length;
    	while (k != 0) {
        	rotateRec(nums, 0, size - 1, nums[0]);
        	k = k - 1;
    	}
    	System.out.println(Arrays.toString(nums));
    }
    
    private void rotateRec(int[] arr, int start, int size, int element) {
    	if (start < size) {
    		rotateRec(arr, start + 1, size, arr[start + 1]);
		}
    	
    	if (start == size) {
			arr[0] = arr[start];
		} else {
			arr[start + 1] = element;
		}
    }

    // 10. https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/
    public boolean hasGroupsSizeX(int[] deck) {
    	int arrSize = deck.length;
    	List<Integer> divisors = new ArrayList<>();
    	
    	for (int i = 2; i <= arrSize; i++) {
			if (arrSize % i == 0) {
				divisors.add(i);
			}
		}
    	if (divisors.isEmpty()) {
			return false;
		}
    	
    	Arrays.sort(deck);
    	
    	boolean result = true;
    	for (Integer divisor : divisors) {
        	result = true;
        	for (int i = 0; i < arrSize; i = i + divisor) {
				if (deck[i] == deck[i + divisor - 1]) {
					continue;
				} else {
					result = false;
					break;
				}
    		}
        	if (result) {
				break;
			}
		}
    	
        return result;
    }
    
    // 11. https://leetcode.com/problems/valid-mountain-array/
    public boolean validMountainArray(int[] A) {
    	int size = A.length;
    	if (size < 3) {
			return false;
		}
    	
    	int biggestLocation = 0;
    	int biggest = A[0];
    	
    	for (int i = 0; i < size; i++) {
			if (biggest < A[i]) {
				biggest = A[i];
				biggestLocation = i;
			}
		}
    	
    	if (biggestLocation == 0 || biggestLocation == (size - 1)) {
			return false;
		}
    	
    	boolean leftMountain = true;
    	for (int i = 1; i <= biggestLocation; i++) {
			if (A[i] > A[i - 1]) {
				continue;
			} else {
				leftMountain = false;
		    	return false;
			}
    	}
    	
    	boolean rightMountain = true;
    	for (int i = biggestLocation; i < size - 1; i++) {
			if (A[i] > A[i + 1]) {
				continue;
			} else {
				leftMountain = false;
		    	return false;
			}
    	}
    	
    	return leftMountain && rightMountain;
    }
    
	public static void main(String[] args) {
//		ArrayEasy arrayEasy = new ArrayEasy();
//		int[] arr0 = { 0, 2, 3, 4, 5, 2, 1, 0 };
//		System.out.println(arrayEasy.validMountainArray(arr0));
//
//		int[] arr1 = { 0, 2, 3, 3, 5, 2, 1, 0 };
//		System.out.println(arrayEasy.validMountainArray(arr1));
//
//		int[] arr2 = { 2, 1 };
//		System.out.println(arrayEasy.validMountainArray(arr2));
		
//		int[] arr3 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
//		System.out.println(arrayEasy.validMountainArray(arr3));
		
//		int[] arr4 = { 0, 0 };
//		System.out.println(arrayEasy.hasGroupsSizeX(arr4));
//		
//		int[] arr5 = { 1, 1, 2, 2, 2, 2 };
//		System.out.println(arrayEasy.hasGroupsSizeX(arr5));
	}
}
