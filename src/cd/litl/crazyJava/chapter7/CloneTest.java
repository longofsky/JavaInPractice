package cd.litl.crazyJava.chapter7;
class Dog implements Cloneable {
	private String name ;
	private double weight;
	public Dog (String name,double weight) {
		System.out.println("调用带参构造器");
		this.name = name;
		this.weight = weight;
	}
	@Override
	protected Object clone(){
		// TODO Auto-generated method stub
		Dog dog = null;
			try {
				dog = (Dog)super.clone();
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return dog;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (this == obj) {
			return true;
		}
		if (this.getClass() == obj.getClass()) {
			Dog target = (Dog) obj;
			return this.name.equals(target.name) && this.weight == target.weight;
		}
		return false;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return name.hashCode()*17 + (int)weight;
	}
	
	//重写clone 方法
	
}
public class CloneTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Dog dog = new Dog("Blot", 9.9);
		System.out.println("dog 对象创建");
		
		Dog dog2 = (Dog)dog.clone();
		System.out.println(dog.equals(dog2));
		System.out.println(dog == dog2);
	}

}
