package cd.litl.crazyJava.chapter2;


class Base2 {
	int count = 2;
	public void test() {
		System.out.println("Base2");
	}
}

class Mid extends Base2 {
	int count = 20;
	public void test() {
		System.out.println("Mid");
	}
}
public class Sub extends Mid{

	int count = 200;
	public void test() {
		System.out.println("Sub");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Sub sub = new Sub();
		Mid mid = sub;
		Base2 base2  = sub;
		
		System.out.println(sub.count);
		sub.test();
		System.out.println(mid.count);
		mid.test();
		System.out.println(base2.count);
		base2.test();
	}

}
