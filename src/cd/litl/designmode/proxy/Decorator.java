package cd.litl.designmode.proxy;

public class Decorator implements Sourceable{

	private Source source;
	public Decorator () {
		this.source = new Source();
	}
	@Override
	public void method() {
		// TODO Auto-generated method stub
		
//		System.out.println("װ��ǰ");
		before();
		source.method();
//		System.out.println("װ�κ�");
		after();
		
	}
	
	private void before() {
		System.out.println("����ǰ");
	}
	
	private void after() {
		System.out.println("�����");
	}

	
}
