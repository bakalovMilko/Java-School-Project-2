package recursion_1;

import java.util.Scanner;

public class SumUpToN {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		sc.close();
		System.out.println("Sum is " + sumUpToN(n));
	}
	
	public static int sumUpToN(int n) {
		int sum=0;
		for(int i=0; i<=n; i++) {
			sum+=i;
		}
		return sum;
	}
}

