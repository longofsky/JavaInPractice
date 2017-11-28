package cd.litl.crazyJava.chapter9;

import java.util.Arrays;
//顺序线性表
public class SequenceList<T> {
	//定义线性表的属性
	private int DEFAULT_SIZE = 16;
	private int capacity;
	private Object[] elemenData;
	private int size = 0;
	//定义线性表的构造方法
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
		//把capacity 设置为 最小的2的N次方的值
		capacity = 1;
		
		while (capacity < initSize) {
			capacity <<= 1;
		}
		
		elemenData = new Object[capacity];
		elemenData[0] = element;
		size ++;
		
	}
	
	//定义线性表的常用方法
	
	//获取顺序线性表的大小
	public int getSize () {
		return size;
	}
	
	//获取顺序线性表中索引为i处的元素
	public T getElement (int i) {
		
		if (i < 0 || size > size -1) {
				throw new IndexOutOfBoundsException("线性表索引越界");
		}
		return (T)elemenData[i];
	}
	
	//查找顺序线性表指定元素的索引
	public int 	locate (T element) {
		for (int i = 0; i < elemenData.length; i ++) {
			if (elemenData[i].equals(element)) {
				return i;
			}
		}
		return -1;
	}
	//向线性顺序表的指定位置插入一个元素
	public void insert (T element,int index) {
		
		if (index < 0 || index >size) {
			
			throw new IndexOutOfBoundsException("线性表索引越界");
		}
		ensureCapacity(index);
		//将指定索引处之后所有的元素向后移一格
		System.arraycopy(elemenData, index, elemenData, index + 1, size - index);
		elemenData[index] = element;
		size ++;
	}
	//在线性表开始处添加元素
	public void add (T element) {
//		elemenData[size] = element;
//		size ++;
		insert (element,size);
	}
	//确保顺序的长度	
	private void ensureCapacity (int minCapacity) {
		
		if (capacity < minCapacity) {
			
			while (capacity < minCapacity) {
				capacity <<= 1;
			}
			elemenData = Arrays.copyOf(elemenData, capacity);
		}
	}
	
	//删除指定索引处的元素
	public T delete (int index) {
		if (index < 0 || index >size) {
			
			throw new IndexOutOfBoundsException("线性表索引越界");
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
	
	//判断顺序线性表是否为空表
	public boolean empty () {
		return size == 0;
	}
	
	//清空线性表
	public void clear () {
		Arrays.fill(elemenData, null);
	}
	//toString 方法
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
