package soGraphs;

public class InsertionSort implements ISorter {
	
	public InsertionSort() {
		//Empty Constructor
	}
	
	public SortStats sort(int nums []) {
		long nanoseconds = System.nanoTime();
		int comparisons = 0;
		int moves = 0;
		for (int i = 1; i < nums.length; i++) {
			int index = i - 1;
			int val = nums[i];
			moves++;
			
			while (index >= 0 && nums[index] > val) {
				nums[index + 1] = nums[index];
				moves ++;
				comparisons++;
				index -= 1;
			}
			
			nums[index + 1] = val;
			moves++;
		}
		
		return new SortStats("Insertion Sort", nums.length, comparisons, moves, System.nanoTime() - nanoseconds);
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
