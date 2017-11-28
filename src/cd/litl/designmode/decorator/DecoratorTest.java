package cd.litl.designmode.decorator;

public class DecoratorTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Source source = new Source();
		Decorator decorator = new Decorator(source);
		
		decorator.method();
	}

}
