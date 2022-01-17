package soGraphs;

public class SelectionSort implements ISorter {
	
	public SelectionSort() {
		//Empty Constructor
	}
	
	public SortStats sort(int arr []) {
		long nanoseconds = System.nanoTime();
		int comparisons = 0;
		int moves = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			int lowest = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[lowest]) {
					lowest = j;
				}
				comparisons++;
			}
			int temp = arr[i];
			arr[i] = arr[lowest];
			arr[lowest] = temp;
			
			moves += 2;
		}
		
		return new SortStats("Selection Sort", arr.length, comparisons, moves, System.nanoTime() - nanoseconds);
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
