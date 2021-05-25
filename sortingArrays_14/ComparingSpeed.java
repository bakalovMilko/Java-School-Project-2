package sortingArrays_14;

import java.util.HashSet;
import java.util.Iterator;

public class ComparingSpeed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Array size | Selection Sort | Bubble Sort | MergeSort | Quick Sort");
		for(int i = 500; i<3500; i+= 500) {
			int[] array = randomArray(i);
			int[] workArray = array.clone(); 
			
			long timeBeginning = System.currentTimeMillis();
			bubbleSort(workArray);
			long timeEnd = System.currentTimeMillis();
			long timeBubble = timeEnd - timeBeginning;
			
			timeBeginning = System.currentTimeMillis();
			insertionSort(workArray);
			timeEnd = System.currentTimeMillis();
			long timeInsertion = timeEnd - timeBeginning;
			
			timeBeginning = System.currentTimeMillis();
			mergeSort(workArray);
			timeEnd = System.currentTimeMillis();
			long timeMerge = timeEnd - timeBeginning;
			
			timeBeginning = System.currentTimeMillis();
			quickSort(workArray);
			timeEnd = System.currentTimeMillis();
			long timeQuick = timeEnd - timeBeginning;
			
			System.out.println(i + " | " + timeBubble + " | " + timeInsertion + " | " + timeMerge + " | " + timeQuick);
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
	public static void insertionSort(int[] list) {
		for (int i = 1; i < list.length; i++) {
			/**
			 * Insert list[i] into a sorted sublist
			 *  list[0..i-1] so that list[0..i] is
			 * sorted.
			 */
			int currentElement = list[i];
			int k;
			for (k = i - 1; k >= 0 && list[k] > currentElement; k--) {
				list[k + 1] = list[k];
			}
// Insert the current element into list[k + 1]
			list[k + 1] = currentElement;
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
		}
		return array;
	}

}
