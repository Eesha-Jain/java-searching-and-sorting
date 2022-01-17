package se;

/* WHAT IS FIBONACCI SEARCH?
 * 
 * 
 * Time Complexity: O (log n)
 * Space Complexity: O (1)
 */

public class FibonacciSearch {
	
	public static void search(int arr[], int find) {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr [] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		long start = System.nanoTime();
		search(arr, 7);
		long end = System.nanoTime();
		System.out.println("\n\nTime Taken: " + (end - start));
	}
}

