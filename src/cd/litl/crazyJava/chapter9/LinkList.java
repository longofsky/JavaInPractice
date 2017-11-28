package cd.litl.crazyJava.chapter9;

//��ʽ���Ա�
public class LinkList<T> {
	
	//����һ���ڲ���Node,Node ʵ����������Ľڵ�
	private class Node {
		
		//����ڵ������
		private T data;
		//ָ����һ���ڵ��Ӧ��
		private Node next;
		//�޲����Ĺ�����
		public Node () {
			
		}
		//��ʼ��ȫ�����ԵĹ�����
		public Node (T data,Node next) {
			this.data = data;
			this.next = next;
		}
	}
	
	//���������ͷ�ڵ�
	private Node header;
	//���������β�ڵ�
	private Node tail;
	//���������Ľڵ���
	private int size;
	//����������
	public LinkList() {
		this.header = null;
		this.tail = null;
	}
	//��ָ������Ԫ������������������ֻ��һ��Ԫ��
	public LinkList (T element) {
		
		this.header = new Node (element,null);
		tail = header;
		size ++;
	}
	//��������ĳ���
	public int length () {
		return size;
	}
	//��ȡ��ʽ���Ա�����Ϊindex����Ԫ��
	public T get (int index) {

		return getNodeByIndex(index).data;
	}
	//��������index ��ȡindex���Ľڵ�
	public Node getNodeByIndex (int index) {
		
		if (index < 0 || index > size -1) {
			throw new IndexOutOfBoundsException("���Ա�����Խ��");
		}
		
		//��header �ڵ㿪ʼ 
		Node current  = header;
		
		for (int i = 0; i < size && current != null;i++,current = current.next) {
			
			if (i == index) {
				return current;
			}
		}
		
		return null;
	}
	//������ʽ���Ա�ָ��Ԫ�ص�����
	public int locate (T element) {
		Node current  = header;
		
		for (int i = 0; i < size && current != null;i++,current = current.next) {
			
			if (current.data.equals(element)) {
				return i;
			}
		}
		return -1;
	}
	//����ʽ���Ա�ָ��λ�ò���һ��Ԫ��
	
	public void insert (T element,int index) {
		
		if (index < 0 || index > size -1) {
			
			throw new IndexOutOfBoundsException("���Ա�����Խ��");
		}
		//���ͷ��Ϊ�� ˵�� ���Ǹ�������
		if (header == null) {
			add (element);
		}else {
			//��ȡ������ǰһ���ڵ�
			Node preNode = getNodeByIndex(index -1);
			
			preNode.next = new Node(element,preNode.next);
			size ++;
		}
	}
	//����β�巨Ϊ��������½ڵ�
	public void add (T element) {
		
		if (header == null) {
			header = new Node (element,null);
			tail = header;
		}else {
			//�����½ڵ�
			Node newNode = new Node(element,null);
			//��β�ڵ��next ָ�������ڵ�
			tail.next = newNode;
			//�����ڵ� ��Ϊβ�ڵ�
			tail = newNode;
		}
		
		size ++;
	}
	//����ͷ�巨Ϊ��������½ڵ�
	public void addAtHeader (T element) {
		//�����½ڵ㣬���½ڵ��next ָ��ԭ����header
		//�����½ڵ���Ϊ�µ�header
		header = new Node (element,header);
		//�������֮ǰ�ǿ�ջ--tail Ϊ��
		if (tail == null) {
			tail = header;
		}
	}
	//ɾ����ʽ���Ա���ָ����������Ԫ��    header�ڵ�    �ͱ�� �ڵ�
	public T delete (int index) {
		
		if (index < 0 || index > size -1) {	
			throw new IndexOutOfBoundsException("���Ա�����Խ��");
		}
		
		Node del = null;
		
		//���ɾ������header �ڵ�
		if (index == 0) {
			del = header;
			header = header.next;
		} else {
			//��ȡ ɾ�����ǰһ���ڵ�
			Node prev = getNodeByIndex(index - 1);
			
			//��ȡ��Ҫɾ���Ľڵ�
			del = prev.next;
			//�ñ�ɾ�����ǰһ���ڵ��next ָ��ɾ�������һ���ڵ�
			prev.next = del.next;
			//��ɾ�����next ��ֵΪ��
			del.next = null;
			
			
			
		}
		size--;
		return del.data;	
	}
	//ɾ����ʽ���Ա����һ��Ԫ��
	public T remove () {
		return delete(size - 1);
	}
	
	//�ж���ʽ���Ա��Ƿ�Ϊ�ձ�
	public boolean empty () {
		return size == 0;
	}
	
	//������Ա�
	public void clear () {
		//�� header tail  ��ֵΪ null
		header = null;
		tail = null;
		size = 0;
	}
	//toString ����
	public String toString () {
		//����Ϊ������
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
