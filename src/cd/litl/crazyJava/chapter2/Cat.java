package cd.litl.crazyJava.chapter2;

public class Cat {
	
//	定义两个实例变量
	String  name;
	int age;
	public Cat (String name,int age) {
		
		System.out.println("执行构造器");
		this.name = name;
		this.age = age;
	}
	
//	非静态代码块
	
	
	double weight = 2.3;
	{
		System.out.println("非静态代码块！");
		weight = 2.0;
	}
	public String toString () {
		return "Cat[name=" +name+"age="+age+"weight="+weight+"]";
	}

}
