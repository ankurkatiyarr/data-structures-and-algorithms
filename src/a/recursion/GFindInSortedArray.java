package a.recursion;

public class GFindInSortedArray {
	// Finds element and print the location but does not return anything
	public static void findElementInSortedArray(int[] arr, int number, int start, int end) {
		if (start < end) {
			int mid = (start + end)/2;
			if (number == arr[mid]) {
				System.out.println("Number: " + number + " found at: " + mid);
			} else if (number < arr[mid]) {
				findElementInSortedArray(arr, number, start, mid);
			} else {
				findElementInSortedArray(arr, number, mid + 1, end);
			}
		}
	}
	
	public static int findElementInSortedArray2(int[] arr, int number, int start, int end) {
		if (start < end) {
			int mid = (start + end)/2;
			if (number == arr[mid]) {
				return mid;
			} else if (number < arr[mid]) {
				return findElementInSortedArray2(arr, number, start, mid);
			} else {
				return findElementInSortedArray2(arr, number, mid + 1, end);
			}
		} else {
			return -1;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 2, 5, 8, 11, 21 };
		
//		findElementInSortedArray(arr, 5, 0, arr.length);
//		findElementInSortedArray(arr, 2, 0, arr.length);
//		findElementInSortedArray(arr, 21, 0, arr.length);
//		findElementInSortedArray(arr, 11, 0, arr.length);
//		findElementInSortedArray(arr, 23, 0, arr.length);
//		findElementInSortedArray(arr, 0, 0, arr.length);

		System.out.println(findElementInSortedArray2(arr, 5, 0, arr.length));
		System.out.println(findElementInSortedArray2(arr, 2, 0, arr.length));
		System.out.println(findElementInSortedArray2(arr, 21, 0, arr.length));
		System.out.println(findElementInSortedArray2(arr, 11, 0, arr.length));
		System.out.println(findElementInSortedArray2(arr, 23, 0, arr.length));
		System.out.println(findElementInSortedArray2(arr, 0, 0, arr.length));
	}
}
