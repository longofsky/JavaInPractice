package cd.litl.designmode.singleton;

import java.util.Vector;


//��һ�δ�������ʱ �߳�ͬ��  ���Singleton2 ��������ܣ�������ִ֤��˳�򣬿��ܣ�����instance���ڴ�
public class Singleton6 {

	//����˽�еľ�̬ʵ������ֹ�����ã��˴���ֵΪnull��Ŀ�� �ӳټ���
	private static Singleton6 instance = null;
	
	private Vector properties =null;
	
	public Vector getProperties() {
		return properties;
	}
	public void setProperties(Vector properties) {
		this.properties = properties;
	}
	//���췽��˽�У���ֹ������
	private Singleton6 () {
		
	}
	private static synchronized Singleton6 synInit () {
		if (null == instance) {
			instance = new Singleton6();
		}
		return instance;
	}
	//��ȡʵ������,synchronized �� static��λ��˳��
	public  static Singleton6 getInstance () {
		if (null == instance) {
			synInit();
		}
		
		
		return instance;
	}
	
	//����"Ӱ��ʵ��"�İ취Ϊ�������������ͬ������
	public void updateProperties() {
		Singleton6 shadow = new Singleton6();
		properties = shadow.getProperties();
	}
	
	public Object readResolve () {
		return instance;
	}
}
