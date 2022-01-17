package soGraphs;

public class BubbleSort implements ISorter {
	
	public BubbleSort() {
		//Empty Constructor
	}
	
	public SortStats sort(int arr[]) {
		long nanoseconds = System.nanoTime();
		boolean sorted = false;
		int comparisons = 0;
		int moves = 0;
		while (!sorted) {
			sorted = true;
			for (int i = 0; i < arr.length - 1; i++) {
				comparisons++;
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					moves += 2;
					
					sorted = false;
				}
			}
		}
		return new SortStats("Bubble Sort", arr.length, comparisons, moves, System.nanoTime() - nanoseconds);
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
