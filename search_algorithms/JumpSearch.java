package se;

import java.lang.Math;

/* WHAT IS JUMP SEARCH?
 * Jump Search only works on a sorted list
 * Basically like linear search except you jump at bigger intervals
 * 
 * Time Complexity: O (sqrt(n^2))
 * Space Complexity: 0(1)
 */

public class JumpSearch {
	
	public static void search(int arr[], int find) {
		int n = arr.length;
		int size = (int) (Math.sqrt(n));
		int current = 0;
		int prev = 0;
		
		while (arr[current] < find) {
			prev = current;
			current += size;
		}
		
		if (current > arr.length) {
			System.out.println("Sorry, we didn't find " + find + " in this array.");
			return;
		}
		
		for (int i = current; i > prev; i--) {
			if (arr[i] == find) {
				System.out.println("We found the value " + find + " at index " + i + ".");
				return;
			}
		}
		System.out.println("Sorry, we didn't find " + find + " in this array.");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr [] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		long start = System.nanoTime();
		search(arr, 7);
		long end = System.nanoTime();
		System.out.println("\n\nTime Taken: " + (end - start));
	}
}

