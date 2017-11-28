package cd.litl.test;

public class TrueLength {

	public static void main (String []args) {
		System.out.println(getTruelength("123456789"));
	}
	
	public static double getTruelength (String str) {
		double valueLength = 0;  
//		String chinese = "[\u4e00-\u9fa5]";  
		String chinese = "[^\\x00-\\xff]";
		// 获取字段值的长度，如果含中文字符，则每个中文字符长度为2，否则为1  
		for (int i = 0; i < str.length(); i++) {  
			// 获取一个字符  
			String temp = str.substring(i, i + 1);  
			// 判断是否为中文字符  
			if (temp.matches(chinese)) {  
		        // 中文字符长度为1  
		 		valueLength += 3;  
		 	} else {  
		 		// 其他字符长度为0.5  
		 		valueLength += 1;  
		 	}  
		 }  
		    //进位取整  
		 return Math.ceil(valueLength);
	}
}
