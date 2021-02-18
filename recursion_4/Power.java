package recursion_3;

import java.util.Scanner;

public class Power {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int power = sc.nextInt();
		System.out.println(powRecursive(n, power));
	}

    public static int powRecursive( int x, int n ) {
    	return powRecursive(x, n, 1);
    }
    public static int powRecursive(int x, int n, int ans) {
    	if(n==0) {
    		return ans;
    	}
    	else {
    		return powRecursive(x, n-1, ans*x);
    	}
    }


}
