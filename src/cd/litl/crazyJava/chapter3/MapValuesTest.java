package cd.litl.crazyJava.chapter3;

import java.util.HashMap;
import java.util.TreeMap;

public class MapValuesTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<String, Double> scores = new HashMap<String, Double>();
		
		scores.put("111", (double) 99);
		scores.put("222", (double) 98);
		scores.put("333", (double) 87);
		scores.put("444", (double) 76);
		
		System.out.println(scores.values());
		System.out.println(scores.values().getClass());
		
		TreeMap<String, Double> treeMap = new TreeMap<String, Double>();
		
		treeMap.put("aaa", 12.0);
		treeMap.put("bbb", 13.0);
		treeMap.put("ccc", 14.0);
		treeMap.put("ddd", 15.0);
		
		System.out.println(treeMap.values());
		System.out.println(treeMap.values().getClass());
	}

}
