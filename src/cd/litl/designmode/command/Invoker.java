package cd.litl.designmode.command;

public class Invoker {

	private Command command;
	
	public Invoker (Command command) {
		this.command = command;
	}
	
	public void action () {
		if (null != command) {
			command.exe();
		}
	}
}
