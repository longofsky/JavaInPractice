package cd.litl.crazyJava.chapter11;

import java.util.Arrays;

//顺序 存储的二叉树
public class ArrayBinTree<T> {

	//使用 数组来记录该树的所有节点
	private Object[] datas;
	private int DEFAULT_DEEP = 8;
	//保存 树的深度
	private int deep;
	private int arraySize;
	//以默认额深度创建 二叉树
	public ArrayBinTree () {
		
		this.deep = DEFAULT_DEEP;
		this.arraySize = (int)Math.pow(2, deep) -1;
		
		datas = new Object[arraySize];
	}
	//以指定 深度创建二叉树
	public ArrayBinTree (int deep) {
		
		this.deep = deep;
		this.arraySize = (int)Math.pow(2, deep) -1;
		
		datas = new Object[arraySize];
	}
	//以指定深度 指定节点创建二叉树
	public ArrayBinTree (int deep,T data) {
		
		this.deep = deep;
		this.arraySize = (int)Math.pow(2, deep) -1;
		
		datas = new Object[arraySize];
		datas[0] = data;
	}
	
	//为指定节点添加子节点-需要添加子节点 父节点的索引-新子节点的数据-是否为左节点
	public void add (int index,T data,boolean left) {
		
		if (datas[index] == null) {
			
			throw new RuntimeException(index +"处节点为空，无法添加子节点");
		}
		if (2*index+1 >= arraySize) {
			
			throw new RuntimeException("树底层的数组已满，书越界异常");
		}
		//添加左子节点
		if (left) {
			
			datas[2*index +1] = data;
		}else {
			
			datas[2*index +2] = data;
		}
	}
	
	//判断 二叉树是否为空
	public boolean empty () {
		
		//根据根元素 判断 二叉树是否为空
		return datas[0] == null;
	}
	//返回 根节点
	public T root () {
		
		return (T) datas[0];
	}
	//返回指定节点（非根节点的）父节点
	public T parent (int index) {
		
		return (T) datas[(index - 1)/2];
	}
	//返回指定节点（非叶子）的左子节点，当左子节点不存在是 返回null
	public T left (int index) {
		
		if (2*index+1 >= arraySize) {
			
			throw new RuntimeException("改节点为叶子节点，无子节点");
		}
		return (T) datas[index * 2+1];
	}
	//返回指定节点（非叶子）的右子节点，当右子节点不存在是 返回null
	public T right (int index) {
		
		if (2*index+1 >= arraySize) {
			
			throw new RuntimeException("改节点为叶子节点，无子节点");
		}
		return (T) datas[index * 2+2];
	}
	//返回 该二叉树的深度
	public int deep () {
		return deep;
	}
	//返回指定节点的位置
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
