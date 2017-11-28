package cd.litl.designmode.command;

public class MyCommand implements Command {
	
	private Receiver receiver;
	
	public MyCommand (Receiver receiver) {
		
		this.receiver = receiver;
	}

	@Override
	public void exe() {
		// TODO Auto-generated method stub
		if (null != receiver) {
			receiver.action();
		}
	}

}
