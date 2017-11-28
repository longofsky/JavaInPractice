package cd.litl.crazyJava.chapter2;

class Fruit {
	String color ="未确认的颜色";
	
	public Fruit getThis () {
		return this;
	}
	
	public void info () {
		System.out.println("Fruit 的方法");
	}
}

public class Apple extends Fruit{
	
	public void info () {
		System.out.println("Apple 的方法");
	}
	
	public void accessSuperinfo () {
		super.info();
	}

	
	public Fruit getSuper () {
		return super.getThis();
	}
	
	String color = "red";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Apple a = new Apple();
		Fruit f = a.getSuper();
		
		System.out.println("a 和f 所引用的对象是否相同" + (a == f));
		System.out.println("a所引用对象的实例变量color:"+a.color);
		System.out.println("f所引用对象的实例变量color:"+f.color);
		
		a.info();
		f.info();
		
		a.accessSuperinfo();
		
		
	}

}
