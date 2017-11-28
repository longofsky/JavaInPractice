package cd.litl.designmode.adapter.interFaceAdapter;

public abstract class Adapter implements Targetable {

	@Override
	public void method1() {
		System.out.println("this is method1 method!");
	}
	
	@Override
	public void method2() {
		System.out.println("this is method2 method!");

	}

}
