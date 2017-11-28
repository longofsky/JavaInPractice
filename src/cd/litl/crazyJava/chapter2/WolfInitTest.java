package cd.litl.crazyJava.chapter2;


class Creature {
	{
		System.out.println("creature 非静态代码块");
	}
	
	public Creature () {
		System.out.println("creature 无惨构造器");
	}
	
	public Creature (String name) {
		this();
		System.out.println("creature name参数构造器+"+name);
	}
}

class Animer extends Creature {
	{
		System.out.println("Animer 非静态代码块");
	}
	
	
	
	public Animer (String name) {
		super(name);
		System.out.println("Animer name参数构造器+"+name);
	}
	
	public Animer (String name,int age) {
		this(name);
		System.out.println("Animer name参数构造器+"+name+"age参数构造器+"+age);
	}
}

class Wolf extends Animer{
	{
		System.out.println("Wolf 非静态代码块");
	}
	
	
	public Wolf () {
		super ("灰太狼",23);
		
		System.out.println("WOlf 无惨构造器");
	}
	
	
	public Wolf (String name) {
		super(name);
		System.out.println("Wolf name参数构造器+"+name);
	}
	
	public Wolf (double weight) {
		this();
		System.out.println("Wolf weight参数构造器+"+weight);
	}
}

public class WolfInitTest {
	public static void main (String [] args) {
		Wolf wolf = new Wolf(5.6);
	}
}
