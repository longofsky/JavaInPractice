package cd.litl.designmode.factoryMethod;

public class MailSenderFactory implements provider {

	@Override
	public Sender produce() {
		// TODO Auto-generated method stub
		return new MailSender();
	}

}
