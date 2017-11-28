package cd.litl.designmode.strategy;

public abstract class AbstractCalculator {

	public int[] split (String exp,String opt) {
		
		String[] array = exp.split(opt);
		
		int [] intArray = new int[2];
		
		intArray[0] = Integer.parseInt(array[0]);
		intArray[1] = Integer.parseInt(array[1]);
		
		return intArray;
	}
}
