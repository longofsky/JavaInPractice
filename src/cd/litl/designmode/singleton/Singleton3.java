package cd.litl.designmode.singleton;


//��һ�δ�������ʱ �߳�ͬ��  ���Singleton2 ��������ܣ�������ִ֤��˳�򣬿��ܣ�����instance���ڴ�
public class Singleton3 {

	//����˽�еľ�̬ʵ������ֹ�����ã��˴���ֵΪnull��Ŀ�� �ӳټ���
	private static Singleton3 instance = null;
	//���췽��˽�У���ֹ������
	private Singleton3 () {
		
	}
	//��ȡʵ������,synchronized �� static��λ��˳��
	public  static Singleton3 getInstance () {
		if (null == instance) {
			synchronized (instance) {
				if (null == instance) {
					instance = new Singleton3();
				}
			}
		}
		
		
		return instance;
	}
	
	public Object readResolve () {
		return instance;
	}
}
