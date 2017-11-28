package cd.litl.crazyJava.chapter5;

public class StringJoinTest2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "Hello Java的长度：10";
		String Str2 = "Hello "+"Java的长度："+"Hello Java".length();
		int length = 10;
		String str3 = "Hello "+"Java的长度："+length;
		System.out.println(str1 == Str2);
		System.out.println(Str2 == str3);
		
	}

}
