package cd.litl.crazyJava.chapter9;

//双向链表
public class DuLinkList<T> {

	//双向链表 和 单向 链表的区别    分别 具有 一个向上 引用  和一个向 引用
	
	//定义一个内部类Node,Node 实例代表链表的节点
	private class Node {
		
		//保存节点的数据
		private T data;
		//指向上一个节点的引用
		private Node prev;
		//指向下一个节点的引用
		private Node next;
		//无参数的构造器
		public Node () {
			
		}
		//初始化全部属性的构造器
		public Node (T data,Node prev,Node next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
	}
	//保存链表的头节点
	private Node header;
	//保存链表的尾节点
	private Node tail;
	//保存该链表的节点数
	private int size;
	
	//创建空链表
	public DuLinkList () {
		
		//空链表  header 和 tail 都为空
		this.header = null;
		this.tail = null;
	}
	//以指定数据元素来创建链表  该链表只有这一个元素
	public DuLinkList (T element) {
		
		this.header = new Node (element,null,null);
		this.tail = header;
		
		size++;
	}
	
	//返回链表的长度
	public int length() {
		return size;
	}
	
	//获取链式线性表中索引为index 处的元素
	public T get (int index) {
		return getNodeByIndex(index).data;
	}
	//根据索引index获取指定位置的节点
	public Node getNodeByIndex (int index) {
		
		if (index < 0 || index > size -1) {
			throw new IndexOutOfBoundsException("线性表索引越界");
		}
		
		
		if (index < size/2) {
			//从头开始 
			Node current  = header;
			
			for (int i = 0; i < size/2 && current != null;i++,current = current.next) {
				
				if (i == index) {
					return current;
				}
			}
		}else { 
			//从 尾开始
			Node current  = tail;
			
			for (int i = 0; i < size/2 && current != null;i++,current = current.prev) {
				
				if (i == index) {
					return current;
				}
			}
		}
		return null;
	}
	
	//查找链式线性表 指点元素的索引
	public int locate (T element) {
		Node current  = header;
		
		for (int i = 0; i < size && current != null;i++,current = current.next) {
			
			if (current.data.equals(element)) {
				return i;
			}
		}
		return -1;
	}
	//向线性链式表 指定位置插入一个元素
	public void insert (T element,int index) {
		
		if (index < 0 || index > size -1) {
			
			throw new IndexOutOfBoundsException("线性表索引越界");
		}
		//如果头部为空 说明 这是个空链表
		if (header == null) {
//			add (element);
		}else {
			//获取插入点的前一个节点
			Node preNode = getNodeByIndex(index -1);
			//获取下一个节点
			Node next = preNode.next;
			//创建插入的当前节点
			Node newNode = new Node(element,preNode,next);
			//当前节点 加入 链表
			preNode.next = newNode;
			next.prev = newNode;
			
			size ++;
		}
	}
	//采用尾插法 为链表添加新节点
	public void add (T element) {
		//如果链表还是空链表
		if( header == null) {
			header = new Node(element,null,null);
			tail = header;
		}else {
			Node newNode = new Node (element,tail,null);
			tail.next = newNode;
			tail = newNode;
		}
		size ++;
	}
	
	//采用头插法 为链表添加新节点
	public void addAtHeader (T element) {
		
		header = new Node(element,null,header);
		
		if(tail == null) {
			tail = header;
		}
		size ++;
	}
	//删除   链式线性表 指定索引处的元素
	
	public T delete (int index) {
		
		if (index < 0 || index > size -1) {
			
			throw new IndexOutOfBoundsException("线性表索引越界");
		} 
		
		Node del = null;
		if (index == 0) {
			
			del = header;
					
			header = header.next;
			
			//对象间相互持有两个索引
			header.prev = null;
			
			del.next = null;
		} else {
			Node preNode = getNodeByIndex(index -1);
			
			del = preNode.next;
			
			Node nextNode = del.next;
			if (nextNode != null) {
				preNode.next = nextNode;
			}
			
			nextNode.prev = preNode;
			
			del.prev = null;
			del.next = null;
		}
		size --;
		return del.data;
	}
	//删除链式线性表 	中最后一个元素
	
	public T remove () {
		return delete(size -1);
	}
	
	//判断 链式线性表 是否为空链表
	public boolean empty () {
		
		return size ==0;
	}
	
	//清空 线性表
	public void clear () {
		
		header = null;
		tail = null;
		size = 0;
	}
	
	//toString
	public String toString () {
		
		if (empty()) {
			return "[]";
		}else {
			StringBuilder sb = new StringBuilder("[");
			
			for (Node current = header; current != null;current = current.next) {
				
				sb.append(current.data.toString() + ",");
				
			}
			
			int len = sb.length();
			return sb.delete(len - 2, len).append("]").toString();
		}
	}
	
	//reverseToString(反向 toSring)
	public String reverseToString () {
		
		if (empty()) {
			return "[]";
		}else {
			StringBuilder sb = new StringBuilder("[");
			
			for (Node current = tail; current != null;current = tail.prev) {
				
				sb.append(current.data.toString() + ",");
				
			}
			
			int len = sb.length();
			return sb.delete(len - 2, len).append("]").toString();
		}
	}
}
