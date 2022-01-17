package so;

import java.util.ArrayList;

/* WHAT IS PIGEONHOLE SORT?
 * A combination of counting sort and bucket sort
 * 
 * Find the min, max, and range of the array
 * An empty array of "pigeonholes" will be made (length of range)
 * Visit each element and put it at arr[i] - min
 * Put the values back into original array
 * 
 * Time Complexity: O(n*range)
 * Space Complexity: O(2^k)
 */

public class PigeonholeSort {

	public static void sort(int arr []) {
		int min = arr[0];
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
			
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		
		int range = (max - min) + 1;
		ArrayList<Integer> [] holes = new ArrayList[range];
		
		for (int i = 0; i < holes.length; i++) {
			holes[i] = new ArrayList();
		}
		
		for (int i = 0; i < arr.length; i++) {
			int index = arr[i] - min;
			if (holes[index] != null) {
				holes[index].add(arr[i]);
			}
		}
		
		int pos = 0;
		for (int i = 0; i < holes.length; i++) {
			if (holes[i] != null) {
				for (Integer val: holes[i]) {
					if (holes[i].size() != 0 && val != null) {
						arr[pos] = val;
						pos++;
					}
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
