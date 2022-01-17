package so;

/* WHAT IS COMB SORT?
 * It is basically an improved version of bubble sort
 * Instead of comparing adjacent values, it will compare values
 * That have a bigger gap in between them
 * It starts with a large value (the length of array) and then shrinks by 1.3 until it reaches 1
 * 
 * Time Complexity: O(n^2) - Worst Case Scenario, O(n*log n) - Average Case Scenario
 * Space Complexity: O(1)
 */

public class CombSort {
	
	public static void sort(int arr[]) {
		for (int gap = arr.length; gap > 0; gap /= 1.3 ) {
			for (int i = 0; i < arr.length - 1 && (i + gap) < arr.length; i++) {
				if (arr[i] > arr[i+gap]) {
					int temp = arr[i];
					arr[i] = arr[i + gap];
					arr[i + gap] = temp;
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
