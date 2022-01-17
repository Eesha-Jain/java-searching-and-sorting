package soGraphs;

public class QuickSort implements ISorter {
	
	private int comparisons = 0;
	private int moves = 0;
	
	public QuickSort() {
		//Empty Constructor
	}
	
	private int partition(int arr [], int left, int right) {
		//So that we can change i and j but still have the original value
		int i = left;
		int j = right;
				
		//Pivot is the middle value
		int pivot = arr[(left + right) / 2];
				
		//We are going to find the first value on the left side that is greater than the pivot point
		//And the first value on the right side that is less than the pivot point
		//And then we are going to switch them
		//Until the i pointer is greater than the j pointer
		while (i <= j) {
			while (arr[i] < pivot)
				i++;
				comparisons++;
			while (arr[j] > pivot)
				j--;
				comparisons++;
			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				moves += 2;
						
				i++;
				j--;
			}
		}
				
		return i;
	}
	
	private void quicksort(int arr [], int left, int right) {
		
		//Finding the proper pivot point
		int index = partition(arr, left, right);
				
		//Then, we will do quicksort on the other two halves of the array
		if (left < index - 1)
			quicksort(arr, left, index - 1);
		if (right > index)
			quicksort(arr, index, right);
		comparisons += 2;
	}
	
	public SortStats sort(int arr []) {
		long nanoseconds = System.nanoTime();
		quicksort(arr, 0, arr.length - 1);
		return new SortStats("Quick Sort", arr.length, comparisons, moves, System.nanoTime() - nanoseconds);
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
