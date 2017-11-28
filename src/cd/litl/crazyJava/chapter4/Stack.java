package cd.litl.crazyJava.chapter4;

public class Stack {

	//���ջ��Ԫ�ص�����
	private Object[] elementData;
	//��¼ջ��Ԫ�صĸ���
	private int size= 0;
	private int capacityIncrement;
	//ָ����ʼ����������һ��stack
	public Stack (int initialCapacity) {
		elementData = new Object[initialCapacity];
	}
	public Stack (int initialCapacity,int capacityIncrement) {
		this(initialCapacity);
		this.capacityIncrement = capacityIncrement;
	}
	
	//��ջ��ѹ��һ��Ԫ��
	public void push (Object object) {
		ensureCapacity();
		elementData[size++] = object;
	}
	
	public Object pop () {
		if (size == 0) {
			throw new RuntimeException("��ջ�쳣");
		}
		Object ele =  elementData[--size];
		//�ж����úͶ���֮�����ϵ����ֹ �ڴ����
		elementData[size] =null;
		
		return ele;
	}
	
	public int size () {
		return size;
	}
	
	//��֤�ײ�����������ջ������Ԫ��
	private void ensureCapacity() {
		if (elementData.length == size) {
			Object[] oldElements = elementData;
			
			int newLength = 0;
			//����Ѿ�����capacityIncrement
			if (capacityIncrement > 0){
				newLength = elementData.length + capacityIncrement;
			} else {
				//�����������ԭ����1.5��
				newLength = (int)(elementData.length*1.5);
			}
			
			elementData = new Object[newLength];
			
			//��ԭ�����Ԫ�ظ��Ƶ���������
			System.arraycopy(oldElements, 0, elementData, 0, size);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
