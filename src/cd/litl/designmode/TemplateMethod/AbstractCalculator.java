package cd.litl.designmode.TemplateMethod;

public abstract class AbstractCalculator {
	
	public final int calculator (String exp,String opt) {
		
		int [] intArray = split(exp,opt);
		return calculator(intArray[0],intArray[1]);
	}

	abstract public int calculator (int a,int b);
	
	public int[] split (String exp,String opt) {
		
		String[] array = exp.split(opt);
		
		int [] intArray = new int[2];
		
		intArray[0] = Integer.parseInt(array[0]);
		intArray[1] = Integer.parseInt(array[1]);
		
		return intArray;
	}
}
