package recursion_1;

import java.util.Scanner;

public class MirrorNumber {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		printTheMirrorNumber(n);
		sc.close();
	}
	
	public static void printTheMirrorNumber(int n) {
		while(n>0) {
			System.out.print(n%10);
			n/=10;
		}
	}
}
