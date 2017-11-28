package cd.litl.crazyJava.chapter2;

class Base1{
	int count = 2;
	public void display () {
		System.out.println(this.count);
	}
}

class Derived1 extends Base1 {
	int count = 20;
	 
	public void display () {
		System.out.println(this.count);
	}
}

public class FieldAndMethodTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Base1 b = new Base1();
		System.out.println(b.count);
		
		b.display();
		
		Derived1 d = new Derived1();
		System.out.println(d.count);
		
		d.display();
		
		Base1 bb = new Derived1();
		System.out.println(bb.count);
		
		bb.display();
		
	}

}
