package cd.litl.designmode.proxy;

public class Decorator implements Sourceable{

	private Source source;
	public Decorator () {
		this.source = new Source();
	}
	@Override
	public void method() {
		// TODO Auto-generated method stub
		
//		System.out.println("装饰前");
		before();
		source.method();
//		System.out.println("装饰后");
		after();
		
	}
	
	private void before() {
		System.out.println("代理前");
	}
	
	private void after() {
		System.out.println("代理后");
	}

	
}
