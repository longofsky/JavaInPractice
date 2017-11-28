package cd.litl.designmode.Iterator;

public class IteratorTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Collection collection = new MyCollection();
		
		Iterator iterator = collection.iterator();
		
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
	}

}
