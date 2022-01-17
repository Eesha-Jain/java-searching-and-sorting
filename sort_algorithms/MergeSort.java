package so;

/* WHAT IS MERGE SORT?
 * First, you break the original array into arrays that are length 1
 * Then, you will slowly combine them, sorting them along the way
 * 
 * Time Complexity: O(n * log n)
 * Space Complexity: O (n)
 */

public class MergeSort {
	
	public static void merge(int arr[], int left, int mid, int right) {
		int leftside [] = new int [mid - left + 1];
		int rightside [] = new int [right - mid];
		
		//Initialize the stuff in both arrays
		for (int i = 0; i < leftside.length; i++) {
			leftside[i] = arr[left + i];
		}
		
		for (int i = 0; i < rightside.length; i++) {
			rightside[i] = arr[mid + 1 + i];
		}
		
		//Compare
		int leftpointer = 0;
		int rightpointer = 0;
		int pos = left;
		
		while (leftpointer < leftside.length && rightpointer < rightside.length) {
			if (leftside[leftpointer] < rightside[rightpointer]) {
				arr[pos] = leftside[leftpointer];
				leftpointer++;
			} else {
				arr[pos] = rightside[rightpointer];
				rightpointer++;
			}
					
			pos++;
		}
		
		//Copying over the extra elements (if any)
		if (leftpointer < leftside.length) {
			for (int i = leftpointer; i < leftside.length; i++) {
				arr[pos] = leftside[i];
				pos++;
			}
		}
		
		if (rightpointer < rightside.length) {
			for (int i = rightpointer; i < rightside.length; i++) {
				arr[pos] = rightside[i];
				pos++;
			}
		}
	}
		
	public static void sort(int arr[], int left, int right) {
		if (right > left) {
			int mid = (left + right) / 2;
			sort(arr, left, mid);
			sort(arr, mid + 1, right);
			
			merge(arr, left, mid, right);
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
