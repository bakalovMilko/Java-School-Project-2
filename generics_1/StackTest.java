package generics_1;

import java.util.Scanner;

public class StackTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		GenericStack<String> stack = new GenericStack();
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
