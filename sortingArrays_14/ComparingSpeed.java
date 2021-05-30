package sortingArrays_14;

import java.util.HashSet;
import java.util.Iterator;

public class ComparingSpeed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String headingFormat = "%-12s%-7s%-10s%-6s%-6s%n";
		String dataFormat = "%-12d%-7d%-10d%-6d%-6d%n";
		System.out.printf(headingFormat, "Array size", "Bubble", "Selection", "Merge", "Quick");
		for(int i = 5000; i<35000; i+= 5000) {
			int[] array = randomArray(i);
			int[] workArray = array.clone(); 
			
			long timeBeginning = System.currentTimeMillis();
			bubbleSort(workArray);
			long timeEnd = System.currentTimeMillis();
			long timeBubble = timeEnd - timeBeginning;     
			                                               
			workArray = array.clone();                     
			timeBeginning = System.currentTimeMillis();    
			selectionSort(workArray);
			timeEnd = System.currentTimeMillis();
			long timeSelection = timeEnd - timeBeginning;
			
			workArray = array.clone();
			timeBeginning = System.currentTimeMillis();
			mergeSort(workArray);
			timeEnd = System.currentTimeMillis();
			long timeMerge = timeEnd - timeBeginning;
			
			workArray = array.clone();
			timeBeginning = System.currentTimeMillis();
			quickSort(workArray);
			timeEnd = System.currentTimeMillis();
			long timeQuick = timeEnd - timeBeginning;
			
			System.out.printf(dataFormat, i, timeBubble, timeSelection, timeMerge, timeQuick);
		}
	}
	public static void bubbleSort(int[] list) {
		for (int k = 0; k < list.length - 1; k++) {
			for (int i = 0; i < list.length - 1 - k; i++) {
				if (list[i] > list[i + 1]) {
					// Swap list[i] with list[i + 1]
					int temp = list[i];
					list[i] = list[i + 1];
					list[i + 1] = temp;
				}
			}
		}
	}
	public static void selectionSort(int[] list) {
		for (int i = 0; i < list.length - 1; i++) {
			// Find the minimum in the list[i..list.length-1]
						int currentMin = list[i];
						int currentMinIndex = i;
						for (int j = i + 1; j < list.length; j++) {
							if (currentMin > list[j]) {
								currentMin = list[j];
								currentMinIndex = j;
							}
						}
			// Swap list[i] with list[currentMinIndex] if necessary
						if (currentMinIndex != i) {
							list[currentMinIndex] = list[i];
							list[i] = currentMin;
						}
					}
	}
	public static void mergeSort(int[] list) {
		if (list.length > 1) {
// Merge sort the first half
			int[] firstHalf = new int[list.length / 2];
			System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
			mergeSort(firstHalf);
// Merge sort the second half
			int secondHalfLength = list.length - list.length / 2;
			int[] secondHalf = new int[secondHalfLength];
			System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
			mergeSort(secondHalf);
// Merge firstHalf with secondHalf into list
			merge(firstHalf, secondHalf, list);
		}
	}

	/** Merge two sorted lists */
	public static void merge(int[] list1, int[] list2, int[] temp) {
		int current1 = 0;
		int current2 = 0;
		int current3 = 0;

		while (current1 < list1.length && current2 < list2.length) {
			if (list1[current1] < list2[current2])
				temp[current3++] = list1[current1++];
			else
				temp[current3++] = list2[current2++];
		}
		while (current1 < list1.length)
			temp[current3++] = list1[current1++];
		while (current2 < list2.length)
			temp[current3++] = list2[current2++];
	}
	public static void quickSort(int[] list) {
		quickSort(list, 0, list.length - 1);
	}

	public static void quickSort(int[] list, int first, int last) {
		if (last > first) {
			int pivotIndex = partition(list, first, last);
			quickSort(list, first, pivotIndex - 1);
			quickSort(list, pivotIndex + 1, last);
		}
	}

	/** Partition the array list[first..last] */
	public static int partition(int[] list, int first, int last) {
		int pivot = list[first]; // Choose the first element as the pivot
		int low = first + 1; // Index for forward search
		int high = last; // Index for backward search
		while (high > low) {
// Search forward from left
			while (low <= high && list[low] <= pivot)
				low++;
//Search backward from right
			while (low <= high && list[high] > pivot)
				high--;
//Swap two elements in the list
			if (high > low) {
				int temp = list[high];
				list[high] = list[low];
				list[low] = temp;
			}
		}
		while (high > first && list[high] >= pivot)
			high--;
//Swap pivot with list[high]
		if (pivot > list[high]) {
			list[first] = list[high];
			list[high] = pivot;
			return high;
		} else {
			return first;
		}
	}
	public static int[] randomArray(int size) {
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0; i<size; i++) {
			set.add(i);
		}
		int[] array = new int[size];
		for(int i = 0; i < size; i++) {
			int index = (int) (Math.random()*(size-i));
			Iterator<Integer> itr = set.iterator();
			for(int j=0; j < index; j++) {
				itr.next();
			}
			array[i] = itr.next();
			set.remove(array[i]);
		}
		return array;
	}

}
