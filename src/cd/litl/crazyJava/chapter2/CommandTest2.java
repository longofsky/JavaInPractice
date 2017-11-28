package cd.litl.crazyJava.chapter2;

import java.util.Arrays;

interface IntArrayProductor2 {
	int product();
}
public class CommandTest2 {
	
	public int[] process (IntArrayProductor2 cmd,int length) {
		int [] result = new int[length];
		for (int i=0; i < length;i++) {
			result[i] = cmd.product();
		}
		
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CommandTest2 test = new CommandTest2();
		final int seed = 5;
		
		class IntArrayProductor2Imp implements IntArrayProductor2 {
			public int product () {
				return (int)Math.round(Math.random()*seed);
			}
		}
		int[] result = test.process(new IntArrayProductor2Imp(), 6);
		
		System.out.println(Arrays.toString(result));
	}

}
