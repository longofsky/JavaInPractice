package cd.litl.crazyJava.chapter2;


class Creature {
	{
		System.out.println("creature �Ǿ�̬�����");
	}
	
	public Creature () {
		System.out.println("creature �޲ҹ�����");
	}
	
	public Creature (String name) {
		this();
		System.out.println("creature name����������+"+name);
	}
}

class Animer extends Creature {
	{
		System.out.println("Animer �Ǿ�̬�����");
	}
	
	
	
	public Animer (String name) {
		super(name);
		System.out.println("Animer name����������+"+name);
	}
	
	public Animer (String name,int age) {
		this(name);
		System.out.println("Animer name����������+"+name+"age����������+"+age);
	}
}

class Wolf extends Animer{
	{
		System.out.println("Wolf �Ǿ�̬�����");
	}
	
	
	public Wolf () {
		super ("��̫��",23);
		
		System.out.println("WOlf �޲ҹ�����");
	}
	
	
	public Wolf (String name) {
		super(name);
		System.out.println("Wolf name����������+"+name);
	}
	
	public Wolf (double weight) {
		this();
		System.out.println("Wolf weight����������+"+weight);
	}
}

public class WolfInitTest {
	public static void main (String [] args) {
		Wolf wolf = new Wolf(5.6);
	}
}
