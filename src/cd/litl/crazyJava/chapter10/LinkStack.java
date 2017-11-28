package cd.litl.crazyJava.chapter10;

public class LinkStack<T> {

	//定义一个内部类 Node  Node实例 代表链表中的一个节点
	private class Node<T> {
		
		//保存节点的数据
		private T data;
		//指向下一个节点的引用
		private Node next;
		//无参数的构造器
		public Node () {
			
		}
		//初始化全部参数的构造器
		public Node (T data,Node next) {
			this.data = data;
			this.next = next;
		}
	}
	//保存 该链表的栈顶元素
	private Node top;
	//保存该链表中已包含的节点数
	private int size;
	//创建空 链表
	public LinkStack () {
		top =null;
	}
	//以指定元素创建链表该链表只有一个 元素
	public LinkStack (T element) {
		
		top = new Node(element,null);
		
		size ++;
		
	}
	//返回链表的长度
	public int length () {
		return size;
	}
	//进栈
	public void push (T element) {
		top = new Node (element,top);
		size ++;
	}
	//出栈
	public T pop() {
		Node oldNode = top;
		top= top.next;
		oldNode.next = null;
		size--;
		return (T) oldNode.data;
	}
	//访问栈顶元素 但不删除此元素
	public T peek() {
		
		return (T) top.data;
	}
	//清空链栈
	public void clear() {
		top = null;
		size = 0;
	}
	//toString
	public String toString () {
		
		if (size == 0) {
			return "[]";
		}else {
			StringBuilder sb = new StringBuilder("[");
			
			
			for (Node current = top;current != null;current = current.next) {
				
				sb.append(current.data.toString()+",");
			}
			int len = sb.length();
			return sb.delete(len-2, len).append("]").toString();
			
		}
	}
}
