package cd.litl.crazyJava.chapter5;

public class CompositeAssign {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		short st = 5;
		//û������ϵͳִ����ʽ������ת��
		st += 10;//�൱��st = (short)(st + 10)
		System.out.println(st);
		st += 90000;//90015 �޷�ת��Ϊshort  ���¼���������
		System.out.println(st);
	}

}
