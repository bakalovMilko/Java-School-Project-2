package allgorithmEfficiency;

import java.util.Scanner;

public class SearchingInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the first string: ");
		String s1 = sc.next();
		System.out.print("Enter the second string: ");
		String s2 = sc.next();
		sc.close();
		System.out.println((containsAString(s1, s2)>=0)? ("matched at index " + containsAString(s1, s2)) : "no match");
		//System.out.println(s1);
	}
	public static int containsAString (String s1, String s2) {
		int matchingChars = 0;
		String current1 = s1;
		current1.toLowerCase();
		String current2 = s2;
		current2.toLowerCase();
		for(int i = 0; i < current1.length(); i++) {
			if(current1.charAt(i) == current2.charAt(matchingChars)) {
				matchingChars++;
			}
			else {
				i -= matchingChars;
				matchingChars = 0;
			}
			if(matchingChars == current2.length()) {
				return i-matchingChars + 1;
			}
		}
		return -1;
	}

}
