package so;

/* WHAT IS SELECTION SORT?
 * This is a method to sort an array
 * You look through the entire array and find the lowest value
 * Then, you put that value with the value currently in the first position
 * Then, you move to the second index and continue this pattern
 * Until the array is sorted
 * 
 * @author Eesha J.
 * 
 * Time Complexity: O(n^2)
 * Space Complexity: O (1)
 */

public class SelectionSort {
	
	public static void sort(int arr []) {
		for (int i = 0; i < arr.length; i++) {
			int min = i;
			for (int j = i; j < arr.length; j++) {
				if (arr[min] > arr[j]) {
					min = j;
				}
			}
			if (min != i) {
				int temp = arr[min];
				arr[min] = arr[i];
				arr[i] = temp;
			}
		}
	}
	
	public static void print(int arr []) {
		for (int i = 0; i < arr.length; i++) {
			if (i + 1 == arr.length) {
				System.out.print(arr[i]);
			} else {
				System.out.print(arr[i] + ", ");
			}
			
		}
	}
	
	public static void main (String args[]) {
		//Random
		int arr [] = {41, 35, 67, 54, 29, 92, 104, 18, 80, 79};
		//Sorted
		//int arr [] = {18, 29, 35, 41, 54, 67, 79, 80, 92, 104};
		// Reversed
		//int arr [] = {104, 92, 80, 79, 67, 54, 41, 35, 29, 18};
		
		System.out.print("Randomized: ");
		print(arr);
		System.out.print("\n\nSorted Array: ");
		long start = System.nanoTime();
		sort(arr);
		long end = System.nanoTime();
		print(arr);
		System.out.println("\n\nTime Taken: " + (end - start));
	}
}
