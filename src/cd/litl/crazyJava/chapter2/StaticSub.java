package cd.litl.crazyJava.chapter2;

class StaticBase {
	static int count = 20;
}
public class StaticSub extends StaticBase{

	static int count = 200;
	
	public void info () {
		System.out.println("���ʱ����count�������" +count);
		System.out.println("���ʸ����count�������" +StaticBase.count);
		System.out.println("���ʸ����count�������" +super.count);
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
