package cd.litl.crazyJava.chapter7;
//循环调用 构造器  导致内存溢出
public class ConstrucorRecursion {

	ConstrucorRecursion rc;
	{
		rc = new ConstrucorRecursion();
	}
	public ConstrucorRecursion () {
		System.out.println("程序执行无参数的构造器");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConstrucorRecursion rc = new ConstrucorRecursion();
	}

}
