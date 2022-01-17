package soGraphs;

import java.util.Arrays;
import java.util.Collections;

public class SortingMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int length = 4096;
		ISorter sorter [] = {new QuickSort(), new HeapSort(), new InsertionSort(), new SelectionSort(), new BubbleSort(), new MergeSort()};
		
		System.out.println("---------------------RANDOM ARRAYS---------------------");
		//Creates like the 2, 4, 8, .... length arrays
		for (int i = 1; i <= length; i *= 2) {
			Integer arr [] = new Integer [i];
			
			//Sorted array
			for (int j = 1; j <= i; j++) {
				arr[j-1] = j;
			}
			
			//Shuffles that sorted array
			Collections.shuffle(Arrays.asList(arr));
			int b [] = new int [i];
			
			//Convert Integer array to int array
			for (int j = 0; j < i; j++) {
				b[j] = arr[j];
			}
			
			
			
			for (ISorter sorting: sorter) {
				int copyarr [] = b.clone();
				
				//Create a clone for each sorting method				
				SortStats stats = (SortStats) sorting.sort(copyarr);
				
				//Did the sorting method put the array in order?
				System.out.println(Check.isInOrder(copyarr));
				
				//The statics of the array
				System.out.println(stats);
				System.out.println();
			}
		}
		
		System.out.println("---------------------REVERSE ARRAYS---------------------");
		for (ISorter sorting: sorter) {
			int[] arr = new int[length];
			for (int j = arr.length; j > 0; j--) {
				arr[j-1] = arr.length - j + 1;
			}
			
			SortStats stats = (SortStats) sorting.sort(arr);
			System.out.println(Check.isInOrder(arr));
			System.out.println(stats);
			System.out.println();
		}
		
		System.out.println("---------------------SORTED ARRAYS---------------------");
		for (ISorter sorting: sorter) {
			int[] arr = new int[length];
			for (int j = 0; j < arr.length; j++) {
				arr[j] = j + 1;
			}
			
			SortStats stats = (SortStats) sorting.sort(arr);
			System.out.println(Check.isInOrder(arr));
			System.out.println(stats);
			System.out.println();
		}
	}
}
