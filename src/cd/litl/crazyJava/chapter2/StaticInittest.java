package cd.litl.crazyJava.chapter2;

public class StaticInittest {

	/**
	 * @param args
	 */
	static int count = 2;
	
	static String name = "���Java";
	static {
		System.out.println("��̬��ʼ����");
		name = "java���";
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("���ʸ��������������");
		System.out.println(StaticInittest.count);
		System.out.println(StaticInittest.name);
	}

}
