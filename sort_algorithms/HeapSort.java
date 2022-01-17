package so;

/* WHAT IS A HEAP SORT?
 * First, we make a tree so that at the top is the largest value
 * And then there are two values per row after that
 * And it becomes a division tree like thing
 * So that the parent is always greater than the child
 * This is called creating a heap or heapify
 * 
 * Then, to sort, you take the top one out and you take one from the bottom
 * And put it at the top
 * Then, you move it down the tree until it reaches the correct position
 * Swapping the values in the meantime
 * 
 * And then, you continue pulling values from the top until it is sorted
 * 
 * Major Reference: https://www.geeksforgeeks.org/heap-sort/
 * 
 * @author Eesha J.
 * 
 * Time Complexity: O (n log n)
 * Space Complexity: O (1)
 */

public class HeapSort {	
		
	public static void heapify(int arr[], int n, int i) {
		//The root is i
		int largest = i; 
		int left = 2*i + 1;
		int right = 2*i + 2;
		
		if (left < n && arr[largest] < arr[left]) {
			largest = left;
		}
		
		if (right < n && arr[largest] < arr[right]) {
			largest = right;
		}
		
		if (largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			heapify(arr, n, largest);
		}
	}
	
	public static void sort(int arr []) {
		for (int i = arr.length/ 2; i >= 0; i--) {
			heapify(arr, arr.length, i);
		}
		
		for (int i =arr.length - 1; i >= 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			
			heapify(arr, i, 0);
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
