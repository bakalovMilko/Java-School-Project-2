package recursion_1;

import java.util.Scanner;

public class PowersOfTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		System.out.println(recursionMethod(n));
		System.out.println(iterativeMethod(n));
	}
	public static int recursionMethod(int n) {
		if(n==0) {
			return 1;
		}
		else {
			return 2 * recursionMethod(n-1);
		}
	}
	public static int iterativeMethod (int n) {
		int ans = 1;
		for(int i=0; i<n; i++) {
			ans*=2;
		}
		return ans;
	}
}
