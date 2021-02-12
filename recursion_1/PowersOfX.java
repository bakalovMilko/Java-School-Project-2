package recursion_1;

import java.util.Scanner;

public class PowersOfX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), k=n;
		double x = sc.nextDouble();
		sc.close();
		System.out.println(recursionMethod(k, x));
		System.out.println(iterativeMethod(n, x));
	}
	public static double recursionMethod(int n, double x) {
		if(n==0) {
			return 1;
		}
		else {
			return x * recursionMethod(n-1, x);
		}
	}
	public static double iterativeMethod (int n, double x) {
		double ans = 1;
		for(int i=0; i<n; i++) {
			ans*=x;
		}
		return ans;
	}

}
