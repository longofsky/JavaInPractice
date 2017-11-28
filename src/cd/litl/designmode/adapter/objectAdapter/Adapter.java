package cd.litl.designmode.adapter.objectAdapter;

public class Adapter extends Source implements Targetable {

	private Source source;
	public Adapter(Source source2) {
		// TODO Auto-generated constructor stub
		this.source = source2;
	}
	
	public void method1() {
		source.method1();

	}
	
	@Override
	public void method2() {
		System.out.println("this is target method!");

	}

}
