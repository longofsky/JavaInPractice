package cd.litl.designmode.decorator;

public class Decorator implements Sourceable{

	private Source source;
	public Decorator (Source source) {
		this.source = source;
	}
	@Override
	public void method() {
		// TODO Auto-generated method stub
		
		System.out.println("装饰前");
		source.method();
		System.out.println("装饰后");
		
	}

	
}
