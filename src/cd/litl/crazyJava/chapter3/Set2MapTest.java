package cd.litl.crazyJava.chapter3;

public class Set2MapTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Set2Map<String,Integer> set2Map = new Set2Map<String,Integer>();
		
		set2Map.put("����", 99);
		set2Map.put("��ѧ", 98);
		set2Map.put("Ӣ��", 97);
		set2Map.put("����", 96);
		System.out.println(set2Map);
		System.out.println(set2Map.size());
		
		set2Map.removeEntry("����");
		System.out.println(set2Map);
		System.out.println(set2Map.size());
		
		System.out.println("���ĳɼ�+"+set2Map.getValue("��ѧ"));
		
		System.out.println("�Ƿ����Ӣ��"+set2Map.containsKey("Ӣ��"));
		System.out.println("�Ƿ����96"+set2Map.containsValue(96));
	}

}
