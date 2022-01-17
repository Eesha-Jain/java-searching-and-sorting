package se;

/* WHAT IS INTERPOLATION SEARCH?
 * Step1: In a loop, calculate the value of “pos” using the probe position formula.
 * Step2: If it is a match, return the index of the item, and exit.
 * Step3: If the item is less than arr[pos], calculate the probe position of the left sub-array. 
 * Otherwise calculate the same in the right sub-array.
 * Step4: Repeat until a match is found or the sub-array reduces to zero.
 * 
 * Pos Formula: pos = lo + [ (x-arr[lo])*(hi-lo) / (arr[hi]-arr[Lo]) ]
 * 
 * Time Complexity: O(log2(log2 n)) for the average case, and O(n) 
 * Space Complexity: O(1)
 */

public class InterpolationSearch {
	
	public static void search(int arr[], int find, int start, int end) {
		int pos = start + ((find - arr[start]) * (end - start) / (arr[end] - arr[start]));
		
		if (start > end || start < 0 || end > arr.length || pos < 0 || pos > arr.length) {
			System.out.println("Sorry, we didn't find " + find + " in this array.");
			return;
		}
		
		if (arr[pos] == find) {
			System.out.println("We found the value " + find + " at index " + pos + ".");
			return;
		} else if (arr[pos] > find) {
			search (arr, find, pos + 1, end);
		} else {
			search (arr, find, start, pos);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int arr [] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int arr [] = {10, 12, 13, 16, 18, 19, 20, 21, 22, 23, 24, 33, 35, 42, 47}; 
		long start = System.nanoTime();
		search(arr, 47, 0, arr.length -1);
		long end = System.nanoTime();
		System.out.println("\n\nTime Taken: " + (end - start));
	}
}

