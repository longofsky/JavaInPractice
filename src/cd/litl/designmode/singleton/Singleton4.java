package cd.litl.designmode.singleton;

//����ģʽʹ���ڲ�����ά��������ʵ�֣�JVM�ڲ��Ļ����ܹ���֤��һ���౻���ص�ʱ�������ļ��ع������̻߳���ġ�
//���������ǵ�һ�ε���getInstance��ʱ��JVM�ܹ������Ǳ�֤instanceֻ������һ�Σ����һᱣ֤�Ѹ�ֵ��instance���ڴ��ʼ����ϣ��������ǾͲ��õ�����������⡣
//ͬʱ�÷���Ҳֻ���ڵ�һ�ε��õ�ʱ��ʹ�û�����ƣ������ͽ���˵��������⡣����������ʱ�ܽ�һ�������ĵ���ģʽ

//ȱ�㣺����ڹ��캯�����׳��쳣��ʵ������Զ�ò���������Ҳ���������˵��ʮ�������Ķ�����û�е�
public class Singleton4 {

	//����˽�еľ�̬ʵ������ֹ�����ã��˴���ֵΪnull��Ŀ�� �ӳټ���
	private static Singleton4 instance = null;
	//���췽��˽�У���ֹ������
	private Singleton4 () {
		
	}
	//�ڲ���̬��ķ�ʽ��������
	private static class SingletonFactory {
		
		private static Singleton4 instance = new Singleton4();
	}
	//��ȡʵ������,synchronized �� static��λ��˳��
	public  static Singleton4 getInstance () {
		
		
		return SingletonFactory.instance;
	}
	
	public Object readResolve () {
		return instance;
	}
}
