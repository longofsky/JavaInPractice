package cd.litl.designmode.memento;

public class MementpTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Original original = new Original("frist");
		
		Storage storage = new Storage(original.createMementp());
		
		System.out.println("初始类的状态为：" +original.getValue());
		original.setValue("second");
		System.out.println("修改后的状态为：" +original.getValue());
		 
		original.restoreMemento(storage.getMemento());
		System.out.println("恢复后的状态为：" +original.getValue());
	}

}
