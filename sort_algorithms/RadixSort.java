package so;

/* WHAT IS RADIX SORT?
 * Radix sort is when you first sort the list based on the first digit
 * (If two are the same, you place them in order of how they originally came in the array)
 * Then, you will sort based on the tens digit
 * And you will continue up the scale until list is sorted
 * 
 * IMPORTANT: This sorting method can only be used with numbers
 * 
 * Time Complexity: O((n+b) * log b(k))
 * b is which decimal system you are using (in this case, 10)
 * Space Complexity: O (n + 2^d)
 */

public class RadixSort {
	
	public static void countingSort(int arr[], int size, int exp) {
		int max = findMax(arr);
		int [] count = new int [max + 1];
		int [] temp = new int [size + 1];
		
		for (int i = 0; i < size; i++) {
			count[(arr[i]/exp) % 10]++;
		}
		
		for (int i = 1; i < size; i++) {
			count[i] += count[i-1];
		}
		
		for (int i = size - 1; i >= 0; i--) {
			temp[count[(arr[i]/exp) % 10] - 1] = arr[i];
			count[(arr[i]/exp) % 10]--;
		}
		
		for (int i = 0; i < size; i++) {
			arr[i] = temp[i];
		}
	}
		
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
		int placeValue = findMax(arr);
		
		for (int i = 1; placeValue/i > 0; i *= 10) {
			//DO COUNTING SORT HERE
			countingSort(arr, arr.length, i);
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
