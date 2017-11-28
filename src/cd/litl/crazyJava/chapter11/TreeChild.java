package cd.litl.crazyJava.chapter11;

import java.util.ArrayList;
import java.util.List;

//�ӽڵ��� ��ʾ��
public class TreeChild<E> {

	//�ӽڵ����Ľڵ�
	private static class SonNode {
		
		//��ǰ�ڵ��λ��
		private int pos;
		
		//��¼��һ���ڵ�
		private SonNode next;
		public SonNode (int pos,SonNode next) {
			
			this.pos = pos;
			this.next = next;
		}
		
	}
	
	//���Ľڵ�
	public static class Node<T> {
		
		T data;
		//��¼ ��һ�� �ӽڵ�
		SonNode first;
		public Node (T data) {
			this.data = data;
			this.first = null;
		}
		
		public String toString () {
			
			if (first != null) {
				
				return "TreeChild$Node[data="+data+",first ="+first.pos+"]";
			} else {
				
				return "TreeChild$Node[data="+data+",first ="+-1+"]";
			}
		}
		
	}
	
	//Ĭ�� ��ʼ�� ���Ĵ�С
	private final int DEFAULT_TREE_SIZE= 100;
	
	//���Ĵ�С
	private int treeSize = 0;
	
	//Node ����
	private Node<E>[] nodes;
	
	//��¼�ڵ���
	private int nodeNums;
	//��ָ�����ڵ� ������
	public TreeChild (E data) {
		
		this.treeSize = DEFAULT_TREE_SIZE;
		nodes = new Node[treeSize];
		
		nodes[0] = new Node<E>(data);
		nodeNums ++;
	}
	//��ָ�� ���ڵ�  treeSie ���� ��
	public TreeChild (E data,int treeSize) {
		
		this.treeSize = treeSize;
		nodes = new Node[treeSize];
		
		nodes[0] = new Node<E>(data);
		nodeNums ++;
	}
	
	//��ָ���ڵ�  ��� �ӽڵ�
	public void addNode(E data,Node parent) {
		
		//���� �ڵ� ���� �ҵ������е�һ��Ϊnull��Ԫ�� ���� �½ڵ�
		for(int i = 0; i< treeSize; i++) {
			
			if (nodes[i] == null) {
				
				nodes[i] = new Node<E>(data);
				
				if (parent.first == null) {
					
					parent.first = new SonNode(i, null);
				} else {
					
					SonNode next = parent.first.next;
					
					while (next != null) {
						
						next = next.next;
					}
					next = new SonNode(i, null);
				}
				
				nodeNums ++;
				return;
			}
		}
		
		throw new RuntimeException("�������� �޷���� �ӽڵ�");
	}
	
	//�ж����Ƿ�Ϊ��
	public boolean empty() {
		
		//���ڵ� �Ƿ�Ϊ��
		return nodes[0] == null;
	}
	
	//���� ���ڵ�
	public Node<E> root() {
		
		return nodes[0];
	}
	
	//����ָ�� �ڵ� ����Ҷ�ӽڵ㣩������ �ӽڵ�
	public List<Node<E>> children (Node parent) {
		
		List<Node<E>> list = new ArrayList<Node<E>>();
		
		SonNode next = parent.first;
		
		while (next != null) {
			list.add(nodes[next.pos]);
			
			next = next.next;
		}
		
		return list;
	}
	
	//���� ָ���ڵ㣨��Ҷ�ӽڵ㣩 ��index�����ӽڵ�
	public Node<E> child (Node parent,int index) {
		
		List<Node<E>> list = new ArrayList<Node<E>>();
		
		SonNode next = parent.first;
		
		for (int i = 0; next != null;i++) {
			
			if (index == i) {
				
				return nodes[next.pos];
			}
			next = next.next;
		}
		
		return null;
	}
	
	//���ظ��������
	public int deep () {
		
		return deep(root());
	}
	//���Ǹ��ݹ鷽���� ÿ����������� Ϊ��������������� +1
	private int deep (Node node) {
		
		if (node.first == null) {
			return 1;
		} else {
			
			//��¼������������������
			int max = 0;
			SonNode next = node.first;
			//���� ������ �������� ��һ�����ӽڵ�
			while (next != null) {
				
				//��ȡ �����ӽڵ� Ϊ�� �����������
				int tmp = deep(nodes[next.pos]);
				
				if (max < tmp) {
					max = tmp;
				}
				
				next = next.next;
			}
			
			//��󣬷��� ������������������ +1
			return max +1;
		}
	}
	
	//���� ���� ָ��ֵ�ýڵ�
	public int pos(Node node) {
		
		for (int i = 0; i < treeSize; i++) {
			
			if (nodes[i] == node) {
				return i;
			}
		}
		return -1;
	}
	
}
