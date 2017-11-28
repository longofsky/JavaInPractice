package cd.litl.designmode.bridge;

public class BridgeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Bridge bridge = new MyBridge();
		
		//调用第一个对象
		Sourceable sourceable1 = new SourceSub1();
		bridge.setSourceable(sourceable1);
		bridge.method();
		
		//调用第二个对象
		Sourceable sourceable2 = new SourceSub2();
		bridge.setSourceable(sourceable2);
		bridge.method();
	}

}
