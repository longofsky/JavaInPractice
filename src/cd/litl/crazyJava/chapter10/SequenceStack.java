package cd.litl.crazyJava.chapter10;

import java.util.Arrays;

public class SequenceStack<T> {

	//底层数组的默认大小
	private int DEFAULT_SIZE = 10;
	//保存数组的长度
	private int capacity;
	//定义当底层数组容量不够时，程序每次增加的数组长度
	private int capacityIncrement = 0;
	//定义一个数组用于保存顺序站的元素
	private Object[] elementData;
	//保存顺序栈中，元素的个数
	private int size = 0;
	//以默认数组长度创空顺序栈
	public SequenceStack () {
		
		this.capacity = DEFAULT_SIZE;
		elementData = new Object[capacity];
	}
	//以一个初始化元素创建顺序栈
	public SequenceStack (T element) {
		
		this();//先创建数组
		elementData[0] = element;
		size ++;
	}
	//以指定长度的数组创建顺序栈
	public SequenceStack (T element,int initSize) {
		
		this.capacity = initSize;
		elementData = new Object[capacity];
		elementData[0] = element;
		size ++;
	}
	//以指定长度的数组创建顺序栈 2
	public SequenceStack (T element,int initSize,int capacityIncrement) {
		
		this.capacity = initSize;
		this.capacityIncrement = capacityIncrement;
		elementData = new Object[capacity];
		elementData[0] = element;
		size ++;
	}
	
	//获取顺序栈的大小
	public int length() {
		return size;
	}
	
	//入栈
	public void push (T element) {
		
		ensurecapacity(size +1);
		elementData[size ++] = element;
	}
	
	//ensurecapacity
	private void ensurecapacity(int minCapacity) {
		
		//如果数组的长度小于 所需数组的最小长度
		if(capacity < minCapacity) {
			
			if (capacityIncrement > 0) {
				
				while (capacity < minCapacity) {
					//不断的 把capacity 增加 capacityIncrement  直到capacity 大于minCapacity
					capacity += capacityIncrement;
				}
			} else {
				while (capacity < minCapacity) {
					//不断的 把capacity 乘于2  直到capacity 大于minCapacity
					capacity <<= 1;
				}
			}
			
			elementData = Arrays.copyOf(elementData, capacity);
		}
	}
	
	//出栈
	public T pop () {
		
		T oldValue = (T)elementData[size -1];
		//释放栈顶元素
		elementData[--size] = null;
		return oldValue;
	}
	
	//返回栈顶元素 但不删栈顶元素
	public T peek () {
		
		return (T)elementData[size -1];
		
	}
	
	//判断 顺序栈 是否为空栈
	public boolean empty () {
		return size == 0;
	}
	
	//清空顺序栈
	public void clear () {
		
		Arrays.fill(elementData, null);
	}
	
	//toString
	public String toString () {
		
		if(size == 0) {
			return "[]";
		} else {
			
			StringBuilder sb = new StringBuilder("[");
			//倒叙便利 数组
			for (int i = size - 1; i > -1;i--) {
				sb.append(elementData[i].toString() + ",");
			}
			
			int len = sb.length();
			
			return sb.delete(len - 2, len).append("]").toString();
		}
	}
}
