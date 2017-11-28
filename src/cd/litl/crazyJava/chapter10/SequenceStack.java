package cd.litl.crazyJava.chapter10;

import java.util.Arrays;

public class SequenceStack<T> {

	//�ײ������Ĭ�ϴ�С
	private int DEFAULT_SIZE = 10;
	//��������ĳ���
	private int capacity;
	//���嵱�ײ�������������ʱ������ÿ�����ӵ����鳤��
	private int capacityIncrement = 0;
	//����һ���������ڱ���˳��վ��Ԫ��
	private Object[] elementData;
	//����˳��ջ�У�Ԫ�صĸ���
	private int size = 0;
	//��Ĭ�����鳤�ȴ���˳��ջ
	public SequenceStack () {
		
		this.capacity = DEFAULT_SIZE;
		elementData = new Object[capacity];
	}
	//��һ����ʼ��Ԫ�ش���˳��ջ
	public SequenceStack (T element) {
		
		this();//�ȴ�������
		elementData[0] = element;
		size ++;
	}
	//��ָ�����ȵ����鴴��˳��ջ
	public SequenceStack (T element,int initSize) {
		
		this.capacity = initSize;
		elementData = new Object[capacity];
		elementData[0] = element;
		size ++;
	}
	//��ָ�����ȵ����鴴��˳��ջ 2
	public SequenceStack (T element,int initSize,int capacityIncrement) {
		
		this.capacity = initSize;
		this.capacityIncrement = capacityIncrement;
		elementData = new Object[capacity];
		elementData[0] = element;
		size ++;
	}
	
	//��ȡ˳��ջ�Ĵ�С
	public int length() {
		return size;
	}
	
	//��ջ
	public void push (T element) {
		
		ensurecapacity(size +1);
		elementData[size ++] = element;
	}
	
	//ensurecapacity
	private void ensurecapacity(int minCapacity) {
		
		//�������ĳ���С�� �����������С����
		if(capacity < minCapacity) {
			
			if (capacityIncrement > 0) {
				
				while (capacity < minCapacity) {
					//���ϵ� ��capacity ���� capacityIncrement  ֱ��capacity ����minCapacity
					capacity += capacityIncrement;
				}
			} else {
				while (capacity < minCapacity) {
					//���ϵ� ��capacity ����2  ֱ��capacity ����minCapacity
					capacity <<= 1;
				}
			}
			
			elementData = Arrays.copyOf(elementData, capacity);
		}
	}
	
	//��ջ
	public T pop () {
		
		T oldValue = (T)elementData[size -1];
		//�ͷ�ջ��Ԫ��
		elementData[--size] = null;
		return oldValue;
	}
	
	//����ջ��Ԫ�� ����ɾջ��Ԫ��
	public T peek () {
		
		return (T)elementData[size -1];
		
	}
	
	//�ж� ˳��ջ �Ƿ�Ϊ��ջ
	public boolean empty () {
		return size == 0;
	}
	
	//���˳��ջ
	public void clear () {
		
		Arrays.fill(elementData, null);
	}
	
	//toString
	public String toString () {
		
		if(size == 0) {
			return "[]";
		} else {
			
			StringBuilder sb = new StringBuilder("[");
			//������� ����
			for (int i = size - 1; i > -1;i--) {
				sb.append(elementData[i].toString() + ",");
			}
			
			int len = sb.length();
			
			return sb.delete(len - 2, len).append("]").toString();
		}
	}
}
