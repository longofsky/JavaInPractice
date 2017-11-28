package cd.litl.crazyJava.chapter2;

import java.util.Arrays;

interface IntArrayProductor {
	int product();
}
public class CommandTest {
	
	public int[] process (IntArrayProductor cmd,int length) {
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

		CommandTest test = new CommandTest();
		final int seed = 5;
		int[] result = test.process(new IntArrayProductor() {
			public int product () {
				return (int)Math.round(Math.random()*seed);
			}
		}, 6);
		
		System.out.println(Arrays.toString(result));
	}

}
