package so;

/* WHAT IS AN INSERTION SORT?
 * An insertion sort sorts the first element
 * Then, it sorts the first two elements
 * (If it is less then the next value, then it swaps them
 * else, it leaves it in its current position)
 * Then, it sorts the first three elements
 * It continues this process until the end of the array
 * 
 * @author Eesha J.
 * 
 * Time Complexity: O (n^2)
 * Space Complexity: O(1)
 */

public class InsertionSort {
	
	public static void sort(int arr []) {
		for (int i = 1; i < arr.length; i++) {
			int counter = i-1;
			int ideal = arr[i];
			while (counter >= 0 && arr[counter] > ideal) {
				arr[counter + 1] = arr[counter];
				
				counter--;
			}
			arr[counter + 1] = ideal;
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
		// int arr [] = {18, 29, 35, 41, 54, 67, 79, 80, 92, 104};
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
