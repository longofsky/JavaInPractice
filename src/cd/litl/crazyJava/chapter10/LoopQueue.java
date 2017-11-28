package cd.litl.crazyJava.chapter10;

import java.util.Arrays;

public class LoopQueue <T>{
	
	//底层数组的默认大小
	private int DEFAULT_SIZE = 10;
	//保存数组的长度
	private int capacity;
	//定义一个数组用于保存顺序站的元素
	private Object[] elementData;
	//保存顺序栈中，元素的个数
	private int front = 0;
	private int rear = 0;
	//以默认数组长度创空顺序栈
	public LoopQueue () {
				
		this.capacity = DEFAULT_SIZE;
		elementData = new Object[capacity];
	}
	//以一个初始化元素创建顺序栈
	public LoopQueue (T element) {
				
		this();//先创建数组
		elementData[0] = element;
		rear ++;
	}
	//以指定长度的数组创建顺序栈
	public LoopQueue (T element,int initSize) {
				
		this.capacity = initSize;
		elementData = new Object[capacity];
		elementData[0] = element;
		rear ++;
	}
			
	//获取顺序栈的大小
	public int length() {
		
		if (empty()) {
			return 0;
		}
		return rear > front ? rear - front: capacity - (front - rear);
	}
	//插入队列
	public void add (T element) {
				
		if (rear == front && elementData[front] != null) {
			throw new IndexOutOfBoundsException("队列已满异常");
		} 
		elementData[rear ++] = element;
		
		rear = rear == capacity ? 0:rear;//循环队列
	}
	//移除队列
			
			public T remove() {
				if (empty()) {
					throw new IndexOutOfBoundsException("空队列异常");
				}
				T oldelement = (T) elementData[front];
				elementData[front ++] = null;
				
				front = front == capacity ? 0:front;//循环队列
				
				return oldelement;
			}
		//返回队列顶元素 但不删除 队列顶元素
			
			public T element() {
				if (empty()) {
					throw new IndexOutOfBoundsException("空队列异常");
				}
				
				return (T) elementData[front];
			}
		//判断队列是否为 空队列
			public boolean empty() {
				return rear == front && elementData[front] == null;
			}
		//清空顺序队列
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
