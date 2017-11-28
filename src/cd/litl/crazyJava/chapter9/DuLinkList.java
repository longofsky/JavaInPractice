package cd.litl.crazyJava.chapter9;

//˫������
public class DuLinkList<T> {

	//˫������ �� ���� ���������    �ֱ� ���� һ������ ����  ��һ���� ����
	
	//����һ���ڲ���Node,Node ʵ����������Ľڵ�
	private class Node {
		
		//����ڵ������
		private T data;
		//ָ����һ���ڵ������
		private Node prev;
		//ָ����һ���ڵ������
		private Node next;
		//�޲����Ĺ�����
		public Node () {
			
		}
		//��ʼ��ȫ�����ԵĹ�����
		public Node (T data,Node prev,Node next) {
			this.data = data;
			this.prev = prev;
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
	public DuLinkList () {
		
		//������  header �� tail ��Ϊ��
		this.header = null;
		this.tail = null;
	}
	//��ָ������Ԫ������������  ������ֻ����һ��Ԫ��
	public DuLinkList (T element) {
		
		this.header = new Node (element,null,null);
		this.tail = header;
		
		size++;
	}
	
	//��������ĳ���
	public int length() {
		return size;
	}
	
	//��ȡ��ʽ���Ա�������Ϊindex ����Ԫ��
	public T get (int index) {
		return getNodeByIndex(index).data;
	}
	//��������index��ȡָ��λ�õĽڵ�
	public Node getNodeByIndex (int index) {
		
		if (index < 0 || index > size -1) {
			throw new IndexOutOfBoundsException("���Ա�����Խ��");
		}
		
		
		if (index < size/2) {
			//��ͷ��ʼ 
			Node current  = header;
			
			for (int i = 0; i < size/2 && current != null;i++,current = current.next) {
				
				if (i == index) {
					return current;
				}
			}
		}else { 
			//�� β��ʼ
			Node current  = tail;
			
			for (int i = 0; i < size/2 && current != null;i++,current = current.prev) {
				
				if (i == index) {
					return current;
				}
			}
		}
		return null;
	}
	
	//������ʽ���Ա� ָ��Ԫ�ص�����
	public int locate (T element) {
		Node current  = header;
		
		for (int i = 0; i < size && current != null;i++,current = current.next) {
			
			if (current.data.equals(element)) {
				return i;
			}
		}
		return -1;
	}
	//��������ʽ�� ָ��λ�ò���һ��Ԫ��
	public void insert (T element,int index) {
		
		if (index < 0 || index > size -1) {
			
			throw new IndexOutOfBoundsException("���Ա�����Խ��");
		}
		//���ͷ��Ϊ�� ˵�� ���Ǹ�������
		if (header == null) {
//			add (element);
		}else {
			//��ȡ������ǰһ���ڵ�
			Node preNode = getNodeByIndex(index -1);
			//��ȡ��һ���ڵ�
			Node next = preNode.next;
			//��������ĵ�ǰ�ڵ�
			Node newNode = new Node(element,preNode,next);
			//��ǰ�ڵ� ���� ����
			preNode.next = newNode;
			next.prev = newNode;
			
			size ++;
		}
	}
	//����β�巨 Ϊ��������½ڵ�
	public void add (T element) {
		//��������ǿ�����
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
	
	//����ͷ�巨 Ϊ��������½ڵ�
	public void addAtHeader (T element) {
		
		header = new Node(element,null,header);
		
		if(tail == null) {
			tail = header;
		}
		size ++;
	}
	//ɾ��   ��ʽ���Ա� ָ����������Ԫ��
	
	public T delete (int index) {
		
		if (index < 0 || index > size -1) {
			
			throw new IndexOutOfBoundsException("���Ա�����Խ��");
		} 
		
		Node del = null;
		if (index == 0) {
			
			del = header;
					
			header = header.next;
			
			//������໥������������
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
	//ɾ����ʽ���Ա� 	�����һ��Ԫ��
	
	public T remove () {
		return delete(size -1);
	}
	
	//�ж� ��ʽ���Ա� �Ƿ�Ϊ������
	public boolean empty () {
		
		return size ==0;
	}
	
	//��� ���Ա�
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
	
	//reverseToString(���� toSring)
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
