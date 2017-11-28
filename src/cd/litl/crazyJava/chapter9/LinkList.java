package cd.litl.crazyJava.chapter9;

//链式线性表
public class LinkList<T> {
	
	//定义一个内部类Node,Node 实例代表链表的节点
	private class Node {
		
		//保存节点的数据
		private T data;
		//指向下一个节点的应用
		private Node next;
		//无参数的构造器
		public Node () {
			
		}
		//初始化全部属性的构造器
		public Node (T data,Node next) {
			this.data = data;
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
	public LinkList() {
		this.header = null;
		this.tail = null;
	}
	//以指定数据元素来创建链表，该链表只有一个元素
	public LinkList (T element) {
		
		this.header = new Node (element,null);
		tail = header;
		size ++;
	}
	//返回链表的长度
	public int length () {
		return size;
	}
	//获取链式线性表索引为index处的元素
	public T get (int index) {

		return getNodeByIndex(index).data;
	}
	//根据索引index 获取index处的节点
	public Node getNodeByIndex (int index) {
		
		if (index < 0 || index > size -1) {
			throw new IndexOutOfBoundsException("线性表索引越界");
		}
		
		//从header 节点开始 
		Node current  = header;
		
		for (int i = 0; i < size && current != null;i++,current = current.next) {
			
			if (i == index) {
				return current;
			}
		}
		
		return null;
	}
	//查找链式线性表指定元素的索引
	public int locate (T element) {
		Node current  = header;
		
		for (int i = 0; i < size && current != null;i++,current = current.next) {
			
			if (current.data.equals(element)) {
				return i;
			}
		}
		return -1;
	}
	//向链式线性表指定位置插入一个元素
	
	public void insert (T element,int index) {
		
		if (index < 0 || index > size -1) {
			
			throw new IndexOutOfBoundsException("线性表索引越界");
		}
		//如果头部为空 说明 这是个空链表
		if (header == null) {
			add (element);
		}else {
			//获取插入点的前一个节点
			Node preNode = getNodeByIndex(index -1);
			
			preNode.next = new Node(element,preNode.next);
			size ++;
		}
	}
	//采用尾插法为链表添加新节点
	public void add (T element) {
		
		if (header == null) {
			header = new Node (element,null);
			tail = header;
		}else {
			//创建新节点
			Node newNode = new Node(element,null);
			//让尾节点的next 指向新增节点
			tail.next = newNode;
			//新增节点 变为尾节点
			tail = newNode;
		}
		
		size ++;
	}
	//采用头插法为链表添加新节点
	public void addAtHeader (T element) {
		//创建新节点，让新节点的next 指向原来的header
		//并以新节点作为新的header
		header = new Node (element,header);
		//如果插入之前是空栈--tail 为空
		if (tail == null) {
			tail = header;
		}
	}
	//删除链式线性表中指定索引处的元素    header节点    和别的 节点
	public T delete (int index) {
		
		if (index < 0 || index > size -1) {	
			throw new IndexOutOfBoundsException("线性表索引越界");
		}
		
		Node del = null;
		
		//如果删除的是header 节点
		if (index == 0) {
			del = header;
			header = header.next;
		} else {
			//获取 删除点的前一个节点
			Node prev = getNodeByIndex(index - 1);
			
			//获取将要删除的节点
			del = prev.next;
			//让被删除点的前一个节点的next 指向删除点的下一个节点
			prev.next = del.next;
			//将删除点的next 赋值为空
			del.next = null;
			
			
			
		}
		size--;
		return del.data;	
	}
	//删除链式线性表最后一个元素
	public T remove () {
		return delete(size - 1);
	}
	
	//判断链式线性表是否为空表
	public boolean empty () {
		return size == 0;
	}
	
	//清空线性表
	public void clear () {
		//将 header tail  赋值为 null
		header = null;
		tail = null;
		size = 0;
	}
	//toString 方法
	public String toString () {
		//链表为空链表
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
	
}
