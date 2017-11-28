package cd.litl.crazyJava.chapter4;

public class Stack {

	//存放栈内元素的数组
	private Object[] elementData;
	//记录栈内元素的个数
	private int size= 0;
	private int capacityIncrement;
	//指定初始化容量创建一个stack
	public Stack (int initialCapacity) {
		elementData = new Object[initialCapacity];
	}
	public Stack (int initialCapacity,int capacityIncrement) {
		this(initialCapacity);
		this.capacityIncrement = capacityIncrement;
	}
	
	//向栈顶压入一个元素
	public void push (Object object) {
		ensureCapacity();
		elementData[size++] = object;
	}
	
	public Object pop () {
		if (size == 0) {
			throw new RuntimeException("空栈异常");
		}
		Object ele =  elementData[--size];
		//切断引用和对象之间的联系，防止 内存溢出
		elementData[size] =null;
		
		return ele;
	}
	
	public int size () {
		return size;
	}
	
	//保证底层数组能容纳栈内所有元素
	private void ensureCapacity() {
		if (elementData.length == size) {
			Object[] oldElements = elementData;
			
			int newLength = 0;
			//如果已经设置capacityIncrement
			if (capacityIncrement > 0){
				newLength = elementData.length + capacityIncrement;
			} else {
				//将长度扩充的原来的1.5倍
				newLength = (int)(elementData.length*1.5);
			}
			
			elementData = new Object[newLength];
			
			//将原数组的元素复制到新数组中
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
