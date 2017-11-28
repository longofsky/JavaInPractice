package cd.litl.crazyJava.chapter2;

class StaticBase {
	static int count = 20;
}
public class StaticSub extends StaticBase{

	static int count = 200;
	
	public void info () {
		System.out.println("访问本类的count类变量：" +count);
		System.out.println("访问父类的count类变量：" +StaticBase.count);
		System.out.println("访问父类的count类变量：" +super.count);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StaticSub sb = new StaticSub();
		sb.info();
	}

}
