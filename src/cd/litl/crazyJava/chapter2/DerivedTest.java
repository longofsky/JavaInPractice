package cd.litl.crazyJava.chapter2;

class Base {
	private int i= 2;
	
	public Base () {
		this.display();
	}
	
	public void display () {
		System.out.println(i);
	}
}

class Derived extends Base {
	private int i = 22;
	
	public Derived () {
		i = 222;
	}
	
	public void display () {
		System.out.println(i);
	}
}




public class DerivedTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Derived();
	}

}
