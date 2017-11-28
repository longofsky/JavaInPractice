package cd.litl.crazyJava.chapter11;

import java.util.Arrays;

//˳�� �洢�Ķ�����
public class ArrayBinTree<T> {

	//ʹ�� ��������¼���������нڵ�
	private Object[] datas;
	private int DEFAULT_DEEP = 8;
	//���� �������
	private int deep;
	private int arraySize;
	//��Ĭ�϶���ȴ��� ������
	public ArrayBinTree () {
		
		this.deep = DEFAULT_DEEP;
		this.arraySize = (int)Math.pow(2, deep) -1;
		
		datas = new Object[arraySize];
	}
	//��ָ�� ��ȴ���������
	public ArrayBinTree (int deep) {
		
		this.deep = deep;
		this.arraySize = (int)Math.pow(2, deep) -1;
		
		datas = new Object[arraySize];
	}
	//��ָ����� ָ���ڵ㴴��������
	public ArrayBinTree (int deep,T data) {
		
		this.deep = deep;
		this.arraySize = (int)Math.pow(2, deep) -1;
		
		datas = new Object[arraySize];
		datas[0] = data;
	}
	
	//Ϊָ���ڵ�����ӽڵ�-��Ҫ����ӽڵ� ���ڵ������-���ӽڵ������-�Ƿ�Ϊ��ڵ�
	public void add (int index,T data,boolean left) {
		
		if (datas[index] == null) {
			
			throw new RuntimeException(index +"���ڵ�Ϊ�գ��޷�����ӽڵ�");
		}
		if (2*index+1 >= arraySize) {
			
			throw new RuntimeException("���ײ��������������Խ���쳣");
		}
		//������ӽڵ�
		if (left) {
			
			datas[2*index +1] = data;
		}else {
			
			datas[2*index +2] = data;
		}
	}
	
	//�ж� �������Ƿ�Ϊ��
	public boolean empty () {
		
		//���ݸ�Ԫ�� �ж� �������Ƿ�Ϊ��
		return datas[0] == null;
	}
	//���� ���ڵ�
	public T root () {
		
		return (T) datas[0];
	}
	//����ָ���ڵ㣨�Ǹ��ڵ�ģ����ڵ�
	public T parent (int index) {
		
		return (T) datas[(index - 1)/2];
	}
	//����ָ���ڵ㣨��Ҷ�ӣ������ӽڵ㣬�����ӽڵ㲻������ ����null
	public T left (int index) {
		
		if (2*index+1 >= arraySize) {
			
			throw new RuntimeException("�Ľڵ�ΪҶ�ӽڵ㣬���ӽڵ�");
		}
		return (T) datas[index * 2+1];
	}
	//����ָ���ڵ㣨��Ҷ�ӣ������ӽڵ㣬�����ӽڵ㲻������ ����null
	public T right (int index) {
		
		if (2*index+1 >= arraySize) {
			
			throw new RuntimeException("�Ľڵ�ΪҶ�ӽڵ㣬���ӽڵ�");
		}
		return (T) datas[index * 2+2];
	}
	//���� �ö����������
	public int deep () {
		return deep;
	}
	//����ָ���ڵ��λ��
	public int pos (T data) {
		
		for (int i =0; i < arraySize; i++) {
			
			if (datas[i].equals(data)) {
				return i;
			}
		}
		return -1;
	}
	//toString
	
	public String toString () {
		
		return Arrays.toString(datas);
	}
	
}
