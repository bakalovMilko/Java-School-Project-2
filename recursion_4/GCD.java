package recursion_3;

import java.util.Scanner;

public class GCD {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		sc.close();
		System.out.println(foo(a,b));
	}
	public static int foo (int x, int y)
	{
		if (y == 0) return x;
		else return foo(y, x % y);
	}
	   


}
