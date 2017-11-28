package cd.litl.designmode.factoryMethod;

public class SmsSenderFactory implements provider {

	@Override
	public Sender produce() {
		// TODO Auto-generated method stub
		return new SmsSender();
	}

}
