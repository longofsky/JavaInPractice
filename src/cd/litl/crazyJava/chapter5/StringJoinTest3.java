package cd.litl.crazyJava.chapter5;

public class StringJoinTest3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "Hello Java�ĳ��ȣ�10";
		final String s1 = "Hello ";
		String Str2 = s1+"Java�ĳ��ȣ�"+10;
		final int length = 10;
		String str3 = "Hello "+"Java�ĳ��ȣ�"+length;
		System.out.println(str1 == Str2);
		System.out.println(Str2 == str3);
		
	}

}
