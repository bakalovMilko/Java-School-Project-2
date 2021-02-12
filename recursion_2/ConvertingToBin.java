package recursion_2;

import java.util.Scanner;

public class ConvertingToBin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc. nextInt();
		sc.close();
		System.out.println(dec2Bin(n));
	}
	public static String dec2Bin (int value) {
		if(value==0) {
			return "";
		}
		else {
			return dec2Bin(value/2) + value%2;
		}
	}
}
