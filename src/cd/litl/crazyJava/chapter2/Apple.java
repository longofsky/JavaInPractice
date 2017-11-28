package cd.litl.crazyJava.chapter2;

class Fruit {
	String color ="δȷ�ϵ���ɫ";
	
	public Fruit getThis () {
		return this;
	}
	
	public void info () {
		System.out.println("Fruit �ķ���");
	}
}

public class Apple extends Fruit{
	
	public void info () {
		System.out.println("Apple �ķ���");
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
		
		System.out.println("a ��f �����õĶ����Ƿ���ͬ" + (a == f));
		System.out.println("a�����ö����ʵ������color:"+a.color);
		System.out.println("f�����ö����ʵ������color:"+f.color);
		
		a.info();
		f.info();
		
		a.accessSuperinfo();
		
		
	}

}
