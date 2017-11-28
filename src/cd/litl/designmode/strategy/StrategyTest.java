package cd.litl.designmode.strategy;

public class StrategyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String exp = "2+8";
		
		ICalculator calculator = new Plus();
		
		int result = calculator.calculator(exp);
		System.out.println(result);
	}

}
