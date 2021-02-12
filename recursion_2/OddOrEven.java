package recursion_2;

import java.util.Scanner;

public class OddOrEven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);	
		int n = sc.nextInt();
		sc.close();
		System.out.println("The number is " + (isEven(n)? "even": "odd"));
	}
	public static boolean isEven (int n) {
		if(n==0) {
			return true;
		}
		else if(n==1) {
			return false;
		}
		else {
			return isEven(n-2);
		}
	}
}
