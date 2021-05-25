package sets_9;

import java.util.*;
import java.io.*;

public class CountKeywords {
	public static void main(String[] args) throws Exception {
		File file = new File("src/sets_9/CountLetters.java");
		if (file.exists()) {
			System.out.println("The number of keywords is " + countKeywords(file));
		} else {
			System.out.println("File does not exist");
		}

	}

	public static int countKeywords(File file) throws Exception {

		String[] keywordString = { "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class",
				"const", "continue", "default", "do", "double", "else", "enum", "extends", "for", "final", "finally",
				"float", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native",
				"new", "package", "private", "protected", "public", "return", "short", "static", "strictfp", "super",
				"switch", "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "while",
				"true", "false", "null" };
		Set<String> keywordSet = new HashSet<String>(Arrays.asList(keywordString));
		int count = 0;

		boolean quotes = false;
		boolean comments = false;
		
		Scanner input = new Scanner(file);
		while (input.hasNextLine()) {
			String line = input.nextLine();
			String[] words = line.split(" ");
			for(String word : words) {
				if(comments && !word.contains("*//")) 
					continue;
				else if(comments) {
					comments = false;
					word = word.substring(word.indexOf("*//") + 1, word.length()-1);
				}
				if(word.contains("//*")) {
					if(keywordSet.contains(word.substring(word.indexOf("//*")))) 
						count ++;
					comments = true;
				}
				else if(word.contains("////")) {
					if(keywordSet.contains(word.substring(word.indexOf("////")))) 
						count ++;
					break;
				}
				else if(keywordSet.contains(word))
					count ++;
			}
		}
		return count;
	}
}