package cd.litl.crazyJava.chapter7;
//ѭ������ ������  �����ڴ����
public class ConstrucorRecursion {

	ConstrucorRecursion rc;
	{
		rc = new ConstrucorRecursion();
	}
	public ConstrucorRecursion () {
		System.out.println("����ִ���޲����Ĺ�����");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConstrucorRecursion rc = new ConstrucorRecursion();
	}

}
