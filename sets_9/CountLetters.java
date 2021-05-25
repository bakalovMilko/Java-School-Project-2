package sets_9;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CountLetters {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		File file = new File("src/capitals.txt");
		if (file.exists()) {
			System.out.println("The number of vowels is " + countVowels(file));
			System.out.println("The number of consonants is " + countConsonants(file));
		} else {
			System.out.println("File does not exist");
		}

	}
	public static int countVowels(File file) throws Exception {
		Character[] vowels = {'A', 'O','U','E','I', 'a','o', 'u', 'e', 'i'};
		Set<Character> vowelSet = new HashSet<Character>(Arrays.asList(vowels));
		
		int count = 0;
		
		Scanner sc = new Scanner(file);
		while(sc.hasNext()) {
			String current = sc.next();
			for(int i=0; i<current.length(); i++) {
				if(vowelSet.contains(current.charAt(i)))
					count++;
			}
		}
		sc.close();
		return count;
	}
	public static int countConsonants(File file) throws Exception{
		Character[] vowels = {'A', 'O','U','E', 'I', 'a','o', 'u', 'e', 'i'};
		Set<Character> vowelSet = new HashSet<Character>(Arrays.asList(vowels));
		
		int count = 0;
		
		Scanner sc = new Scanner(file);
		while(sc.hasNext()) {
			String current = sc.next();
			for(int i=0; i<current.length(); i++) {
				if(!vowelSet.contains(current.charAt(i)) && (current.charAt(i)>'a' && current.charAt(i)<='z'
						|| current.charAt(i)>'A' && current.charAt(i)<='Z'))
					count++;
			}
		}
		sc.close();
		return count;
	}

}
