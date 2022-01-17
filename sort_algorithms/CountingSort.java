package so;

/* WHAT IS COUNTING SORT?
 * It is basically when you make another array
 * Which will store how much each number comes up
 * Then, they will modify it to be the sum of the previous numbers plus itself
 * Then, it will add it to the output one at a time
 * 
 * Major Reference: https://www.geeksforgeeks.org/counting-sort/
 * https://www.programiz.com/dsa/counting-sort
 * 
 * Watch the video (on first link) for more clarity
 * 
 * Time Complexity: O (n+k)
 * Space Complexity: O (n+k)
 */

public class CountingSort {
	
	public static int findMax(int arr[]) {
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
		}

		return max;
	}
	
	public static void sort(int arr[]) {
		int max = findMax(arr);
		int [] bucket = new int [max + 1];
		int [] temp = new int [arr.length];
		
		for (int i = 0; i < arr.length; i++) {
			temp[i] = arr[i];
		}
		
		for (int i = 0; i < arr.length; i++) {
			bucket[arr[i]]++;
		}
		
		for (int i = 1; i < bucket.length; i++) {
			bucket[i] += bucket[i-1];
		}
		
		for (int i = 0; i < arr.length; i++) {
			int var = bucket[temp[i]];
			arr[var - 1] = temp[i];
			bucket[temp[i]]--;
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
