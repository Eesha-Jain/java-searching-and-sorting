package soGraphs;

public class MergeSort implements ISorter {
	
	private int comparisons = 0;
	private int moves = 0;
	
	public MergeSort() {
		//Empty Constructor
	}
	
	private void merge (int arr[], int left, int mid, int right) {
		
		//Making two different arrays with each of the two sorted parts				
		int l [] = new int [mid - left + 1];
		int r [] = new int [right - mid];
		
		for (int i = 0; i < l.length; i++) {
			l[i] = arr[left + i];
		}
		for (int i = 0; i < r.length; i++) {
			r[i] = arr[mid + i + 1];
		}
		
		//Actually merging them together with while loop
		int leftpointer = 0;
		int rightpointer = 0;
		
		// Initial index of merged subarray	
		int arrposition = left;
		while (leftpointer < l.length && rightpointer < r.length) {
			
			if (l[leftpointer] > r[rightpointer]) {
				arr[arrposition] = r[rightpointer];
				moves++;
				rightpointer++;
			} else {
				arr[arrposition] = l[leftpointer];
				moves++;
				leftpointer++;
			}
			
			comparisons += 2;
			arrposition += 1;
		}
		
		//Copying over the rest of the elements from l array
		if (leftpointer < l.length) {
			for (int i = leftpointer; i < l.length; i++) {
				arr[arrposition] = l[i];
				arrposition++;
				moves++;
			}
		}
		//Copying over the rest of the elements from r array
		if (rightpointer < r.length) {
			for (int i = rightpointer; i < r.length; i++) {
				arr[arrposition] = r[i];
				arrposition++;
				moves++;
			}
		}
	}
	
	private void mergesort(int arr[], int left, int right) {
		if (right > left) {
			int mid = (right + left) / 2;
			mergesort(arr, left, mid);
			mergesort(arr, mid + 1, right);
			
			merge(arr, left, mid, right);
		}
	}
	
	public SortStats sort(int arr[]) {
		long nanoseconds = System.nanoTime();
		mergesort(arr, 0, arr.length - 1);
		return new SortStats("Merge Sort", arr.length, comparisons, moves, System.nanoTime() - nanoseconds);
	}
}
