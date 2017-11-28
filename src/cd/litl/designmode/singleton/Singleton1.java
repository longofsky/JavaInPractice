package cd.litl.designmode.singleton;


//�򵥵�����ȷ�� �̲߳���ȫ
public class Singleton1 {

	//����˽�еľ�̬ʵ������ֹ�����ã��˴���ֵΪnull��Ŀ�� �ӳټ���
	private static Singleton1 instance = null;
	//���췽��˽�У���ֹ������
	private Singleton1 () {
		
	}
	//��ȡʵ������
	public static Singleton1 getInstance () {
		if (null == instance) {
			instance = new Singleton1();
		}
		
		return instance;
	}
	
	public Object readResolve () {
		return instance;
	}
}
