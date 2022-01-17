package so;

import java.util.ArrayList;

/* WHAT IS BUCKET SORT?
 * Create an empty bucket list
 * Put each value in original array into the bucket array at n/10
 * Then, sort each array in the bucket array
 * Combine the sorted arrays together
 * 
 * Time Complexity: O (n^2)
 * Space Complexity: O (n + k)
 */

public class BucketSort {
	
	public static void insertionsort(ArrayList <Double> arr) {
		for (int i = 1; i < arr.size(); i++) {
			int counter = i-1;
			double ideal = arr.get(i);
			while (counter >= 0 && arr.get(counter) > ideal) {
				arr.set(counter + 1, arr.get(counter));
				
				counter--;
			}
			arr.set(counter + 1, ideal);
		}
	}
	
	public static void sort(double[] arr, int length) {
		ArrayList<Double> [] bucket = new ArrayList[arr.length];
		
		for (int i = 0; i < arr.length; i++) {
			bucket[i] = new ArrayList();
		}
		
		for (int i = 0; i < arr.length; i++) {
			int bucketIndex = (int) arr[i] / arr.length;
			bucket[bucketIndex].add(arr[i]);
		}
		
		for (ArrayList list: bucket) {
			insertionsort(list);
		}
		
		int pos = 0;
		for (ArrayList list: bucket) {
			for (Object val: list) {
				arr[pos] = (double) val;
				pos++;
			}
		}
	}

	public static void print(double arr []) {
		for (int i = 0; i < arr.length; i++) {
			if (i + 1 == arr.length) {
				System.out.print(arr[i]);
			} else {
				System.out.print(arr[i] + ", ");
			}
			
		}
	}
	
	public static void main (String args[]) {
		//Randomized
		double arr [] = {4, 3, 6, 5, 2, 9, 10, 1, 8, 7};
		//Sorted
		// double arr [] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		//Reverse
		// double arr [] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		
		System.out.println("Randomized:");
		print(arr);
		System.out.println("\n\nSorted Array:");
		long start = System.nanoTime();
		sort(arr, arr.length);
		long end = System.nanoTime();
		print(arr);
		System.out.println("\n\nTime Taken: " + (end - start));
	}
}
