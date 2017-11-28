package cd.litl.designmode.factoryMethod;

public class FactoryTest {

	public static void main (String []args) {
		
//		SenderFactory senderFactory = new SenderFactory();
//		
//		Sender sender1 = senderFactory.produce("Mail");
//		Sender sender2 = senderFactory.produce("Sms");
//		
//		sender2.send();
		
//		Sender sender1 = SenderFactory.produceMail();
//		Sender sender2 = SenderFactory.produceSms();
//		
//		sender2.send();
		
		provider provider = new MailSenderFactory();
		Sender sender1 = provider.produce();
		sender1.send(); 
		
	}
}
