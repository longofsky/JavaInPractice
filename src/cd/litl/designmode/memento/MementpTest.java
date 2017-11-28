package cd.litl.designmode.memento;

public class MementpTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Original original = new Original("frist");
		
		Storage storage = new Storage(original.createMementp());
		
		System.out.println("��ʼ���״̬Ϊ��" +original.getValue());
		original.setValue("second");
		System.out.println("�޸ĺ��״̬Ϊ��" +original.getValue());
		 
		original.restoreMemento(storage.getMemento());
		System.out.println("�ָ����״̬Ϊ��" +original.getValue());
	}

}
