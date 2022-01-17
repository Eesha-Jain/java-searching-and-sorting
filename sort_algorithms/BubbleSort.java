package so;

/* WHAT IS BUBBLE SORT?
 * You look at the first two elements and swap them if they are out of order
 * Then, you look at second and third element, swapping them if they are out of order
 * You continue swapping until you reach the end
 * Then, you check whether it is sorted or not
 * If it is sorted, then you will exit
 * Otherwise, you will continue the binary search on the elements
 * (On the second iteration, you don't have to do it on the last element because
 * the last element would already be in place due to the first cycle)
 * 
 * Time Complexity: O(n^2)
 * Space Complexity: 0(1)
 */

public class BubbleSort {
	
	public static void sort(int arr[]) {
		boolean sorted = false;
		while (!sorted) {
			sorted = true;
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] > arr[i+1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					
					sorted = false;
				}
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
