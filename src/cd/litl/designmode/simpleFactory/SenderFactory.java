package cd.litl.designmode.simpleFactory;

public class SenderFactory {
	
	public Sender produce (String type) {
		
		if ("Mail".equals(type)) {
			return new MailSender();
		} else if ("Sms".equals(type)) {
			return new SmsSender();
		} else {
			System.out.println("请输入正确类型");
			return null;
		}
		
	}
	
	public static Sender produceMail () {
		return new MailSender();
	}
	
	public static Sender produceSms () {
		return new SmsSender();
	}

}
