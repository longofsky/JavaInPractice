package cd.litl.test;

public class TrueLength {

	public static void main (String []args) {
		System.out.println(getTruelength("123456789"));
	}
	
	public static double getTruelength (String str) {
		double valueLength = 0;  
//		String chinese = "[\u4e00-\u9fa5]";  
		String chinese = "[^\\x00-\\xff]";
		// ��ȡ�ֶ�ֵ�ĳ��ȣ�����������ַ�����ÿ�������ַ�����Ϊ2������Ϊ1  
		for (int i = 0; i < str.length(); i++) {  
			// ��ȡһ���ַ�  
			String temp = str.substring(i, i + 1);  
			// �ж��Ƿ�Ϊ�����ַ�  
			if (temp.matches(chinese)) {  
		        // �����ַ�����Ϊ1  
		 		valueLength += 3;  
		 	} else {  
		 		// �����ַ�����Ϊ0.5  
		 		valueLength += 1;  
		 	}  
		 }  
		    //��λȡ��  
		 return Math.ceil(valueLength);
	}
}
