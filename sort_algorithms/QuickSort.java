package so;

/* WHAT IS QUICK SORT?
 * You select a pivot point
 * Using quick sort, you sort everything before and after that pivot point
 * You continue sorting until the entire array is sorted
 * @author Eesha J.
 * 
 * Time Complexity: (n * log n)
 * Space Complexity: O(n * log n) sometimes O(n)
 */

public class QuickSort {
	
	public static int partition (int arr [], int left, int right) {
		int index = (left + right) / 2;
		int pointer1 = left;
		int pointer2 = right;
		while (pointer1 < pointer2) {
			while (arr[pointer1] < arr[index]) {
				pointer1++;
			}
			while (arr[pointer2] > arr[index]) {
				pointer2--;
			}
			
			if (pointer1 <= pointer2) {
				int temp = arr[pointer1];
				arr[pointer1] = arr[pointer2];
				arr[pointer2] = temp;
				
				pointer1++;
				pointer2--;
			}
		}
		
		return pointer1;
	}
		
	public static void sort(int arr [], int left, int right) {
		
		int index = partition(arr, left, right);
		
		if (left < (index - 1)) {
			sort(arr, left, index - 1);
		}
		
		if (right > index)	{
			sort(arr, index, right);
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
		sort(arr, 0, arr.length - 1);
		long end = System.nanoTime();
		print(arr);
		System.out.println("\n\nTime Taken: " + (end - start));
	}
}
