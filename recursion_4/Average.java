package recursion_3;

import java.util.Scanner;

public class Average {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner (System.in);
		int length = sc.nextInt();
		int[] arr = new int[length];
		for(int i=0; i<length; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		System.out.println(average(arr));
	}
	public static double average(int[] arr) {
		return average(arr, 0, 0);
	}
	public static double average(int[] arr, int n, double average) {
		if(n == arr.length) {
			return average;
		}
		else {
			return average(arr, n+1, (average*n+arr[n])/(n+1));
		}
	}

}
