package cd.litl.crazyJava.chapter3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.Vector;


enum Gender {
	MALE,FEMALE;
}
public class IteratorTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashSet<String> hashSet = new HashSet<String>();
		System.out.println("HashSet的Iterator+"+hashSet.iterator());
		
		LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
		System.out.println("LinkedHashSet的Iterator+"+linkedHashSet.iterator());
		
		TreeSet<String> treeSet = new TreeSet<String>();
		System.out.println("TreeSet的Iterator+"+treeSet.iterator());
		
		EnumSet<Gender> enumSet = EnumSet.allOf(Gender.class);
		System.out.println("EnumSet的Iterator+"+enumSet.iterator());
		
		ArrayList<String> arrayList = new ArrayList<String>();
		System.out.println("ArrayList的Iterator+"+arrayList.iterator());
		
		Vector<String> vector = new Vector<String>();
		System.out.println("Vector的Iterator+"+vector.iterator());
		
		LinkedList<String> linkedList = new LinkedList<String>();
		System.out.println("LinkedList的Iterator+"+linkedList.iterator());
		
		ArrayDeque<String> arrayDeque = new ArrayDeque<String>();
		System.out.println("ArrayDeque的Iterator+"+arrayDeque.iterator());
		
	}

}
