package cd.litl.crazyJava.chapter5;

public class ImmutableString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Hello ";
		StringBuilder builder1 = new StringBuilder("Hello ");
		System.out.println(builder1.toString());
		System.out.println(System.identityHashCode(builder1));//identityHashCode  打印对象地址的hash值,是否指向同一块内存，同一对象
		str = str + "java1";
		builder1 = builder1.append("java1");
		System.out.println(builder1.toString());
		System.out.println(System.identityHashCode(builder1));
		str = str + "java2";
		builder1 = builder1.append("java2");
		System.out.println(builder1.toString());
		System.out.println(System.identityHashCode(builder1));
		
		String str1 = new String ("WWWW");
		String str2 = new String ("WWWW");
		System.out.println(str1.equals(str2));
		System.out.println(System.identityHashCode(str1)==System.identityHashCode(str2));
	}

}
