package collections_7;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

import collections_7.DLL.Node;

public class LinkedListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int i=0; i<50000; i++) {
			list.addLast(i);
		}
		int a;
		//Test with iterator
		long miliSec1 =  java.lang.System.currentTimeMillis();
		for(Iterator<Integer> itr = list.iterator(); itr.hasNext();) {
			a = itr.next(); 
		}
		long miliSecEnd1 = java.lang.System.currentTimeMillis();
		System.out.println(miliSecEnd1 - miliSec1);
		
		//Test with get()
		/*long miliSec2 = java.lang.System.currentTimeMillis();
		for(Integer i : list) {
			a = list.get(i); 
		}
		long miliSecEnd2 = java.lang.System.currentTimeMillis();
		System.out.println(miliSecEnd2 - miliSec2);
		*/
	}

}
