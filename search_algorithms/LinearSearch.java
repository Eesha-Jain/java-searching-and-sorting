package se;


/* WHAT IS LINEAR SEARCH?
 * You look one at a time to see whether it is the element
 * Go in order
 * 
 * Time Complexity: O (n)
 * Space Complexity: 0(1)
 */

public class LinearSearch {
	
	public static void search(int arr[], int find) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == find) {
				System.out.println("We found the value " + find + " at index " + i + ".");
				return;
			}
		}
		System.out.println("Sorry, we didn't find " + find + " in this array.");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr [] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		long start = System.nanoTime();
		search(arr, 12);
		long end = System.nanoTime();
		System.out.println("\n\nTime Taken: " + (end - start));
	}
}

