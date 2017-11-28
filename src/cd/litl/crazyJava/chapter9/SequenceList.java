package cd.litl.crazyJava.chapter9;

import java.util.Arrays;
//˳�����Ա�
public class SequenceList<T> {
	//�������Ա������
	private int DEFAULT_SIZE = 16;
	private int capacity;
	private Object[] elemenData;
	private int size = 0;
	//�������Ա�Ĺ��췽��
	public SequenceList () {
		capacity = DEFAULT_SIZE;
		elemenData = new Object[capacity];
	}
	
	public SequenceList (T element) {
		this();
		elemenData[0] = element;
		size ++;
	}
	public SequenceList (T element,int initSize) {
		//��capacity ����Ϊ ��С��2��N�η���ֵ
		capacity = 1;
		
		while (capacity < initSize) {
			capacity <<= 1;
		}
		
		elemenData = new Object[capacity];
		elemenData[0] = element;
		size ++;
		
	}
	
	//�������Ա�ĳ��÷���
	
	//��ȡ˳�����Ա�Ĵ�С
	public int getSize () {
		return size;
	}
	
	//��ȡ˳�����Ա�������Ϊi����Ԫ��
	public T getElement (int i) {
		
		if (i < 0 || size > size -1) {
				throw new IndexOutOfBoundsException("���Ա�����Խ��");
		}
		return (T)elemenData[i];
	}
	
	//����˳�����Ա�ָ��Ԫ�ص�����
	public int 	locate (T element) {
		for (int i = 0; i < elemenData.length; i ++) {
			if (elemenData[i].equals(element)) {
				return i;
			}
		}
		return -1;
	}
	//������˳����ָ��λ�ò���һ��Ԫ��
	public void insert (T element,int index) {
		
		if (index < 0 || index >size) {
			
			throw new IndexOutOfBoundsException("���Ա�����Խ��");
		}
		ensureCapacity(index);
		//��ָ��������֮�����е�Ԫ�������һ��
		System.arraycopy(elemenData, index, elemenData, index + 1, size - index);
		elemenData[index] = element;
		size ++;
	}
	//�����Ա�ʼ�����Ԫ��
	public void add (T element) {
//		elemenData[size] = element;
//		size ++;
		insert (element,size);
	}
	//ȷ��˳��ĳ���	
	private void ensureCapacity (int minCapacity) {
		
		if (capacity < minCapacity) {
			
			while (capacity < minCapacity) {
				capacity <<= 1;
			}
			elemenData = Arrays.copyOf(elemenData, capacity);
		}
	}
	
	//ɾ��ָ����������Ԫ��
	public T delete (int index) {
		if (index < 0 || index >size) {
			
			throw new IndexOutOfBoundsException("���Ա�����Խ��");
		}
		
		T oldValue  = (T)elemenData[index];
		int numMoved = size - index -1;
		if (numMoved > 0) { }
		
		elemenData[size-1] = null;
		return oldValue;
		
	}
	
	public T remove () {
		return delete(size-1);
	}
	
	//�ж�˳�����Ա��Ƿ�Ϊ�ձ�
	public boolean empty () {
		return size == 0;
	}
	
	//������Ա�
	public void clear () {
		Arrays.fill(elemenData, null);
	}
	//toString ����
	public String toString () {
		if (size == 0) {
			return "[]";
		}else {
			StringBuilder sb = new StringBuilder("[");
			for (int i = 0;i < size;i++) {
				sb.append(elemenData[i].toString() + ",");
			}
			
			int len = sb.length();
			
			return sb.delete(len - 2, len).append("]").toString();
		}
	}
}
