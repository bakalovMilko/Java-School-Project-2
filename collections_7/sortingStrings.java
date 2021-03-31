package collections_7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class sortingStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File sourceFile = new File("C:\\Users\\User\\Documents\\workspace\\Eclipse in School\\textFile.txt");
		ArrayList<String> list = new ArrayList();
		list = fileToList(sourceFile);
		sortList(list);
		System.out.println(list.toString());
	}
	public static ArrayList<String> fileToList (File sourceFile){
		ArrayList<String> outputList = new ArrayList<>();
		try {
			Scanner sc = new Scanner(sourceFile);
			while (sc.hasNext()) {
				outputList.add(sc.next());
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outputList;
	}
	public static void sortList (ArrayList<String> list) {
		boolean hasToContinue = true;
		while(hasToContinue) {
			hasToContinue = false;
			for(int i=0; i<list.size()-1; i++) {
				if(list.get(i).compareTo(list.get(i+1))>0) {
					String current = list.get(i);
					list.set(i, list.get(i+1));
					list.set(i+1, current);
					hasToContinue = true;
				}
			}
		}
	}

}
