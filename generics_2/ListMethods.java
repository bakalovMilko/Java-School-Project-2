package generics_2;

import java.util.ArrayList;

public class ListMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> integers = new ArrayList<>();
		integers.add(7);
		integers.add(1);
		integers.add(3);
		integers.add(2);
		integers.add(4);
		shuffle(integers);
		System.out.println(integers.toString());
		sort(integers);
		System.out.println(integers.toString());
		System.out.println(min(integers));
	}
	public static <E> void shuffle(ArrayList<E> list) {
		for(int i=0; i<list.size(); i++) {
			int randomIndex = (int)((i-1)*Math.random());
			E randomObject = list.get(randomIndex);
			list.set(randomIndex, list.get(i));
			list.set(i, randomObject);
		}
	}
	
	public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
		for (int i = 0; i < list.size(); i++) {
			E currentMin = list.get(i);
			int currentMinIndex = i;
			for (int j = i + 1; j < list.size(); j++) {
				if (currentMin.compareTo(list.get(j)) > 0) {
					currentMin = list.get(j);
					currentMinIndex = j;
				}
			}
			if (currentMinIndex != i) {
				list.set(currentMinIndex , list.get(i));
				list.set(i, currentMin);
			}
		}
	}
	
	public static <E extends Comparable<E>> E min(ArrayList<E> list) {
		E min = list.get(0);
		for(int i=1; i< list.size(); i++) {
			if(min.compareTo(list.get(i))>0) {
				min = list.get(i);
			}
		}
		return min;
	}


}
