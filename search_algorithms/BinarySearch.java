package se;

/* WHAT IS BINARY SEARCH?
 * Pointer 1 starts at the first position, pointer 2 is at the last position
 * It finds the middle value and determines whether the value we are looking
 * for is greater than or less than the value in the middle
 * If it is greater, than we move last to the middle index - 1
 * If it is less than, we move the first index to the middle index + 1
 * If it is equal to, then we say that we found the object
 * You continue this process until you find object or the first index comes after the last index
 * In which you already searched through entire array so you return the value isn't found
 * This method eliminates about half the remaining array each iteration
 * You have to use this method on a sorted array 
 * 
 * Time Complexity: O (log n)
 * Space Complexity: 0(1)
 */

public class BinarySearch {
	
	public static void search(int arr[], int find) {
		int first = 0;
		int last = arr.length - 1;
		
		int mid = (int) ((first + last) / 2);
		
		while (first <= last) {
			if (arr[mid] < find) {
				first = mid + 1;
			} else if (arr[mid] == find) {
				System.out.println("We found the value " + find + " at index " + mid + ".");
				return;
			} else {
				last = mid - 1;
			}
			
			mid = (first + last)/2;
		}
		
		if (first > last) {
			System.out.println("Sorry, we didn't find " + find + " in this array.");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr [] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		long start = System.nanoTime();
		search(arr, 12);
		long end = System.nanoTime();
		System.out.println("\n\nTime Taken: " + (end - start));
	}
}

