package cd.litl.designmode.chainOfResponsibility;

public class test {

	public static void main (String [] args) {
		MyHandler myHandler1 = new MyHandler("handler1");
		MyHandler myHandler2 = new MyHandler("handler2");
		MyHandler myHandler3 = new MyHandler("handler3");
		
		myHandler1.setHandler(myHandler2);
		myHandler2.setHandler(myHandler3);
//		myHandler3.setHandler(myHandler1);//会循环 无限
		
		myHandler1.operator();
	}
}
