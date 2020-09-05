package a.recursion;

public class DBiggestInArray {
	// Noob way
	static int output;
	public static int findBiggestInArrayRecursive(int[] arr, int start, int end, int biggest) {
		if (start <= end) {
			if (arr[start] > biggest) {
				biggest = arr[start];
			}
			findBiggestInArrayRecursive(arr, start + 1, end, biggest);
		} else {
			output = biggest;
		}
		return output;
	}
	
	// better way
	public static int findBiggestInArrayRecursive2(int[] arr, int start, int end, int biggest) {
		if (start <= end) {
			if (arr[start] > biggest) {
				biggest = arr[start];
			}

			return findBiggestInArrayRecursive(arr, start + 1, end, biggest);
		} else {
			return biggest;
		}
	}
	
	public static void main(String[] args) {
		int arr[] = { 4, 3, 5, 2 };
		
//		int biggest = findBiggestInArrayRecursive(arr, 0, arr.length - 1, arr[0]);
//		System.out.println("biggest: " + biggest);
		
		int biggest2 = findBiggestInArrayRecursive2(arr, 0, arr.length - 1, arr[0]);
		System.out.println("biggest2: " + biggest2);

	}
}
