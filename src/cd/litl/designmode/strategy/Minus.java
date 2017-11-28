package cd.litl.designmode.strategy;

public class Minus extends AbstractCalculator implements ICalculator {

	@Override
	public int calculator(String exp) {
		// TODO Auto-generated method stub
		
		int [] intArray = split(exp,"-");
		return intArray[0] - intArray[1];
	}

}
