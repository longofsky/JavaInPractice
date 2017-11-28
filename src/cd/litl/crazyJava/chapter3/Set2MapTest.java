package cd.litl.crazyJava.chapter3;

public class Set2MapTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Set2Map<String,Integer> set2Map = new Set2Map<String,Integer>();
		
		set2Map.put("语文", 99);
		set2Map.put("数学", 98);
		set2Map.put("英语", 97);
		set2Map.put("物理", 96);
		System.out.println(set2Map);
		System.out.println(set2Map.size());
		
		set2Map.removeEntry("语文");
		System.out.println(set2Map);
		System.out.println(set2Map.size());
		
		System.out.println("语文成绩+"+set2Map.getValue("数学"));
		
		System.out.println("是否包含英语"+set2Map.containsKey("英语"));
		System.out.println("是否包含96"+set2Map.containsValue(96));
	}

}
