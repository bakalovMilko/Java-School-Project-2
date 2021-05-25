package google_12;

import java.util.HashSet;

public class searchingForASum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 12;
		int[] testArray = {1, 2, 5, 2, 10};
		System.out.println(hasASum_n2(testArray, n));
		System.out.println(hasASum_nlogn(testArray, n));
		System.out.println(hasASum_n_sorted(testArray, n));
		System.out.println(hasASum_n_unsorted(testArray, n));
	}
	public static boolean hasASum_n2 (int[] array, int sum) {
		for(int i = 0; i<array.length; i++) {
			for(int j = i+1; j<array.length;j++) {
				if(array[i] + array[j] == sum)
					return true;
			}
		}
		return false;
	}
	public static boolean hasASum_nlogn (int[] array, int sum) {
		for(int i = 0; i<array.length; i++) {
			int low = i+1;
			int high = array.length-1;
			while(high >= low) {
				int mid = (high + low)/2;
				if(array[mid] + array[i] == sum)
					return true;
				else if(array[mid] + array[i] > sum)
					high = mid - 1;
				else 
					low = mid + 1;
			}
			
		}
		return false;
	}
	public static boolean hasASum_n_sorted (int[] array, int sum) {
		int low = 0;
		int high = array.length - 1;
		while(high > low) {
			if(array[high] + array[low] == sum)
				return true;
			else if(array[high] + array[low] > sum)
				high --;
			else 
				low ++;
		}
		return false;
	}
	public static boolean hasASum_n_unsorted(int[] array, int sum) {
		HashSet<Integer> cont = new HashSet<Integer>();
		for(int i : array) {
			if(cont.contains(i)) {
				return true;
			}
			else
				cont.add(sum - i);
		}
		return false;
	}

}
