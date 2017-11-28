package cd.litl.crazyJava.chapter5;

public class CompositeAssign {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		short st = 5;
		//没有问题系统执行隐式的类型转换
		st += 10;//相当于st = (short)(st + 10)
		System.out.println(st);
		st += 90000;//90015 无法转换为short  导致计算结果出错
		System.out.println(st);
	}

}
