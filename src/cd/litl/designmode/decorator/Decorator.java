package cd.litl.designmode.decorator;

public class Decorator implements Sourceable{

	private Source source;
	public Decorator (Source source) {
		this.source = source;
	}
	@Override
	public void method() {
		// TODO Auto-generated method stub
		
		System.out.println("װ��ǰ");
		source.method();
		System.out.println("װ�κ�");
		
	}

	
}
