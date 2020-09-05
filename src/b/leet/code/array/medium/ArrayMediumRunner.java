package b.leet.code.array.medium;

import java.util.Arrays;

public class ArrayMediumRunner {
	public static void main(String[] args) {
		ArrayMedium demo = new ArrayMedium();
		
		// processQueries
		int[] arr1 = { 3, 1, 2, 1 };
		Arrays.toString(demo.processQueries(arr1, 5));
		int[] arr2 = { 4, 1, 2, 2 };
		Arrays.toString(demo.processQueries(arr2, 4));
		int[] arr3 = { 7, 5, 5, 8, 3 };
		Arrays.toString(demo.processQueries(arr3, 8));
		
		// diagonalSort
		int[][] mat = { 
				{ 4, 6, 3, 2 }, 
				{ 2, 2, 2, 0 }, 
				{ 1, 0, 5, 5 },
				{ 6, 1, 1, 8 },
				{ 5, 3, 8, 6 }
			};
		demo.diagonalSort(mat);


	}
}
