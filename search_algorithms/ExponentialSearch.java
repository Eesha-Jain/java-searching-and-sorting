package se;

/* WHAT IS EXPONENTIAL SEARCH?
 * 
 * 
 * Time Complexity: O(1) for the best case. 
 * 					O(log2 i) for average or worst case. 
 * Where i is the location where search key is present.
 * Space Complexity: 0(1)
 */

public class ExponentialSearch {
	
	public static void binarySearch(int arr[], int find, int first, int last) {
			
		int mid = (int) ((first + last) / 2);
		
		while (first <= last) {
			if (arr[mid] < find) {
				first = mid + 1;
			} else if (arr[mid] == find) {
				System.out.println("We found the value " + find + " at index " + mid + ".");
				break;
			} else {
				last = mid - 1;
			}
			
			mid = (first + last)/2;
		}
		
		if (first > last) {
			System.out.println("Sorry, we didn't find " + find + " in this array.");
		}
	}
	
	public static void search(int arr[], int find) {
		if (arr[0] == find) {
			System.out.println("We found the value " + find + " at index " + 0 + ".");
			return;
		}
		
		int i = 1;
		while (i < arr.length && arr[i] <= find) {
			i *= 2;
		}
		
		if (i > arr.length) {
			System.out.println("Sorry, we didn't find " + find + " in this array.");
			return;
		}
		
		binarySearch(arr, find, i / 2, i);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr [] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		long start = System.nanoTime();
		search(arr,12);
		long end = System.nanoTime();
		System.out.println("\n\nTime Taken: " + (end - start));
	}
}


