package soGraphs;


public class HeapSort implements ISorter {
	private int comparisons = 0;
	private int moves = 0;
	
	public HeapSort() {
		//Empty Constructor
	}
	
	// To heapify a subtree rooted with node i which is 
    // an index in arr[]. length is the length of the heap
	private void heapify(int arr[], int length, int i) {
		//Say that the value in the current top position is the largest
		int largest = i;
		//The value to the leftmost of the tree is the "left" value
		int left = 2*i + 1;
		//The value to the rightmost of the tree is the "right" value
		int right = 2*i + 2;
		
		//If the left child is greater than the supposed "largest" value and it is a valid value
		if (left < length && arr[left] > arr[largest]) {
			//then set the largest value to the left value
			largest = left;
		}
		comparisons++;
		
		//If the right child is greater than the supposed "largest" value and it is a valid value
		if (right < length && arr[right] > arr[largest]) {
			largest = right;
		}
		comparisons++;
		
		//If the largest value is not what it originally was
		if (largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;
			moves += 3;
			
			//then, you have to continue this process until the entire thing becomes a max heap
			heapify(arr, length, largest);
		}
	}
	
	public SortStats sort(int arr []) {
		long nanoseconds = System.nanoTime();
		int length = arr.length;
		if (length == 0) {
			return new SortStats("Heap Sort", arr.length, comparisons, moves, System.nanoTime() - nanoseconds);
		}	
		
		//Builds max heap
		for (int i = length/2 - 1; i >= 0; i--) {
			heapify(arr, length, i);
		}
		
		//One by one, it switches the top node (the parent) with the bottom value to sort the array
		for (int i = length-1; i > 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			moves += 2;
			
			//Then, it builds a max heap with reduced array
			heapify(arr, i, 0);
		}
		
		return new SortStats("Heap Sort", arr.length, comparisons, moves, System.nanoTime() - nanoseconds);
	}
	
	public void print(int arr []) {
		for (int i = 0; i < arr.length; i++) {
			if (i + 1 == arr.length) {
				System.out.print(arr[i]);
			} else {
				System.out.print(arr[i] + ", ");
			}
		}
	}
}
