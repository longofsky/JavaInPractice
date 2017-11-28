package cd.litl.designmode.singleton;


//�̰߳�ȫ�����ܵ�
public class Singleton2 {

	//����˽�еľ�̬ʵ������ֹ�����ã��˴���ֵΪnull��Ŀ�� �ӳټ���
	private static Singleton2 instance = null;
	//���췽��˽�У���ֹ������
	private Singleton2 () {
		
	}
	//��ȡʵ������,synchronized �� static��λ��˳��
	public  static synchronized Singleton2 getInstance () {
		if (null == instance) {
			instance = new Singleton2();
		}
		
		return instance;
	}
	
	public Object readResolve () {
		return instance;
	}
}
