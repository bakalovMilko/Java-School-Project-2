package generics_1;

import java.util.Scanner;

public class StackTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		GenericStack2<String> stack = new GenericStack2();
		for(int i=0; i<5; i++){
			System.out.println("Please enter a name of a city:");
			stack.push(sc.next());
		}
		sc.close();
		for(int i=0; i<5; i++){
			System.out.println(stack.pop());
		}
	}

}
