package cd.litl.crazyJava.chapter2;

public class Cat {
	
//	��������ʵ������
	String  name;
	int age;
	public Cat (String name,int age) {
		
		System.out.println("ִ�й�����");
		this.name = name;
		this.age = age;
	}
	
//	�Ǿ�̬�����
	
	
	double weight = 2.3;
	{
		System.out.println("�Ǿ�̬����飡");
		weight = 2.0;
	}
	public String toString () {
		return "Cat[name=" +name+"age="+age+"weight="+weight+"]";
	}

}
