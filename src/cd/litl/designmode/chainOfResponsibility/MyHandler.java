package cd.litl.designmode.chainOfResponsibility;

public class MyHandler extends AbstractHandler implements Handler {

	private String name;
	
	public MyHandler (String name) {
		this.name = name;
	}
	
	@Override
	public void operator() {
		// TODO Auto-generated method stub

		System.out.println(name +"deal");
		if (null != getHandler()) {
			getHandler().operator();
		}
	}

}
