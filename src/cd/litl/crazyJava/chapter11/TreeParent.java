package cd.litl.crazyJava.chapter11;

import java.util.ArrayList;
import java.util.List;

//���ڵ� ��ʾ��
public class TreeParent<E> {

	//�ṩһ���ڲ��࣬�ڲ����ʵ����Ϊ���Ľڵ�
	public static class Node <T> {
		
		//����
		T data;
		//��¼���ڵ��λ��
		int parent;
		
		public Node () {
			
		}
		public Node (T data) {
			this.data = data;
		}
		public Node (T data,int parent) {
			this.data = data;
			this.parent = parent;
		}
		
		public String toString () {
			
			return "TreeParent$Node[data="+data+",parent="+parent+"]";
		}
	}
	
	//��ʼ�����ĵײ�����Ĵ�С
	private final int DEFAULT_TREE_SIZE = 100;
	
	//��ʼ�����Ĵ�С
	private int treeSize;
	
	//ʹ��һ��Node[]���� ����¼�������нڵ�
	private Node<E>[] nodes;
	
	//��¼�ڵ���
	private int nodeNums;
	
	//��ָ�����ڵ㴴����
	public TreeParent(E data) {
		
		treeSize = DEFAULT_TREE_SIZE;
		nodes = new Node[treeSize];
		nodes[0] = new Node<E>(data,-1);
		nodeNums ++;
	}
	
	//��ָ�����ڵ�   ָ�� treeSize  ���� ��
	public TreeParent(E data,int initTreeSize) {
		
		treeSize = initTreeSize;
		nodes = new Node[treeSize];
		nodes[0] = new Node<E>(data,-1);
		nodeNums ++;
	}
	
	//Ϊָ���ڵ� ��� �ӽڵ�
	public void addNode (E data,Node parent) {

		for (int i = 0; i < treeSize;i++) {
			//�ҵ������� ��һ��Ϊ null��Ԫ�أ���Ԫ�ر��� �½ڵ�
			if (nodes[i] == null) {
				//�����½ڵ� ����ָ�� ������Ԫ�� ����
				nodes[i] = new Node<E>(data,pos(parent));
				nodeNums ++;
				return;
			}
		}
		
		throw new RuntimeException("�����������޷�����½ڵ�");//���� ���������� ������ �ײ����飿����
	}
	
	//�ж� ���Ƿ�Ϊ��
	public boolean empty () {
		
		//���ڵ� �Ƿ�Ϊ��
		return nodes[0] == null;
	}
	
	//���ظ��ڵ�
	public Node<E> root () {
		return nodes[0];
	}
	
	//����ָ���ڵ㣨�Ǹ��ڵ㣩 �ĸ��ڵ�
	public Node<E> parent (Node node) {
		
		//ÿһ���ڵ�� parent ��¼�� �����ڵ��λ��
		return nodes[node.parent];
	}
	
	//����ָ��ڵ㣨�� Ҷ�ӽ�㣩 �������ӽڵ�
	public List<Node<E>> children (Node parent) {
		
		List<Node<E>> list = new ArrayList<Node<E>>();
		for (int i = 0; i < treeSize; i++) {
			if (nodes[i] != null && nodes[i].parent == pos(parent)) {
				
				list.add(nodes[i]);
			}
		}
		return list;
	}
	
	//���� �������
	public int deep () {
		
		//���ڼ�¼�ڵ��������
		int max = 0;
		for (int i = 0; i< treeSize && nodes[i] != null;i++) {
			
			//��ʼ�����ڵ�� ���
			int def = 1;
			
			int parent = nodes[i].parent;
			while (parent != -1 && nodes[parent] != null) {
				
				//���ϼ������� ���ڵ�
				parent = nodes[parent].parent;
				def++;	
			}
			max = def > max ? def:max;
		} 
		
		return max;
	}
	
	//���� ���� ָ��ֵ�ýڵ�
	public int pos(Node node) {
		
		for (int i = 0; i < treeSize;i++) {
			
			if (nodes[i] == node) {
				return i;
			}
		}
		return -1;
	}
}
