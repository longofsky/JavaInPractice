package cd.litl.designmode.adapter.objectAdapter;

public class AdapterTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Source source = new Source();
		Targetable targetable = new Adapter(source);
		targetable.method1();
		targetable.method2();
	}

}
