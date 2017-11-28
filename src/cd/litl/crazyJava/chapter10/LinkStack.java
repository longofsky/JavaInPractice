package cd.litl.crazyJava.chapter10;

public class LinkStack<T> {

	//����һ���ڲ��� Node  Nodeʵ�� ���������е�һ���ڵ�
	private class Node<T> {
		
		//����ڵ������
		private T data;
		//ָ����һ���ڵ������
		private Node next;
		//�޲����Ĺ�����
		public Node () {
			
		}
		//��ʼ��ȫ�������Ĺ�����
		public Node (T data,Node next) {
			this.data = data;
			this.next = next;
		}
	}
	//���� �������ջ��Ԫ��
	private Node top;
	//������������Ѱ����Ľڵ���
	private int size;
	//������ ����
	public LinkStack () {
		top =null;
	}
	//��ָ��Ԫ�ش������������ֻ��һ�� Ԫ��
	public LinkStack (T element) {
		
		top = new Node(element,null);
		
		size ++;
		
	}
	//��������ĳ���
	public int length () {
		return size;
	}
	//��ջ
	public void push (T element) {
		top = new Node (element,top);
		size ++;
	}
	//��ջ
	public T pop() {
		Node oldNode = top;
		top= top.next;
		oldNode.next = null;
		size--;
		return (T) oldNode.data;
	}
	//����ջ��Ԫ�� ����ɾ����Ԫ��
	public T peek() {
		
		return (T) top.data;
	}
	//�����ջ
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
