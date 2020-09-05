package b.leet.code.array.medium;

import java.util.Arrays;

public class ArrayMedium {
	
	// 1. https://leetcode.com/problems/queries-on-a-permutation-with-key/
    public int[] processQueries(int[] queries, int m) {
    	int queriesSize = queries.length;

    	// initialize p-array
        int[] pArr = new int[m];
        for (int i = 0; i < m; i++) {
        	pArr[i] = i + 1;
		}
        
        int[] outputArr = new int[queriesSize];
        for (int i = 0; i < queriesSize; i++) {
			int number = queries[i];
			int location = findLocationInPArrAndShuffle(number, pArr);
			outputArr[i] = location;
		}
        
    	System.out.println(Arrays.toString(outputArr));
    	return outputArr;
    }
    
    private int findLocationInPArrAndShuffle(int number, int[] pArr) {
    	int location = 0;
    	for (int i = 0; i < pArr.length; i++) {
			if (number == pArr[i]) {
				location = i;
				break;
			}
		}
//    	System.out.println("number: " + number + " location: " + location);
    	
    	// re-shuffle p-array
    	int temp = pArr[0];
    	pArr[0] = pArr[location];
    	for (int i = 1; i <= location; i++) {
			int temp2 = pArr[i];
			pArr[i] = temp;
			temp = temp2;
		}
//    	System.out.println("After freshuffling the array..");
//    	System.out.println(Arrays.toString(pArr));
		return location;
	}

    // 2. https://leetcode.com/problems/count-number-of-teams/
    public int numTeams(int[] rating) {
    	int result = 0;
		for (int i = 0; i < rating.length; i++) {
			for (int j = i + 1; j < rating.length; j++) {
				for (int k = j + 1; k < rating.length; k++) {
//					System.out.println(rating[i] + " " + rating[j] + " " + rating[k]);
					if ((rating[i] > rating[j]) && (rating[j] > rating[k])) {
						result = result + 1;
					}
					if ((rating[i] < rating[j]) && (rating[j] < rating[k])) {
						result = result + 1;
					}
				}
			}
		}    	
    	return result;
    }
    
    /* 
     * 3. https://leetcode.com/problems/sort-the-matrix-diagonally/
     * step 1: sort all the diagonals for first row
     * 		step a: get the count of diagonal elements
     * 		step b: sort the diagonal elements using selection sort
     * 
     * step2: sort all the diagonals for first column
     * 		step a: get the count of diagonal elements
     * 		step b: sort the diagonal elements using selection sort
     */
    public int[][] diagonalSort(int[][] mat) {
    	int rows = mat.length;
    	int columns = mat[0].length;
//    	System.out.println("rows: " + rows + " columns: " + columns);
    	
    	// processing first row of matrix
    	for (int i = 0; i < columns; i++) {
    		// finding number of diagonal elements
    		int count = 0;
			int x = 0;
			int y = i;
    		while (true) {
    			if (x == rows || y == columns) {
					break;
				} else {
					count = count + 1;
					x = x + 1;
					y = y + 1;
				}
    		}
//    		System.out.println("x: " + x + " y: " + y + " count: " + count);

    		// Picking one diagonal and applying selection sort on it.
    		for (int j = 0; j < count; j++) {
    			int a = j;
    			int b = i + j;
    			
        		x = j;
        		y = i + j;
    			int smallest = mat[x][y];
    			int smallestX = x;
    			int smallestY = y;
				for (int k = j; k < count; k++) {
					// find smallest
//		    		System.out.println("x: " + x + " y: " + y + " mat[x][y]: " + mat[x][y] + " smallest: " + smallest);
					if (mat[x][y] < smallest) {
						smallest = mat[x][y];
						smallestX = x;
						smallestY = y;
					}
					x = x + 1;
					y = y + 1;
				}
//				System.out.println("smallest: " + smallest + " smallestX: " + smallestX + " smallestY: " + smallestY);
				// swap
				int temp = mat[a][b];
				mat[a][b] = mat[smallestX][smallestY];
				mat[smallestX][smallestY] = temp;
			}
//    		System.out.println(Arrays.deepToString(mat));
		}
    	
    	// processing first column
    	for (int i = 1; i < rows; i++) {
			// step a: get the count of diagonal elements
    		int count = 0;
    		int x = i;
    		int y = 0;
    		while (true) {
    			if (x == rows || y == columns) {
					break;
				} else {
	    			y = y + 1;
	    			x = x + 1;
	    			count = count + 1;
				}
    		}
//    		System.out.println("count: " + count);
    		
			// step b: sort the diagonal elements using selection sort
    		for (int j = 0; j < count; j++) {
    			int a = i + j;
    			int b = j;
    			
        		x = i + j;
        		y = j;
				// find smallest in the diagonal array
    			int smallest = mat[x][y];
    			int smallestX = x;
    			int smallestY = y;
    			for (int k = j; k < count; k++) {
					if (mat[x][y] < smallest) {
						smallest = mat[x][y];
		    			smallestX = x;
		    			smallestY = y;
					}
					x = x + 1;
					y = y + 1;
				}
//    			System.out.println("smallest : " + smallest + " smallestX: " + smallestX + " smallestY: " + smallestY);
    			
    			// swap
    			int temp = mat[a][b];
    			mat[a][b] = mat[smallestX][smallestY];
    			mat[smallestX][smallestY] = temp;
			}
		}
//    	System.out.println(Arrays.deepToString(mat));
    	return mat;
    }
    
	public static void main(String[] args) {
		ArrayMedium demo = new ArrayMedium();
		
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
