package z.sorting;

import java.util.Arrays;

public class SelectionSort {
	public static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int smallest = arr[i];
			int smallestLocation = i;
			for (int j = i; j < arr.length; j++) {
				// find smallest
				if (arr[j] < smallest) {
					smallest = arr[j];
					smallestLocation = j;
				}
			}
			// swap
			int temp = arr[i];
			arr[i] = arr[smallestLocation];
			arr[smallestLocation] = temp;
		}
		System.out.println(Arrays.toString(arr));
	}
	
	public static void main(String[] args) {
		int[] arr = { 64, 25, 12, 22, 11 };
		selectionSort(arr);
	}
}
