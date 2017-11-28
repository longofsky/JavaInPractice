package cd.litl.crazyJava.chapter2;

public class StaticInittest {

	/**
	 * @param args
	 */
	static int count = 2;
	
	static String name = "疯狂Java";
	static {
		System.out.println("静态初始化块");
		name = "java编程";
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("访问该类的两个变量！");
		System.out.println(StaticInittest.count);
		System.out.println(StaticInittest.name);
	}

}
