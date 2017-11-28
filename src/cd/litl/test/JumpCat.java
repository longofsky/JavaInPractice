package cd.litl.test;
class Cat {
	private String name;
	private int age;
	public Cat () {
		
	}
	public Cat (String name,int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
public class JumpCat extends Cat {
	
	public JumpCat () {
		super();
	}
	
	public JumpCat (String name,int age) {
		super(name,age);
	}
}
