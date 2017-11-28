package cd.litl.crazyJava.chapter10;

import java.util.Arrays;

public class LoopQueue <T>{
	
	//�ײ������Ĭ�ϴ�С
	private int DEFAULT_SIZE = 10;
	//��������ĳ���
	private int capacity;
	//����һ���������ڱ���˳��վ��Ԫ��
	private Object[] elementData;
	//����˳��ջ�У�Ԫ�صĸ���
	private int front = 0;
	private int rear = 0;
	//��Ĭ�����鳤�ȴ���˳��ջ
	public LoopQueue () {
				
		this.capacity = DEFAULT_SIZE;
		elementData = new Object[capacity];
	}
	//��һ����ʼ��Ԫ�ش���˳��ջ
	public LoopQueue (T element) {
				
		this();//�ȴ�������
		elementData[0] = element;
		rear ++;
	}
	//��ָ�����ȵ����鴴��˳��ջ
	public LoopQueue (T element,int initSize) {
				
		this.capacity = initSize;
		elementData = new Object[capacity];
		elementData[0] = element;
		rear ++;
	}
			
	//��ȡ˳��ջ�Ĵ�С
	public int length() {
		
		if (empty()) {
			return 0;
		}
		return rear > front ? rear - front: capacity - (front - rear);
	}
	//�������
	public void add (T element) {
				
		if (rear == front && elementData[front] != null) {
			throw new IndexOutOfBoundsException("���������쳣");
		} 
		elementData[rear ++] = element;
		
		rear = rear == capacity ? 0:rear;//ѭ������
	}
	//�Ƴ�����
			
			public T remove() {
				if (empty()) {
					throw new IndexOutOfBoundsException("�ն����쳣");
				}
				T oldelement = (T) elementData[front];
				elementData[front ++] = null;
				
				front = front == capacity ? 0:front;//ѭ������
				
				return oldelement;
			}
		//���ض��ж�Ԫ�� ����ɾ�� ���ж�Ԫ��
			
			public T element() {
				if (empty()) {
					throw new IndexOutOfBoundsException("�ն����쳣");
				}
				
				return (T) elementData[front];
			}
		//�ж϶����Ƿ�Ϊ �ն���
			public boolean empty() {
				return rear == front && elementData[front] == null;
			}
		//���˳�����
			public void clear () {
				Arrays.fill(elementData, null);
				front = 0;
				rear = 0;
			}
		//toString
			
			public String toString () {
				
				if (empty()) {
					return "[]";
				} else {
					
					StringBuilder sb = new StringBuilder("[");
					if (front < rear) {
						for (int i = front; i < rear ;i ++) {
							sb.append(elementData[i].toString() + ",");
						}	
						
					} else {
						
						for (int i = front; i < capacity ;i ++) {
							sb.append(elementData[i].toString() + ",");
						}
						for (int i = 0; i < rear ;i ++) {
							sb.append(elementData[i].toString() + ",");
						}
					}		
					int len = sb.length();
					return sb.delete(len - 2, len).append("]").toString();
				}
			}
}
