package so;

/* WHAT IS SHELL SORT?
 * This is a variation of insertion sort
 * Instead of comparing elements right next to each other
 * We compare elements that are a certain gap apart
 * And that gap divides by 2 each iteration
 * 
 * Time Complexity: o(n^2)
 * Space Complexity: O(n) or O(1)
 */

public class ShellSort {
	
	public static void sort(int arr[]) {
		for (int gap = arr.length; gap > 0; gap /= 2 ) {
			for (int i = gap; i < arr.length; i++) {
				int ideal = arr[i];
				int j;
				for (j = i; j >= gap && arr[j - gap] >= ideal; j -= gap) {
					arr[j] = arr[j - gap];
				}
				arr[j] = ideal;
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
