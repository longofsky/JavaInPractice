package cd.litl.designmode.singleton;


//��һ�δ�������ʱ �߳�ͬ��  ���Singleton2 ��������ܣ�������ִ֤��˳�򣬿��ܣ�����instance���ڴ�
public class Singleton5 {

	//����˽�еľ�̬ʵ������ֹ�����ã��˴���ֵΪnull��Ŀ�� �ӳټ���
	private static Singleton5 instance = null;
	//���췽��˽�У���ֹ������
	private Singleton5 () {
		
	}
	private static synchronized Singleton5 synInit () {
		if (null == instance) {
			instance = new Singleton5();
		}
		return instance;
	}
	//��ȡʵ������,synchronized �� static��λ��˳��
	public  static Singleton5 getInstance () {
		if (null == instance) {
			synInit();
		}
		
		
		return instance;
	}
	
	public Object readResolve () {
		return instance;
	}
}
